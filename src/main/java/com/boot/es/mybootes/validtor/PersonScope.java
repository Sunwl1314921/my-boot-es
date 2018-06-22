package com.boot.es.mybootes.validtor;

import lombok.Data;

public class PersonScope {

    private String name;

    private String address;

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
}
