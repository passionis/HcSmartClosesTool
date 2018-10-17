package com.jtec.passion.hcsmartclosestool.struct;

/**
 * 最有参数
 */
public abstract class FunctionOnlyParams<Params> extends Function {

    public FunctionOnlyParams(String functionName) {
        super(functionName);
    }

    /**
     * 只有参数的接口方法
     *
     * @return
     */
    public abstract void function(Params t);




}
