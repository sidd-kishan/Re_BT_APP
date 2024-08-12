/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean$AdvertLimitDTO$LimitDTO$LimitItemDTO$LimitTypeListDTO$TypeDTO
 */
package com.lianhezhuli.btnotification.network.bean;

import com.google.gson.annotations.SerializedName;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;

public static class AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO.LimitTypeListDTO {
    @SerializedName(value="fast")
    private TypeDTO fast;
    @SerializedName(value="lock")
    private TypeDTO lock;
    @SerializedName(value="total")
    private TypeDTO total;

    public TypeDTO getFast() {
        return this.fast;
    }

    public TypeDTO getLock() {
        return this.lock;
    }

    public TypeDTO getTotal() {
        return this.total;
    }

    public void setFast(TypeDTO typeDTO) {
        this.fast = typeDTO;
    }

    public void setLock(TypeDTO typeDTO) {
        this.lock = typeDTO;
    }

    public void setTotal(TypeDTO typeDTO) {
        this.total = typeDTO;
    }
}
