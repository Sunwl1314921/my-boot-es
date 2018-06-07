package com.boot.es.mybootes.myTomcate;

import java.util.ArrayList;
import java.util.List;
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappings = new ArrayList<ServletMapping>(16);
    static {
        servletMappings.add(new ServletMapping("student","/student","com.boot.es.mybootes.myTomcate.StudentServlet"));
        servletMappings.add(new ServletMapping("teacher","/teacher","com.boot.es.mybootes.myTomcate.TeacherServlet"));
        servletMappings.add(new ServletMapping("favicon","/favicon.ico","com.boot.es.mybootes.myTomcate.FaviconServlet"));
    }
}