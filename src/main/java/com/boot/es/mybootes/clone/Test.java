//package com.boot.es.mybootes.clone;
//
//import org.apache.commons.beanutils.BeanUtils;
//
//import java.lang.reflect.InvocationTargetException;
//
///**
// * clone 克隆测试
// */
//public class Test {
//
//    public static void main(String[] args) {
//        Parent parent = new Parent(1, "三四十", "杭州", 12, true);
//
//        System.out.println(parent.getId() + parent.getName() + parent.getCity() + parent.getAge() + parent.getSex());
//
//        try {
//            Child child = new Child();
//            BeanUtils.copyProperties(child, parent);
//
//            System.out.println(child.getIds() + child.getAge() + child.getCont() + child.getName() + child.getSex());
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
//}
