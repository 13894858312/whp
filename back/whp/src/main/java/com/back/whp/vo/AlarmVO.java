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
public class AlarmVO {
    private Integer chemicalId;

    @ApiModelProperty("报警信息")
    private String title;

    @ApiModelProperty("备注信息")
    private String remarks;

    @ApiModelProperty("位置信息")
    private String position;
}
