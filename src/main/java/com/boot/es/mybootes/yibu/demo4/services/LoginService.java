package com.boot.es.mybootes.yibu.demo4.services;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 异步方法
     * 有@Async注解的方法，默认就是异步执行的，会在默认的线程池中执行，但是此方法不能在本类调用；
     * 启动类需添加直接开启异步执行@EnableAsync。
     */
    @Async
    public void getTest1() {
        for (int i = 1; i <= 10; i++) {
            logger.info(Thread.currentThread().getName() + "----------异步：>" + i);
            logger.info("============>" + "执行中");
        }
    }

    /**
     * 同步方法
     */
    public void getTest2() {
        synchronized (LoginService.class) {
            try {
                for (int i = 1; i <= 10; i++) {
                    logger.info(Thread.currentThread().getName() + "----------同步：>" + i);
                    logger.info("============>" + "执行中");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
