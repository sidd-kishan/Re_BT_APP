/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.internal.ads.zzbes
 *  com.google.android.gms.internal.ads.zzbhl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbhl;

final class zzbhk
extends zzbes {
    final zzbhl zza;

    zzbhk(zzbhl zzbhl2) {
        this.zza = zzbhl2;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        zzbhl.zza((zzbhl)this.zza).zza(this.zza.zzx());
        super.onAdFailedToLoad(loadAdError);
    }

    public final void onAdLoaded() {
        zzbhl.zza((zzbhl)this.zza).zza(this.zza.zzx());
        super.onAdLoaded();
    }
}
