/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.Adapter
 *  com.google.android.gms.ads.mediation.MediationAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationBannerAd
 *  com.google.android.gms.ads.mediation.MediationBannerAdCallback
 *  com.google.android.gms.ads.mediation.MediationBannerAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationInterscrollerAd
 *  com.google.android.gms.ads.mediation.MediationInterstitialAd
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdCallback
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationNativeAdCallback
 *  com.google.android.gms.ads.mediation.MediationNativeAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationRewardedAd
 *  com.google.android.gms.ads.mediation.MediationRewardedAdCallback
 *  com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration
 *  com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 *  com.google.android.gms.ads.mediation.rtb.RtbSignalData
 *  com.google.android.gms.ads.mediation.rtb.SignalCallbacks
 */
package com.google.android.gms.ads.mediation.rtb;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class RtbAdapter
extends Adapter {
    public abstract void collectSignals(RtbSignalData var1, SignalCallbacks var2);

    public void loadRtbBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.loadBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbInterscrollerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(((Object)((Object)this)).getClass().getSimpleName()).concat(" does not support interscroller ads."), "com.google.android.gms.ads"));
    }

    public void loadRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.loadInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        this.loadNativeAd(mediationNativeAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbRewardedInterstitialAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.loadRewardedInterstitialAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }
}
