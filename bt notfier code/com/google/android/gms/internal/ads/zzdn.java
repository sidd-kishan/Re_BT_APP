/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdp;

final class zzdn
implements Runnable {
    private final zzdp zza;
    private final Exception zzb;

    zzdn(zzdp zzdp2, Exception exception) {
        this.zza = zzdp2;
        this.zzb = exception;
    }

    @Override
    public final void run() {
        this.zza.zzl(this.zzb);
    }
}
