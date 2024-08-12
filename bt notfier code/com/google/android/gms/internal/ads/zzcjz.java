/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcki
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcki;
import java.util.Map;

final class zzcjz
implements Runnable {
    private final zzcjb zza;
    private final Map zzb;

    zzcjz(zzcjb zzcjb2, Map map) {
        this.zza = zzcjb2;
        this.zzb = map;
    }

    @Override
    public final void run() {
        zzcjb zzcjb2 = this.zza;
        Map map = this.zzb;
        int n = zzcki.zzc;
        zzcjb2.zze("onGcacheInfoEvent", map);
    }
}
