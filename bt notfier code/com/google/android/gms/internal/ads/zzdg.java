/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdp;

final class zzdg
implements Runnable {
    private final zzdp zza;
    private final String zzb;
    private final long zzc;
    private final long zzd;

    zzdg(zzdp zzdp2, String string, long l, long l2) {
        this.zza = zzdp2;
        this.zzb = string;
        this.zzc = l;
        this.zzd = l2;
    }

    @Override
    public final void run() {
        this.zza.zzs(this.zzb, this.zzc, this.zzd);
    }
}
