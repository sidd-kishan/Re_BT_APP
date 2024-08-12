/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.mediation.MediationBannerAdapter
 *  com.google.android.gms.ads.mediation.MediationBannerListener
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 *  com.google.android.gms.ads.mediation.MediationInterstitialListener
 *  com.google.android.gms.ads.mediation.MediationNativeAdapter
 *  com.google.android.gms.ads.mediation.MediationNativeListener
 *  com.google.android.gms.ads.mediation.NativeMediationAdRequest
 *  com.google.android.gms.ads.mediation.customevent.CustomEventBanner
 *  com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
 *  com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial
 *  com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
 *  com.google.android.gms.ads.mediation.customevent.CustomEventNative
 *  com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
 *  com.google.android.gms.ads.mediation.customevent.zza
 *  com.google.android.gms.ads.mediation.customevent.zzb
 *  com.google.android.gms.ads.mediation.customevent.zzc
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventBanner;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventNative;
import com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener;
import com.google.android.gms.ads.mediation.customevent.zza;
import com.google.android.gms.ads.mediation.customevent.zzb;
import com.google.android.gms.ads.mediation.customevent.zzc;
import com.google.android.gms.internal.ads.zzcgt;

public final class CustomEventAdapter
implements MediationBannerAdapter,
MediationInterstitialAdapter,
MediationNativeAdapter {
    static final AdError zza = new AdError(0, "Could not instantiate custom event adapter", "com.google.android.gms.ads");
    CustomEventBanner zzb;
    CustomEventInterstitial zzc;
    CustomEventNative zzd;
    private View zze;

    static /* synthetic */ void zza(CustomEventAdapter customEventAdapter, View view) {
        customEventAdapter.zze = view;
    }

    private static <T> T zzb(Class<T> clazz, String string) {
        if (string == null) throw null;
        try {
            return clazz.cast(Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
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
    }

    public View getBannerView() {
        return this.zze;
    }

    public void onDestroy() {
        CustomEventBanner customEventBanner = this.zzb;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        if ((customEventBanner = this.zzc) != null) {
            customEventBanner.onDestroy();
        }
        if ((customEventBanner = this.zzd) == null) return;
        customEventBanner.onDestroy();
    }

    public void onPause() {
        CustomEventBanner customEventBanner = this.zzb;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        if ((customEventBanner = this.zzc) != null) {
            customEventBanner.onPause();
        }
        if ((customEventBanner = this.zzd) == null) return;
        customEventBanner.onPause();
    }

    public void onResume() {
        CustomEventBanner customEventBanner = this.zzb;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        if ((customEventBanner = this.zzc) != null) {
            customEventBanner.onResume();
        }
        if ((customEventBanner = this.zzd) == null) return;
        customEventBanner.onResume();
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle object) {
        CustomEventBanner customEventBanner;
        this.zzb = customEventBanner = CustomEventAdapter.zzb(CustomEventBanner.class, bundle.getString("class_name"));
        if (customEventBanner == null) {
            mediationBannerListener.onAdFailedToLoad((MediationBannerAdapter)this, zza);
            return;
        }
        object = object == null ? null : object.getBundle(bundle.getString("class_name"));
        customEventBanner = this.zzb;
        if (customEventBanner == null) throw null;
        customEventBanner.requestBannerAd(context, (CustomEventBannerListener)new zza(this, mediationBannerListener), bundle.getString("parameter"), adSize, mediationAdRequest, object);
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle object) {
        CustomEventInterstitial customEventInterstitial;
        this.zzc = customEventInterstitial = CustomEventAdapter.zzb(CustomEventInterstitial.class, bundle.getString("class_name"));
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter)this, zza);
            return;
        }
        object = object == null ? null : object.getBundle(bundle.getString("class_name"));
        customEventInterstitial = this.zzc;
        if (customEventInterstitial == null) throw null;
        customEventInterstitial.requestInterstitialAd(context, (CustomEventInterstitialListener)new zzb(this, this, mediationInterstitialListener), bundle.getString("parameter"), mediationAdRequest, object);
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle object) {
        CustomEventNative customEventNative;
        this.zzd = customEventNative = CustomEventAdapter.zzb(CustomEventNative.class, bundle.getString("class_name"));
        if (customEventNative == null) {
            mediationNativeListener.onAdFailedToLoad((MediationNativeAdapter)this, zza);
            return;
        }
        object = object == null ? null : object.getBundle(bundle.getString("class_name"));
        customEventNative = this.zzd;
        if (customEventNative == null) throw null;
        customEventNative.requestNativeAd(context, (CustomEventNativeListener)new zzc(this, mediationNativeListener), bundle.getString("parameter"), nativeMediationAdRequest, object);
    }

    public void showInterstitial() {
        CustomEventInterstitial customEventInterstitial = this.zzc;
        if (customEventInterstitial == null) return;
        customEventInterstitial.showInterstitial();
    }
}
