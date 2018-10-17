package com.jtec.passion.hcsmartclosestool.struct;

/**
 * 只有结果
 */
public abstract class  FunctionOnlyResult<Result> extends Function {

    public FunctionOnlyResult(String functionName) {
        super(functionName);
    }

    /**
     * 只有结果的接口方法
     * @return
     */
    public abstract Result function();




}
