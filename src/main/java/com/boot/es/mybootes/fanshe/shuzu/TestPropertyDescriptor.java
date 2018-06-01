package com.boot.es.mybootes.fanshe.shuzu;

import com.boot.es.mybootes.yuanma.ArrayListTest;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class TestPropertyDescriptor {
    static  void getFieldName(Object obj,String name)throws  Exception{
        Class clazz = obj.getClass();
        PropertyDescriptor pro = new PropertyDescriptor(name,clazz);
        Method method = pro.getReadMethod();
        Object objc = method.invoke(obj);
        System.out.println(objc);
    }

    public static void main(String[] args) throws  Exception{
        ArrayListTest he=new ArrayListTest(12,"哈哈");
        getFieldName(he,"age");
    }


    // 通过反射得到name
    // 可以看到这是通过 得到 属性的get方法（pd.getReadMethod()） 再调用invole方法取出对应的属性值
    //同样得到set方法（pd.getWriteMethod()）
    private static void getFiled(Object object, String field) {
        Class clazz  = object.getClass();
        PropertyDescriptor pd = null;
        Method getMethod = null;
        try {
            pd = new PropertyDescriptor(field, clazz);
            // 获取  这个 field 属性 的get方法
            getMethod = pd.getReadMethod();
            Object invoke = getMethod.invoke(object);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
