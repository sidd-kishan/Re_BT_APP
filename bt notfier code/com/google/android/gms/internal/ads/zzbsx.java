/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzbtr
 *  com.google.android.gms.internal.ads.zzbts
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzbtr;
import com.google.android.gms.internal.ads.zzbts;

final class zzbsx
implements Runnable {
    private final zzbts zza;
    private final zzbtr zzb;

    zzbsx(zzbts zzbts2, zzaas zzaas2, zzbtr zzbtr2) {
        this.zza = zzbts2;
        this.zzb = zzbtr2;
    }

    @Override
    public final void run() {
        this.zza.zzi(null, this.zzb);
    }
}
