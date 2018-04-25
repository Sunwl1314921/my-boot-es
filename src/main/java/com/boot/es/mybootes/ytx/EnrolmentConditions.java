package com.boot.es.mybootes.ytx;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 报名条件
 * @author
 */
public class EnrolmentConditions implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 报名条件名称
     */
    private String name;
    /**
     * 报名要求
     * 1~5之间的数字，精确的小数点后一位
     */
    private BigDecimal requirement;
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
