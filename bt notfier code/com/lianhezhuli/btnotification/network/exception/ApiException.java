/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.network.exception;

public class ApiException
extends RuntimeException {
    private String code;
    private String detail;
    private String displayMessage;

    public ApiException(String string) {
        super(string);
    }

    public ApiException(String string, String string2, String string3) {
        this.code = string;
        this.displayMessage = string2;
        this.detail = string3;
    }

    public String getCode() {
        return this.code;
    }

    public String getDetail() {
        return this.detail;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public void setCode(String string) {
        this.code = string;
    }

    public void setDetail(String string) {
        this.detail = string;
    }

    public void setDisplayMessage(String string) {
        this.displayMessage = string;
    }
}
