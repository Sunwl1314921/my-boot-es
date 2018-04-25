package com.boot.es.mybootes.shejimoshi.diedaiqi.my;

/**
 * 自定义迭代器接口
 */
public interface MyIterator {
    boolean hasnext();//是否有下一个元素
    Object next();//获取当前游标所指元素,并将游标加1
}
