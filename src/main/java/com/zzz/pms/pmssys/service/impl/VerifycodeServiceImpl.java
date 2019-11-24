package com.zzz.pms.pmssys.service.impl;

import com.zzz.pms.pmssys.dao.VerifycodeDao;
import com.zzz.pms.pmssys.entity.Verifycode;
import com.zzz.pms.pmssys.service.VerifycodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Service
public class VerifycodeServiceImpl extends BaseServiceImpl<Verifycode, Long> implements VerifycodeService {

    private VerifycodeDao verifycodeDao;

    @Autowired
    public VerifycodeServiceImpl(VerifycodeDao verifycodeDao) {
        super(verifycodeDao);
        this.verifycodeDao = verifycodeDao;
    }


    @Override
    public List<Verifycode> listByCodeTypeAndReceiver(Integer codeType, String receiver) {
        return verifycodeDao.findByCodeTypeAndReceiverOrderByCreateTimeDesc(codeType, receiver);
    }

    @Override
    public void save(Verifycode entity) {
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(r.nextInt(10));
        }
        Calendar c = Calendar.getInstance();
        entity.setCreateTime(c.getTime());
        c.add(Calendar.MINUTE, 10);
        entity.setExpireTime(c.getTime());
        entity.setCodeNumber(sb.toString());
        add(entity);
    }
}




