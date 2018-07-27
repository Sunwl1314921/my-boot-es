package com.boot.es.mybootes.序列化;
import java.io.Serializable;
public class Student  implements Serializable {

    private String name;

    private int age;

    Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return "姓名："+name+",年龄:"+age;
    }
}
