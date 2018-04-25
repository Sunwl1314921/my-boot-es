package com.boot.es.mybootes.export;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Alex
 **/
@Data
public class OrderVO {
    /**
     * 订单编号
     */
    public int id;
    /**
     * 创建时间
     */
    public String createdAt;
    /**
     * 当前订单中商品数
     */
    public Integer itemSumCount;
    /**
     * 商家备注
     */
    public String remark;
    /**
     * 订单状态 汉字描述
     */
    public String orderStatusStr;

}
