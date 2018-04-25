package com.boot.es.mybootes.export;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2018/1/17.
 * 订单导出的vo
 */
@Data
public class OrderExportVO implements Serializable {

    public static final String[] sheets = {"订单列表", "商品列表"};
    /**
     * 第一个工作表的数据
     */
    public List<SheetOneVO> sheetOneVOs;

}
