package com.boot.es.mybootes.yibu.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/my")
@RestController
public class AsyncTaskController {

    @Autowired
    private AsyncTask asyncTask;
    @Autowired
    private AsyncTask2 asyncTask2;

    @RequestMapping("")
    public String doTask() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
        long currentTimeMillis1 = System.currentTimeMillis();
        return "task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";

    }

    @RequestMapping("/2")
    public String doTask2(){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("开始");
        asyncTask2.test1();
        asyncTask2.test2();
        asyncTask2.test3();
        System.out.println("结束");
        long currentTimeMillis1 = System.currentTimeMillis();
        return "task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";

    }
}
