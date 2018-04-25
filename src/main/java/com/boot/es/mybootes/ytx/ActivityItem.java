package com.boot.es.mybootes.ytx;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 拼团活动商品
 * @author
 */
public class ActivityItem implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 商家id
     */
    private Long sellerAccountId;
    /**
     * 商品SKUID
     */
    private Long itemSkuId;
    /**
     * 库存量
     */
    private Integer stockNum;
    /**
     * 市场价
     */
    private BigDecimal salePrice;
    /**
     * 拼团价
     */
    private BigDecimal activityPrice;
    /**
     * 限购数 每个用户最大能购买的数量
     * 1～5
     */
    private Integer restrictionsNum;
    /**
     * 参团人数
     *
     * 2～6
     */
    private Integer groupNum;
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



    public static void main(String[] args) {
        String te="1,2,";
        List<String> tes=Arrays.asList(te.split(","));

        System.out.println(tes.contains("1"));

    }

}
