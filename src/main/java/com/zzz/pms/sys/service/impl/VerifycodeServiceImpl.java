package com.zzz.pms.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzz.pms.sys.mapper.VerifycodeMapper;
import com.zzz.pms.sys.entity.Verifycode;
import com.zzz.pms.sys.service.VerifycodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VerifycodeServiceImpl extends ServiceImpl<VerifycodeMapper, Verifycode> implements VerifycodeService {
    @Override
    public List<Verifycode> listByCodeTypeAndReceiver(Integer codeType, String receiver) {
        LambdaQueryWrapper<Verifycode> sql = new LambdaQueryWrapper<Verifycode>().eq(Verifycode::getCodeType, codeType).eq(Verifycode::getReceiver, receiver).orderByDesc(Verifycode::getCreateTime);
        return baseMapper.selectList(sql);
    }


}




