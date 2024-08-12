/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.Property
 */
package com.lianhezhuli.btnotification.greendao.bean;

import org.greenrobot.greendao.Property;

public static class SleepDataBeanDao.Properties {
    public static final Property AwakeTime;
    public static final Property BinTime;
    public static final Property DeepSleep;
    public static final Property Id;
    public static final Property IsUpdate;
    public static final Property LightSleep;
    public static final Property Mac;
    public static final Property TotalSleep;
    public static final Property UserId;

    static {
        Id = new Property(0, Long.class, "id", true, "_id");
        UserId = new Property(1, String.class, "userId", false, "USER_ID");
        IsUpdate = new Property(2, Boolean.TYPE, "isUpdate", false, "IS_UPDATE");
        BinTime = new Property(3, String.class, "binTime", false, "BIN_TIME");
        TotalSleep = new Property(4, Integer.TYPE, "totalSleep", false, "TOTAL_SLEEP");
        DeepSleep = new Property(5, Integer.TYPE, "deepSleep", false, "DEEP_SLEEP");
        LightSleep = new Property(6, Integer.TYPE, "lightSleep", false, "LIGHT_SLEEP");
        AwakeTime = new Property(7, Integer.TYPE, "awakeTime", false, "AWAKE_TIME");
        Mac = new Property(8, String.class, "mac", false, "MAC");
    }
}
