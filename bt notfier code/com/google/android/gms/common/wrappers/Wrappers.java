/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.common.wrappers.PackageManagerWrapper
 */
package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;

public class Wrappers {
    private static Wrappers zzb = new Wrappers();
    private PackageManagerWrapper zza = null;

    public static PackageManagerWrapper packageManager(Context context) {
        return zzb.zza(context);
    }

    public final PackageManagerWrapper zza(Context context) {
        synchronized (this) {
            if (this.zza == null) {
                Context context2 = context;
                if (context.getApplicationContext() != null) {
                    context2 = context.getApplicationContext();
                }
                context = new PackageManagerWrapper(context2);
                this.zza = context;
            }
            context = this.zza;
            return context;
        }
    }
}
