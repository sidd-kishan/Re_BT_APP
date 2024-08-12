/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeyc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeyc;

final class zzexw
implements Runnable {
    private final zzeyc zza;

    zzexw(zzeyc zzeyc2) {
        this.zza = zzeyc2;
    }

    @Override
    public final void run() {
        this.zza.zzh();
    }
}
