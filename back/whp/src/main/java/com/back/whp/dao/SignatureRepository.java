package com.back.whp.dao;

import com.back.whp.model.SignatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface SignatureRepository extends JpaRepository<SignatureEntity, String> {

    @Transactional
    void deleteAllByUserClientLike(String username);

    SignatureEntity findBySignature(String signature);
}
