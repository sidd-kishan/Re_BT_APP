/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjs;

final class zzcjo
implements Runnable {
    private final zzcjs zza;
    private final int zzb;
    private final int zzc;

    zzcjo(zzcjs zzcjs2, int n, int n2) {
        this.zza = zzcjs2;
        this.zzb = n;
        this.zzc = n2;
    }

    @Override
    public final void run() {
        this.zza.zzK(this.zzb, this.zzc);
    }
}
