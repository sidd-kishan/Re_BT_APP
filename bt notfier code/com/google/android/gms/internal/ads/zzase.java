/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzasl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzasl;

final class zzase
implements Runnable {
    final zzasl zza;

    zzase(zzasl zzasl2) {
        this.zza = zzasl2;
    }

    @Override
    public final void run() {
        zzasl.zzx((zzasl)this.zza);
    }
}
