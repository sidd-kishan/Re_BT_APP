/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  com.google.ads.AdSize
 *  com.google.ads.mediation.MediationAdRequest
 *  com.google.ads.mediation.MediationAdapter
 *  com.google.ads.mediation.MediationBannerListener
 *  com.google.ads.mediation.MediationServerParameters
 *  com.google.ads.mediation.NetworkExtras
 */
package com.google.ads.mediation;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public interface MediationBannerAdapter<ADDITIONAL_PARAMETERS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
extends MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    public View getBannerView();

    public void requestBannerAd(MediationBannerListener var1, Activity var2, SERVER_PARAMETERS var3, AdSize var4, MediationAdRequest var5, ADDITIONAL_PARAMETERS var6);
}
