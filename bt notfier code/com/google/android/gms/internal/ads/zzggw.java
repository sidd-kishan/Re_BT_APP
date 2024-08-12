/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggt
 *  com.google.android.gms.internal.ads.zzggu
 *  com.google.android.gms.internal.ads.zzggv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggt;
import com.google.android.gms.internal.ads.zzggu;
import com.google.android.gms.internal.ads.zzggv;
import java.util.List;

abstract class zzggw {
    private static final zzggw zza = new zzggt(null);
    private static final zzggw zzb = new zzggu(null);

    /* synthetic */ zzggw(zzggv zzggv2) {
    }

    static zzggw zzd() {
        return zza;
    }

    static zzggw zze() {
        return zzb;
    }

    abstract <L> List<L> zza(Object var1, long var2);

    abstract void zzb(Object var1, long var2);

    abstract <L> void zzc(Object var1, Object var2, long var3);
}
