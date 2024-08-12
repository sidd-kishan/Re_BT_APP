/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdLoadCallback
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbfc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbfc;

public final class zzbdc<AdT>
extends zzbfc {
    private final AdLoadCallback<AdT> zza;
    private final AdT zzb;

    public zzbdc(AdLoadCallback<AdT> adLoadCallback, AdT AdT) {
        this.zza = adLoadCallback;
        this.zzb = AdT;
    }

    public final void zzb() {
        AdLoadCallback<AdT> adLoadCallback = this.zza;
        if (adLoadCallback == null) return;
        AdT AdT = this.zzb;
        if (AdT == null) return;
        adLoadCallback.onAdLoaded(AdT);
    }

    public final void zzc(zzbcz zzbcz2) {
        AdLoadCallback<AdT> adLoadCallback = this.zza;
        if (adLoadCallback == null) return;
        adLoadCallback.onAdFailedToLoad(zzbcz2.zzb());
    }
}
