package com.back.whp.service.impl;

import com.back.whp.dao.BaseInfoRepository;
import com.back.whp.dao.HistoryRepository;
import com.back.whp.model.BaseInfoEntity;
import com.back.whp.model.HistoryEntity;
import com.back.whp.service.BaseInfoService;
import com.back.whp.util.QrCode;
import com.back.whp.util.exception.ErrorCode;
import com.back.whp.util.exception.ErrorCodeException;
import com.back.whp.vo.AddChemicalVO;
import com.back.whp.vo.ChemicalSearchVO;
import com.back.whp.vo.HistoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {
    @Autowired
    private BaseInfoRepository baseInfoRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<BaseInfoEntity> getChemicals(ChemicalSearchVO chemicalSearchVO) {

        if (Objects.nonNull(chemicalSearchVO.getCas()) && Objects.nonNull(chemicalSearchVO.getName())) {
            return baseInfoRepository.searchByCasAndName("%" + chemicalSearchVO.getCas() + "%", "%" + chemicalSearchVO.getName() + "%");
        }

        if (Objects.nonNull(chemicalSearchVO.getCas())) {
            return baseInfoRepository.findByCasLike("%" + chemicalSearchVO.getCas() + "%");
        }

        if (Objects.nonNull(chemicalSearchVO.getName())) {
            return baseInfoRepository.searchByName("%" + chemicalSearchVO.getName() + "%");
        }


        return baseInfoRepository.findAll();
    }

    @Override
    public BaseInfoEntity getChemical(Integer chemicalId, String cas) {
        if ((Objects.isNull(chemicalId) && Objects.isNull(cas)) || (Objects.nonNull(chemicalId) && Objects.nonNull(cas))) {
            throw new ErrorCodeException(ErrorCode.BAD_REQUEST, "id和cas能且只能有一个");
        }

        if (Objects.nonNull(chemicalId)) {
            return baseInfoRepository.findOne(chemicalId);
        }

        return baseInfoRepository.findByCas(cas);
    }

    @Override
    public List<BaseInfoEntity> getChemicals(List<Integer> chemicalIds) {
        return baseInfoRepository.findAll(chemicalIds);
    }

    @Override
    public String genCodeByCas(String cas) {
        BaseInfoEntity baseInfoEntity = baseInfoRepository.findByCas(cas);
        if (Objects.isNull(baseInfoEntity)) {
            throw new ErrorCodeException(ErrorCode.CHEMICAL_NOT_EXISTS, "化学品不存在");
        }
        if (Objects.nonNull(baseInfoEntity.getUri()) && baseInfoEntity.getUri().length() > 0) {
            throw new ErrorCodeException(ErrorCode.CHEMICAL_ALREADY_HAS_CODE, "化学品已有二维码，不可重复生成");
        }

        String uri = QrCode.generateQrCode(cas);
        baseInfoEntity.setUri(uri);
        baseInfoRepository.saveAndFlush(baseInfoEntity);
        return uri;
    }

    @Override
    public Boolean genAllQrCode() {
        List<BaseInfoEntity> baseInfoEntities = baseInfoRepository.findAll();
        for (BaseInfoEntity entity : baseInfoEntities) {
            if (entity.getUri() == null || entity.getUri().length() == 0) {
                genCodeByCas(entity.getCas());
            }
        }
        return true;
    }

    @Override
    public BaseInfoEntity addChemical(AddChemicalVO addChemicalVO) {
        BaseInfoEntity baseInfoEntity = new BaseInfoEntity(addChemicalVO);
        return baseInfoRepository.saveAndFlush(baseInfoEntity);
    }

    @Override
    public HistoryEntity addHistory(String signature, HistoryVO historyVO) {
        BaseInfoEntity baseInfoEntity = baseInfoRepository.findOne(historyVO.getChemicalId());

        if (baseInfoEntity == null) {
            throw new ErrorCodeException(ErrorCode.CHEMICAL_NOT_EXISTS, "化学品不存在");
        }

        HistoryEntity historyEntity = new HistoryEntity();
        BeanUtils.copyProperties(historyVO, historyEntity);
        historyEntity.setChemicalName(baseInfoEntity.getCnName());
        historyEntity.setCreateTime(new Timestamp(new Date().getTime()));

        return historyRepository.saveAndFlush(historyEntity);
    }

    @Override
    public List<HistoryEntity> getHistories(String signature, Integer managerId) {
        return historyRepository.findByManagerIdOrderByCreateTimeDesc(managerId);
    }
}
