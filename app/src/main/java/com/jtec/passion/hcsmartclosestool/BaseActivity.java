package com.jtec.passion.hcsmartclosestool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

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
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();

        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void replaceFragment(int contentId, BaseFragment fragment, String fragmentTag, boolean addStrack) {

        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FragmentTransaction transaction = beginTransaction.replace(contentId, fragment, fragmentTag);
        if (addStrack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    /**
     * 添加fragment 的重载方法
     * @param fragment
     * @param contentId
     */
    public void addFragment(BaseFragment fragment, int contentId) {
        String fragmentTag = fragment.getClass().getSimpleName();
        boolean addToStack = true;
        addFragment(contentId, fragment, fragmentTag, addToStack);
    }

    /**
     * 添加fragment 到指定的容器中
     * @param contentId 容器id
     * @param fragment  需要添加的fragment
     * @param fragmentTag   fragment 的tag
     * @param addToStack    是否添加到栈中
     */
    public void addFragment(int contentId, BaseFragment fragment, String fragmentTag, boolean addToStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(contentId, fragment, fragmentTag);

        if (addToStack)
            transaction.addToBackStack(null);

        transaction.commit();
    }




    protected abstract int contentLayout();

    protected abstract void initData();

    protected abstract void initView();

}
