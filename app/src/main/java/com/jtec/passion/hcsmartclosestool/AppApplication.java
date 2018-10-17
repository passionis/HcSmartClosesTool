package com.jtec.passion.hcsmartclosestool;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initParams();

    }

    public void initParams() {
        // 初始化工具类
        Utils.init(this);
    }
}
