/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

public final class zzglo {
    private static String zza;

    /*
     * Enabled force condition propagation
     */
    public static String zza(Context object) {
        ArrayList<String> arrayList;
        block13: {
            Intent intent;
            String string = zza;
            if (string != null) {
                return string;
            }
            PackageManager packageManager = object.getPackageManager();
            string = packageManager.resolveActivity(intent = new Intent("android.intent.action.VIEW", Uri.parse((String)"http://www.example.com")), 0);
            string = string != null ? ((ResolveInfo)string).activityInfo.packageName : null;
            Object object2 = packageManager.queryIntentActivities(intent, 0);
            arrayList = new ArrayList<String>();
            object2 = object2.iterator();
            while (object2.hasNext()) {
                ResolveInfo resolveInfo = (ResolveInfo)object2.next();
                Intent intent2 = new Intent();
                intent2.setAction("android.support.customtabs.action.CustomTabsService");
                intent2.setPackage(resolveInfo.activityInfo.packageName);
                if (packageManager.resolveService(intent2, 0) == null) continue;
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
            if (arrayList.isEmpty()) {
                zza = null;
                return zza;
            }
            if (arrayList.size() == 1) {
                zza = (String)arrayList.get(0);
                return zza;
            }
            if (!TextUtils.isEmpty((CharSequence)string)) {
                block12: {
                    try {
                        object = object.getPackageManager().queryIntentActivities(intent, 64);
                        if (object == null || object.size() == 0) break block12;
                        object = object.iterator();
                        while (object.hasNext()) {
                            intent = (ResolveInfo)object.next();
                            packageManager = intent.filter;
                            if (packageManager == null || packageManager.countDataAuthorities() == 0 || packageManager.countDataPaths() == 0 || (intent = intent.activityInfo) == null) continue;
                            break block13;
                        }
                    }
                    catch (RuntimeException runtimeException) {
                        Log.e((String)"CustomTabsHelper", (String)"Runtime exception while getting specialized handlers");
                    }
                }
                if (arrayList.contains(string)) {
                    zza = string;
                    return zza;
                }
            }
        }
        if (arrayList.contains("com.android.chrome")) {
            zza = "com.android.chrome";
            return zza;
        }
        if (arrayList.contains("com.chrome.beta")) {
            zza = "com.chrome.beta";
            return zza;
        }
        if (arrayList.contains("com.chrome.dev")) {
            zza = "com.chrome.dev";
            return zza;
        }
        if (!arrayList.contains("com.google.android.apps.chrome")) return zza;
        zza = "com.google.android.apps.chrome";
        return zza;
    }
}
