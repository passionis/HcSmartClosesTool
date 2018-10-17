package com.jtec.passion.hcsmartclosestool.base;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.ISupportActivity;

public abstract class BaseActivity extends MySupportActivity implements ISupportActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentLayout());
        mUnbinder = ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();

        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    protected abstract int contentLayout();

    protected abstract void initData();

    protected abstract void initView();


}
