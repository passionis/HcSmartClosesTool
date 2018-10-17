package com.jtec.passion.hcsmartclosestool.fragment;

import com.jtec.passion.hcsmartclosestool.R;
import com.jtec.passion.hcsmartclosestool.base.BaseFragment;

/**
 * 主界面
 */
public class MainFragment extends BaseFragment {

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int fragmentContentLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData() {

    }

}
