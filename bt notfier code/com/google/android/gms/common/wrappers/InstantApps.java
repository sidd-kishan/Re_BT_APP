/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.common.util.PlatformVersion
 */
package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

public class InstantApps {
    private static Context zza;
    private static Boolean zzb;

    public static boolean isInstantApp(Context context) {
        synchronized (InstantApps.class) {
            Context context2 = context.getApplicationContext();
            if (zza != null && zzb != null && zza == context2) {
                boolean bl = zzb;
                return bl;
            }
            zzb = null;
            if (PlatformVersion.isAtLeastO()) {
                zzb = context2.getPackageManager().isInstantApp();
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    zzb = true;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    zzb = false;
                }
            }
            zza = context2;
            boolean bl = zzb;
            return bl;
        }
    }
}
