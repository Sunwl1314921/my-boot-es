package com.boot.es.mybootes.myTomcate;

import java.io.IOException;
public class StudentServlet extends MyServlet{
    @Override
    protected void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("I am a student.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("I am a student.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
