package com.rpc.cn.productapi.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private double price;

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(int i, String s, double v) {
        this.id=i;
        this.name=s;
        this.price=v;
    }
}
