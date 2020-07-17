package com.back.whp.model;

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
@Table(name = "alarm")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlarmEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer chemicalId;

    private String title;

    private Integer type;

    private String contact;

    private String username;

    private String remarks;//备注信息

    private String position;//经纬度
    private String address;//具体位置

    /**
     * @see com.back.whp.constants.AlarmState
     */
    private Integer state;

    private Integer handleManagerId;

    private Timestamp createTime;
    private Timestamp modifyTime;
}
