package com.yanshang.watchpro.utils;

import com.yanshang.watchpro.exception.BusinessException;
import com.yanshang.watchpro.exception.SystemException;
import com.yanshang.watchpro.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result systemException(SystemException ex){//ex.getCode()
        System.out.println("遇到系统异常了");
        //告诉运维
        //记录日志
        return new Result(401,ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result systemException(BusinessException ex){
        System.out.println("遇到业务异常了");
        return new Result(402,ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        //告诉运维
        //记录日志
        System.out.println("遇到其他异常了");
        System.out.println(ex);
        return new Result(Code.SYSTEM_UNKNOW_ERR,"","系统繁忙，请稍后再试");
    }
}
