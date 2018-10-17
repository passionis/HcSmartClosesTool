package com.jtec.passion.hcsmartclosestool;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ObjectUtils;
import com.jtec.passion.hcsmartclosestool.struct.FunctionsManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder mUnbinder;

    protected FunctionsManager mFunctionsManager;
    private MainActivity mBaseActivity;

    public void setFunctionsManager(FunctionsManager functionsManager) {
        mFunctionsManager = functionsManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mBaseActivity = (MainActivity) context;
            mBaseActivity.setFunctionsForFragment(getTag());

        } else {
            throw new RuntimeException("basefragment  onattch() methrod error");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(fragmentContentLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        initView();

        return view;
    }

    protected abstract void initView();

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    protected abstract void initData();


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
     * @return
     */
    abstract int fragmentContentLayoutId();
}
