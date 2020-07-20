package com.back.whp.model;

import com.back.whp.vo.AddChemicalVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "base_info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseInfoEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String cnName;//中文名称
    private String enName;//英文名称
    private String cnAlia;//中文别名

    private String cas;//CAS号
    private String formula;//分子式

    private String emergency; // 紧急情况描述
    private String dangerClass;//GHS危害性分类
    private String other;// 未知列
    private String danger;//危险信息
    private String prevent;//预防措施
    private String response;//事故响应
    private String store;//安全存储
    private String disposalOverview;//废弃处置
    private String physicalChemical;//物理和化学危险
    private String health;//健康危害
    private String environment;//环境危害

    private String firstAid;//急救措施
    private String eyeTouch;//急救措施-眼睛接触
    private String skinTouch;//急救措施-皮肤接触
    private String eat;//急救措施-食入
    private String breath;//急救措施-吸入

    private String advice;//对保护施救者的忠告
    private String doctor;//对医生的特别提示
    private String dangerProperties;//危险特性
    private String fireStuff;//适合的灭火介质
    private String notFireStuff;//不适合的灭火介质
    private String fireStep;//灭火注意事项及措施
    private String protectiveStep;//作业人员防护措施、防护装备和应急处置程序
    private String environmentStep;//环境保护措施
    private String leakMethod;//泄漏化学品的收容、清除方法及处置材料
    private String stepAttention;//操作注意事项
    private String stepAttention2;//操作注意事项
    private String storeAttention;//储存注意事项
    private String engControl;//工程控制
    private String eyeProtect;//眼睛防护
    private String handProtect;//手部防护
    private String breathProtect;//呼吸系统防护
    private String skinProtect;//皮肤和身体防护
    private String look;//外观与性状
    private String ph;//ph值（指明浓度）
    private String smell;//气味
    private String fei;//沸点、初沸点和沸程(℃)
    private String rong;//熔点/凝固点(℃)
    private String sky;//相对蒸气密度(空气=1)
    private String kpa;//饱和蒸汽压
    private String water;//相对密度
    private String mm2;//黏度
    private String shan;//闪点
    private String xinchun;//n-辛醇/水分配系数
    private String fenjie;//分解温度
    private String yinran;//引燃温度
    private String baozha;//爆炸上限/下限
    private String rongjie;//溶解性
    private String yiran;//易燃性
    private String stability;//稳定性
    private String dangerAct;//危险反应
    private String avoid;//应避免的条件
    private String noRong;//不相容的物质
    private String apart;//分解产物
    private String disposal;//废弃物质处置方法-产品
    private String disposal2;//废弃处置方法-不洁的包装
    private String disposalAttention;//废弃注意事项
    private String transAttention;//运输注意事项
    private int book1;
    private int book2;
    private int book3;
    private int book4;
    private int book5;
    private int book6;
    private int book7;
    private int book8;

    private String uri;

    public BaseInfoEntity(AddChemicalVO addChemicalVO) {
        BeanUtils.copyProperties(addChemicalVO, this);
    }

}
