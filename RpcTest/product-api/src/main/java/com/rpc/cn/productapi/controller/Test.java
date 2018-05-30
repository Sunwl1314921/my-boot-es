package com.rpc.cn.productapi.controller;

import com.rpc.cn.productapi.model.Product;
import com.rpc.cn.productapi.services.ProductServices;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Test {


    public static void main(String[] args) {
        //获取rpc调用
        ProductServices productServices =(ProductServices)rpc(ProductServices.class);
        Product product =productServices.findOne(2);
        System.out.println(product.getName());
    }

    static Object rpc(final Class clazz){
      return Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new InvocationHandler(){

          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              Socket socket =new Socket("127.0.0.1",8888);

              String apiClassName = clazz.getName();
              String methodName = method.getName();
              Class [] parameters = method.getParameterTypes();

              ObjectOutputStream objectOutputStream =new ObjectOutputStream(socket.getOutputStream());
              objectOutputStream.writeUTF(apiClassName);
              objectOutputStream.writeUTF(methodName);
              objectOutputStream.writeObject(parameters);
              objectOutputStream.writeObject(args);
              objectOutputStream.flush();

              ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
              Object object=objectInputStream.readObject();

              objectInputStream.close();
              objectOutputStream.close();
              socket.close();

              return object;
          }
      });
    }
}
