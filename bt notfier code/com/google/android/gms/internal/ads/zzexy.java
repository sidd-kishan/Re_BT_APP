/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeyb
 *  com.google.android.gms.internal.ads.zzeyc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeyb;
import com.google.android.gms.internal.ads.zzeyc;

final class zzexy
implements Runnable {
    private final zzeyb zza;

    zzexy(zzeyb zzeyb2) {
        this.zza = zzeyb2;
    }

    @Override
    public final void run() {
        zzeyc.zze((zzeyc)this.zza.zzc).zzf();
    }
}
