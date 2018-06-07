package com.boot.es.mybootes.validtor;


import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonalValidtor implements Validator{

    /**
     * 判断支持的JavaBean类型
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return PersonScope.class.equals(aClass);
    }

    /**
     * 实现Validator中的validate接口
     * @param obj
     * @param errors
     */
    @Override
    public void validate(Object obj, Errors errors) {
        //把校验信息注册到Error的实现类里
        ValidationUtils.rejectIfEmpty(errors,"name",null,"姓名不能为空!");
//        PersonScope personScope = (PersonScope) obj;
//        if(StringUtils.isEmpty(personScope.getAddress())){
//            errors.rejectValue("address",null,"家庭地址不能为空!!!!");
//        }
    }
}
