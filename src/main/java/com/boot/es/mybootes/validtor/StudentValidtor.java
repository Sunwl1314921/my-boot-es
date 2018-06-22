package com.boot.es.mybootes.validtor;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

public class StudentValidtor implements Validator {

    /**
     * 判断支持的JavaBean类型
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class == aClass;
    }

    /**
     * 实现Validator中的validate接口
     *
     * @param obj
     * @param errors
     */
    @Override
    public void validate(Object obj, Errors errors) {
        //把校验信息注册到Error的实现类里
        ValidationUtils.rejectIfEmpty(errors, "name", null, "姓名不能为空!");
        Student student = (Student) obj;
        if (StringUtils.isEmpty(student.getName())) {
            errors.rejectValue("name", null, "姓名不能为空!!!!");
        }
    }


    public static void main(String[] args) {
//        BigDecimal w1 = new BigDecimal("11.1");
//        BigDecimal w2 = new BigDecimal("1");
//        BigDecimal s = w1.subtract(w2);
//
//        BigDecimal ss = s.multiply(new BigDecimal("2"));
//
//        System.out.println(s);
//        System.out.println(ss);
//
//
//        BigDecimal a=new BigDecimal(12.08);
//        int b=a.intValue();
//        System.out.println(b);//b=12;
//
//
//        int bb = 5;
//        BigDecimal aa = new BigDecimal(bb);
//        System.out.println(aa +"的数据类型是"+aa.getClass().getName());

        BigDecimal w1 = new BigDecimal("11.00");
        System.out.println(w1);
        System.out.println(formatNumber(w1));
    }

    //BigDecimal进1法 取整
    public static BigDecimal formatNumber(BigDecimal number){
        BigDecimal numbers = number.setScale(0, BigDecimal.ROUND_UP);
        return numbers;
    }

}
