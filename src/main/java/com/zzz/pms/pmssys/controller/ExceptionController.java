package com.zzz.pms.pmssys.controller;

import com.zzz.pms.pmsgeneric.common.AppException;
import com.zzz.pms.pmsgeneric.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exception(Exception e) {
        Result<String> rs = new Result<>();
        rs.setSuccess(false);
        rs.setMsg("未知错误，请联系管理员");
        log.error(rs.toString(), e);
        return rs;
    }

    @ExceptionHandler(value = AppException.class)
    public Result<String> appException(AppException e) {
        Result<String> rs = new Result<>();
        rs.setSuccess(false);
        rs.setMsg(e.getMessage());
        log.error(rs.toString());
        return rs;
    }

}
