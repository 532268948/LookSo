package com.zust.lookso.util;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/27
 * 时 间： 21:48
 * 项 目： LookSo
 * 描 述：
 */
public enum ReturnCode {
    SUCCESS("0000","查询成功有记录"),
    NODATA("0001","查询成功无记录"),
    FEAILED("0002","查询失败"),
    UNKNOWN_IP("0003","非法用户"),
    REGISTER_FALSE("2001","注册失败"),
//    ACCOUNT_ERROR("1000", "账户不存在或被禁用"),
//    API_NOT_EXISTS("1001", "请求的接口不存在"),
//    API_NOT_PER("1002", "没有该接口的访问权限"),
//    PARAMS_ERROR("1004", "参数为空或格式错误"),
//    SIGN_ERROR("1005", "数据签名错误"),
//    AMOUNT_NOT_QUERY("1010", "余额不够，无法进行查询"),
//    API_DISABLE("1011", "查询权限已被限制"),
//    UNKNOWN_IP("1099", "非法IP请求"),
//    SYSTEM_ERROR("9999", "系统异常");
    UNKNOWN_ERROE("0004","未知错误"),
    EMPTY_ERROR("4001","数据不能为空"),
    DELETE_SUCCESS("4002","数据删除成功"),
    USER_FORBIDDEN("4003","该用户已被封禁");

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ReturnCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

