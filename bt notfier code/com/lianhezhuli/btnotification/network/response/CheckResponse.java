/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.network.response;

import java.io.Serializable;

public class CheckResponse
implements Serializable {
    private String code;
    private String msg;

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return this.code.equals("success");
    }

    public void setCode(String string) {
        this.code = string;
    }

    public void setMsg(String string) {
        this.msg = string;
    }
}
