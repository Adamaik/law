package com.adamaik.law.exception;

import com.adamaik.law.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Adamaik
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception e){
        log.warn(e.getMessage());
        return Result.error("发生错误，请联系管理员");
    }
}
