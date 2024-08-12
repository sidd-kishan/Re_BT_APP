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

final class zzexx
implements Runnable {
    private final zzeyb zza;

    zzexx(zzeyb zzeyb2) {
        this.zza = zzeyb2;
    }

    @Override
    public final void run() {
        zzeyc.zzd((zzeyc)this.zza.zzc).zzf();
    }
}
