/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzccy
 *  com.google.android.gms.internal.ads.zzcdm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzccy;
import com.google.android.gms.internal.ads.zzcdm;

public final class zzcdl
extends zzccy {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzcdm zzb;

    public zzcdl(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzcdm zzcdm2) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzcdm2;
    }

    public final void zze() {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback == null) return;
        zzcdm zzcdm2 = this.zzb;
        if (zzcdm2 == null) return;
        rewardedInterstitialAdLoadCallback.onAdLoaded((Object)zzcdm2);
    }

    public final void zzf(int n) {
    }

    public final void zzg(zzbcz zzbcz2) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback == null) return;
        rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzbcz2.zzb());
    }
}
