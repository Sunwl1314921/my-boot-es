package com.boot.es.mybootes.yibu.demo4;

import com.boot.es.mybootes.yibu.demo4.services.LoginService;
import com.boot.es.mybootes.yibu.demo4.services.RunnableTask1;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("tmall")
public class LoginController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginService loginService;
    /**
     * 同步处理
     * @return
     */
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public String test2(){
        logger.info("============>" + "开始执行");
        loginService.getTest2();
        logger.info(Thread.currentThread().getName()+"==========主线程名");
        logger.info("============>" + "执行完毕");
        return "同步,正在解析......";
    }

    /**
     * 异步处理1：线程池，创建新线程处理
     * @return
     */
    @RequestMapping(value = "test3",method = RequestMethod.GET)
    public String test3(){
        logger.info("============>" + "开始执行");
        ExecutorService service = Executors.newFixedThreadPool(5);
        RunnableTask1 task1 = new RunnableTask1();
        service.execute(task1);
        logger.info("=========当前线程名》："+Thread.currentThread().getName());
        logger.info("============>" + "执行完毕");
        return "异步,正在解析......";
    }


    /**
     * 异步处理2：使用springBoot自带async注解
     */
    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public String test1() {
        logger.info("============>" + "开始执行");
        loginService.getTest1();
        logger.info("============>" + Thread.currentThread().getName());
        logger.info("============>" + "执行完毕");
        return "异步,正在解析......";
    }
}
