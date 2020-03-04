package com.thoth.my.shop.common.dto;

import java.io.Serializable;

/**
 * @program: my-shop
 * @description: 请求返回结果
 * @author: yyj
 * @create: 2020-02-13 14:50
 **/
public class BaseResult implements Serializable {

    public static final int SUCCESS_CODE = 200;
    public static final int FAIl_CODE = 500;


    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static BaseResult success() {
        return BaseResult.creatBaseResult(SUCCESS_CODE, "成功");
    }

    public static BaseResult success(String message) {
        return BaseResult.creatBaseResult(SUCCESS_CODE, message);

    }

    public static BaseResult fail() {
        return BaseResult.creatBaseResult(FAIl_CODE, "失败");

    }

    public static BaseResult fail(String message) {
        return BaseResult.creatBaseResult(FAIl_CODE, message);

    }
    public static BaseResult fail(int code,String message) {
        return BaseResult.creatBaseResult(code, message);

    }

    private static BaseResult creatBaseResult(int code, String message) {

        BaseResult baseResult = new BaseResult();
        baseResult.setCode(code);
        baseResult.setMessage(message);
        return baseResult;

    }


}
