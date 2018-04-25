package com.boot.es.mybootes.export;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository("BeanServices")
public class BeanServices implements BeanService {

    public YTXResponse getBeans() {
        YTXResponse ytxResponse = new YTXResponse();
        List<OrderVO> orderVOS = new ArrayList<>();

        int it = 10;
        for (int i = 0; i < 10; i++) {
            OrderVO orderVO = new OrderVO();
            orderVO.setId(i);

            orderVO.setCreatedAt(DateUtil.DateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
            orderVO.setItemSumCount(i + 10);
            orderVO.setOrderStatusStr("订单状态 汉字描述" + i);
            orderVO.setRemark("备注" + i);
            orderVOS.add(orderVO);

        }

        Page page = new Page<OrderVO>();
        BeanUtils.copyProperties(orderVOS, page);

        page.setTotal(orderVOS.size());
        page.setList(orderVOS);
        page.setPageNum(1);

        ytxResponse.addData("data", orderVOS);
        ytxResponse.addData("page", page);
        return ytxResponse;
    }
}
