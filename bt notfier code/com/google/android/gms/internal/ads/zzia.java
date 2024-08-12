/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzig
 *  com.google.android.gms.internal.ads.zzot
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzig;
import com.google.android.gms.internal.ads.zzot;

final class zzia
implements Runnable {
    private final zzig zza;
    private final zzot zzb;

    zzia(zzig zzig2, zzot zzot2) {
        this.zza = zzig2;
        this.zzb = zzot2;
    }

    @Override
    public final void run() {
        this.zza.zzK(this.zzb);
    }
}
