/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.network.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AdvertReportBean {
    @SerializedName(value="affect_position")
    private List<String> affectPosition;
    @SerializedName(value="hide_time")
    private int hideTime;
    @SerializedName(value="is_limit")
    private int isLimit;
    @SerializedName(value="is_logout")
    private int isLogout;
    @SerializedName(value="next_time")
    private int nextTime;
    @SerializedName(value="total")
    private int total;
    @SerializedName(value="type_id")
    private int typeId;

    public List<String> getAffectPosition() {
        return this.affectPosition;
    }

    public int getHideTime() {
        return this.hideTime;
    }

    public int getIsLimit() {
        return this.isLimit;
    }

    public int getIsLogout() {
        return this.isLogout;
    }

    public int getNextTime() {
        return this.nextTime;
    }

    public int getTotal() {
        return this.total;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public void setAffectPosition(List<String> list) {
        this.affectPosition = list;
    }

    public void setHideTime(int n) {
        this.hideTime = n;
    }

    public void setIsLimit(int n) {
        this.isLimit = n;
    }

    public void setIsLogout(int n) {
        this.isLogout = n;
    }

    public void setNextTime(int n) {
        this.nextTime = n;
    }

    public void setTotal(int n) {
        this.total = n;
    }

    public void setTypeId(int n) {
        this.typeId = n;
    }
}
