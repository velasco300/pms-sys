package com.zzz.pms.pmssys.controller;

import com.zzz.pms.pmsgeneric.common.CommonResult;
import com.zzz.pms.pmsgeneric.exception.ExceptionItemEnum;
import com.zzz.pms.pmssys.entity.Verifycode;
import com.zzz.pms.pmssys.service.VerifycodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@Slf4j
@Api(tags = "验证码模块")
@RestController
@RequestMapping(value = "/verifycodes")
public class VerifycodeController extends BaseController {

    @Autowired
    private VerifycodeService verifycodeService;

    @ApiOperation(value = "根据验证码类型和接收端号码查询验证码")
    @ApiImplicitParams({@ApiImplicitParam(name = "codeType", value = "验证码类型", dataType = "Integer", required = true), @ApiImplicitParam(name = "receiver", value = "接收端号码", dataType = "String", required = true)})
    @GetMapping(value = "/receiver")
    public CommonResult<Verifycode> queryByCodeTypeAndReceiver(Integer codeType, String receiver) {
        log.debug(msg("参数codeType=" + codeType + "; receiver=" + receiver));
        CommonResult<Verifycode> rs = null;
        List<Verifycode> verifycodes = verifycodeService.listByCodeTypeAndReceiver(codeType, receiver);
        if (verifycodes != null && !verifycodes.isEmpty()) {
            Calendar c = Calendar.getInstance();
            // 已经按创建时间拍好序，直接取第一个
            Verifycode v = verifycodes.get(0);
            if (c.getTime().before(v.getExpireTime())) {
                rs = CommonResult.success(v);
            } else {
                rs = CommonResult.failed("", ExceptionItemEnum.VERIFYCODE_TIMEOUT, null);
            }
        } else {
            rs = CommonResult.failed("", ExceptionItemEnum.VERIFYCODE_NO_FIND, null);
        }
        return rs;
    }

}
