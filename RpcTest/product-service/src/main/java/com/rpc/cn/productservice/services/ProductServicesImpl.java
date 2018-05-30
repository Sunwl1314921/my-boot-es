package com.rpc.cn.productservice.services;

import com.rpc.cn.productapi.model.Product;
import com.rpc.cn.productapi.services.ProductServices;

import java.util.ArrayList;
import java.util.List;

public class ProductServicesImpl implements ProductServices {
    @Override
    public Product findOne(int id) {
        List<Product> products =new ArrayList<>();
        for (int i=0;i<10;i++){
            Product product=new Product(i+1,"名称"+i,1+i+0.01);
        }
        if(id>products.size()){
            return null;
        }else {
            return products.get(id);
        }
    }
}
