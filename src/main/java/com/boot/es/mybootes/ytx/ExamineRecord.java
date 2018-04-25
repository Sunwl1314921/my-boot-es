package com.boot.es.mybootes.ytx;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 审核记录表
 * @author
 */
public class ExamineRecord implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 审核拼团活动商品id
     */
    private Long  ActivityItemId;
    /**
     * 审核状态
     */
    public enum Status {
        /**
         * 待设置
         */
        WAIT_SETUP(1, "待设置"),
        /**
         * 待提交
         */
        WAIT_SUBMIT(2, "待提交"),
        /**
         * 待审核
         */
        WAIT_EXAMINE(3, "待审核"),
        /**
         * 审核驳回
         */
        REJECT_EXAMINE(4, "审核驳回"),
        /**
         * 审核通过
         */
        ADOPT_EXAMINE(5, "审核通过"),
        /**
         * 已下线
         *
         * 已下线状态的商品商家修改后可再次上线，不需要再次审核
         *
         *
         6、已下线：对应的操作有设置、审核记录；已下线的商品修改后提交审核，
            还是在平台已下线列表，不需要平台再次审核，平台可操作上线，操作上线后商品为审核通过状态；
         */
        DOWNLINE(6, "已下线");

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
    /**
     * 审核驳回原因
     */
    private String rejectReson;
    /**
     * 创建时间
     */
    private Date createdAt;
}
