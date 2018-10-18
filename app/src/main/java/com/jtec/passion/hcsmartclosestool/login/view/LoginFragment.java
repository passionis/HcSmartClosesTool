package com.jtec.passion.hcsmartclosestool.login.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jtec.passion.hcsmartclosestool.R;
import com.jtec.passion.hcsmartclosestool.base.BaseFragment;
import com.jtec.passion.hcsmartclosestool.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登陆界面
 */
public class LoginFragment extends BaseFragment<ILoginVIew, LoginPresenter<ILoginVIew>> implements ILoginVIew {
    public static final String TAG = LoginFragment.class.getSimpleName();

    public static int QRE_REGISTER_ACCOUNT = 1;

    @BindView(R.id.login)
    Button login;

    @BindView(R.id.registerAccount)
    Button registerAccount;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void initView() {
    }

    @Override
    public LoginPresenter<ILoginVIew> createPresenter() {
        return new LoginPresenter<ILoginVIew>();
    }

    @Override
    public void initData() {

    }

    @Override
    public int fragmentContentLayoutId() {
        return R.layout.fragment_login;
    }

    @OnClick({R.id.login, R.id.registerAccount})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                mPresenter.login();
//                startWithPop(MainFragment.newInstance());
                break;
            case R.id.registerAccount:
                startForResult(RegisterAccountFragment.newInstance(), QRE_REGISTER_ACCOUNT);

                break;
        }
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == QRE_REGISTER_ACCOUNT) {
            if (ObjectUtils.isNotEmpty(data)) {
                String f1 = data.getString("f");
                LogUtils.e("f1 = " + f1);
            }
        }
    }

    @Override
    public void showLoading() {
        ToastUtils.showLong("显示logading");

    }

    @Override
    public void hideLoding() {
        ToastUtils.showLong("影藏logading");
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPwd() {
        return null;
    }
}
