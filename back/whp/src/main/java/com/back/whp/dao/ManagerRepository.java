package com.back.whp.dao;

import com.back.whp.model.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerEntity, Integer> {

    ManagerEntity findByEmail(String email);

    ManagerEntity findByNickname(String nickname);
}
