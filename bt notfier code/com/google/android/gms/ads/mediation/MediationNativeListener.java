/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd
 *  com.google.android.gms.ads.mediation.MediationNativeAdapter
 *  com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 */
package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

@Deprecated
public interface MediationNativeListener {
    public void onAdClicked(MediationNativeAdapter var1);

    public void onAdClosed(MediationNativeAdapter var1);

    @Deprecated
    public void onAdFailedToLoad(MediationNativeAdapter var1, int var2);

    public void onAdFailedToLoad(MediationNativeAdapter var1, AdError var2);

    public void onAdImpression(MediationNativeAdapter var1);

    public void onAdLeftApplication(MediationNativeAdapter var1);

    public void onAdLoaded(MediationNativeAdapter var1, UnifiedNativeAdMapper var2);

    public void onAdOpened(MediationNativeAdapter var1);

    public void onVideoEnd(MediationNativeAdapter var1);

    public void zzb(MediationNativeAdapter var1, NativeCustomTemplateAd var2);

    public void zzc(MediationNativeAdapter var1, NativeCustomTemplateAd var2, String var3);
}
