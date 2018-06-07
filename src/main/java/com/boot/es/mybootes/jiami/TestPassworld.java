package com.boot.es.mybootes.jiami;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * 字符串加密，校验工具类
 */
public class TestPassworld implements PasswordEncoder {

    private static final String SITE_WIDE_SECRET = "XXXXXXXXXXXX";
    private static final PasswordEncoder encoder = new StandardPasswordEncoder(SITE_WIDE_SECRET);
    /**
     * 加密方法
     * @param rawPassword 被加密的字符串
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return encoder.encode(rawPassword);
    }
    /**
     * 比较是否相等
     * @param rawPassword 加密后的字符串
     * @param password 源字符串
     * @return
     */
    @Override
    public  boolean matches(CharSequence password, String rawPassword) {
        boolean isSuccess = false;
        try {
            isSuccess = encoder.matches(password, rawPassword);
        } catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    public static void main(String[] args) {
        TestPassworld util = new TestPassworld();
        //a33746f52f500280df3c8116934b505905d7d4d9daee6390656b9c4fe67382df46c00c8b38915803
        String passworld = util.encode("123456");
        //System.out.println(passworld);
        boolean falg = util.matches("123456","a33746f52f500280df3c8116934b505905d7d4d9daee6390656b9c4fe67382df46c00c8b38915803");
        System.out.println(falg);

    }

}