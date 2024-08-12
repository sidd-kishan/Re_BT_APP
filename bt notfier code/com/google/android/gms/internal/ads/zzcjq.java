/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjs;

final class zzcjq
implements Runnable {
    private final zzcjs zza;
    private final int zzb;

    zzcjq(zzcjs zzcjs2, int n) {
        this.zza = zzcjs2;
        this.zzb = n;
    }

    @Override
    public final void run() {
        this.zza.zzI(this.zzb);
    }
}
