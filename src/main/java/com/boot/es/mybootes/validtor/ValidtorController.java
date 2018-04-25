package com.boot.es.mybootes.validtor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class ValidtorController {
    //绑定PersonalValidator
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new PersonalValidtor());
    }
    //接下来我们需要在@RequestMapping这个注解所在的方法上使用@Valid注解进行数据的校验。

    @RequestMapping(value = "testPersonalValidtor.do")
    @ResponseBody
    //直接返回对象
    public Object testPersonalValidtor(@Valid PersonScope personScope, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuffer sb = new StringBuffer();
            for(ObjectError objectError : bindingResult.getAllErrors()){
                sb.append(((FieldError)objectError).getField() +" : ").append(objectError.getDefaultMessage());
            }
            return sb.toString();
        }else{
            return personScope;
        }
    }

}
