/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  androidx.core.content.ContextCompat
 *  com.lianhezhuli.btnotification.MApplication
 */
package com.lianhezhuli.btnotification.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.lianhezhuli.btnotification.MApplication;

public class PermissionCheckUtils {
    public static boolean check(String ... stringArray) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray[n2];
            if (ContextCompat.checkSelfPermission((Context)MApplication.getInstance(), (String)string) != 0) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static void toPermissionSetting() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package:");
        stringBuilder.append(MApplication.getInstance().getPackageName());
        stringBuilder = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse((String)stringBuilder.toString()));
        MApplication.getInstance().startActivity((Intent)stringBuilder);
    }
}
