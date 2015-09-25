package com.xlab.wonders.fullway.network.entity;

/**
 * Created by lixuanwu on 15/9/18.
 */
public class BaseEntity {

    public String message;

    public String ret_code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }
}
