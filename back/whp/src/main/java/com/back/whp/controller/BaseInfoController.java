package com.back.whp.controller;

import com.back.whp.dto.SimpleResponse;
import com.back.whp.model.BaseInfoEntity;
import com.back.whp.service.BaseInfoService;
import com.back.whp.vo.AddChemicalVO;
import com.back.whp.vo.ChemicalSearchVO;
import com.back.whp.vo.GenQrCodeVO;
import com.back.whp.vo.QueryChemicalVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "化学品模块", description = "化学品及查询历史信息相关接口")
@RestController
@RequestMapping("/whp/chemical")
public class BaseInfoController {
    @Autowired
    private BaseInfoService baseInfoService;

    @ApiOperation(value = "根据名称或cas搜索化学品列表", response = BaseInfoEntity.class, notes = "")
    @PostMapping("/getChemicals")
    public SimpleResponse getChemicals(@RequestBody ChemicalSearchVO chemicalSearchVO) {
        return SimpleResponse.ok(baseInfoService.getChemicals(chemicalSearchVO));
    }

    @ApiOperation(value = "根据id或cas获取化学品详情", response = BaseInfoEntity.class, notes = "id和cas只传一个")
    @PostMapping("/getDetail")
    public SimpleResponse getDetail(@RequestBody QueryChemicalVO queryChemicalVO) {
        return SimpleResponse.ok(baseInfoService.getChemical(queryChemicalVO.getChemicalId(), queryChemicalVO.getCas()));
    }

    @ApiOperation(value = "根据cas生成化学品二维码", response = String.class, notes = "返回值为二维码的uri，前面需加服务器地址")
    @PostMapping("/genQrCode")
    public SimpleResponse genQrCode(@RequestBody GenQrCodeVO genQrCodeVO) {
        return SimpleResponse.ok(baseInfoService.genCodeByCas(genQrCodeVO.getCas()));
    }

    @PostMapping("/genAllQrCode")
    public SimpleResponse genAllQrCode() {
        return SimpleResponse.ok(baseInfoService.genAllQrCode());
    }

    @ApiOperation(value = "新增化学品", response = BaseInfoEntity.class, notes = "")
    @PostMapping("/addChemical")
    public SimpleResponse addChemical(@RequestBody AddChemicalVO addChemicalVO) {
        addChemicalVO.validate();
        return SimpleResponse.ok(baseInfoService.addChemical(addChemicalVO));
    }

//    @ApiOperation(value = "用户查看化学品详情时，需要调用此接口，新增用户浏览信息历史", response = HistoryEntity.class, notes = "signature在登录时获得")
//    @PostMapping("/addHistory")
//    public SimpleResponse addHistory(@RequestParam String signature, @RequestBody HistoryVO historyVO){
//        return SimpleResponse.ok(baseInfoService.addHistory(signature, historyVO));
//    }
//
//    @ApiOperation(value = "获取用户查看化学品历史列表", response = HistoryEntity.class, notes = "signature在登录时获得")
//    @GetMapping("/getHistory")
//    public SimpleResponse getHistory(@RequestParam String signature, @RequestParam Integer managerId) {
//        return SimpleResponse.ok(baseInfoService.getHistories(signature, managerId));
//    }
}
