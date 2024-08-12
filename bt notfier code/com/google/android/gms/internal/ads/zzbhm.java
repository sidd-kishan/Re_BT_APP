/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.initialization.OnInitializationCompleteListener
 *  com.google.android.gms.internal.ads.zzbhs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbhs;

final class zzbhm
implements Runnable {
    private final zzbhs zza;
    private final OnInitializationCompleteListener zzb;

    zzbhm(zzbhs zzbhs2, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zza = zzbhs2;
        this.zzb = onInitializationCompleteListener;
    }

    @Override
    public final void run() {
        this.zza.zzu(this.zzb);
    }
}
