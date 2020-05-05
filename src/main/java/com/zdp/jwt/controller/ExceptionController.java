package com.zdp.jwt.controller;


import com.zdp.jwt.domain.ResultDto;
import org.apache.shiro.ShiroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zdp
 * @description: 异常处理Controller
 */
@RestControllerAdvice
public class ExceptionController {


    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public ResultDto handle403() {
        return ResultDto.auth("您没有权限访问！");
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public ResultDto globalException(HttpServletRequest request, Throwable ex) {
        return ResultDto.error("访问出错，无法访问: " + ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
