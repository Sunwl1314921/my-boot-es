//package com.boot.es.mybootes.yibu;
//
//import org.springframework.scheduling.annotation.EnableAsync;
//
//@EnableAsync
//public class Test {
//
//    public static void main(String[] args) {
//        Account account=new Account();
//        account.setId(1L);
//        account.setName("swl");
//
//        System.out.println("111111");
//        publishAccountRegisterEvent(account);
//
//        System.out.println("555555");
//    }
//
//    private static void publishAccountRegisterEvent(Account account) {
//        AccountRegisterEvent accountRegisterEvent = new AccountRegisterEvent();
//        accountRegisterEvent.setPayload(account);
//        MyApplicationEventPublisher applicationEventPublisher=new MyApplicationEventPublisher();
//        applicationEventPublisher.publishEvent(accountRegisterEvent);
//    }
//}
