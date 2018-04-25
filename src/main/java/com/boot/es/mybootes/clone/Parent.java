package com.boot.es.mybootes.clone;

import lombok.Data;

import java.io.Serializable;

@Data
public class Parent implements  Cloneable,Serializable{


    private int id;

    private String name;

    private Boolean sex;

    private String city;

    private int age;

    public  Parent(int id,String name,String city,int age,Boolean sex){
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.city=city;
        this.age=age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
