package com.jtec.passion.hcsmartclosestool;

import android.widget.FrameLayout;

import com.blankj.utilcode.util.SPUtils;
import com.jtec.passion.hcsmartclosestool.base.BaseActivity;
import com.jtec.passion.hcsmartclosestool.login.view.GuideFragment;
import com.jtec.passion.hcsmartclosestool.fragment.MainFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity  {

    @BindView(R.id.frame_layout_main)
    FrameLayout frameLayoutMain;

    private boolean mIsFirstLogin;

    @Override
    protected int contentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mIsFirstLogin = SPUtils.getInstance().getBoolean("isFirstLogin", true);
        if (mIsFirstLogin) {
            GuideFragment fragment = findFragment(GuideFragment.class);
            if (fragment == null) {
                loadRootFragment(R.id.frame_layout_main, GuideFragment.newInstance());
            }
        } else {
            MainFragment fragment = findFragment(MainFragment.class);
            if (fragment == null) {
                loadRootFragment(R.id.frame_layout_main, MainFragment.newInstance());
            }
        }
    }


}
