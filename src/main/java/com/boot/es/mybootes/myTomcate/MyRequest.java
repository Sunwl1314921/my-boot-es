package com.boot.es.mybootes.myTomcate;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {
    private String url;
    private String method;
    public MyRequest(InputStream inputStream) throws IOException {
        StringBuilder httpRequest = new StringBuilder();
        byte[] httpRequestByte = new byte[1014];
        int length = 0;
        if ((length = inputStream.read(httpRequestByte)) > 0) {
            httpRequest.append(new String(httpRequestByte,0,length));
        }
        System.out.println("httpRequest = [" + httpRequest + "]");
        /**
         GET /student HTTP/1.1
         Host: localhost:8080
         Connection: keep-alive
         Cache-Control: max-age=0
         Upgrade-Insecure-Requests: 1
         User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
         Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,
         */
        String httpHead = httpRequest.toString().split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println("MyRequests = [" + this + "]");
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
}
