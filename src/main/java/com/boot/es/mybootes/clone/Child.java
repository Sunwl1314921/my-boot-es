package com.boot.es.mybootes.clone;

import lombok.Data;

import java.io.Serializable;

@Data
public class Child implements Serializable{


    private int ids;

    private String name;

    private Boolean sex;

    private int age;

    private  String cont;
}
