package com.jtec.passion.hcsmartclosestool.login.model;

public interface ILoginModel {
    void doLogin(LogingCallBack callBack);


    interface LogingCallBack{
        void onSuccess(Object oject);

        void onError(Exception e);
    }
}
