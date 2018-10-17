package com.jtec.passion.hcsmartclosestool.struct;


public abstract class FunctionParamsAndResult<Result,Params> extends Function {

    public FunctionParamsAndResult(String functionName) {
        super(functionName);
    }

    /**
     * 有参数和返回值的接口方法
     * @param t
     */
    public abstract Result function(Params t);




}
