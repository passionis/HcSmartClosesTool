package com.jtec.passion.hcsmartclosestool.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.blankj.utilcode.util.ObjectUtils;
import com.jtec.passion.hcsmartclosestool.R;
import com.jtec.passion.hcsmartclosestool.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登陆界面
 */
public class LoginFragment extends BaseFragment {

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
    public int fragmentContentLayoutId() {
        return R.layout.fragment_login;
    }

    @OnClick(R.id.text)
    public void onClick() {
    }


}
