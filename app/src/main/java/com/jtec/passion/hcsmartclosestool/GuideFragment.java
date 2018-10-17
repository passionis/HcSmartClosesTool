package com.jtec.passion.hcsmartclosestool;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.blankj.utilcode.util.ObjectUtils;
import com.jtec.passion.hcsmartclosestool.struct.FunctionsManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 导航页面
 */
public class GuideFragment extends BaseFragment {

    //定义接口方法
    public static final String interfaceName = GuideFragment.class.getSimpleName() + FunctionsManager.NPNR;

    @BindView(R.id.params)
    TextView params;

    public static BaseFragment newInstance(String params) {
        GuideFragment guideFragment = new GuideFragment();
        Bundle bundle = new Bundle();
        bundle.putString("params", params);
        guideFragment.setArguments(bundle);
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
    int fragmentContentLayoutId() {
        return R.layout.fragment_guide;
    }

    @OnClick(R.id.params)
    public void onViewClicked() {
        if (ObjectUtils.isNotEmpty(mFunctionsManager)) {
            mFunctionsManager.invokeFunction(GuideFragment.interfaceName);
        }

    }


}
