package com.zzz.pms.sys.controller;

import com.zzz.pms.generic.util.ThreadParam;
import com.zzz.pms.generic.util.Watch;

public class BaseController {

    protected String msg(String msg) {
        Watch w = ThreadParam.get();
        return w.logMsg(msg);
    }

}
