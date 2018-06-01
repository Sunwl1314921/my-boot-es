//package com.boot.es.mybootes.yibu;
//
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.context.event.EventListener;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//
//@Component
//public  class MyApplicationEventPublisher implements ApplicationEventPublisher {
//
//    @Async
//    @EventListener
//    public void  handleAccountRegister(AccountRegisterEvent accountRegisterEvent){
//        System.out.println("333333");
//        Account account = accountRegisterEvent.getPayload();
//    }
//
//    @Override
//    public void publishEvent(ApplicationEvent applicationEvent) {
//        System.out.println("4444444");
//    }
//
//    @Override
//    public void publishEvent(Object o) {
//        System.out.println("222222");
//        handleAccountRegister((AccountRegisterEvent)o);
//    }
//}
