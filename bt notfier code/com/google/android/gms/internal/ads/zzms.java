/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzmt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmt;

final class zzms
implements Runnable {
    private final zzmt zza;
    private final Exception zzb;

    zzms(zzmt zzmt2, Exception exception) {
        this.zza = zzmt2;
        this.zzb = exception;
    }

    @Override
    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
