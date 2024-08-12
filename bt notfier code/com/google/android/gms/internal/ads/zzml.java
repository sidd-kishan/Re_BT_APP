/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzmt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzmt;

final class zzml
implements Runnable {
    private final zzmt zza;
    private final zzafv zzb;
    private final zzba zzc;

    zzml(zzmt zzmt2, zzafv zzafv2, zzba zzba2) {
        this.zza = zzmt2;
        this.zzb = zzafv2;
        this.zzc = zzba2;
    }

    @Override
    public final void run() {
        this.zza.zzr(this.zzb, this.zzc);
    }
}
