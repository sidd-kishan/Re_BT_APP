/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzi
 */
package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.zzi;

final class zzg
implements Runnable {
    private final zzi zza;
    private final boolean zzb;

    zzg(zzi zzi2, boolean bl) {
        this.zza = zzi2;
        this.zzb = bl;
    }

    @Override
    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
