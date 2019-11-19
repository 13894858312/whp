package com.back.whp.config;

import com.back.whp.dao.SignatureRepository;
import com.back.whp.model.SignatureEntity;
import com.back.whp.util.AES;
import com.back.whp.util.RandomUtil;
import com.back.whp.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.back.whp.constants.DataConstants.SPLIT_SIGNAL;

@Component
public class TokenManager {
    // token过期时间间隔7天
    private static final int INTERVAL = 7;
    // 加盐长度
    private static final int SALT_LENGTH = 8;

    @Autowired
    private SignatureRepository signatureRepository;

    /**
     * 获取令牌
     * 签名格式：（sal`email`clientType）
     *
     * @param email   邮箱
     * @param clientType 客户端类型
     * @return 令牌
     */
    public Token generateLoginToken(String email, String clientType) {
        String salt = RandomUtil.getRandomString(SALT_LENGTH);
        Token token = new Token(AES.serverEncrypt(salt + SPLIT_SIGNAL + email + SPLIT_SIGNAL + clientType), System.currentTimeMillis());

        signatureRepository.save(new SignatureEntity(email + SPLIT_SIGNAL + clientType, token.getSignature(), token.getTimestamp()));
        return token;
    }

    public void removeLoginToken(String email, String clientType) {

        signatureRepository.delete(email + SPLIT_SIGNAL + clientType);
    }

    public void removeUsersTokenRecord(String email) {
        //TODO 清空所有用户所有
        signatureRepository.deleteAllByUserClientLike(email + SPLIT_SIGNAL + "%");

    }

    public boolean validateLoginToken(String email, String clientType) {
        return signatureRepository.findOne(email + SPLIT_SIGNAL + clientType) != null;

    }

    public boolean validateLoginToken(String signature) {
        return signatureRepository.findBySignature(signature) != null;
    }

    public String getEmail(String signature) {
        return signature == null ? null : AES.serverDecrypt(AES.clientDecrypt(signature)).split(SPLIT_SIGNAL)[1];
    }


    /**
     * 清除令牌Cache中过期令牌
     * TODO 每天0点执行一次
     */
    @Scheduled(cron = "0 0 0 * * ?")
    private void cleanToken() {

        for (SignatureEntity signature : signatureRepository.findAll()) {
            if (((System.currentTimeMillis() - signature.getTimestamp()) / 1000 / 60 / 60 / 24) >= INTERVAL) {
                signatureRepository.delete(signature);
            }
        }
    }
}
