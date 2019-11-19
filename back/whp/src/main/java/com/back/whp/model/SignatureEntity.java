package com.back.whp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "signature")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignatureEntity {
    @Id
    private String userClient;

    private String signature;

    private long timestamp;

}
