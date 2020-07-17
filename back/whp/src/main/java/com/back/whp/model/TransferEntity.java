package com.back.whp.model;

import com.back.whp.constants.TransferState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "transfer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer chemicalId;

    private String bn;//产品批号
    private String enterprise;//企业名称

    /**
     * 状态
     *
     * @see TransferState
     */
    private Integer state;

    private String remarks;//备注信息
    private String position;//经纬度
    private String address;//具体位置

    private Timestamp createTime;
    private Timestamp modifyTime;

}
