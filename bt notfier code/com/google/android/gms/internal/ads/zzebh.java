/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzebq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebq;

final class zzebh
implements Runnable {
    private final zzebq zza;

    zzebh(zzebq zzebq2) {
        this.zza = zzebq2;
    }

    @Override
    public final void run() {
        this.zza.zzk();
    }
}
