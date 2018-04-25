package com.boot.es.mybootes.ESSearch;

import java.util.List;

public interface SearchEs {

    /**
     * 搜索,当关键字搜索失败时，会进行拆词的形式匹配
     * @param keyword   关键字
     * @param idKey     匹配名称
     * @param id        匹配id
     * @param keywordQueryIndex 分词方式
     * @see KeywordQueryEnum
     * @param sort  排序
     * @param sortType  排序规则
     * @param pageNum   页数
     * @param pageSize  页尺寸
     * @return
     */
    List<City> searchItemList(String keyword, String idKey, int id, int keywordQueryIndex, String sort, String sortType, int pageNum, int pageSize);
}
