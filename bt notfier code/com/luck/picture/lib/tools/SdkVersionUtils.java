/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.luck.picture.lib.tools;

import android.os.Build;

public class SdkVersionUtils {
    public static boolean checkedAndroid_Q() {
        boolean bl = Build.VERSION.SDK_INT >= 29;
        return bl;
    }

    public static boolean checkedAndroid_R() {
        boolean bl = Build.VERSION.SDK_INT >= 30;
        return bl;
    }
}
