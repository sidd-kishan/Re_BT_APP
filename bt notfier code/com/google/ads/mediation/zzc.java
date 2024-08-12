/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.AbstractAdViewAdapter
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 *  com.google.android.gms.ads.mediation.MediationInterstitialListener
 */
package com.google.ads.mediation;

import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

final class zzc
extends InterstitialAdLoadCallback {
    final AbstractAdViewAdapter zza;
    final MediationInterstitialListener zzb;

    public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationInterstitialListener;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad((MediationInterstitialAdapter)this.zza, (AdError)loadAdError);
    }
}
