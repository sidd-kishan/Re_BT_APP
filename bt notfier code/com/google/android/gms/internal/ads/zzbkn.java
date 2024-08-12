/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzblm
 *  com.google.android.gms.internal.ads.zzbln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzblm;
import com.google.android.gms.internal.ads.zzbln;

public class zzbkn<T> {
    private final String zza;
    private final T zzb;
    private final int zzc;

    protected zzbkn(String string, T t, int n) {
        this.zza = string;
        this.zzb = t;
        this.zzc = n;
    }

    public static zzbkn<Boolean> zza(String string, boolean bl) {
        return new zzbkn<Boolean>(string, bl, 1);
    }

    public static zzbkn<Long> zzb(String string, long l) {
        return new zzbkn<Long>(string, l, 2);
    }

    public static zzbkn<Double> zzc(String string, double d) {
        return new zzbkn<Double>(string, d, 3);
    }

    public static zzbkn<String> zzd(String string, String string2) {
        return new zzbkn<String>(string, string2, 4);
    }

    public final T zze() {
        zzblm zzblm2 = zzbln.zza();
        if (zzblm2 == null) {
            return this.zzb;
        }
        int n = this.zzc - 1;
        if (n == 0) return (T)zzblm2.zza(this.zza, ((Boolean)this.zzb).booleanValue());
        if (n == 1) return (T)zzblm2.zzb(this.zza, ((Long)this.zzb).longValue());
        if (n == 2) return (T)zzblm2.zzc(this.zza, ((Double)this.zzb).doubleValue());
        return (T)zzblm2.zzd(this.zza, (String)this.zzb);
    }
}
