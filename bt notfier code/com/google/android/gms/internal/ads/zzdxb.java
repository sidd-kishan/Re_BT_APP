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

final class zzdxb
implements Runnable {
    private final zzdxk zza;
    private final zzchl zzb;

    zzdxb(zzdxk zzdxk2, zzchl zzchl2) {
        this.zza = zzdxk2;
        this.zzb = zzchl2;
    }

    @Override
    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
