/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.rewarded.RewardedAd
 *  com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzccy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzccy;

public final class zzcdf
extends zzccy {
    private final RewardedAdLoadCallback zza;
    private final RewardedAd zzb;

    public zzcdf(RewardedAdLoadCallback rewardedAdLoadCallback, RewardedAd rewardedAd) {
        this.zza = rewardedAdLoadCallback;
        this.zzb = rewardedAd;
    }

    public final void zze() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zza;
        if (rewardedAdLoadCallback == null) return;
        rewardedAdLoadCallback.onAdLoaded((Object)this.zzb);
    }

    public final void zzf(int n) {
    }

    public final void zzg(zzbcz zzbcz2) {
        if (this.zza == null) return;
        zzbcz2 = zzbcz2.zzb();
        this.zza.onAdFailedToLoad((LoadAdError)zzbcz2);
    }
}
