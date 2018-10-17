package com.jtec.passion.hcsmartclosestool.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ObjectUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends MySupportFragment {

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(fragmentContentLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        initView();

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (ObjectUtils.isNotEmpty(mUnbinder)) {
            mUnbinder.unbind();
        }

        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * 重写改方法获取fragment的布局id
     *
     * @return
     */
    public abstract int fragmentContentLayoutId();

    public abstract void initData();

    public abstract void initView();
}
