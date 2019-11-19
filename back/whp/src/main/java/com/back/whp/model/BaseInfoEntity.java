package com.back.whp.model;

import com.back.whp.vo.AddChemicalVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "base_info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseInfoEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String cnName;
    private String cnAlia;
    private String enName;
    private String enAlia;

    private String cas;
    private String formula;//分子式
    private Double weight;//分子量

    private String properties;//理化特性
    private String stability;//稳定性和反应性
    private String overview;//危险有害性概述
    private String dangerClass;//GHS危害性分类
    private String word;//操作处置与储存
    private String touchControl;//接触控制/个体防护
    private String firstAid;//急救措施
    private String leakage;//泄露应急处理
    private String disposal;//废弃处置

    private String uri;

    public BaseInfoEntity(AddChemicalVO addChemicalVO){
        BeanUtils.copyProperties(addChemicalVO, this);
    }

}
