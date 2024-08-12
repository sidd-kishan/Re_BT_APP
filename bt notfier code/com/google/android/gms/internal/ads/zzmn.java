/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzmt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmt;

final class zzmn
implements Runnable {
    private final zzmt zza;
    private final long zzb;
    private final int zzc;

    zzmn(zzmt zzmt2, long l, int n) {
        this.zza = zzmt2;
        this.zzb = l;
        this.zzc = n;
    }

    @Override
    public final void run() {
        this.zza.zzp(this.zzb, this.zzc);
    }
}
