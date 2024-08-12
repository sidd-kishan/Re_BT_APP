/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzags
 *  com.google.android.gms.internal.ads.zzfog
 *  com.google.android.gms.internal.ads.zzhf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzfog;
import com.google.android.gms.internal.ads.zzhf;

final class zzagr
implements Runnable {
    private final zzags zza;
    private final zzfog zzb;
    private final zzhf zzc;

    zzagr(zzags zzags2, zzfog zzfog2, zzhf zzhf2) {
        this.zza = zzags2;
        this.zzb = zzfog2;
        this.zzc = zzhf2;
    }

    @Override
    public final void run() {
        this.zza.zzq(this.zzb, this.zzc);
    }
}
