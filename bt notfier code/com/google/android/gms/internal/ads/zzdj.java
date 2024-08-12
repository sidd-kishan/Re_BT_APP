/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdp;

final class zzdj
implements Runnable {
    private final zzdp zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;

    zzdj(zzdp zzdp2, int n, long l, long l2) {
        this.zza = zzdp2;
        this.zzb = n;
        this.zzc = l;
        this.zzd = l2;
    }

    @Override
    public final void run() {
        this.zza.zzp(this.zzb, this.zzc, this.zzd);
    }
}
