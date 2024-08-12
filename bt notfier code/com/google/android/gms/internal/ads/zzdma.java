/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdmh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmh;

final class zzdma
implements Runnable {
    private final zzdmh zza;

    zzdma(zzdmh zzdmh2) {
        this.zza = zzdmh2;
    }

    @Override
    public final void run() {
        this.zza.zzP();
    }
}
