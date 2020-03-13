package com.amao.gmall.admin.aop;

import com.amao.gmall.to.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author amao
 * @date 2020/3/11 23:02
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class})
    public Object handlerException01(Exception ex){
        log.error("系统全局异常感知，信息：{}",ex.getStackTrace());
        return new CommonResult().validateFailed("数学没学好！！！");
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public Object handlerException02(Exception exception){
        log.error("系统出现异常感知，信息：{}",exception.getMessage());
        return new CommonResult().validateFailed("空指针了...");
    }

    @ExceptionHandler(value = {Exception.class})
    public Object handlerException03(Exception exception){
        log.error("系统出现异常感知，信息：{}",exception.getMessage());
        return new CommonResult().validateFailed(exception.getMessage());
    }

}
