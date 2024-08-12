/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcnh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcnh;

final class zzcng
implements Runnable {
    private final zzcnh zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final boolean zze;

    zzcng(zzcnh zzcnh2, int n, int n2, boolean bl, boolean bl2) {
        this.zza = zzcnh2;
        this.zzb = n;
        this.zzc = n2;
        this.zzd = bl;
        this.zze = bl2;
    }

    @Override
    public final void run() {
        this.zza.zzt(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
