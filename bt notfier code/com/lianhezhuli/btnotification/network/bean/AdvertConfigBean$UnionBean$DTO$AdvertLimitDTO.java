/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.network.bean;

import com.google.gson.annotations.SerializedName;

public static class AdvertConfigBean.UnionBean.DTO.AdvertLimitDTO {
    @SerializedName(value="advert_expire")
    private int advertExpire;
    @SerializedName(value="error_hide_time")
    private int errorHideTime;
    @SerializedName(value="error_limit")
    private int errorLimit;
    @SerializedName(value="error_limit_time")
    private int errorLimitTime;
    @SerializedName(value="request_limit_time")
    private int requestLimitTime;

    public int getAdvertExpire() {
        return this.advertExpire;
    }

    public int getErrorHideTime() {
        return this.errorHideTime;
    }

    public int getErrorLimit() {
        return this.errorLimit;
    }

    public int getErrorLimitTime() {
        return this.errorLimitTime;
    }

    public int getRequestLimitTime() {
        return this.requestLimitTime;
    }

    public void setAdvertExpire(int n) {
        this.advertExpire = n;
    }

    public void setErrorHideTime(int n) {
        this.errorHideTime = n;
    }

    public void setErrorLimit(int n) {
        this.errorLimit = n;
    }

    public void setErrorLimitTime(int n) {
        this.errorLimitTime = n;
    }

    public void setRequestLimitTime(int n) {
        this.requestLimitTime = n;
    }
}
