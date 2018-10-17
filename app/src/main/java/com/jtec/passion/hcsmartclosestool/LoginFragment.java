package com.jtec.passion.hcsmartclosestool;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jtec.passion.hcsmartclosestool.struct.FunctionsManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登陆界面
 */
public class LoginFragment extends BaseFragment {

    public static final String interfaceName = LoginFragment.class.getName() + FunctionsManager.JSUT_RESTULT;

    @BindView(R.id.text)
    TextView text;


    public static BaseFragment newInstance(String jsonParams) {
        LoginFragment loginFragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString("args", jsonParams);
        loginFragment.setArguments(bundle);
        return loginFragment;
    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        if (ObjectUtils.isNotEmpty(arguments)) {
            String args = arguments.getString("args");
            text.setText(args);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    int fragmentContentLayoutId() {
        return R.layout.fragment_login;
    }

    @OnClick(R.id.text )
    public void onClick() {
        if (ObjectUtils.isNotEmpty(mFunctionsManager)) {
            String  o = (String) mFunctionsManager.invokeFunction(LoginFragment.interfaceName, String.class);
            ToastUtils.showLong(o);
        }

    }




}
