package com.jtec.passion.hcsmartclosestool.login.presenter;

import com.blankj.utilcode.util.ObjectUtils;
import com.jtec.passion.hcsmartclosestool.base.BasePresenter;
import com.jtec.passion.hcsmartclosestool.login.model.ILoginModel;
import com.jtec.passion.hcsmartclosestool.login.model.LoginModel;
import com.jtec.passion.hcsmartclosestool.login.view.ILoginVIew;

public class LoginPresenter<V extends ILoginVIew> extends BasePresenter<V> implements ILoginPre {

    private ILoginModel mLoginModel = new LoginModel();

    @Override
    public void login() {
        if (ObjectUtils.isEmpty(mLoginModel)) {
            return;
        }

        mViewRef.get().showLoading();
        mLoginModel.doLogin(new ILoginModel.LogingCallBack() {
            @Override
            public void onSuccess(Object oject) {
                mViewRef.get().hideLoding();
            }

            @Override
            public void onError(Exception e) {
                mViewRef.get().hideLoding();
            }
        });
    }
}
