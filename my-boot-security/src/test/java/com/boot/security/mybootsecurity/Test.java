package com.boot.security.mybootsecurity;


import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * MapUtils 的用法
 */
public class Test {

    public static void main(String[] args) {
        Map<String, Object> result = new HashMap<>();
        result.put("error","swl");
        result.put("error",12);

        result.put("error","heh");
        result.put("error","boy");
        String suffix = "请编辑商品补充必要信息后再做*保存*操作!";
        String error = MapUtils.getString(result, "error");
        error = error + suffix;

        System.out.println(error);
    }
}
