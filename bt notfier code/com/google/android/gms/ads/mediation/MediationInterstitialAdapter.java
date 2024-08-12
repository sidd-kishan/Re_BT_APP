/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.ads.mediation.MediationInterstitialListener
 */
package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

@Deprecated
public interface MediationInterstitialAdapter
extends MediationAdapter {
    public void requestInterstitialAd(Context var1, MediationInterstitialListener var2, Bundle var3, MediationAdRequest var4, Bundle var5);

    public void showInterstitial();
}
