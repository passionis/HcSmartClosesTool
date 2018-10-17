package com.jtec.passion.hcsmartclosestool;

import android.os.Bundle;

/**
 * 主界面
 */
public class MainFragment extends BaseFragment {

    public static MainFragment newInstance(String params) {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("params", params);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    int fragmentContentLayoutId() {
        return R.layout.fragment_main;
    }
}
