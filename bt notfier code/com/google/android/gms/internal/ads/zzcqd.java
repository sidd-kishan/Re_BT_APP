/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcqf
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzdwj
 *  com.google.android.gms.internal.ads.zzdwm
 *  com.google.android.gms.internal.ads.zzdwt
 *  com.google.android.gms.internal.ads.zzdwu
 *  com.google.android.gms.internal.ads.zzdwx
 *  com.google.android.gms.internal.ads.zzdwy
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcqf;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzdwj;
import com.google.android.gms.internal.ads.zzdwm;
import com.google.android.gms.internal.ads.zzdwt;
import com.google.android.gms.internal.ads.zzdwu;
import com.google.android.gms.internal.ads.zzdwx;
import com.google.android.gms.internal.ads.zzdwy;

final class zzcqd
implements zzdwj {
    private final Long zza;
    private final String zzb;
    private final zzcqu zzc;
    private final zzcqf zzd;
    private final zzcqd zze = this;

    /* synthetic */ zzcqd(zzcqu zzcqu2, zzcqf zzcqf2, Long l, String string, zzcql zzcql2) {
        this.zzc = zzcqu2;
        this.zzd = zzcqf2;
        this.zza = l;
        this.zzb = string;
    }

    public final zzdwt zza() {
        return zzdwu.zza((long)this.zza, (Context)zzcqf.zza((zzcqf)this.zzd), (zzdwm)zzcqf.zzb((zzcqf)this.zzd), (zzcoj)this.zzc, (String)this.zzb);
    }

    public final zzdwx zzb() {
        return zzdwy.zza((long)this.zza, (Context)zzcqf.zza((zzcqf)this.zzd), (zzdwm)zzcqf.zzb((zzcqf)this.zzd), (zzcoj)this.zzc, (String)this.zzb);
    }
}
