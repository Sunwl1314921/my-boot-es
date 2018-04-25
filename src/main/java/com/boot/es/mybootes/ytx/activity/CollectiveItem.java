package com.boot.es.mybootes.ytx.activity;

import lombok.Data;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Data
public class CollectiveItem implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 活动ID
     */
    private Long collectiveActivityId;
    /**
     * 商家账户ID
     */
    private Long sellerAccountId;
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 活动商品名称
     */
    private String itemName;
    /**
     * 活动图
     */
    private String img;
    /**
     * 活动库存
     */
    private Integer stock;
    /**
     * 每人限购
     */
    private Integer limit;
    /**
     * 报名费用
     */
    private Integer fee;
    /**
     * 市场价格/正常价
     */
    private BigDecimal marketPrice;
    /**
     * 活动价/参团价
     */
    private BigDecimal activityPrice;
    /**
     * 参团人数
     */
    private Integer groupNum;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 销量
     */
    private Integer saleNum;

    private Date createdAt;

    private Date updatedAt;
    /**
     * 待设置/待提交/待审核/审核通过/审核驳回/已下线/已下线待审核
     */
    public enum Status {
        /**
         * 待设置
         */
        WAIT_SETUP(11, "待设置"),

        /**
         * 待提交
         */
        WAIT_SUBMIT(12, "待提交"),
        /**
         * 已下线待审核
         */
        OFFLINE_WAIT_EXAMINE(13, "已下线待审核"),
        /**
         * 待审核
         */
        WAIT_EXAMINE(21, "待审核"),
        /**
         * 审核通过
         */
        EXAMINE_ADOPT(22, "审核通过"),
        /**
         * 审核驳回
         */
        EXAMINE_REGECT(23, "审核驳回"),
        /**
         * 已下线 Already Offline
         */
        ALREADY_OFFLINE(24, "已下线");

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
