package com.zust.lookso.util;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/27
 * 时 间： 21:45
 * 项 目： LookSo
 * 描 述：
 */
public class ResponseWrapper {

    /**是否成功*/
    private boolean success;
    /**返回码*/
    private String code;
    /**返回信息*/
    private String msg;
    /**返回数据*/
    private Object data;

    /**
     * 自定义返回结果
     * 建议使用统一的返回结果，特殊情况可以使用此方法
     * @param success
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static ResponseWrapper markCustom(boolean success,String code,String msg,String data){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(success);
        responseWrapper.setCode(code);
        responseWrapper.setMsg(msg);
        responseWrapper.setData(data);
        return responseWrapper;
    }

    /**
     * 查询成功且有数据
     * @param data
     * @return
     */
    public static ResponseWrapper markSuccess(Object data){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.SUCCESS.getCode());
        responseWrapper.setMsg(ReturnCode.SUCCESS.getMsg());
        responseWrapper.setData(data);
        return  responseWrapper;
    }

    /**
     * 查询成功但无数据
     * @return
     */
    public static ResponseWrapper markSuccessButNoData(){
        ResponseWrapper responseWrapper  = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.NODATA.getCode());
        responseWrapper.setMsg(ReturnCode.NODATA.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    /**
     * 查询失败
     * @return
     */
    public static ResponseWrapper markError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.FEAILED.getCode());
        responseWrapper.setMsg(ReturnCode.FEAILED.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    public static ResponseWrapper markUnKnownError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.UNKNOWN_ERROE.getCode());
        responseWrapper.setMsg(ReturnCode.UNKNOWN_ERROE.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    public static ResponseWrapper UnKnowUser(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.UNKNOWN_IP.getCode());
        responseWrapper.setMsg(ReturnCode.UNKNOWN_IP.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
