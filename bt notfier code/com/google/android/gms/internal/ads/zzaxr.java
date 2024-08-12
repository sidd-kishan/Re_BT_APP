/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.appopen.AppOpenAd$AppOpenAdLoadCallback
 *  com.google.android.gms.internal.ads.zzaxs
 *  com.google.android.gms.internal.ads.zzaxw
 *  com.google.android.gms.internal.ads.zzaxy
 *  com.google.android.gms.internal.ads.zzbcz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.internal.ads.zzaxs;
import com.google.android.gms.internal.ads.zzaxw;
import com.google.android.gms.internal.ads.zzaxy;
import com.google.android.gms.internal.ads.zzbcz;

public final class zzaxr
extends zzaxy {
    private final AppOpenAd.AppOpenAdLoadCallback zza;
    private final String zzb;

    public zzaxr(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String string) {
        this.zza = appOpenAdLoadCallback;
        this.zzb = string;
    }

    public final void zzb(zzaxw zzaxw2) {
        if (this.zza == null) return;
        zzaxw2 = new zzaxs(zzaxw2, this.zzb);
        this.zza.onAdLoaded((Object)zzaxw2);
    }

    public final void zzc(int n) {
    }

    public final void zzd(zzbcz zzbcz2) {
        if (this.zza == null) return;
        zzbcz2 = zzbcz2.zzb();
        this.zza.onAdFailedToLoad((LoadAdError)zzbcz2);
    }
}
