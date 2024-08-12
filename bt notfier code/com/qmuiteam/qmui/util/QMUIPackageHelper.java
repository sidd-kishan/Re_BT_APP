/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.qmuiteam.qmui.util;

import android.content.Context;

public class QMUIPackageHelper {
    private static String appVersionName;
    private static int fixVersion = -1;
    private static String majorMinorVersion;
    private static int majorVersion = -1;
    private static int minorVersion = -1;

    public static String getAppVersion(Context object) {
        String string;
        if (appVersionName == null) {
            string = object.getPackageManager();
            try {
                appVersionName = string.getPackageInfo((String)object.getPackageName(), (int)0).versionName;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        string = appVersionName;
        object = string;
        if (string != null) return object;
        object = "";
        return object;
    }

    public static int getFixVersion(Context stringArray) {
        if (fixVersion != -1) return fixVersion;
        if ((stringArray = QMUIPackageHelper.getAppVersion((Context)stringArray).split("\\.")).length < 3) return fixVersion;
        fixVersion = Integer.parseInt(stringArray[2]);
        return fixVersion;
    }

    public static String getMajorMinorVersion(Context context) {
        CharSequence charSequence = majorMinorVersion;
        if (charSequence != null) {
            if (!((String)charSequence).equals("")) return majorMinorVersion;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(QMUIPackageHelper.getMajorVersion(context));
        ((StringBuilder)charSequence).append(".");
        ((StringBuilder)charSequence).append(QMUIPackageHelper.getMinorVersion(context));
        majorMinorVersion = ((StringBuilder)charSequence).toString();
        return majorMinorVersion;
    }

    private static int getMajorVersion(Context stringArray) {
        if (majorVersion != -1) return majorVersion;
        if ((stringArray = QMUIPackageHelper.getAppVersion((Context)stringArray).split("\\.")).length == 0) return majorVersion;
        majorVersion = Integer.parseInt(stringArray[0]);
        return majorVersion;
    }

    private static int getMinorVersion(Context stringArray) {
        if (minorVersion != -1) return minorVersion;
        if ((stringArray = QMUIPackageHelper.getAppVersion((Context)stringArray).split("\\.")).length < 2) return minorVersion;
        minorVersion = Integer.parseInt(stringArray[1]);
        return minorVersion;
    }
}
