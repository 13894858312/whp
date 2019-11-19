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
@Table(name = "manager")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String password;
    private String username;
    private String nickname;

}
