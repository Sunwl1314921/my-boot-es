package com.stream.source.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


@Component
public class Service {

    @Autowired
    private Processor processor;

//    public boolean write(String data) {
//        return processor.output().send(MessageBuilder.withPayload(data).build());
//    }


    public boolean write(Object data) {
        return processor.output().send(
                MessageBuilder.withPayload(data).setHeader("contentType", data.getClass().getSimpleName()).build());
    }

    public boolean subscribe(MessageHandler handler) {
        return processor.input().subscribe(handler);
    }
}
