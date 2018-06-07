package com.boot.es.mybootes.myTomcate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
public class MyTomcat {
    private int port = 8080;
    private Map<String,String> urlServletMap = new HashMap<String, String>(16);
    public MyTomcat(int port) {
        this.port = port;
    }
    public void start(){
        //初始化请求映射关系
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("My tomcat begin start");
            while (true){
               // serverSocket.setSoTimeout(120*1000);//设置超时时间
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                MyRequest request = new MyRequest(inputStream);
                MyResponse response = new MyResponse(outputStream);
                //分发请求
                dispatch(request,response);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void initServletMapping(){
        for (ServletMapping servletMapping:ServletMappingConfig.servletMappings) {
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }
    private void dispatch(MyRequest request,MyResponse response){
        String clazz = urlServletMap.get(request.getUrl());
        try {
            Class servletClass = Class.forName(clazz);
            MyServlet myServlet = (MyServlet)servletClass.newInstance();
            myServlet.service(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new MyTomcat(8080).start();
    }
}
