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
@Table(name = "history")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer managerId;
    private Integer chemicalId;
    private String chemicalName;

    private Timestamp createTime;


}
