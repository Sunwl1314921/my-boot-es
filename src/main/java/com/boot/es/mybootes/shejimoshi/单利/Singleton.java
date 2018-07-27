package com.boot.es.mybootes.shejimoshi.单利;

import java.math.BigDecimal;

public class Singleton {

    private  static final Singleton singleton= new Singleton();
    Singleton(){}

    public static Singleton getInstance(){
            return singleton;
    }


    public static void main(String[] args) {
        BigDecimal weight =new BigDecimal("5.001");
        BigDecimal freeWeight = new BigDecimal("5.000");

        BigDecimal addWeightAmount = new BigDecimal("10");

        BigDecimal beyondWeight = (weight.subtract(freeWeight)).setScale(0, BigDecimal.ROUND_UP);
        //超出的重量的收费
        BigDecimal beyondAmount = addWeightAmount.multiply(beyondWeight);

        System.out.println(beyondAmount);
    }
}
