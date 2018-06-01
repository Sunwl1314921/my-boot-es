package com.boot.es.mybootes.yibu.demo3.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public interface DemoAsyncService {

    @Async
    public Future<String> doTaskOne() throws Exception;

    @Async
    public Future<String> doTaskTwo() throws Exception;

    @Async
    public Future<String> doTaskThree() throws Exception;
}