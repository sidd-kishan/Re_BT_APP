/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.ads.mediation.zzb
 *  com.google.ads.mediation.zzc
 *  com.google.ads.mediation.zze
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.AdLoader
 *  com.google.android.gms.ads.AdLoader$Builder
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.AdView
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$OnCustomClickListener
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$OnCustomTemplateAdLoadedListener
 *  com.google.android.gms.ads.formats.UnifiedNativeAd$OnUnifiedNativeAdLoadedListener
 *  com.google.android.gms.ads.interstitial.InterstitialAd
 *  com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.mediation.MediationBannerAdapter
 *  com.google.android.gms.ads.mediation.MediationBannerListener
 *  com.google.android.gms.ads.mediation.MediationInterstitialListener
 *  com.google.android.gms.ads.mediation.MediationNativeAdapter
 *  com.google.android.gms.ads.mediation.MediationNativeListener
 *  com.google.android.gms.ads.mediation.NativeMediationAdRequest
 *  com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener
 *  com.google.android.gms.ads.mediation.zza
 *  com.google.android.gms.ads.mediation.zzb
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcoi
 */
package com.google.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.zzb;
import com.google.ads.mediation.zzc;
import com.google.ads.mediation.zze;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcoi;
import java.util.Date;

public abstract class AbstractAdViewAdapter
implements MediationBannerAdapter,
MediationNativeAdapter,
OnImmersiveModeUpdatedListener,
zzcoi,
com.google.android.gms.ads.mediation.zzb {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdLoader adLoader;
    protected AdView mAdView;
    protected InterstitialAd mInterstitialAd;

    AdRequest buildAdRequest(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        int n;
        AdRequest.Builder builder = new AdRequest.Builder();
        Object object = mediationAdRequest.getBirthday();
        if (object != null) {
            builder.zzb((Date)object);
        }
        if ((n = mediationAdRequest.getGender()) != 0) {
            builder.zzc(n);
        }
        if ((object = mediationAdRequest.getKeywords()) != null) {
            object = object.iterator();
            while (object.hasNext()) {
                builder.addKeyword((String)object.next());
            }
        }
        if ((object = mediationAdRequest.getLocation()) != null) {
            builder.setLocation(object);
        }
        if (mediationAdRequest.isTesting()) {
            zzber.zza();
            builder.zza(zzcgm.zzt((Context)context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            n = mediationAdRequest.taggedForChildDirectedTreatment();
            boolean bl = true;
            if (n != 1) {
                bl = false;
            }
            builder.zzd(bl);
        }
        builder.zze(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, this.buildExtrasBundle(bundle, bundle2));
        return builder.build();
    }

    protected abstract Bundle buildExtrasBundle(Bundle var1, Bundle var2);

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.mAdView;
    }

    InterstitialAd getInterstitialAd() {
        return this.mInterstitialAd;
    }

    public Bundle getInterstitialAdapterInfo() {
        zza zza2 = new zza();
        zza2.zza(1);
        return zza2.zzb();
    }

    public zzbhc getVideoController() {
        AdView adView = this.mAdView;
        if (adView == null) return null;
        return adView.zza().zzb();
    }

    AdLoader.Builder newAdLoader(Context context, String string) {
        return new AdLoader.Builder(context, string);
    }

    public void onDestroy() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
            this.mAdView = null;
        }
        if (this.mInterstitialAd != null) {
            this.mInterstitialAd = null;
        }
        if (this.adLoader == null) return;
        this.adLoader = null;
    }

    public void onImmersiveModeUpdated(boolean bl) {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd == null) return;
        interstitialAd.setImmersiveMode(bl);
    }

    public void onPause() {
        AdView adView = this.mAdView;
        if (adView == null) return;
        adView.pause();
    }

    public void onResume() {
        AdView adView = this.mAdView;
        if (adView == null) return;
        adView.resume();
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        AdView adView;
        this.mAdView = adView = new AdView(context);
        adView.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.mAdView.setAdUnitId(this.getAdUnitId(bundle));
        this.mAdView.setAdListener((AdListener)new zzb(this, mediationBannerListener));
        this.mAdView.loadAd(this.buildAdRequest(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        InterstitialAd.load((Context)context, (String)this.getAdUnitId(bundle), (AdRequest)this.buildAdRequest(context, mediationAdRequest, bundle2, bundle), (InterstitialAdLoadCallback)new zzc(this, mediationInterstitialListener));
    }

    public void requestNativeAd(Context context, MediationNativeListener object, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zze zze2 = new zze(this, object);
        AdLoader.Builder builder = this.newAdLoader(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener((AdListener)zze2);
        builder.withNativeAdOptions(nativeMediationAdRequest.getNativeAdOptions());
        builder.withNativeAdOptions(nativeMediationAdRequest.getNativeAdRequestOptions());
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            builder.forUnifiedNativeAd((UnifiedNativeAd.OnUnifiedNativeAdLoadedListener)zze2);
        }
        if (nativeMediationAdRequest.zza()) {
            for (String string : nativeMediationAdRequest.zzb().keySet()) {
                object = true != (Boolean)nativeMediationAdRequest.zzb().get(string) ? null : zze2;
                builder.forCustomTemplateAd(string, (NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener)zze2, (NativeCustomTemplateAd.OnCustomClickListener)object);
            }
        }
        object = builder.build();
        this.adLoader = object;
        object.loadAd(this.buildAdRequest(context, (MediationAdRequest)nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd == null) return;
        interstitialAd.show(null);
    }
}
