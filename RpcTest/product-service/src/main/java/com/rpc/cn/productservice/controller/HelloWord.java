package com.rpc.cn.productservice.controller;

import com.rpc.cn.productapi.services.ProductServices;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWord {


    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket=serverSocket.accept();

            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
            String apiClassName =objectInputStream.readUTF();
            String methodName =  objectInputStream.readUTF();
            Class [] parameters = (Class[]) objectInputStream.readObject();
            Object[] arg = (Object[]) objectInputStream.readObject();
            Class clazz =null;
            if(apiClassName.equals(ProductServices.class)){
                clazz = ProductServices.class;
            }

            Method method =clazz.getMethod(methodName,parameters);
            Object invoke = method.invoke(method,arg);


            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(invoke);
            objectOutputStream.flush();

            System.out.println(invoke);

            objectOutputStream.close();
            objectInputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("123");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("123");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("123");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("123");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("123");
        }

        System.out.println("1234");
    }
}
