package com.back.whp.dao;

import com.back.whp.model.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Integer> {
    List<HistoryEntity> findByManagerIdOrderByCreateTimeDesc(Integer managerId);

}
