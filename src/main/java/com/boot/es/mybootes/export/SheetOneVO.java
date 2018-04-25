package com.boot.es.mybootes.export;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by apple on 2018/1/17.
 * 第一个工作表的数据   订单列表
 * 不能改变顺序，需要添加只能追加到最前或最后 对应headers数组
 */
@Data
public class SheetOneVO implements Serializable {
    public static final String[] headers = {"订单编号", "订单创建时间", "商品总数量", "商家备注", "订单状态 汉字描述"};
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
