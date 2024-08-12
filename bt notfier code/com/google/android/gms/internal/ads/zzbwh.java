/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd
 *  com.google.android.gms.ads.mediation.MediationBannerAdapter
 *  com.google.android.gms.ads.mediation.MediationBannerListener
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 *  com.google.android.gms.ads.mediation.MediationInterstitialListener
 *  com.google.android.gms.ads.mediation.MediationNativeAdapter
 *  com.google.android.gms.ads.mediation.MediationNativeListener
 *  com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbnc
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbvw
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbnc;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbvw;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbwh
implements MediationBannerListener,
MediationInterstitialListener,
MediationNativeListener {
    private final zzbvm zza;
    private UnifiedNativeAdMapper zzb;
    private NativeCustomTemplateAd zzc;

    public zzbwh(zzbvm zzbvm2) {
        this.zza = zzbvm2;
    }

    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdClicked.");
        try {
            this.zza.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdClicked.");
        try {
            this.zza.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        mediationNativeAdapter = this.zzb;
        if (this.zzc == null) {
            if (mediationNativeAdapter == null) {
                zzcgt.zzl((String)"#007 Could not call remote method.", null);
                return;
            }
            if (!mediationNativeAdapter.getOverrideClickHandling()) {
                zzcgt.zzd((String)"Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        zzcgt.zzd((String)"Adapter called onAdClicked.");
        try {
            this.zza.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdClosed.");
        try {
            this.zza.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdClosed.");
        try {
            this.zza.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdClosed.");
        try {
            this.zza.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter object, int n) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        object = new StringBuilder(55);
        ((StringBuilder)object).append("Adapter called onAdFailedToLoad with error. ");
        ((StringBuilder)object).append(n);
        zzcgt.zzd((String)((StringBuilder)object).toString());
        try {
            this.zza.zzg(n);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter object, AdError adError) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        int n = adError.getCode();
        String string = adError.getMessage();
        object = adError.getDomain();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 97 + String.valueOf(object).length());
        stringBuilder.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        stringBuilder.append(n);
        stringBuilder.append(". ErrorMessage: ");
        stringBuilder.append(string);
        stringBuilder.append(". ErrorDomain: ");
        stringBuilder.append((String)object);
        zzcgt.zzd((String)stringBuilder.toString());
        try {
            this.zza.zzx(adError.zza());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdFailedToLoad(MediationInterstitialAdapter object, int n) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        object = new StringBuilder(55);
        ((StringBuilder)object).append("Adapter called onAdFailedToLoad with error ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(".");
        zzcgt.zzd((String)((StringBuilder)object).toString());
        try {
            this.zza.zzg(n);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdFailedToLoad(MediationInterstitialAdapter object, AdError adError) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        int n = adError.getCode();
        object = adError.getMessage();
        String string = adError.getDomain();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 97 + String.valueOf(string).length());
        stringBuilder.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        stringBuilder.append(n);
        stringBuilder.append(". ErrorMessage: ");
        stringBuilder.append((String)object);
        stringBuilder.append(". ErrorDomain: ");
        stringBuilder.append(string);
        zzcgt.zzd((String)stringBuilder.toString());
        try {
            this.zza.zzx(adError.zza());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter object, int n) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        object = new StringBuilder(55);
        ((StringBuilder)object).append("Adapter called onAdFailedToLoad with error ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(".");
        zzcgt.zzd((String)((StringBuilder)object).toString());
        try {
            this.zza.zzg(n);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter object, AdError adError) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        int n = adError.getCode();
        String string = adError.getMessage();
        object = adError.getDomain();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 97 + String.valueOf(object).length());
        stringBuilder.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        stringBuilder.append(n);
        stringBuilder.append(". ErrorMessage: ");
        stringBuilder.append(string);
        stringBuilder.append(". ErrorDomain: ");
        stringBuilder.append((String)object);
        zzcgt.zzd((String)stringBuilder.toString());
        try {
            this.zza.zzx(adError.zza());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        mediationNativeAdapter = this.zzb;
        if (this.zzc == null) {
            if (mediationNativeAdapter == null) {
                zzcgt.zzl((String)"#007 Could not call remote method.", null);
                return;
            }
            if (!mediationNativeAdapter.getOverrideImpressionRecording()) {
                zzcgt.zzd((String)"Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        zzcgt.zzd((String)"Adapter called onAdImpression.");
        try {
            this.zza.zzk();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdLeftApplication.");
        try {
            this.zza.zzh();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdLeftApplication.");
        try {
            this.zza.zzh();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdLeftApplication.");
        try {
            this.zza.zzh();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdLoaded.");
        try {
            this.zza.zzj();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdLoaded.");
        try {
            this.zza.zzj();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdLoaded.");
        this.zzb = unifiedNativeAdMapper;
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            mediationNativeAdapter = new VideoController();
            mediationNativeAdapter.zza((zzbhc)new zzbvw());
            if (unifiedNativeAdMapper != null && unifiedNativeAdMapper.hasVideoContent()) {
                unifiedNativeAdMapper.zza((VideoController)mediationNativeAdapter);
            }
        }
        try {
            this.zza.zzj();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdOpened.");
        try {
            this.zza.zzi();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdOpened.");
        try {
            this.zza.zzi();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdOpened.");
        try {
            this.zza.zzi();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onVideoEnd.");
        try {
            this.zza.zzn();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zza(MediationBannerAdapter mediationBannerAdapter, String string, String string2) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAppEvent.");
        try {
            this.zza.zzl(string, string2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzb(MediationNativeAdapter object, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        object = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        object = ((String)object).length() != 0 ? "Adapter called onAdLoaded with template id ".concat((String)object) : new String("Adapter called onAdLoaded with template id ");
        zzcgt.zzd((String)object);
        this.zzc = nativeCustomTemplateAd;
        try {
            this.zza.zzj();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzc(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String string) {
        if (!(nativeCustomTemplateAd instanceof zzbnc)) {
            zzcgt.zzi((String)"Unexpected native custom template ad type.");
            return;
        }
        try {
            this.zza.zzm(((zzbnc)nativeCustomTemplateAd).zza(), string);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final UnifiedNativeAdMapper zzd() {
        return this.zzb;
    }

    public final NativeCustomTemplateAd zze() {
        return this.zzc;
    }
}
