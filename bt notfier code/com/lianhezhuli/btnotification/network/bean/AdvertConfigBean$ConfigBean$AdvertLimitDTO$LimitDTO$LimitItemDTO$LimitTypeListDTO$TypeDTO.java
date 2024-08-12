/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.network.bean;

import com.google.gson.annotations.SerializedName;

public static class AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO.LimitTypeListDTO.TypeDTO {
    @SerializedName(value="expire_time")
    private int expireTime;
    @SerializedName(value="hide_time")
    private int hideTime;
    @SerializedName(value="id")
    private int id;
    @SerializedName(value="is_logout")
    private int isLogout;
    @SerializedName(value="limit_id")
    private int limitId;
    @SerializedName(value="limit_num")
    private int limitNum;
    @SerializedName(value="type_code")
    private String typeCode;
    @SerializedName(value="type_id")
    private int typeId;

    public int getExpireTime() {
        return this.expireTime;
    }

    public int getHideTime() {
        return this.hideTime;
    }

    public int getId() {
        return this.id;
    }

    public int getIsLogout() {
        return this.isLogout;
    }

    public int getLimitId() {
        return this.limitId;
    }

    public int getLimitNum() {
        return this.limitNum;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public void setExpireTime(int n) {
        this.expireTime = n;
    }

    public void setHideTime(int n) {
        this.hideTime = n;
    }

    public void setId(int n) {
        this.id = n;
    }

    public void setIsLogout(int n) {
        this.isLogout = n;
    }

    public void setLimitId(int n) {
        this.limitId = n;
    }

    public void setLimitNum(int n) {
        this.limitNum = n;
    }

    public void setTypeCode(String string) {
        this.typeCode = string;
    }

    public void setTypeId(int n) {
        this.typeId = n;
    }
}
