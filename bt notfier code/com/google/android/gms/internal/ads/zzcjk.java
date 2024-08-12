/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjs;

final class zzcjk
implements Runnable {
    private final zzcjs zza;
    private final String zzb;

    zzcjk(zzcjs zzcjs2, String string) {
        this.zza = zzcjs2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.zzO(this.zzb);
    }
}
