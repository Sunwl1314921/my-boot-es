package com.boot.es.mybootes.shejimoshi.diedaiqi.my;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 */
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<Object>();

    public void addObject(Object obj) {
        this.list.add(obj);
    }

    public void removeObject(Object obj) {
        this.list.remove(obj);
    }

    //获取迭代器
    public MyIterator CreateIterator() {
        return new ConcreteMyIterator();
    }

    /**
     * 具体迭代器角色
     * 使用内部类定义迭代器，可以直接使用外部类属性
     */
    private  class ConcreteMyIterator implements MyIterator{
        private int cursor;//定义游标用于记录遍历时的位置

        @Override
        public boolean hasnext() {
            if(cursor<list.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            Object obj=list.get(cursor);
            if(cursor<list.size()){
                cursor++;
            }
            return obj;
        }
    }
}