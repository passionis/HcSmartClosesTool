package com.jtec.passion.hcsmartclosestool.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.blankj.utilcode.util.ObjectUtils;
import com.jtec.passion.hcsmartclosestool.R;
import com.jtec.passion.hcsmartclosestool.base.BaseFragment;

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
    protected void initView() {
        Bundle arguments = getArguments();
        if (ObjectUtils.isNotEmpty(arguments)) {
            String params = arguments.getString("params");
            this.params.setText(params);
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    public int fragmentContentLayoutId() {
        return R.layout.fragment_guide;
    }

    @OnClick(R.id.params)
    public void onViewClicked() {


    }


}
