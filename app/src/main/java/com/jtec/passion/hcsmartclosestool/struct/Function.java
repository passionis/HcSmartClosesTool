package com.jtec.passion.hcsmartclosestool.struct;

/**
 * 针对fragment通信过程定义的接口进行面对对象的抽取
 * 接口中通用部分
 *       方法名
 *       返回值
 *       参数
 *       没有方法体的方法
 *             接口方法分为：
 *                  1:有参数有返回值
 *                  2：没有参数没有返回值
 *                  3：只有返回值
 *                  4：只有参数
 *
 *
 *
 *
 *  */
abstract class Function {
    /**
     * 接口方法中的方法名
     */
    private String mFunctionName;

    Function(String functionName) {
        this.mFunctionName = functionName;
    }

    public String getFunctionName() {
        return mFunctionName;
    }
}
