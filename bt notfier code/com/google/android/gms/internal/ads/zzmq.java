/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzmt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmt;

final class zzmq
implements Runnable {
    private final zzmt zza;
    private final String zzb;

    zzmq(zzmt zzmt2, String string) {
        this.zza = zzmt2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.zzm(this.zzb);
    }
}
