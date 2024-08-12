/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzwc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwc;

final class zzwa
implements Runnable {
    final String zza;
    final long zzb;
    final zzwc zzc;

    zzwa(zzwc zzwc2, String string, long l) {
        this.zzc = zzwc2;
        this.zza = string;
        this.zzb = l;
    }

    @Override
    public final void run() {
        zzwc.zza((zzwc)this.zzc).zza(this.zza, this.zzb);
        zzwc.zza((zzwc)this.zzc).zzb(this.zzc.toString());
    }
}
