package com.back.whp.vo;

import com.back.whp.constants.AlarmType;
import com.back.whp.model.AlarmEntity;
import com.back.whp.model.BaseInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlarmInfoVO {
    private Integer id;

    private Integer chemicalId;

    private String chemicalName;

    private String title;

    private String type;

    private String contact;

    private String username;

    private String remarks;//备注信息

    private String position;

    /**
     * @see com.back.whp.constants.AlarmState
     */
    private Integer state;

    private Integer handleManagerId;

    private Timestamp createTime;
    private Timestamp modifyTime;

    public AlarmInfoVO(AlarmEntity alarmEntity, BaseInfoEntity baseInfoEntity){
        BeanUtils.copyProperties(alarmEntity, this, "type");
        String type = AlarmType.alarmTypeI2S.getOrDefault(alarmEntity.getType(), "未知类型");
        this.setType(type);
        this.setChemicalName(baseInfoEntity.getCnName());
    }
}
