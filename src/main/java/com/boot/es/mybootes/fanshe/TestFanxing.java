package com.boot.es.mybootes.fanshe;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/**
 * 反射方法的其它使用之---通过反射越过泛型检查
 * 泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
 *
 * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
 */
public class TestFanxing {
    public static void main(String[] args) throws  Exception{
//        List list=new ArrayList();
//        list.add("asd");
//        list.add(123);
        //指定范型的list集合
        List<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbb");
//        strings.add(123); error
        //获取list的class
        Class clazz=strings.getClass();
        //获取add方法
        Method method=clazz.getMethod("add",Object.class);
        //擦出范型插入int类型的值
        method.invoke(strings,123);
//        strings.forEach(str -> System.out.println(str));//error
//        strings.forEach(System.out::println);;//error
        for(Object obj : strings){
            System.out.println(obj);
        }

        //forEach的使用
//        items.forEach(item->{
//            if("C".equals(item)){
//                System.out.println(item);
//            }
//        });
//        //Output : B
//        items.stream()
//                .filter(s->s.contains("B"))
//                .forEach(System.out::println);
    }
}
