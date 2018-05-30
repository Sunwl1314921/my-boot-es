package com.rpc.cn.productapi.services;

import com.rpc.cn.productapi.model.Product;

public interface ProductServices {
    Product findOne(int id);
}
