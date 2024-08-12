/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkn
 *  com.google.android.gms.internal.ads.zzgkp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkn;
import com.google.android.gms.internal.ads.zzgkp;

public abstract class zzgks {
    public static zzgks zzb(Class clazz) {
        if (!System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) return new zzgkp(clazz.getSimpleName());
        return new zzgkn(clazz.getSimpleName());
    }

    public abstract void zza(String var1);
}
