/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzdp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzdp;

final class zzdh
implements Runnable {
    private final zzdp zza;
    private final zzafv zzb;
    private final zzba zzc;

    zzdh(zzdp zzdp2, zzafv zzafv2, zzba zzba2) {
        this.zza = zzdp2;
        this.zzb = zzafv2;
        this.zzc = zzba2;
    }

    @Override
    public final void run() {
        this.zza.zzr(this.zzb, this.zzc);
    }
}
