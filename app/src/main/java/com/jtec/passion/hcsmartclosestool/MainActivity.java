package com.jtec.passion.hcsmartclosestool;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.FragmentUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.jtec.passion.hcsmartclosestool.struct.FunctionNoParamNotResult;
import com.jtec.passion.hcsmartclosestool.struct.FunctionOnlyResult;
import com.jtec.passion.hcsmartclosestool.struct.FunctionsManager;

import butterknife.BindView;
public class MainActivity extends BaseActivity implements FragmentManager.OnBackStackChangedListener {

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
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        mIsFirstLogin = SPUtils.getInstance().getBoolean("isFirstLogin", true);
        if (mIsFirstLogin) {
            replaceFragment(R.id.frame_layout_main, GuideFragment.newInstance("测试的banner数据"), GuideFragment.class.getSimpleName(),false);
        } else {
            replaceFragment(R.id.frame_layout_main, LoginFragment.newInstance("测试的登陆界面"), LoginFragment.class.getSimpleName(),false);
        }
    }

    @Override
    public void onBackStackChanged() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        LogUtils.e("栈的数量" + backStackEntryCount);
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < backStackEntryCount; i++) {
            FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(i);
            String name = backStackEntry.getName();
            stringBuffer.append(name + ",");
        }
        LogUtils.e("后台栈中的数据" + stringBuffer.toString());

    }
//
//    @Override
//    public void goToMainFragment() {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        Fragment loginfragment = getSupportFragmentManager().findFragmentByTag(LoginFragment.class.getSimpleName());
//        if (ObjectUtils.isNotEmpty(loginfragment)) {
//            fragmentTransaction.remove(loginfragment).commit();
//        }
//
//        replaceFragment(R.id.frame_layout_main, MainFragment.newInstance("dddd"), MainFragment.class.getSimpleName(), false);
//
//    }

    /**
     * 初始化所有activity中需要使用的接口
     */
    public void setFunctionsForFragment(String fragmentTag) {
        if (TextUtils.isEmpty(fragmentTag)){
            Log.e(MainActivity.class.getSimpleName(),"tag is null !");
            return;
        }


        FragmentManager fm = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(fragmentTag);
        if (ObjectUtils.isNotEmpty(fragment)) {
            FunctionsManager functionsManager = FunctionsManager.newInstance();
            fragment.setFunctionsManager(functionsManager.addFunction(new FunctionNoParamNotResult(GuideFragment.interfaceName) {
                @Override
                public void function() {
                    replaceFragment(R.id.frame_layout_main, LoginFragment.newInstance("测试的登陆界面"), LoginFragment.class.getSimpleName(),false);

                }
            }).addFunction(new FunctionOnlyResult<String>(LoginFragment.interfaceName) {
                @Override
                public String function() {

                    return "loginfragment 返回数据";
                }
            }))
            ;

        }

    }
}
