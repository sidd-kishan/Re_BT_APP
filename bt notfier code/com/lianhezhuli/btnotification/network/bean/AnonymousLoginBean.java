/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.network.bean;

public class AnonymousLoginBean {
    private String account;
    private String authcode;
    private int expires_in;
    private String password;
    private String uid;
    private String uuid;

    public String getAccount() {
        return this.account;
    }

    public String getAuthcode() {
        return this.authcode;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setAccount(String string) {
        this.account = string;
    }

    public void setAuthcode(String string) {
        this.authcode = string;
    }

    public void setExpires_in(int n) {
        this.expires_in = n;
    }

    public void setPassword(String string) {
        this.password = string;
    }

    public void setUid(String string) {
        this.uid = string;
    }

    public void setUuid(String string) {
        this.uuid = string;
    }
}
