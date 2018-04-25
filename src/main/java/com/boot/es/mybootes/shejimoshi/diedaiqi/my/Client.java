package com.boot.es.mybootes.shejimoshi.diedaiqi.my;

public class Client {

    public static void main(String[] args) {
        ConcreteMyAggregate cma=new ConcreteMyAggregate();
        cma.addObject("aa");
        cma.addObject("bb");
        cma.addObject("cc");
        cma.addObject("dd");
        MyIterator iterator=cma.CreateIterator();
        while(iterator.hasnext()){
            System.out.println(iterator.next());
        }
    }
}
