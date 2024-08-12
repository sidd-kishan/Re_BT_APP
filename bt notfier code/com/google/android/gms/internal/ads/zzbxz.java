/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationBannerAdCallback
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdCallback
 *  com.google.android.gms.ads.mediation.MediationNativeAdCallback
 *  com.google.android.gms.ads.mediation.MediationRewardedAdCallback
 *  com.google.android.gms.ads.rewarded.RewardItem
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzcdj
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzcdj;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbxz
implements MediationBannerAdCallback,
MediationInterstitialAdCallback,
MediationRewardedAdCallback,
MediationNativeAdCallback {
    final zzbvm zza;

    zzbxz(zzbvm zzbvm2) {
        this.zza = zzbvm2;
    }

    /*
     * Enabled force condition propagation
     */
    public final void onAdClosed() {
        try {
            this.zza.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onAdFailedToShow(AdError adError) {
        try {
            int n = adError.getCode();
            String string = adError.getMessage();
            String string2 = adError.getDomain();
            int n2 = String.valueOf(string).length();
            int n3 = String.valueOf(string2).length();
            StringBuilder stringBuilder = new StringBuilder(n2 + 86 + n3);
            stringBuilder.append("Mediated ad failed to show: Error Code = ");
            stringBuilder.append(n);
            stringBuilder.append(". Error Message = ");
            stringBuilder.append(string);
            stringBuilder.append(" Error Domain = ");
            stringBuilder.append(string2);
            zzcgt.zzi((String)stringBuilder.toString());
            this.zza.zzy(adError.zza());
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onAdFailedToShow(String string) {
        try {
            String string2 = String.valueOf(string);
            string2 = string2.length() != 0 ? "Mediated ad failed to show: ".concat(string2) : new String("Mediated ad failed to show: ");
            zzcgt.zzi((String)string2);
            this.zza.zzv(string);
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onAdLeftApplication() {
        try {
            this.zza.zzh();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onAdOpened() {
        try {
            this.zza.zzi();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            zzbvm zzbvm2 = this.zza;
            zzcdj zzcdj2 = new zzcdj(rewardItem);
            zzbvm2.zzr((zzccp)zzcdj2);
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onVideoComplete() {
        try {
            this.zza.zzn();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    public final void onVideoMute() {
    }

    /*
     * Enabled force condition propagation
     */
    public final void onVideoPause() {
        try {
            this.zza.zzq();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onVideoPlay() {
        try {
            this.zza.zzu();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onVideoStart() {
        try {
            this.zza.zzo();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    public final void onVideoUnmute() {
    }

    /*
     * Enabled force condition propagation
     */
    public final void reportAdClicked() {
        try {
            this.zza.zze();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void reportAdImpression() {
        try {
            this.zza.zzk();
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }
}
