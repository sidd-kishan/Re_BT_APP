/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.network.bean;

public class LoginBean {
    private String authcode;
    private int expires_in;
    private String uid;

    public String getAuthcode() {
        return this.authcode;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAuthcode(String string) {
        this.authcode = string;
    }

    public void setExpires_in(int n) {
        this.expires_in = n;
    }

    public void setUid(String string) {
        this.uid = string;
    }
}
