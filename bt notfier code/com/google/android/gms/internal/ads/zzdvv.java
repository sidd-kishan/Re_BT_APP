/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamv
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbla
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdbx
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzdwf
 *  com.google.android.gms.internal.ads.zzfet
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamv;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbla;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdbx;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzdwf;
import com.google.android.gms.internal.ads.zzfet;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdvv {
    public static final Set<zzdih<zzdbc>> zza(zzdwf zzdwf2, Executor executor) {
        return zzdvv.zzj(zzdwf2, executor);
    }

    public static final Set<zzdih<zzdbf>> zzb(zzdwf zzdwf2, Executor executor) {
        return zzdvv.zzj(zzdwf2, executor);
    }

    public static final Set<zzdih<zzdbx>> zzc(zzdwf zzdwf2, Executor executor) {
        return zzdvv.zzj(zzdwf2, executor);
    }

    public static final Set<zzdih<zzdcq>> zzd(zzdwf zzdwf2, Executor executor) {
        return zzdvv.zzj(zzdwf2, executor);
    }

    public static final Set<zzdih<zzddx>> zze(zzdwf zzdwf2, Executor executor) {
        return zzdvv.zzj(zzdwf2, executor);
    }

    public static final Set<zzdih<zzamv>> zzf(zzdwf zzdwf2, Executor executor) {
        return zzdvv.zzj(zzdwf2, executor);
    }

    public static final Set<zzdih<zzbcv>> zzg(zzdwf zzdwf2, Executor executor) {
        return zzdvv.zzj(zzdwf2, executor);
    }

    public static final Set<zzdih<zzdbw>> zzh(zzdwf zzdwf2, Executor executor) {
        return zzdvv.zzj(zzdwf2, executor);
    }

    public static final Set<zzdih<zzfet>> zzi(zzdwf zzdwf2, Executor executor) {
        return zzdvv.zzj(zzdwf2, executor);
    }

    private static final <T> Set<zzdih<T>> zzj(T t, Executor executor) {
        if ((Boolean)zzbla.zza.zze() == false) return Collections.emptySet();
        return Collections.singleton(new zzdih(t, executor));
    }
}
