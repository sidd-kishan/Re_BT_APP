/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcmb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcmb;
import java.util.Map;

final class zzclr
implements Runnable {
    private final zzcjb zza;
    private final Map zzb;

    zzclr(zzcjb zzcjb2, Map map) {
        this.zza = zzcjb2;
        this.zzb = map;
    }

    @Override
    public final void run() {
        zzcjb zzcjb2 = this.zza;
        Map map = this.zzb;
        int n = zzcmb.zzc;
        zzcjb2.zze("onGcacheInfoEvent", map);
    }
}
