/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  com.google.ads.AdRequest$ErrorCode
 *  com.google.ads.AdSize
 *  com.google.ads.mediation.MediationAdRequest
 *  com.google.ads.mediation.MediationBannerAdapter
 *  com.google.ads.mediation.MediationBannerListener
 *  com.google.ads.mediation.MediationInterstitialAdapter
 *  com.google.ads.mediation.MediationInterstitialListener
 *  com.google.ads.mediation.customevent.CustomEventBanner
 *  com.google.ads.mediation.customevent.CustomEventBannerListener
 *  com.google.ads.mediation.customevent.CustomEventInterstitial
 *  com.google.ads.mediation.customevent.CustomEventInterstitialListener
 *  com.google.ads.mediation.customevent.CustomEventServerParameters
 *  com.google.ads.mediation.customevent.zza
 *  com.google.ads.mediation.customevent.zzb
 *  com.google.android.gms.ads.mediation.customevent.CustomEventExtras
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventBanner;
import com.google.ads.mediation.customevent.CustomEventBannerListener;
import com.google.ads.mediation.customevent.CustomEventInterstitial;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventServerParameters;
import com.google.ads.mediation.customevent.zza;
import com.google.ads.mediation.customevent.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.ads.zzcgt;

public final class CustomEventAdapter
implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>,
MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    CustomEventBanner zza;
    CustomEventInterstitial zzb;
    private View zzc;

    static /* synthetic */ void zza(CustomEventAdapter customEventAdapter, View view) {
        customEventAdapter.zzc = view;
    }

    private static <T> T zzb(String string) {
        Object obj;
        try {
            obj = Class.forName(string).newInstance();
        }
        catch (Throwable throwable) {
            String string2 = throwable.getMessage();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 46 + String.valueOf(string2).length());
            stringBuilder.append("Could not instantiate custom event adapter: ");
            stringBuilder.append(string);
            stringBuilder.append(". ");
            stringBuilder.append(string2);
            zzcgt.zzi((String)stringBuilder.toString());
            return null;
        }
        return (T)obj;
    }

    public void destroy() {
        CustomEventBanner customEventBanner = this.zza;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        if ((customEventBanner = this.zzb) == null) return;
        customEventBanner.destroy();
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzc;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras object) {
        CustomEventBanner customEventBanner;
        this.zza = customEventBanner = (CustomEventBanner)CustomEventAdapter.zzb(customEventServerParameters.className);
        if (customEventBanner == null) {
            mediationBannerListener.onFailedToReceiveAd((MediationBannerAdapter)this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        object = object == null ? null : object.getExtra(customEventServerParameters.label);
        this.zza.requestBannerAd((CustomEventBannerListener)new zza(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, object);
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras object) {
        CustomEventInterstitial customEventInterstitial;
        this.zzb = customEventInterstitial = (CustomEventInterstitial)CustomEventAdapter.zzb(customEventServerParameters.className);
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onFailedToReceiveAd((MediationInterstitialAdapter)this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        object = object == null ? null : object.getExtra(customEventServerParameters.label);
        this.zzb.requestInterstitialAd((CustomEventInterstitialListener)new zzb(this, this, mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, object);
    }

    public void showInterstitial() {
        this.zzb.showInterstitial();
    }
}
