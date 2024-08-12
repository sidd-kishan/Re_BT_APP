/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjs;

final class zzcjr
implements Runnable {
    private final zzcjs zza;
    private final boolean zzb;
    private final long zzc;

    zzcjr(zzcjs zzcjs2, boolean bl, long l) {
        this.zza = zzcjs2;
        this.zzb = bl;
        this.zzc = l;
    }

    @Override
    public final void run() {
        this.zza.zzH(this.zzb, this.zzc);
    }
}
