/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzmt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmt;

final class zzmm
implements Runnable {
    private final zzmt zza;
    private final int zzb;
    private final long zzc;

    zzmm(zzmt zzmt2, int n, long l) {
        this.zza = zzmt2;
        this.zzb = n;
        this.zzc = l;
    }

    @Override
    public final void run() {
        this.zza.zzq(this.zzb, this.zzc);
    }
}
