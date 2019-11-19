package com.back.whp.service;

import com.back.whp.model.BaseInfoEntity;
import com.back.whp.model.HistoryEntity;
import com.back.whp.vo.AddChemicalVO;
import com.back.whp.vo.ChemicalSearchVO;
import com.back.whp.vo.HistoryVO;

import java.util.List;

public interface BaseInfoService {
    List<BaseInfoEntity> getChemicals(ChemicalSearchVO chemicalSearchVO);

    BaseInfoEntity getChemical(Integer chemicalId, String cas);

    List<BaseInfoEntity> getChemicals(List<Integer> chemicalIds);

    String genCodeByCas(String cas);

    BaseInfoEntity addChemical(AddChemicalVO addChemicalVO);

    HistoryEntity addHistory(String signature, HistoryVO historyVO);

    List<HistoryEntity> getHistories(String signature, Integer managerId);
}
