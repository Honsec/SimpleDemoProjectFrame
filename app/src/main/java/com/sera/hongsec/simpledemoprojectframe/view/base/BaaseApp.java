package com.sera.hongsec.simpledemoprojectframe.view.base;

import genius.baselib.base.BaseApplication;
import genius.baselib.center.Config;

/**
 * Created by Hongsec on 2016-08-31.
 * email : piaohongshi0506@gmail.com
 * QQ: 251520264
 */
public class BaaseApp extends BaseApplication {

    @Override
    public void onCreate() {
        Config.init(true,"i will be back",false);
        super.onCreate();
    }
}
