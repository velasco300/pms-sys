package com.zzz.pms.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzz.pms.sys.entity.Verifycode;

import java.util.List;

public interface VerifycodeService extends IService<Verifycode> {

    public List<Verifycode> listByCodeTypeAndReceiver(Integer codeType, String receiver);

}
