/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcrf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcrf;

final class zzcrc
implements Runnable {
    private final zzcrf zza;

    zzcrc(zzcrf zzcrf2) {
        this.zza = zzcrf2;
    }

    @Override
    public final void run() {
        this.zza.zzb();
    }
}
