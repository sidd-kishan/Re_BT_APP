/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean$AdvertLimitDTO$LimitDTO$LimitItemDTO
 */
package com.lianhezhuli.btnotification.network.bean;

import com.google.gson.annotations.SerializedName;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;

public static class AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO {
    @SerializedName(value="1")
    private LimitItemDTO $1;
    @SerializedName(value="2")
    private LimitItemDTO $2;
    @SerializedName(value="3")
    private LimitItemDTO $3;
    @SerializedName(value="5")
    private LimitItemDTO $5;
    @SerializedName(value="6")
    private LimitItemDTO $6;

    public LimitItemDTO get$1() {
        return this.$1;
    }

    public LimitItemDTO get$2() {
        return this.$2;
    }

    public LimitItemDTO get$3() {
        return this.$3;
    }

    public LimitItemDTO get$5() {
        return this.$5;
    }

    public LimitItemDTO get$6() {
        return this.$6;
    }

    public void set$1(LimitItemDTO limitItemDTO) {
        this.$1 = limitItemDTO;
    }

    public void set$2(LimitItemDTO limitItemDTO) {
        this.$2 = limitItemDTO;
    }

    public void set$3(LimitItemDTO limitItemDTO) {
        this.$3 = limitItemDTO;
    }

    public void set$5(LimitItemDTO limitItemDTO) {
        this.$5 = limitItemDTO;
    }

    public void set$6(LimitItemDTO limitItemDTO) {
        this.$6 = limitItemDTO;
    }
}
