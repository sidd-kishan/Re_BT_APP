/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.AbstractAdViewAdapter
 *  com.google.ads.mediation.zza
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$OnCustomClickListener
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$OnCustomTemplateAdLoadedListener
 *  com.google.android.gms.ads.formats.UnifiedNativeAd
 *  com.google.android.gms.ads.formats.UnifiedNativeAd$OnUnifiedNativeAdLoadedListener
 *  com.google.android.gms.ads.mediation.MediationNativeAdapter
 *  com.google.android.gms.ads.mediation.MediationNativeListener
 *  com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 */
package com.google.ads.mediation;

import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.ads.mediation.zza;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

final class zze
extends AdListener
implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener,
NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener,
NativeCustomTemplateAd.OnCustomClickListener {
    final AbstractAdViewAdapter zza;
    final MediationNativeListener zzb;

    public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationNativeListener;
    }

    public final void onAdClicked() {
        this.zzb.onAdClicked((MediationNativeAdapter)this.zza);
    }

    public final void onAdClosed() {
        this.zzb.onAdClosed((MediationNativeAdapter)this.zza);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad((MediationNativeAdapter)this.zza, (AdError)loadAdError);
    }

    public final void onAdImpression() {
        this.zzb.onAdImpression((MediationNativeAdapter)this.zza);
    }

    public final void onAdLoaded() {
    }

    public final void onAdOpened() {
        this.zzb.onAdOpened((MediationNativeAdapter)this.zza);
    }

    public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String string) {
        this.zzb.zzc((MediationNativeAdapter)this.zza, nativeCustomTemplateAd, string);
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
        this.zzb.zzb((MediationNativeAdapter)this.zza, nativeCustomTemplateAd);
    }

    public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
        this.zzb.onAdLoaded((MediationNativeAdapter)this.zza, (UnifiedNativeAdMapper)new zza(unifiedNativeAd));
    }
}
