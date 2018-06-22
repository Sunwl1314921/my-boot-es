package com.boot.es.mybootes.validtor;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.boot.es.mybootes.export.YTXResponse;
/**
 * 捕获校验信息
 *
 * @ExceptionHandler：统一处理某一类异常，从而能够减少代码重复率和复杂度
 * @ControllerAdvice：异常集中处理，更好的使业务逻辑与异常处理剥离开
 * @RestControllerAdvice：包含@ControllerAdvice多了一个@ResponseBody注解
 * @ResponseStatus：可以将某种异常映射为HTTP状态码
 */
@RestControllerAdvice
public class ValidatorExceptionHandler {
    /**
     * 捕获校验异常信息
     * 组装成YTXResponse格式 返回
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    public YTXResponse bindException(MethodArgumentNotValidException e) {
        YTXResponse result = YTXResponse.success();

        //获取校验的错误信息
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.getFieldErrors().size() > 0) {
            //获取错误信息第一条默认错误处理信息返回
            result.setMessage(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            result.setSuccess(YTXResponse.SuccessFlag.FALSE.toString());
        }
        return result;
    }
}
