/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjs;

final class zzcjh
implements Runnable {
    private final zzcjs zza;
    private final String zzb;

    zzcjh(zzcjs zzcjs2, String string) {
        this.zza = zzcjs2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.zzG(this.zzb);
    }
}
