package com.boot.es.mybootes.yibu.demo5;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask2 {

    @Async
    public void test1(){
        System.out.println("111111111");
    }
    @Async
    public void test2(){
        System.out.println("222222222");
    }
    @Async
    public void test3(){
        System.out.println("333333333");
    }
}
