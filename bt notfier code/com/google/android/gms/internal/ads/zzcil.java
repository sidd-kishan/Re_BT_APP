/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcip
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcip;

final class zzcil
implements Runnable {
    private final zzcip zza;
    private final boolean zzb;

    zzcil(zzcip zzcip2, boolean bl) {
        this.zza = zzcip2;
        this.zzb = bl;
    }

    @Override
    public final void run() {
        this.zza.zzG(this.zzb);
    }
}
