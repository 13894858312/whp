package com.back.whp.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlarmHandleVO {
    private Integer alarmId;

    @ApiModelProperty("提交1 | 正在处理2 | 已处理3 | 拒绝处理4")
    private Integer state;

    private Integer managerId;
}
