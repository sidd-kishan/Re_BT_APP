/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.network.response;

import java.io.Serializable;

public class Response<T>
implements Serializable {
    private String code;
    private T data;
    private String msg;

    public String getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return this.msg.equals("success");
    }

    public void setCode(String string) {
        this.code = string;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMsg(String string) {
        this.msg = string;
    }
}
