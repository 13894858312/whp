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
    @ApiModelProperty("必填")
    private String enName;
    @ApiModelProperty("中文别名")
    private String cnAlia;

    @ApiModelProperty("必填，cas")
    private String cas;
    @ApiModelProperty("必填，分子式")
    private String formula;

    @ApiModelProperty("紧急情况描述")
    private String emergency;
    @ApiModelProperty("GHS危害性分类")
    private String dangerClass;
    @ApiModelProperty("未知列")
    private String other;
    @ApiModelProperty("危险信息")
    private String danger;
    @ApiModelProperty("预防措施")
    private String prevent;
    @ApiModelProperty("事故响应")
    private String response;
    @ApiModelProperty("安全存储")
    private String storage;
    @ApiModelProperty("物理和化学危险")
    private String physicalChemical;
    @ApiModelProperty("健康危害")
    private String health;
    @ApiModelProperty("环境危害")
    private String environment;

    @ApiModelProperty("急救措施")
    private String firstAid;
    @ApiModelProperty("急救措施-眼睛接触")
    private String eyeTouch;
    @ApiModelProperty("急救措施-皮肤接触")
    private String skinTouch;
    @ApiModelProperty("急救措施-食入")
    private String eat;
    @ApiModelProperty("急救措施-吸入")
    private String breath;

    @ApiModelProperty("对保护施救者的忠告")
    private String advice;
    @ApiModelProperty("对医生的特别提示")
    private String doctor;
    @ApiModelProperty("危险特性")
    private String dangerProperties;
    @ApiModelProperty("适合的灭火介质")
    private String fireStuff;
    @ApiModelProperty("必不适合的灭火介质填")
    private String notFireStuff;
    @ApiModelProperty("灭火注意事项及措施")
    private String fireStep;
    @ApiModelProperty("作业人员防护措施、防护装备和应急处置程序")
    private String protectiveStep;
    @ApiModelProperty("环境保护措施")
    private String environmentStep;
    @ApiModelProperty("泄漏化学品的收容、清除方法及处置材料")
    private String leakMethod;
    @ApiModelProperty("操作注意事项")
    private String stepAttention;
    @ApiModelProperty("操作注意事项")
    private String stepAttention2;
    @ApiModelProperty("储存注意事项")
    private String storageAttention;
    @ApiModelProperty("工程控制")
    private String engControl;
    @ApiModelProperty("眼睛防护")
    private String eyeProtect;
    @ApiModelProperty("手部防护")
    private String handProtect;
    @ApiModelProperty("呼吸系统防护")
    private String breathProtect;
    @ApiModelProperty("皮肤和身体防护")
    private String skinProtect;
    @ApiModelProperty("外观与性状")
    private String look;
    @ApiModelProperty("ph值（指明浓度）")
    private String ph;
    @ApiModelProperty("气味")
    private String smell;
    @ApiModelProperty("沸点、初沸点和沸程(℃)")
    private String fei;
    @ApiModelProperty("熔点/凝固点(℃)")
    private String rong;
    @ApiModelProperty("相对蒸气密度(空气=1)")
    private String sky;
    @ApiModelProperty("饱和蒸汽压")
    private String kpa;
    @ApiModelProperty("相对密度")
    private String water;
    @ApiModelProperty("黏度")
    private String mm2;
    @ApiModelProperty("闪点")
    private String shan;
    @ApiModelProperty("n-辛醇/水分配系数")
    private String xinchun;
    @ApiModelProperty("分解温度")
    private String fenjie;
    @ApiModelProperty("引燃温度")
    private String yinran;
    @ApiModelProperty("爆炸上限/下限")
    private String baozha;
    @ApiModelProperty("溶解性")
    private String rongjie;
    @ApiModelProperty("易燃性")
    private String yiran;
    @ApiModelProperty("稳定性")
    private String stability;
    @ApiModelProperty("危险反应")
    private String dangerAct;
    @ApiModelProperty("应避免的条件")
    private String avoid;
    @ApiModelProperty("不相容的物质")
    private String noRong;
    @ApiModelProperty("分解产物")
    private String apart;
    @ApiModelProperty("废弃物质处置方法")
    private String disposal;
    @ApiModelProperty("废弃处置方法-不洁的包装")
    private String disposal2;
    @ApiModelProperty("废弃注意事项")
    private String disposalAttention;
    @ApiModelProperty("运输注意事项")
    private String transAttention;
    @ApiModelProperty("《危险化学品目录（2015年版）》，安监总局2015年第5号公告")
    private int book1;
    @ApiModelProperty("《重点环境管理危险化学品目录》，环保部办公厅2014年第33号文")
    private int book2;
    @ApiModelProperty("《中国严格限制的有毒化学品名录》，环保部2017年第74号公告")
    private int book3;
    @ApiModelProperty("《麻醉药品和精神药品品种目录（2013年版）》，食药总局2013年第230号通知")
    private int book4;
    @ApiModelProperty("《重点监管的危险化学品名录（第1和第2批）》，安监总局2011年第95号和2013年第12号通知")
    private int book5;
    @ApiModelProperty("《中国进出口受控消耗臭氧层物质名录（第1到6批）》，环保部2000年至2012系列公告")
    private int book6;
    @ApiModelProperty("《易制爆危险化学品名录（2017年版）》，公安部2017年5月11日公告")
    private int book7;
    @ApiModelProperty("《高毒物品目录》，卫生部2003年第142号通知")
    private int book8;

    public void validate() {
        Preconditions.checkArgument(cnName != null && cnName.length() > 0, "invalid cnName");
        Preconditions.checkArgument(enName != null && enName.length() > 0, "invalid enName");
        Preconditions.checkArgument(cas != null && cas.length() > 0, "invalid cas");
        Preconditions.checkArgument(formula != null && formula.length() > 0, "invalid formula");
    }
}
