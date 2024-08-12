/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzctf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzctf;

final class zzctb
implements Runnable {
    private final zzctf zza;
    private final int zzb;
    private final int zzc;

    zzctb(zzctf zzctf2, int n, int n2) {
        this.zza = zzctf2;
        this.zzb = n;
        this.zzc = n2;
    }

    @Override
    public final void run() {
        this.zza.zzp(this.zzb, this.zzc);
    }
}
