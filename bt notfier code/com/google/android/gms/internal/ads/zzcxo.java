/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdym
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdym;
import com.google.android.gms.internal.ads.zzfrz;

final class zzcxo
implements Runnable {
    private final zzfrz zza;

    zzcxo(zzfrz zzfrz2) {
        this.zza = zzfrz2;
    }

    @Override
    public final void run() {
        this.zza.zza((Throwable)new zzdym(3));
    }
}
