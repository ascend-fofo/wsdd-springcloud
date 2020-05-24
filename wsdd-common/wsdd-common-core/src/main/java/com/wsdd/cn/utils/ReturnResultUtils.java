package com.wsdd.cn.utils;


public class ReturnResultUtils {

    public static ReturnResult returnSuccess(){
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(200);
        returnResult.setMessage("success");
        return returnResult;
    }

    public static ReturnResult returnSuccess(Object data){
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(200);
        returnResult.setMessage("success");
        returnResult.setData(data);
        return returnResult;
    }

    public static ReturnResult returnFail(int code,String message){
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMessage(message);
        return returnResult;
    }

    public static ReturnResult returnSuccess(int code, String message, Object data) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMessage(message);
        returnResult.setData(data);
        return returnResult;
    }
}
