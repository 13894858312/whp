package com.back.whp.service;

import com.back.whp.model.AlarmEntity;
import com.back.whp.vo.AlarmHandleVO;
import com.back.whp.vo.AlarmInfoVO;
import com.back.whp.vo.AlarmVO;

import java.util.List;
import java.util.Map;

public interface AlarmService {
    AlarmInfoVO add(AlarmVO alarmVO);

    AlarmInfoVO getDetail(Integer alarmId);

    List<AlarmInfoVO> getListByChemical(Integer chemicalId);

    List<AlarmInfoVO> getListByState(Integer state);

    List<AlarmInfoVO> getList();

    AlarmInfoVO handle(String signature, AlarmHandleVO alarmHandleVO);

    Map<String, Integer> getTypes();
}
