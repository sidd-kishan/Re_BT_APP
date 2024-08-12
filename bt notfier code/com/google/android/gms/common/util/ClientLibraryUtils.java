/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  com.google.android.gms.common.wrappers.Wrappers
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    public static int getClientVersion(Context context, String string) {
        try {
            context = Wrappers.packageManager((Context)context).getPackageInfo(string, 128);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            context = null;
        }
        if (context == null) return -1;
        if (context.applicationInfo == null) {
            return -1;
        }
        context = context.applicationInfo.metaData;
        if (context == null) return -1;
        return context.getInt("com.google.android.gms.version", -1);
    }

    public static boolean isPackageSide() {
        return false;
    }
}
