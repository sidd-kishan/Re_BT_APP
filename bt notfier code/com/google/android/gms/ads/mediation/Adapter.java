/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.InitializationCompleteCallback
 *  com.google.android.gms.ads.mediation.MediationAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationBannerAd
 *  com.google.android.gms.ads.mediation.MediationBannerAdCallback
 *  com.google.android.gms.ads.mediation.MediationBannerAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationConfiguration
 *  com.google.android.gms.ads.mediation.MediationExtrasReceiver
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
 *  com.google.android.gms.ads.mediation.VersionInfo
 */
package com.google.android.gms.ads.mediation;

import android.content.Context;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
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
import com.google.android.gms.ads.mediation.VersionInfo;
import java.util.List;

public abstract class Adapter
implements MediationExtrasReceiver {
    public abstract VersionInfo getSDKVersionInfo();

    public abstract VersionInfo getVersionInfo();

    public abstract void initialize(Context var1, InitializationCompleteCallback var2, List<MediationConfiguration> var3);

    public void loadBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(this.getClass().getSimpleName()).concat(" does not support banner ads."), "com.google.android.gms.ads"));
    }

    public void loadInterscrollerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(this.getClass().getSimpleName()).concat(" does not support interscroller ads."), "com.google.android.gms.ads"));
    }

    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(this.getClass().getSimpleName()).concat(" does not support interstitial ads."), "com.google.android.gms.ads"));
    }

    public void loadNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(this.getClass().getSimpleName()).concat(" does not support native ads."), "com.google.android.gms.ads"));
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(this.getClass().getSimpleName()).concat(" does not support rewarded ads."), "com.google.android.gms.ads"));
    }

    public void loadRewardedInterstitialAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(this.getClass().getSimpleName()).concat(" does not support rewarded interstitial ads."), "com.google.android.gms.ads"));
    }
}
