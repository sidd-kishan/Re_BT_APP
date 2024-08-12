/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$UnionBean$DTO
 */
package com.lianhezhuli.btnotification.network.bean;

import com.google.gson.annotations.SerializedName;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;

public static class AdvertConfigBean.UnionBean {
    @SerializedName(value="1")
    private DTO _$1;
    @SerializedName(value="2")
    private DTO _$2;
    @SerializedName(value="3")
    private DTO _$3;

    public DTO get_$1() {
        return this._$1;
    }

    public DTO get_$2() {
        return this._$2;
    }

    public DTO get_$3() {
        return this._$3;
    }

    public void set_$1(DTO dTO) {
        this._$1 = dTO;
    }

    public void set_$2(DTO dTO) {
        this._$2 = dTO;
    }

    public void set_$3(DTO dTO) {
        this._$3 = dTO;
    }
}
