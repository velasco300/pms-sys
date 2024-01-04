package com.zzz.pms.pmssys.controller;


import com.zzz.pms.pmsgeneric.util.ThreadParam;
import com.zzz.pms.pmsgeneric.util.Watch;

public class BaseController {

    protected String msg(String msg) {
        Watch w = ThreadParam.get();
        return w.logMsg(msg);
    }

}
