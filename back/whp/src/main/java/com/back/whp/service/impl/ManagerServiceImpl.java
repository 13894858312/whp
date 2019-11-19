package com.back.whp.service.impl;

import com.back.whp.config.TokenManager;
import com.back.whp.dao.ManagerRepository;
import com.back.whp.model.ManagerEntity;
import com.back.whp.service.ManagerService;
import com.back.whp.util.AES;
import com.back.whp.util.Token;
import com.back.whp.util.exception.ErrorCode;
import com.back.whp.util.exception.ErrorCodeException;
import com.back.whp.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    /**
     * 令牌管理类
     */
    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Boolean login(LoginVO loginVO) {
        if (!AES.clientDecrypt(loginVO.getPassword()).equals("123456")) {
            throw new ErrorCodeException(ErrorCode.PASSWORD_WRONG, "密码错误");
        }

        return true;
    }
}
