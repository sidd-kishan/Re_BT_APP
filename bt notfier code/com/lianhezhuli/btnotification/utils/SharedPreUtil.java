/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.lianhezhuli.btnotification.utils;

import android.content.Context;

public class SharedPreUtil {
    public static final String BIRTH = "BIRTH";
    public static final String FACE = "FACE";
    public static final String HEIGHT = "HEIGHT";
    public static final String MID = "MID";
    public static final String NAME = "NAME";
    public static final String SEX = "SEX";
    public static final String USER = "USER";
    public static final String WEIGHT = "WEIGHT";

    public static void delPre(Context context, String string, String string2) {
        context = context.getSharedPreferences(string, 0).edit();
        if (string2 != null && !"".equals(string2)) {
            context.remove(string2);
        } else {
            context.clear();
        }
        context.commit();
    }

    public static String readPre(Context object, String string, String string2) {
        object = object.getSharedPreferences(string, 0);
        if (!string.equals("user")) return object.getString(string2, "");
        if (!string2.equals("mid")) return object.getString(string2, "");
        string = object.getString(string2, "");
        object = string;
        if (!string.equals("")) return object;
        object = "kct_funrun";
        return object;
    }

    public static void savePre(Context context, String string, String string2, String string3) {
        context = context.getSharedPreferences(string, 0).edit();
        context.putString(string2, string3);
        context.commit();
    }
}
