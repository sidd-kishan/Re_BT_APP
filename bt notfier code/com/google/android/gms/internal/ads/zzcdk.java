/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.OnUserEarnedRewardListener
 *  com.google.android.gms.ads.rewarded.RewardItem
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzccu
 *  com.google.android.gms.internal.ads.zzcdc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzccu;
import com.google.android.gms.internal.ads.zzcdc;

public final class zzcdk
extends zzccu {
    private FullScreenContentCallback zza;
    private OnUserEarnedRewardListener zzb;

    public final void zzb(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
    }

    public final void zzc(OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzb = onUserEarnedRewardListener;
    }

    public final void zze() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdShowedFullScreenContent();
    }

    public final void zzf() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdDismissedFullScreenContent();
    }

    public final void zzg(zzccp zzccp2) {
        OnUserEarnedRewardListener onUserEarnedRewardListener = this.zzb;
        if (onUserEarnedRewardListener == null) return;
        onUserEarnedRewardListener.onUserEarnedReward((RewardItem)new zzcdc(zzccp2));
    }

    public final void zzh(int n) {
    }

    public final void zzi(zzbcz zzbcz2) {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzbcz2.zza());
    }

    public final void zzj() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdImpression();
    }

    public final void zzk() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdClicked();
    }
}
