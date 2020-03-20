package com.back.whp.service.impl;

import com.back.whp.config.TokenManager;
import com.back.whp.constants.AlarmState;
import com.back.whp.constants.AlarmType;
import com.back.whp.dao.AlarmRepository;
import com.back.whp.dao.ManagerRepository;
import com.back.whp.model.AlarmEntity;
import com.back.whp.model.BaseInfoEntity;
import com.back.whp.model.ManagerEntity;
import com.back.whp.service.AlarmService;
import com.back.whp.util.exception.ErrorCode;
import com.back.whp.util.exception.ErrorCodeException;
import com.back.whp.vo.AlarmHandleVO;
import com.back.whp.vo.AlarmInfoVO;
import com.back.whp.vo.AlarmVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private AlarmRepository alarmRepository;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private BaseInfoServiceImpl baseInfoService;

    @Override
    public AlarmInfoVO add(AlarmVO alarmVO) {
        AlarmEntity alarmEntity = new AlarmEntity();
        BeanUtils.copyProperties(alarmVO, alarmEntity);
        alarmEntity.setState(AlarmState.SUBMIT);
        alarmEntity.setCreateTime(new Timestamp(new Date().getTime()));

        return getByAlarmEntity(alarmRepository.saveAndFlush(alarmEntity));
    }

    @Override
    public AlarmInfoVO getDetail(Integer alarmId) {
        return getByAlarmEntity(alarmRepository.findOne(alarmId));
    }

    @Override
    public List<AlarmInfoVO> getListByChemical(Integer chemicalId) {
        return getByAlarms(alarmRepository.findByChemicalId(chemicalId));
    }

    @Override
    public List<AlarmInfoVO> getList() {
        return getByAlarms(alarmRepository.getAll());
    }

    @Override
    public List<AlarmInfoVO> getListByState(Integer state) {
        return getByAlarms(alarmRepository.findByStateOrderByCreateTimeDesc(state));
    }

    @Override
    public AlarmInfoVO handle(String signature, AlarmHandleVO alarmHandleVO) {
        if (signature == null || !tokenManager.validateLoginToken(signature)) {
            throw new ErrorCodeException(ErrorCode.TOKEN_NOT_EXISTS, "token不存在");
        }

        String email = tokenManager.getEmail(signature);
        ManagerEntity managerEntity = managerRepository.findByEmail(email);
        if (managerEntity == null || !managerEntity.getId().equals(alarmHandleVO.getManagerId())) {
            throw new ErrorCodeException(ErrorCode.FORBIDDEN, "禁止");
        }

        AlarmEntity alarmEntity = alarmRepository.findOne(alarmHandleVO.getAlarmId());
        if (Objects.isNull(alarmEntity)) {
            throw new ErrorCodeException(ErrorCode.ALARM_NOT_EXISTS, "报警不存在");
        }

        alarmEntity.setHandleManagerId(managerEntity.getId());
        alarmEntity.setState(alarmHandleVO.getState());
        alarmEntity.setModifyTime(new Timestamp(new Date().getTime()));

        return getByAlarmEntity(alarmRepository.saveAndFlush(alarmEntity));
    }

    private AlarmInfoVO getByAlarmEntity(AlarmEntity alarmEntity){
        BaseInfoEntity baseInfoEntity = baseInfoService.getChemical(alarmEntity.getChemicalId(), null);
        return new AlarmInfoVO(alarmEntity, baseInfoEntity);
    }

    private List<AlarmInfoVO> getByAlarms(List<AlarmEntity> alarmEntities){
        List<Integer> chemicalIds = alarmEntities.stream().map(AlarmEntity::getChemicalId).collect(Collectors.toList());
        List<BaseInfoEntity> baseInfoEntities = baseInfoService.getChemicals(chemicalIds);
        Map<Integer, BaseInfoEntity> chemicalIdToBaseInfo = baseInfoEntities.stream().collect(Collectors.toMap(BaseInfoEntity::getId, b -> b));

        List<AlarmInfoVO> res = new ArrayList<>();
        for (AlarmEntity a : alarmEntities) {
            res.add(new AlarmInfoVO(a, chemicalIdToBaseInfo.get(a.getChemicalId())));
        }

        return res;
    }

    @Override
    public Map<String, Integer> getTypes() {
        return AlarmType.alarmTypeS2I;
    }
}
