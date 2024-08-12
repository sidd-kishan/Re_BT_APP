/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzmt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmt;

final class zzmp
implements Runnable {
    private final zzmt zza;
    private final Object zzb;
    private final long zzc;

    zzmp(zzmt zzmt2, Object object, long l) {
        this.zza = zzmt2;
        this.zzb = object;
        this.zzc = l;
    }

    @Override
    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}
