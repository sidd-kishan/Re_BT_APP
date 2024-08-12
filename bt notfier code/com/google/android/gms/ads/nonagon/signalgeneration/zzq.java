/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzdrh
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzdrh;

final class zzq
implements Runnable {
    private final zzv zza;
    private final zzdrh[] zzb;

    zzq(zzv zzv2, zzdrh[] zzdrhArray) {
        this.zza = zzv2;
        this.zzb = zzdrhArray;
    }

    @Override
    public final void run() {
        this.zza.zzz(this.zzb);
    }
}
