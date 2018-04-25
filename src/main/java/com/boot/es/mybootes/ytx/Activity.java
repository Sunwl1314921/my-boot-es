package com.boot.es.mybootes.ytx;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * 平台活动
 * @author
 */
@Data
public class Activity implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 活动名称
     *
     * 活动名称不重复
     * < 20字
     */
    private String name;
    /**
     * 活动说明 <100字
     * 展示给商家
     */
    private String explain;
    /**
     * 报名开始时间
     *
     * 开始时间不能早于当前时间
     * 报名开始后 此项不能修改
     * 未到报名开始时间的活动才能删除
     */
    private Date signUpAt;
    /**
     * 报名截止时间
     *
     * 结束时间不能早于开始时间
     */
    private Date signEndAt;
    /**
     * 活动开始时间
     *
     *  < 报名截止时间+24h
     * 活动时间开始前商品审核截止
     * 审核自动驳回
     * 提示：审核时间已截止
     */
    private Date activityUpAt;
    /**
     * 活动截止时间
     */
    private Date activityEndAt;
    /**
     * 商家类型
     *
     * 特卖不能参与拼团活动
     * 可多选，多选用,隔开
     */
    private String sellerType;
    /**
     * 商家类型
     */
    public enum SellerType {
        /**
         * 全部商家
         */
        ALL_SELLER(1,"全部商家"),
        /**
         * 商城
         */
        SHOPPING_MALL(2,"商城"),
        /**
         * 自营超市
         */
        YTX_SUPERMARKET(3,"自营超市");


        @Getter
        @Setter
        private int code;

        @Getter
        @Setter
        private String name;

        SellerType(int code, String name) {
            this.code = code;
            this.name = name;
        }
    }
    /**
     * 报名商品数
     *
     * 商家可报名的商品数不能超于该数量
     */
    private Integer signCommodityNum;
    /**
     * 坑位数
     *
     * 一期活动最大商品数，审核通过的商品数量不能超于该数量
     * =该数量时 显示 已报满
     */
    private Integer pitsNum;
    /**
     * 是否包邮
     */
    private boolean freeShipping;
    /**
     * 活动类目ID
     */
    private Long categoryId;
    /**
     * 条件ID
     */
    private Long EnrolmentConditionsId;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 修改时间
     */
    private Date updatedAt;
    /**
     * 状态
     */
    public Integer Status;
    /**
     * 状态
     */
    public enum Status {
        /**
         * 删除
         */
        OUT(0, "删除"),

        /**
         * 正常
         */
        NORMAL(1, "正常");

        @Getter
        @Setter
        private int code;

        @Getter
        @Setter
        private String name;

        Status(int code, String name) {
            this.code = code;
            this.name = name;
        }
    }


}
