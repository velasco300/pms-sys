package com.zzz.pms.pmssys.controller;

import com.zzz.pms.pmsgeneric.common.CommonResult;
import com.zzz.pms.pmsgeneric.exception.AppException;
import com.zzz.pms.pmsgeneric.exception.ExceptionItemEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = AppException.class)
    public CommonResult<String> appException(AppException e) {
        CommonResult<String> rs = CommonResult.failed("", e.getExceptionItem());
        log.error(rs.toString(), e);
        return rs;
    }

    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> exception(Exception e) {
        CommonResult<String> rs = CommonResult.failed("", ExceptionItemEnum.ERROR);
        log.error(rs.toString(), e);
        return rs;
    }

}
