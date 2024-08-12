/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.lianhezhuli.btnotification.utils;

import android.content.Context;

public class Utils {
    public static float getCalorie(int n) {
        return (float)n * 0.6f / 1000.0f * 60.0f * 1.036f;
    }

    public static float getDistance(int n) {
        return (float)n * 0.6f / 1000.0f;
    }

    public static int getStatusBarHeight(Context context) {
        int n = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(n);
    }

    public static String getVersion(Context object) {
        try {
            object = object.getPackageManager().getPackageInfo((String)object.getPackageName(), (int)0).versionName;
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static int getVersionCode(Context context) {
        try {
            int n = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode;
            return n;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return 1;
        }
    }
}
