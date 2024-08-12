/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdbp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdbp;

final class zzdbk
implements Runnable {
    private final zzdbp zza;

    zzdbk(zzdbp zzdbp2) {
        this.zza = zzdbp2;
    }

    @Override
    public final void run() {
        this.zza.zzf();
    }
}
