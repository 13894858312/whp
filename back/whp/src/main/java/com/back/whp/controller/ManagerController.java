package com.back.whp.controller;

import com.back.whp.dto.SimpleResponse;
import com.back.whp.service.ManagerService;
import com.back.whp.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "登陆模块", description = "管理员登录相关接口")
@RestController
@RequestMapping("/whp/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;


    @ApiOperation(value = "管理员密码登录", response = Boolean.class)
    @PostMapping("/login")
    public SimpleResponse login(@RequestBody LoginVO loginVO) {
        return SimpleResponse.ok(managerService.login(loginVO));
    }
}
