//package com.back.whp.controller;
//
//import com.back.whp.dto.SimpleResponse;
//import com.back.whp.model.TransferEntity;
//import com.back.whp.service.TransferService;
//import com.back.whp.vo.AddTransferVO;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@Api(value = "流转模块", description = "流转相关接口")
//@RestController
//@RequestMapping("/whp/transfer")
//public class TransferController {
//    @Autowired
//    private TransferService transferService;
//
//    @ApiOperation(value = "新增流转信息", response = TransferEntity.class, notes = "")
//    @PostMapping("/add")
//    public SimpleResponse add(@RequestBody AddTransferVO addTransferVO) {
//        return SimpleResponse.ok(transferService.add(addTransferVO));
//    }
//
//    @ApiOperation(value = "根据产品批号获取流转信息列表", response = TransferEntity.class, notes = "")
//    @PostMapping("/transfer")
//    public SimpleResponse getTransfer(@RequestParam String bn){
//        return SimpleResponse.ok(transferService.getTransfer(bn));
//    }
//
//    @ApiOperation(value = "根据流转id获取流转信息详情", response = TransferEntity.class, notes = "")
//    @GetMapping("/getDetail")
//    public SimpleResponse getDetail(@RequestParam Integer transferId){
//        return SimpleResponse.ok(transferService.getDetail(transferId));
//    }
//
//    @ApiOperation(value = "获取所有流转信息列表", response = TransferEntity.class, notes = "")
//    @GetMapping("/getList")
//    public SimpleResponse getList() {
//        return SimpleResponse.ok(transferService.getList());
//    }
//
//
//}
