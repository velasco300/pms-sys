package com.zzz.pms.pmssys.service;

import com.zzz.pms.pmssys.entity.Verifycode;

import java.util.List;

public interface VerifycodeService extends BaseService<Verifycode, Long> {

    public List<Verifycode> listByCodeTypeAndReceiver(Integer codeType, String receiver);

    public void save(Verifycode entity);

}
