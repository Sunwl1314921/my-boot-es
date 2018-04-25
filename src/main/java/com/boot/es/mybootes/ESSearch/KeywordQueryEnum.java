package com.boot.es.mybootes.ESSearch;

/**
 * 关键字查询方式枚举
 */
public enum KeywordQueryEnum {

    NONE_KEYWORD_MATCH(0, "不含关键字匹配"),

    FULL_TEXT_MATCH(1, "全文本匹配"),

    FULL_TERM_MATCH(2, "全词项匹配"),

    SEGMENT_TERM_MATCH(3, "部分词项匹配"),

    COMMON_KEYWORD_MATCH(4, "普通匹配");


    private int index;

    private String name;

    KeywordQueryEnum(int index, String name){
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
