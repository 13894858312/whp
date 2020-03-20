package com.back.whp.service.impl;

import com.back.whp.config.TokenManager;
import com.back.whp.dao.ManagerRepository;
import com.back.whp.model.ManagerEntity;
import com.back.whp.service.ManagerService;
import com.back.whp.util.AesNew;
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
        ManagerEntity managerEntity = managerRepository.findByNickname("管理员");

        try {
            return AesNew.decrypt(loginVO.getPassword()).equals(managerEntity.getPassword());
        } catch (Exception e) {
            return false;
        }

    }
}
