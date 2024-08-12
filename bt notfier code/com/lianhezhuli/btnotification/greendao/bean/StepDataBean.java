/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.greendao.bean;

public class StepDataBean {
    private int activeTime;
    private String binTime;
    private String calorie;
    private String distance;
    private Long id;
    private boolean isUpdate;
    private String mac;
    private int step;
    private String userId;

    public StepDataBean() {
    }

    public StepDataBean(Long l, String string, boolean bl, String string2, String string3, String string4, int n, int n2, String string5) {
        this.id = l;
        this.userId = string;
        this.isUpdate = bl;
        this.binTime = string2;
        this.calorie = string3;
        this.distance = string4;
        this.step = n;
        this.activeTime = n2;
        this.mac = string5;
    }

    public int getActiveTime() {
        return this.activeTime;
    }

    public String getBinTime() {
        return this.binTime;
    }

    public String getCalorie() {
        return this.calorie;
    }

    public String getDistance() {
        return this.distance;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsUpdate() {
        return this.isUpdate;
    }

    public String getMac() {
        return this.mac;
    }

    public int getStep() {
        return this.step;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setActiveTime(int n) {
        this.activeTime = n;
    }

    public void setBinTime(String string) {
        this.binTime = string;
    }

    public void setCalorie(String string) {
        this.calorie = string;
    }

    public void setDistance(String string) {
        this.distance = string;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsUpdate(boolean bl) {
        this.isUpdate = bl;
    }

    public void setMac(String string) {
        this.mac = string;
    }

    public void setStep(int n) {
        this.step = n;
    }

    public void setUserId(String string) {
        this.userId = string;
    }
}
