package com.boot.es.mybootes.validtor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PreDestroy;
import javax.validation.Valid;

@Controller
public class ValidtorController {
    //绑定PersonalValidator

    @InitBinder("personScope")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new PersonalValidtor());
    }
    //接下来我们需要在@RequestMapping这个注解所在的方法上使用@Valid注解进行数据的校验。

//    @RequestMapping(value = "test1")
//    @ResponseBody
//    //直接返回对象
//    public Object testPersonalValidtor(@Valid PersonScope personScope, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            StringBuffer sb = new StringBuffer();
//            for(ObjectError objectError : bindingResult.getAllErrors()){
//                sb.append(((FieldError)objectError).getField() +" : ").append(objectError.getDefaultMessage());
//            }
//            return sb.toString();
//        }else{
//            return personScope;
//        }
//    }

    @RequestMapping(value = "test1")
    @ResponseBody
    //直接返回对象
    public Object testPersonalValidtor(@Validated PersonScope personScope){
        return personScope.getAddress();
    }

    @RequestMapping(value = "test2")
    @ResponseBody
    //直接返回对象
    public Object testPersonalValidtor2(String name){
        return name;
    }

    @RequestMapping(value = "test3")
    @ResponseBody
    //直接返回对象
    public Object testPersonalValidtor3(@Validated Student student){
        return student.getName();
    }

    @InitBinder("student")
    public void initBinders(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new StudentValidtor());
    }


}
