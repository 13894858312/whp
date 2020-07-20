package com.back.whp.dao;

import com.back.whp.model.AlarmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlarmRepository extends JpaRepository<AlarmEntity, Integer> {
    List<AlarmEntity> findByChemicalId(Integer chemicalId);

    List<AlarmEntity> findByStateOrderByCreateTimeDesc(Integer state);

    @Query("select a from AlarmEntity a order by a.createTime desc ")
    List<AlarmEntity> getAll();
}
