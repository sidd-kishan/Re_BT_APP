/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzmt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmt;

final class zzmk
implements Runnable {
    private final zzmt zza;
    private final String zzb;
    private final long zzc;
    private final long zzd;

    zzmk(zzmt zzmt2, String string, long l, long l2) {
        this.zza = zzmt2;
        this.zzb = string;
        this.zzc = l;
        this.zzd = l2;
    }

    @Override
    public final void run() {
        this.zza.zzs(this.zzb, this.zzc, this.zzd);
    }
}
