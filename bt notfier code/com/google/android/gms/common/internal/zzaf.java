/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 *  com.google.android.gms.common.wrappers.Wrappers
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzaf {
    private static final Object zza = new Object();
    private static boolean zzb;
    private static String zzc;
    private static int zzd;

    public static String zza(Context context) {
        zzaf.zzc(context);
        return zzc;
    }

    public static int zzb(Context context) {
        zzaf.zzc(context);
        return zzd;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static void zzc(Context context) {
        Object object = zza;
        synchronized (object) {
            block6: {
                if (zzb) {
                    return;
                }
                zzb = true;
                String string = context.getPackageName();
                context = Wrappers.packageManager((Context)context);
                context = context.getApplicationInfo((String)string, (int)128).metaData;
                if (context != null) break block6;
                return;
            }
            try {
                zzc = context.getString("com.google.app.id");
                zzd = context.getInt("com.google.android.gms.version");
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.wtf((String)"MetadataValueReader", (String)"This should never happen.", (Throwable)nameNotFoundException);
            }
            return;
        }
    }
}
