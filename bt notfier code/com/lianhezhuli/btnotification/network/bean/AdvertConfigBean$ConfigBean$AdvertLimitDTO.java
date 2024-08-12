/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean$AdvertLimitDTO$LimitDTO
 */
package com.lianhezhuli.btnotification.network.bean;

import com.google.gson.annotations.SerializedName;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;

public static class AdvertConfigBean.ConfigBean.AdvertLimitDTO {
    @SerializedName(value="onclick")
    private LimitDTO onClick;
    @SerializedName(value="onerror")
    private LimitDTO onError;
    @SerializedName(value="onload")
    private LimitDTO onLoad;
    @SerializedName(value="onshow")
    private LimitDTO onShow;

    public LimitDTO getOnClick() {
        return this.onClick;
    }

    public LimitDTO getOnError() {
        return this.onError;
    }

    public LimitDTO getOnLoad() {
        return this.onLoad;
    }

    public LimitDTO getOnShow() {
        return this.onShow;
    }

    public void setOnClick(LimitDTO limitDTO) {
        this.onClick = limitDTO;
    }

    public void setOnError(LimitDTO limitDTO) {
        this.onError = limitDTO;
    }

    public void setOnLoad(LimitDTO limitDTO) {
        this.onLoad = limitDTO;
    }

    public void setOnShow(LimitDTO limitDTO) {
        this.onShow = limitDTO;
    }
}
