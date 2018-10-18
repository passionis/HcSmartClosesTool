package com.jtec.passion.hcsmartclosestool.login.model;

import com.blankj.utilcode.util.ToastUtils;

public class LoginModel implements ILoginModel {

    @Override
    public void doLogin(LogingCallBack callBack) {
        try {
            Thread.sleep(1000);
            ToastUtils.showLong("网络请求");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
