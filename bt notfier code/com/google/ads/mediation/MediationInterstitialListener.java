/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.AdRequest$ErrorCode
 *  com.google.ads.mediation.MediationInterstitialAdapter
 */
package com.google.ads.mediation;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationInterstitialAdapter;

@Deprecated
public interface MediationInterstitialListener {
    public void onDismissScreen(MediationInterstitialAdapter<?, ?> var1);

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> var1, AdRequest.ErrorCode var2);

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> var1);

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> var1);

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> var1);
}
