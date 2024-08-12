/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$UnionBean$DTO$AdvertLimitDTO
 */
package com.lianhezhuli.btnotification.network.bean;

import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;

public static class AdvertConfigBean.UnionBean.DTO {
    private AdvertLimitDTO advert_limit;
    private int app_id;
    private String app_name;
    private String appid;
    private int union_id;
    private String union_name;

    public AdvertLimitDTO getAdvert_limit() {
        return this.advert_limit;
    }

    public int getApp_id() {
        return this.app_id;
    }

    public String getApp_name() {
        return this.app_name;
    }

    public String getAppid() {
        return this.appid;
    }

    public int getUnion_id() {
        return this.union_id;
    }

    public String getUnion_name() {
        return this.union_name;
    }

    public void setAdvert_limit(AdvertLimitDTO advertLimitDTO) {
        this.advert_limit = advertLimitDTO;
    }

    public void setApp_id(int n) {
        this.app_id = n;
    }

    public void setApp_name(String string) {
        this.app_name = string;
    }

    public void setAppid(String string) {
        this.appid = string;
    }

    public void setUnion_id(int n) {
        this.union_id = n;
    }

    public void setUnion_name(String string) {
        this.union_name = string;
    }
}
