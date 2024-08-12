/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcmx
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzffu
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcmx;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzffu;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzdrf
implements Callable<zzdrh> {
    private final zza zza;
    private final zzcmx zzb;
    private final Context zzc;
    private final zzdvi zzd;
    private final zzffc zze;
    private final zzedq zzf;
    private final Executor zzg;
    private final zzaas zzh;
    private final zzcgz zzi;
    private final zzffu zzj;

    public zzdrf(Context context, Executor executor, zzaas zzaas2, zzcgz zzcgz2, zza zza2, zzcmx zzcmx2, zzedq zzedq2, zzffu zzffu2, zzdvi zzdvi2, zzffc zzffc2) {
        this.zzc = context;
        this.zzg = executor;
        this.zzh = zzaas2;
        this.zzi = zzcgz2;
        this.zza = zza2;
        this.zzb = zzcmx2;
        this.zzf = zzedq2;
        this.zzj = zzffu2;
        this.zzd = zzdvi2;
        this.zze = zzffc2;
    }

    static /* synthetic */ zza zza(zzdrf zzdrf2) {
        return zzdrf2.zza;
    }

    static /* synthetic */ zzcmx zzb(zzdrf zzdrf2) {
        return zzdrf2.zzb;
    }

    static /* synthetic */ Context zzc(zzdrf zzdrf2) {
        return zzdrf2.zzc;
    }

    static /* synthetic */ zzdvi zzd(zzdrf zzdrf2) {
        return zzdrf2.zzd;
    }

    static /* synthetic */ zzffc zze(zzdrf zzdrf2) {
        return zzdrf2.zze;
    }

    static /* synthetic */ zzedq zzf(zzdrf zzdrf2) {
        return zzdrf2.zzf;
    }

    static /* synthetic */ Executor zzg(zzdrf zzdrf2) {
        return zzdrf2.zzg;
    }

    static /* synthetic */ zzaas zzh(zzdrf zzdrf2) {
        return zzdrf2.zzh;
    }

    static /* synthetic */ zzcgz zzi(zzdrf zzdrf2) {
        return zzdrf2.zzi;
    }

    static /* synthetic */ zzffu zzj(zzdrf zzdrf2) {
        return zzdrf2.zzj;
    }
}
