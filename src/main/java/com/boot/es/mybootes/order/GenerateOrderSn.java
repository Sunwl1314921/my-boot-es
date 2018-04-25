package com.boot.es.mybootes.order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单流水号
 *
 * @author zhaoya
 * @author chenlushun
 */
public class GenerateOrderSn {
    /**
     * 订单编号前缀
     */
    public static final String PREFIX_SN_PURCHASEORDER = "Y";
    /**
     * 商家订单前缀
     */
    public static final String PREFIX_SN_SALEORDER = "S";
    /**
     * 支付单号前缀
     */
    public static final String PREFIX_SN_PAYMENT = "P";
    /**
     * 售后单号前缀
     */
    public static final String PREFIX_SN_REFUND = "T";
    /**
     * 时间格式
     */
    public static final String DATE_STYLE = "yyMMddHHmmss";

    /**
     * 生成订单流水号
     *
     * @return 订单流水号
     */
    public static synchronized String getOrderSn() {
        String uuid = getRandom(6);
        String str = new SimpleDateFormat(DATE_STYLE).format(new Date());
        return PREFIX_SN_PURCHASEORDER + str + uuid;
    }

    /**
     * 生成订单支付流水号
     *
     * @return 外部交易流水号
     */
    public static synchronized String getOrderPaymentSn() {
        String uuid = getRandom(6);
        String str = new SimpleDateFormat(DATE_STYLE).format(new Date());
        return (PREFIX_SN_PAYMENT + str + uuid);
    }

    /**
     * 生成内部退款交易流水号
     *
     * @return 生成内部退款交易流水号
     */
    public static synchronized String getRefundSn() {
        String uuid = getRandom(6);
        String str = new SimpleDateFormat(DATE_STYLE).format(new Date());
        return (PREFIX_SN_REFUND + str + uuid);
    }

    /**
     * 生成卖家订单号
     *
     * @return 卖家订单号
     */
    public static synchronized String getSaleOrderSn() {
        String uuid = getRandom(6);
        String str = new SimpleDateFormat(DATE_STYLE).format(new Date());
        return (PREFIX_SN_SALEORDER + str + uuid);
    }

    /**
     * 生成对应位数的不规则数字
     *
     * @param len 要生成不规则数字的长度
     * @return 所生成的数字字符串
     */
    public static String getRandom(int len) {
        return String.format("%0" + len + "d", (int) (Math.pow(10, len) * Math.random()));
    }

    public static void main(String[] args) {
        String saleOrder = getSaleOrderSn();
        String refund = getRefundSn();
        String orderPayment = getOrderPaymentSn();
        String refunds = getRefundSn();
        String orderPayments = getOrderPaymentSn();
        String order = getOrderSn();
        System.out.println(saleOrder);
        System.out.println(refund);
        System.out.println(orderPayment);
        System.out.println(refunds);
        System.out.println(orderPayments);
        System.out.println(order);
    }

    //S180209162754179579
    //T180209162754085988
    //P180209162754260870
    //T180209162754378573
    //P180209162754886511
    //Y180209162754651123
}
