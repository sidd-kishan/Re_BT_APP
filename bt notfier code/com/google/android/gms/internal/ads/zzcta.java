/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzctf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzctf;

final class zzcta
implements Runnable {
    private final zzctf zza;
    private final int zzb;
    private final int zzc;

    zzcta(zzctf zzctf2, int n, int n2) {
        this.zza = zzctf2;
        this.zzb = n;
        this.zzc = n2;
    }

    @Override
    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
