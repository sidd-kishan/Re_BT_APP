/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeke
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeke;

final class zzekb
implements Runnable {
    private final zzeke zza;

    zzekb(zzeke zzeke2) {
        this.zza = zzeke2;
    }

    @Override
    public final void run() {
        this.zza.zze();
    }
}