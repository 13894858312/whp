package com.back.whp.service;

import com.back.whp.model.TransferEntity;
import com.back.whp.vo.AddTransferVO;

import java.util.List;

public interface TransferService {
    TransferEntity add(AddTransferVO addTransferVO);

    List<TransferEntity> getTransfer(String bn);

    TransferEntity getDetail(Integer transferId);

    List<TransferEntity> getList();
}
