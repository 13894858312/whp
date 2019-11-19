package com.back.whp.vo;

import com.google.common.base.Preconditions;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddChemicalVO {
    @ApiModelProperty("必填")
    private String cnName;
    private String cnAlia;
    @ApiModelProperty("必填")
    private String enName;
    private String enAlia;

    @ApiModelProperty("必填")
    private String cas;
    @ApiModelProperty("分子式，必填")
    private String formula;
    @ApiModelProperty("分子量，必填")
    private Double weight;

    @ApiModelProperty("理化特性")
    private String properties;
    @ApiModelProperty("稳定性和反应性")
    private String stability;
    @ApiModelProperty("危险有害性概述")
    private String overview;
    @ApiModelProperty("GHS危害性分类")
    private String dangerClass;
    @ApiModelProperty("操作处置与储存")
    private String word;
    @ApiModelProperty("接触控制/个体防护")
    private String touchControl;
    @ApiModelProperty("急救措施")
    private String firstAid;
    @ApiModelProperty("泄露应急处理")
    private String leakage;
    @ApiModelProperty("废弃处置")
    private String disposal;

    public void validate(){
        Preconditions.checkArgument(cnName != null && cnName.length() > 0, "invalid cnName");
        Preconditions.checkArgument(enName != null && enName.length() > 0, "invalid enName");
        Preconditions.checkArgument(cas != null && cas.length() > 0, "invalid cas");
        Preconditions.checkArgument(formula != null && formula.length() > 0, "invalid formula");
        Preconditions.checkArgument(weight != null && weight > 0, "invalid weight");
    }
}
