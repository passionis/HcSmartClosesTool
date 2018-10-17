package com.jtec.passion.hcsmartclosestool.fragment;

import com.jtec.passion.hcsmartclosestool.R;
import com.jtec.passion.hcsmartclosestool.base.BaseFragment;

/**
 * 主界面
 */
public class MainFragment extends BaseFragment {
    public static final String TAG = MainFragment.class.getSimpleName();

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void initView() {

    }

    @Override
    public int fragmentContentLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initData() {

    }

}
