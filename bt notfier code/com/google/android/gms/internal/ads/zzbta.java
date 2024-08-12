/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.internal.ads.zzbsm
 *  com.google.android.gms.internal.ads.zzbsn
 *  com.google.android.gms.internal.ads.zzbtb
 *  com.google.android.gms.internal.ads.zzbtr
 *  com.google.android.gms.internal.ads.zzbts
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbtb;
import com.google.android.gms.internal.ads.zzbtr;
import com.google.android.gms.internal.ads.zzbts;

final class zzbta
implements zzbsm {
    private final zzbts zza;
    private final zzbtr zzb;
    private final zzbsn zzc;

    zzbta(zzbts zzbts2, zzbtr zzbtr2, zzbsn zzbsn2) {
        this.zza = zzbts2;
        this.zzb = zzbtr2;
        this.zzc = zzbsn2;
    }

    public final void zza() {
        zzbts zzbts2 = this.zza;
        zzbtr zzbtr2 = this.zzb;
        zzbsn zzbsn2 = this.zzc;
        zzs.zza.postDelayed((Runnable)new zzbtb(zzbts2, zzbtr2, zzbsn2), 10000L);
    }
}
