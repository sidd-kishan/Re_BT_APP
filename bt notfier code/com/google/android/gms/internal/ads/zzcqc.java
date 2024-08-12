/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcqd
 *  com.google.android.gms.internal.ads.zzcqf
 *  com.google.android.gms.internal.ads.zzcql
 *  com.google.android.gms.internal.ads.zzcqu
 *  com.google.android.gms.internal.ads.zzdwi
 *  com.google.android.gms.internal.ads.zzdwj
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcqd;
import com.google.android.gms.internal.ads.zzcqf;
import com.google.android.gms.internal.ads.zzcql;
import com.google.android.gms.internal.ads.zzcqu;
import com.google.android.gms.internal.ads.zzdwi;
import com.google.android.gms.internal.ads.zzdwj;
import com.google.android.gms.internal.ads.zzgli;

final class zzcqc
implements zzdwi {
    private final zzcqu zza;
    private final zzcqf zzb;
    private Long zzc;
    private String zzd;

    /* synthetic */ zzcqc(zzcqu zzcqu2, zzcqf zzcqf2, zzcql zzcql2) {
        this.zza = zzcqu2;
        this.zzb = zzcqf2;
    }

    public final zzdwj zza() {
        zzgli.zzc((Object)this.zzc, Long.class);
        zzgli.zzc((Object)this.zzd, String.class);
        return new zzcqd(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
