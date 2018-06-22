package com.boot.es.mybootes.leijiazaiqi;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter pw=resp.getWriter();

        ClassLoader cl=this.getClass().getClassLoader();
        while(cl != null){
            pw.println(cl.getClass().getName());
            cl.getParent();
        }

        pw.close();
    }
}
