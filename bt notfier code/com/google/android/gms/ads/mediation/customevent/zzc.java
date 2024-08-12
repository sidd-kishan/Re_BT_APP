/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationNativeAdapter
 *  com.google.android.gms.ads.mediation.MediationNativeListener
 *  com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 *  com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
 *  com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener;
import com.google.android.gms.internal.ads.zzcgt;

final class zzc
implements CustomEventNativeListener {
    private final CustomEventAdapter zza;
    private final MediationNativeListener zzb;

    public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
        this.zza = customEventAdapter;
        this.zzb = mediationNativeListener;
    }

    public final void onAdClicked() {
        zzcgt.zzd((String)"Custom event adapter called onAdClicked.");
        this.zzb.onAdClicked((MediationNativeAdapter)this.zza);
    }

    public final void onAdClosed() {
        zzcgt.zzd((String)"Custom event adapter called onAdClosed.");
        this.zzb.onAdClosed((MediationNativeAdapter)this.zza);
    }

    public final void onAdFailedToLoad(int n) {
        zzcgt.zzd((String)"Custom event adapter called onAdFailedToLoad.");
        this.zzb.onAdFailedToLoad((MediationNativeAdapter)this.zza, n);
    }

    public final void onAdFailedToLoad(AdError adError) {
        zzcgt.zzd((String)"Custom event adapter called onAdFailedToLoad.");
        this.zzb.onAdFailedToLoad((MediationNativeAdapter)this.zza, adError);
    }

    public final void onAdImpression() {
        zzcgt.zzd((String)"Custom event adapter called onAdImpression.");
        this.zzb.onAdImpression((MediationNativeAdapter)this.zza);
    }

    public final void onAdLeftApplication() {
        zzcgt.zzd((String)"Custom event adapter called onAdLeftApplication.");
        this.zzb.onAdLeftApplication((MediationNativeAdapter)this.zza);
    }

    public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        zzcgt.zzd((String)"Custom event adapter called onAdLoaded.");
        this.zzb.onAdLoaded((MediationNativeAdapter)this.zza, unifiedNativeAdMapper);
    }

    public final void onAdOpened() {
        zzcgt.zzd((String)"Custom event adapter called onAdOpened.");
        this.zzb.onAdOpened((MediationNativeAdapter)this.zza);
    }
}
