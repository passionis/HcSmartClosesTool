package com.jtec.passion.hcsmartclosestool.fragment;

import android.os.Bundle;
import android.widget.Button;

import com.jtec.passion.hcsmartclosestool.R;
import com.jtec.passion.hcsmartclosestool.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterAccountFragment extends BaseFragment {
    public static final String TAG = RegisterAccountFragment.class.getSimpleName();
    @BindView(R.id.registerAccount)
    Button registerAccount;


    public static RegisterAccountFragment newInstance() {
        return new RegisterAccountFragment();
    }

    @Override
    public int fragmentContentLayoutId() {
        return R.layout.fragment_register_account;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @OnClick(R.id.registerAccount)
    public void onViewClicked() {
        Bundle bundle = new Bundle();
        bundle.putString("f", "注册成功");
        setFragmentResult(RESULT_OK, bundle);
        pop();
    }
}
