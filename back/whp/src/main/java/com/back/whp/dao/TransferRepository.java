package com.back.whp.dao;

import com.back.whp.model.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransferRepository extends JpaRepository<TransferEntity, Integer> {
    List<TransferEntity> findByBn(String bn);

    @Query("select t from TransferEntity t order by t.createTime desc ")
    List<TransferEntity> getAll();
}
