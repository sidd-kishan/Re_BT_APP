/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzemf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzemf;

final class zzemb
implements Runnable {
    private final zzemf zza;

    zzemb(zzemf zzemf2) {
        this.zza = zzemf2;
    }

    @Override
    public final void run() {
        this.zza.zze();
    }
}