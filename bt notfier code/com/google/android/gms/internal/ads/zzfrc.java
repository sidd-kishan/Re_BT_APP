/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfrd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfrd;

final class zzfrc
implements Runnable {
    final zzfoe zza;
    final zzfrd zzb;

    zzfrc(zzfrd zzfrd2, zzfoe zzfoe2) {
        this.zzb = zzfrd2;
        this.zza = zzfoe2;
    }

    @Override
    public final void run() {
        zzfrd.zzy((zzfrd)this.zzb, (zzfoe)this.zza);
    }
}
