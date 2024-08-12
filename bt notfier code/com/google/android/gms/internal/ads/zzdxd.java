/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdxk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdxk;

final class zzdxd
implements Runnable {
    private final zzdxk zza;
    private final Object zzb;
    private final zzchl zzc;
    private final String zzd;
    private final long zze;

    zzdxd(zzdxk zzdxk2, Object object, zzchl zzchl2, String string, long l) {
        this.zza = zzdxk2;
        this.zzb = object;
        this.zzc = zzchl2;
        this.zzd = string;
        this.zze = l;
    }

    @Override
    public final void run() {
        this.zza.zzp(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
