package com.zzz.pms.pmssys.controller;

import com.zzz.pms.pmsgeneric.utils.ThreadParam;
import com.zzz.pms.pmsgeneric.utils.Watch;

public class BaseController {

    protected String msg(String msg) {
        Watch w = ThreadParam.get();
        return w.logMsg(msg);
    }

}
