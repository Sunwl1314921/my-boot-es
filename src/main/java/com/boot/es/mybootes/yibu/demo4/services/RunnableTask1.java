package com.boot.es.mybootes.yibu.demo4.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnableTask1 implements Runnable{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(){
        synchronized (RunnableTask1.class){
            try {
                for (int i = 1;i <= 10;i++){
                    logger.info("============>" + "执行中");
                    System.out.println(Thread.currentThread().getName()+"----------异步：>"+i);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
