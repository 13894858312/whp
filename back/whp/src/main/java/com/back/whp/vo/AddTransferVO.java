package com.back.whp.vo;

import com.back.whp.constants.TransferState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTransferVO {

    private Integer chemicalId;

    private String bn;//产品批号
    private String enterprise;//企业名称

    /**
     * 状态
     *
     * @see TransferState
     */
    private Integer state;

    private String remarks;//备注信息
    private String position;//经纬度
    private String address;//具体位置
}
