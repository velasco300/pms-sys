package com.zzz.pms.sys.controller;

import cn.hutool.core.bean.BeanUtil;
import com.zzz.pms.generic.common.CommonResult;
import com.zzz.pms.generic.dto.VerifycodeDTO;
import com.zzz.pms.generic.exception.ExceptionItemEnum;
import com.zzz.pms.sys.entity.Verifycode;
import com.zzz.pms.sys.service.VerifycodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/verifycodes")
public class VerifycodeController extends BaseController {

    private final VerifycodeService verifycodeService;

    @PostMapping(value = "add")
    public CommonResult<String> add(@RequestBody @Validated VerifycodeDTO dto) {
        Verifycode entity = createFrom(dto);
        verifycodeService.save(entity);
        return CommonResult.success(entity.getCodeNumber());
    }

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

    private Verifycode createFrom(VerifycodeDTO dto) {
        Verifycode entity = BeanUtil.copyProperties(dto, Verifycode.class);
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(r.nextInt(10));
        }
        Calendar c = Calendar.getInstance();
        entity.setCreateTime(c.getTime());
        c.add(Calendar.MINUTE, 10);
        entity.setExpireTime(c.getTime());
        entity.setCodeNumber(sb.toString());
        return entity;
    }

}

