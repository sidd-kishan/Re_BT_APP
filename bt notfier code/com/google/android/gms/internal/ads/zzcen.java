/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcez
 *  com.google.android.gms.internal.ads.zzcfa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcfa;

final class zzcen
implements Runnable {
    private final zzcfa zza;
    private final zzcez zzb;
    private final String zzc;

    zzcen(zzcfa zzcfa2, zzcez zzcez2, String string) {
        this.zza = zzcfa2;
        this.zzb = zzcez2;
        this.zzc = string;
    }

    @Override
    public final void run() {
        this.zza.zzs(this.zzb, this.zzc);
    }
}
