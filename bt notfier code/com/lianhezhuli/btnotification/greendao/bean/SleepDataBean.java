/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.greendao.bean;

public class SleepDataBean {
    private int awakeTime;
    private String binTime;
    private int deepSleep;
    private Long id;
    private boolean isUpdate;
    private int lightSleep;
    private String mac;
    private int totalSleep;
    private String userId;

    public SleepDataBean() {
    }

    public SleepDataBean(Long l, String string, boolean bl, String string2, int n, int n2, int n3, int n4, String string3) {
        this.id = l;
        this.userId = string;
        this.isUpdate = bl;
        this.binTime = string2;
        this.totalSleep = n;
        this.deepSleep = n2;
        this.lightSleep = n3;
        this.awakeTime = n4;
        this.mac = string3;
    }

    public int getAwakeTime() {
        return this.awakeTime;
    }

    public String getBinTime() {
        return this.binTime;
    }

    public int getDeepSleep() {
        return this.deepSleep;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsUpdate() {
        return this.isUpdate;
    }

    public int getLightSleep() {
        return this.lightSleep;
    }

    public String getMac() {
        return this.mac;
    }

    public int getTotalSleep() {
        return this.totalSleep;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAwakeTime(int n) {
        this.awakeTime = n;
    }

    public void setBinTime(String string) {
        this.binTime = string;
    }

    public void setDeepSleep(int n) {
        this.deepSleep = n;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsUpdate(boolean bl) {
        this.isUpdate = bl;
    }

    public void setLightSleep(int n) {
        this.lightSleep = n;
    }

    public void setMac(String string) {
        this.mac = string;
    }

    public void setTotalSleep(int n) {
        this.totalSleep = n;
    }

    public void setUserId(String string) {
        this.userId = string;
    }
}
