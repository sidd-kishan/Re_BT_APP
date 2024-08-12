/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean$AdvertLimitDTO
 */
package com.lianhezhuli.btnotification.network.bean;

import com.google.gson.annotations.SerializedName;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;

public static class AdvertConfigBean.ConfigBean {
    @SerializedName(value="advert_limit")
    private AdvertLimitDTO advertLimit;
    @SerializedName(value="bundle_id")
    private int bundleId;
    @SerializedName(value="config_id")
    private int configId;
    @SerializedName(value="config_name")
    private String configName;
    @SerializedName(value="firmware_id")
    private int firmwareId;

    public AdvertLimitDTO getAdvertLimit() {
        return this.advertLimit;
    }

    public int getBundleId() {
        return this.bundleId;
    }

    public int getConfigId() {
        return this.configId;
    }

    public String getConfigName() {
        return this.configName;
    }

    public int getFirmwareId() {
        return this.firmwareId;
    }

    public void setAdvertLimit(AdvertLimitDTO advertLimitDTO) {
        this.advertLimit = advertLimitDTO;
    }

    public void setBundleId(int n) {
        this.bundleId = n;
    }

    public void setConfigId(int n) {
        this.configId = n;
    }

    public void setConfigName(String string) {
        this.configName = string;
    }

    public void setFirmwareId(int n) {
        this.firmwareId = n;
    }
}
