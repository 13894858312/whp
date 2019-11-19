package com.back.whp.service.impl;

import com.back.whp.dao.TransferRepository;
import com.back.whp.model.TransferEntity;
import com.back.whp.service.TransferService;
import com.back.whp.vo.AddTransferVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private TransferRepository transferRepository;

    @Override
    public List<TransferEntity> getTransfer(String bn) {
        return transferRepository.findByBn(bn);
    }

    @Override
    public TransferEntity add(AddTransferVO addTransferVO) {
        TransferEntity transferEntity = new TransferEntity();
        BeanUtils.copyProperties(addTransferVO, transferEntity);

        transferEntity.setCreateTime(new Timestamp(new Date().getTime()));

        return transferRepository.saveAndFlush(transferEntity);
    }

    @Override
    public TransferEntity getDetail(Integer transferId) {
        return transferRepository.findOne(transferId);
    }

    @Override
    public List<TransferEntity> getList() {
        return transferRepository.getAll();
    }
}
