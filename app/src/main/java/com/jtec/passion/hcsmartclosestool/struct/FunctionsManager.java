package com.jtec.passion.hcsmartclosestool.struct;

import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.StringUtils;

import java.util.HashMap;

/**
 * 接口的管理类
 */
public class FunctionsManager<Params, Result> {


    //，没有参数没有返回值
    public static final String NPNR = "NoParamsNoResult";

    //只有参数
    public static final String JUSY_PARAMS = "OnlyParams";

    //只有返回值
    public static final String JSUT_RESTULT = "OnlyResult";

    //有参数有返回值
    public static final String WPWR = "WithParamsWithResult";

    private static final String TAG = FunctionsManager.class.getSimpleName();


    private static FunctionsManager mInstance;

    //hasmap  key  表示接口方法名，value：对应的接口方法
    //存储有参数和结果的对象
    private final HashMap<String, FunctionParamsAndResult> mFunctionParamsAndResults;

    //存储没有参数和返回值的对象
    private final HashMap<String, FunctionNoParamNotResult> mFunctionNoParamNoResults;

    //存储只有结果的对象
    private final HashMap<String, FunctionOnlyResult> mFunctionOnlyResults;

    //存储只有参数的对象
    private final HashMap<String, FunctionOnlyParams> mFunctionOnlyParams;

    private FunctionsManager() {
        mFunctionNoParamNoResults = new HashMap<>();
        mFunctionOnlyResults = new HashMap<>();
        mFunctionOnlyParams = new HashMap<>();
        mFunctionParamsAndResults = new HashMap<>();
    }

    public static FunctionsManager newInstance() {
        if (ObjectUtils.isEmpty(mInstance)) {
            mInstance = new FunctionsManager();
        }
        return mInstance;
    }

    /**
     * 向没有参数没有返回值的hasmap 中放入对应的FunctionNoParamNoResult对象
     *
     * @param functionNoParamNotResult
     * @return
     */
    public FunctionsManager addFunction(FunctionNoParamNotResult functionNoParamNotResult) {
        mFunctionNoParamNoResults.put(functionNoParamNotResult.getFunctionName(), functionNoParamNotResult);
        return this;
    }

    /**
     * 向存储只有返回值的蛤蟆皮中存储对应的FunctionOnlyResult 对象
     *
     * @param functionOnlyResult
     * @return
     */
    public FunctionsManager addFunction(FunctionOnlyResult functionOnlyResult) {
        mFunctionOnlyResults.put(functionOnlyResult.getFunctionName(), functionOnlyResult);
        return this;
    }

    /**
     * 添加只有参数的
     * @param functionOnlyParams
     * @return
     */
    public FunctionsManager addFunction(FunctionOnlyParams functionOnlyParams) {
        mFunctionOnlyParams.put(functionOnlyParams.getFunctionName(), functionOnlyParams);
        return this;
    }

    /**
     * 添加有参数有返回值的
     * @param functionParamsAndResult
     * @return
     */
    public FunctionsManager<Params, Result> addFunction(FunctionParamsAndResult functionParamsAndResult) {
        mFunctionParamsAndResults.put(functionParamsAndResult.getFunctionName(), functionParamsAndResult);
        return this;
    }


    /**
     * 根据接口的接口名调用对应的接口方法
     * 没有方法返回值和参数的接口方法
     *
     * @param functionName
     */
    public void invokeFunctionNPNR(String functionName) {
        if (StringUtils.isEmpty(functionName)) {
            throw new RuntimeException("functionName is empty");
        }

        if (ObjectUtils.isNotEmpty(mFunctionNoParamNoResults)) {
            FunctionNoParamNotResult functionNoParamNotResult = mFunctionNoParamNoResults.get(functionName);
            if (ObjectUtils.isNotEmpty(functionNoParamNotResult)) {
                functionNoParamNotResult.function();
            } else {
                throw new RuntimeException("not find function to invoke");
            }
        }
    }


    /**
     * 调用只有返回值的接口方法
     *
     * @param functionName 定义的接口方法的名称
     * @param clazz        定义接口方法返回值的对象class
     * @return
     */
    public <Result> Result invokeOnlyResultFunction(String functionName, Class<Result> clazz) {
        if (TextUtils.isEmpty(functionName)) {
            Log.e(TAG, "funName is null !");
            return null;
        } else {
            if (null != mFunctionOnlyResults) {
                FunctionOnlyResult function = mFunctionOnlyResults.get(functionName);
                if (null != function) {
                    if (null != clazz) {
                        return clazz.cast(function.function());
                    } else {
                        return (Result) function.function();
                    }
                } else {
                    Log.e(TAG, "function is null !");
                }
            } else {
                throw new NullPointerException("mFunctionWithParamsOnlyHashMap can not be null ,please first init FunctionManager !");
            }
        }
        return null;
    }

    /**
     * 调用只有参数的接口方法
     * @param functionName
     * @param param
     */
    public void invokeOnlyParamsFunction(String functionName, Class<Params> param) {
        if (TextUtils.isEmpty(functionName)) {
            Log.e(TAG, "funName is null !");
        } else {
            if (ObjectUtils.isNotEmpty(mFunctionOnlyParams)) {
                FunctionOnlyParams function = mFunctionOnlyParams.get(functionName);
                if (ObjectUtils.isNotEmpty(function)){
                    function.function(param);
                } else {
                    Log.e(TAG, "function is null !");
                }
            } else {
                throw new NullPointerException("mFunctionWithParamsOnlyHashMap can not be null ,please first init FunctionManager !");
            }
        }
    }


    /**
     * 调用有参数有返回值的接口方法
     * @param funName
     * @param paramsClass
     * @param resultClass
     * @param <Result>
     * @return
     */
    public <Result> Result invoketWPWR(String funName, Class<Params> paramsClass, Class<Result> resultClass) {
        if (TextUtils.isEmpty(funName)){
            Log.e(TAG,"funName is null !");
        }else {
            if ( null != mFunctionParamsAndResults){
                FunctionParamsAndResult function = mFunctionParamsAndResults.get(funName);
                if (null != function){
                    if ( null != resultClass){
                        return resultClass.cast(function.function(paramsClass));
                    }else {
                        return (Result) function.function(paramsClass);
                    }
                }else {
                    Log.e(TAG,"function is null !");
                }
            }else {
                throw new NullPointerException("mFunctionWithParamsOnlyHashMap can not be null ,please first init FunctionManager !");
            }
        }
        return null;
    }
}
