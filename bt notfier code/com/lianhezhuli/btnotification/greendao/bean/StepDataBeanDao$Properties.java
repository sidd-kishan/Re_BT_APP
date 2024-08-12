/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.Property
 */
package com.lianhezhuli.btnotification.greendao.bean;

import org.greenrobot.greendao.Property;

public static class StepDataBeanDao.Properties {
    public static final Property ActiveTime;
    public static final Property BinTime;
    public static final Property Calorie;
    public static final Property Distance;
    public static final Property Id;
    public static final Property IsUpdate;
    public static final Property Mac;
    public static final Property Step;
    public static final Property UserId;

    static {
        Id = new Property(0, Long.class, "id", true, "_id");
        UserId = new Property(1, String.class, "userId", false, "USER_ID");
        IsUpdate = new Property(2, Boolean.TYPE, "isUpdate", false, "IS_UPDATE");
        BinTime = new Property(3, String.class, "binTime", false, "BIN_TIME");
        Calorie = new Property(4, String.class, "calorie", false, "CALORIE");
        Distance = new Property(5, String.class, "distance", false, "DISTANCE");
        Step = new Property(6, Integer.TYPE, "step", false, "STEP");
        ActiveTime = new Property(7, Integer.TYPE, "activeTime", false, "ACTIVE_TIME");
        Mac = new Property(8, String.class, "mac", false, "MAC");
    }
}
