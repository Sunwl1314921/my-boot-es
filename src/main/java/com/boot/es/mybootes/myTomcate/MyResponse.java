package com.boot.es.mybootes.myTomcate;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {
    private OutputStream outputStream;
    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    public  void write(String content) throws IOException {
        /**
         * HTTP/1.1 200 OK
         Content-type:text/html
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HTTP/1.1 200 OK\n")
                .append("Content-type:text/html\n")
                .append("\r\n")
                .append("<html><head><title>Hello World</title></head><body>")
                .append(content)
                .append("</body><html>");
        outputStream.write(stringBuffer .toString().getBytes());
        outputStream.close();
    }
}
