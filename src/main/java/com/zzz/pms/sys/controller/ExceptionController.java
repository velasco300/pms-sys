package com.zzz.pms.sys.controller;

import com.zzz.pms.generic.common.CommonResult;
import com.zzz.pms.generic.exception.AppException;
import com.zzz.pms.generic.exception.ExceptionItemEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = AppException.class)
    public CommonResult<String> appException(AppException e) {
        CommonResult<String> rs = CommonResult.failed("", e.getExceptionItem());
        log.error(rs.toString(), e);
        return rs;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<String> appException(MethodArgumentNotValidException e) {
        String msg = "validate error";
        FieldError fe = e.getFieldError();
        if (fe != null) {
            msg = fe.getDefaultMessage();
        }
        CommonResult<String> rs = CommonResult.error(msg);
        log.error(rs.toString(), e);
        return rs;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> exception(Exception e) {
        CommonResult<String> rs = CommonResult.failed("", ExceptionItemEnum.ERROR);
        log.error(rs.toString(), e);
        return rs;
    }

}
