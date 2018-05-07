package com.boot.es.mybootes.yuanma;

import java.util.*;

public class HelloWorld {

    private int age;

    private String name;

    public HelloWorld(int age,String name){
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Collection con=new Vector();
        //((Vector) con).add(0,"23");

        List list=new ArrayList(new Vector());
        for(Object obj:list){
            System.out.println(obj);
        }



        //map 取值的方式
        Map<String,String> map = new HashMap<>();
        map.put("123","321");
        map.put("aaa","vbbb");
        //---------第一种方式-------
        //        Iterator iterator = map.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry entry= (Map.Entry)iterator.next();
//            System.out.println(entry.getKey());
//            System.out.println( entry.getValue());
//
//        }
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }

        //---------第二种方式-------
        for(Object o: map.keySet()){
            System.out.println(o);
            System.out.println(map.get(o));
        }




    }
}
