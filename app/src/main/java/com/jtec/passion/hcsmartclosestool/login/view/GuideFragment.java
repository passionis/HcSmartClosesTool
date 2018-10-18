package com.jtec.passion.hcsmartclosestool.login.view;

import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.jtec.passion.hcsmartclosestool.R;
import com.jtec.passion.hcsmartclosestool.base.BaseFragment;
import com.jtec.passion.hcsmartclosestool.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 导航页面
 */
public class GuideFragment extends BaseFragment {


    @BindView(R.id.params)
    TextView params;

    public static BaseFragment newInstance() {
        GuideFragment guideFragment = new GuideFragment();
        return guideFragment;
    }

    @Override
    public void initView() {


    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void initData() {
        ToastUtils.showLong("dddddddddddddd");
    }

    @Override
    public int fragmentContentLayoutId() {
        return R.layout.fragment_guide;
    }

    @OnClick(R.id.params)
    public void onViewClicked() {
        startWithPop(LoginFragment.newInstance());
    }





}
