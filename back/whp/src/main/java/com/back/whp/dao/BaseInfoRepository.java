package com.back.whp.dao;

import com.back.whp.model.BaseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BaseInfoRepository extends JpaRepository<BaseInfoEntity, Integer> {
    BaseInfoEntity findByCas(String cas);

    List<BaseInfoEntity> findByCasLike(String cas);

    @Query("select b from BaseInfoEntity b where (b.cnName like :name) or (b.cnAlia like :name) or (b.enName like :name)")
    List<BaseInfoEntity> searchByName(@Param("name") String name);

    @Query("select b from BaseInfoEntity b where b.cas like :cas and ((b.cnName like :name) or (b.cnAlia like :name) or (b.enName like :name))")
    List<BaseInfoEntity> searchByCasAndName(@Param("cas") String cas, @Param("name") String name);
}
