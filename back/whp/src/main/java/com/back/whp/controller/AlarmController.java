package com.back.whp.controller;

import com.back.whp.dto.SimpleResponse;
import com.back.whp.model.AlarmEntity;
import com.back.whp.service.AlarmService;
import com.back.whp.vo.AlarmHandleVO;
import com.back.whp.vo.AlarmVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "报警模块", description = "报警相关接口")
@RestController
@RequestMapping("/whp/alarm")
public class AlarmController {
    @Autowired
    private AlarmService alarmService;

    @ApiOperation(value = "新增报警", response = AlarmEntity.class)
    @PostMapping("/add")
    public SimpleResponse add(@RequestBody AlarmVO alarmVO) {
        return SimpleResponse.ok(alarmService.add(alarmVO));
    }

    @ApiOperation(value = "获取报警详情", response = AlarmEntity.class)
    @GetMapping("/getDetail")
    public SimpleResponse getDetail(@RequestParam Integer alarmId) {
        return SimpleResponse.ok(alarmService.getDetail(alarmId));
    }

    @ApiOperation(value = "根据化学品id获取报警列表", response = AlarmEntity.class)
    @GetMapping("/getListByChemical")
    public SimpleResponse getListByChemical(@RequestParam Integer chemicalId) {
        return SimpleResponse.ok(alarmService.getListByChemical(chemicalId));
    }

    @ApiOperation(value = "根据状态获取报警列表", response = AlarmEntity.class, notes = "state：提交1 | 正在处理2 | 已处理3 | 拒绝处理4")
    @GetMapping("/getListByState")
    public SimpleResponse getListByState(@RequestParam Integer state) {
        return SimpleResponse.ok(alarmService.getListByState(state));
    }

    @ApiOperation(value = "获取所有报警列表", response = AlarmEntity.class)
    @GetMapping("/getList")
    public SimpleResponse getList() {
        return SimpleResponse.ok(alarmService.getList());
    }

    @ApiOperation(value = "管理员处理报警", response = AlarmEntity.class, notes = "signature在登录时获得")
    @PostMapping("/handle")
    public SimpleResponse handle(@RequestParam String signature, @RequestBody AlarmHandleVO alarmHandleVO) {
        return SimpleResponse.ok(alarmService.handle(signature, alarmHandleVO));
    }

    @ApiOperation(value = "获取所有报警类型", response = Map.class, notes = "Map<String, Integer>")
    @GetMapping("/getTypes")
    public SimpleResponse getTypes() {
        return SimpleResponse.ok(alarmService.getTypes());
    }
}
