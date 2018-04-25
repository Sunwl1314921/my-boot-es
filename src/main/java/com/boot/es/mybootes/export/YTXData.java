package com.boot.es.mybootes.export;

import java.util.Map;

/**
 * @author Asion.
 * @since 2017/10/13.
 */
public interface YTXData {

    Map<String, Object> getData();

    <T> T getData(String dataName);

    <T> T addData(String dataName, T dataValue);

    <T> Map<String, T> addAllData(Map<String, T> data);
}
