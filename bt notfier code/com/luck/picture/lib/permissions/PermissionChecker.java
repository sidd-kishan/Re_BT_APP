/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  androidx.core.app.ActivityCompat
 *  androidx.core.content.ContextCompat
 */
package com.luck.picture.lib.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionChecker {
    public static boolean checkSelfPermission(Context context, String string) {
        boolean bl = ContextCompat.checkSelfPermission((Context)context.getApplicationContext(), (String)string) == 0;
        return bl;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        boolean bl = context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        return bl;
    }

    public static void launchAppDetailsSettings(Context context) {
        Context context2 = context.getApplicationContext();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package:");
        stringBuilder.append(context2.getPackageName());
        intent.setData(Uri.parse((String)stringBuilder.toString()));
        if (!PermissionChecker.isIntentAvailable(context, intent)) {
            return;
        }
        context2.startActivity(intent.addFlags(0x10000000));
    }

    public static void requestPermissions(Activity activity, String[] stringArray, int n) {
        ActivityCompat.requestPermissions((Activity)activity, (String[])stringArray, (int)n);
    }
}
