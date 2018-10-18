package com.jtec.passion.hcsmartclosestool.base;

import com.blankj.utilcode.util.ObjectUtils;

import java.lang.ref.WeakReference;

public class BasePresenter<T> {

    public WeakReference<T> mViewRef;


    /**
     * 在activity onCreate方法中进行绑定对应的presenter 并采用弱应用的方式进行绑定
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    /**
     * 弱应用解绑--避免内存泄漏
     */
    public void detachView() {
        if (ObjectUtils.isNotEmpty(mViewRef)) {
            mViewRef.clear();
        }
    }


}
