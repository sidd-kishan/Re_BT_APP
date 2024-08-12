/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzaxc
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzaxc;

final class zzawy
implements Runnable {
    final View zza;
    final zzaxc zzb;

    zzawy(zzaxc zzaxc2, View view) {
        this.zzb = zzaxc2;
        this.zza = view;
    }

    @Override
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
