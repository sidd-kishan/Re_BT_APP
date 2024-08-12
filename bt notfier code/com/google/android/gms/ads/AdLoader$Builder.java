/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.AdLoader
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.formats.AdManagerAdViewOptions
 *  com.google.android.gms.ads.formats.NativeAdOptions
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$OnCustomClickListener
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$OnCustomTemplateAdLoadedListener
 *  com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener
 *  com.google.android.gms.ads.formats.UnifiedNativeAd$OnUnifiedNativeAdLoadedListener
 *  com.google.android.gms.ads.nativead.NativeAd$OnNativeAdLoadedListener
 *  com.google.android.gms.ads.nativead.NativeAdOptions
 *  com.google.android.gms.ads.nativead.NativeCustomFormatAd$OnCustomClickListener
 *  com.google.android.gms.ads.nativead.NativeCustomFormatAd$OnCustomFormatAdLoadedListener
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbdb
 *  com.google.android.gms.internal.ads.zzbdk
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfj
 *  com.google.android.gms.internal.ads.zzbib
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbns
 *  com.google.android.gms.internal.ads.zzbnv
 *  com.google.android.gms.internal.ads.zzbol
 *  com.google.android.gms.internal.ads.zzbon
 *  com.google.android.gms.internal.ads.zzboo
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzbyy
 *  com.google.android.gms.internal.ads.zzbza
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbdb;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbib;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbnv;
import com.google.android.gms.internal.ads.zzbol;
import com.google.android.gms.internal.ads.zzbon;
import com.google.android.gms.internal.ads.zzboo;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzcgt;

public static class AdLoader.Builder {
    private final Context zza;
    private final zzbfj zzb;

    public AdLoader.Builder(Context context, String string) {
        Context context2 = (Context)Preconditions.checkNotNull((Object)context, (Object)"context cannot be null");
        context = zzber.zzb().zzl(context, string, (zzbvg)new zzbvd());
        this.zza = context2;
        this.zzb = context;
    }

    public AdLoader build() {
        try {
            AdLoader adLoader = new AdLoader(this.zza, this.zzb.zze(), zzbdk.zza);
            return adLoader;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Failed to build AdLoader.", (Throwable)remoteException);
            zzbib zzbib2 = new zzbib();
            return new AdLoader(this.zza, zzbib2.zzc(), zzbdk.zza);
        }
    }

    public AdLoader.Builder forAdManagerAdView(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener, AdSize ... zzbon2) {
        if (zzbon2 == null) throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        if (((AdSize[])zzbon2).length <= 0) throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        try {
            zzbdl zzbdl2 = new zzbdl(this.zza, (AdSize[])zzbon2);
            zzbfj zzbfj2 = this.zzb;
            zzbon2 = new zzbon(onAdManagerAdViewLoadedListener);
            zzbfj2.zzk((zzbns)zzbon2, zzbdl2);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to add Google Ad Manager banner ad listener", (Throwable)remoteException);
        }
        return this;
    }

    public AdLoader.Builder forCustomFormatAd(String string, NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        onCustomFormatAdLoadedListener = new zzbyy(onCustomFormatAdLoadedListener, onCustomClickListener);
        try {
            this.zzb.zzi(string, onCustomFormatAdLoadedListener.zzc(), onCustomFormatAdLoadedListener.zzd());
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to add custom format ad listener", (Throwable)remoteException);
        }
        return this;
    }

    @Deprecated
    public AdLoader.Builder forCustomTemplateAd(String string, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        onCustomTemplateAdLoadedListener = new zzbol(onCustomTemplateAdLoadedListener, onCustomClickListener);
        try {
            this.zzb.zzi(string, onCustomTemplateAdLoadedListener.zzc(), onCustomTemplateAdLoadedListener.zzd());
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to add custom template ad listener", (Throwable)remoteException);
        }
        return this;
    }

    public AdLoader.Builder forNativeAd(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        try {
            zzbfj zzbfj2 = this.zzb;
            zzbza zzbza2 = new zzbza(onNativeAdLoadedListener);
            zzbfj2.zzm((zzbnv)zzbza2);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to add google native ad listener", (Throwable)remoteException);
        }
        return this;
    }

    @Deprecated
    public AdLoader.Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        try {
            zzbfj zzbfj2 = this.zzb;
            zzboo zzboo2 = new zzboo(onUnifiedNativeAdLoadedListener);
            zzbfj2.zzm((zzbnv)zzboo2);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to add google native ad listener", (Throwable)remoteException);
        }
        return this;
    }

    public AdLoader.Builder withAdListener(AdListener adListener) {
        try {
            zzbfj zzbfj2 = this.zzb;
            zzbdb zzbdb2 = new zzbdb(adListener);
            zzbfj2.zzf((zzbfa)zzbdb2);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to set AdListener.", (Throwable)remoteException);
        }
        return this;
    }

    public AdLoader.Builder withAdManagerAdViewOptions(AdManagerAdViewOptions adManagerAdViewOptions) {
        try {
            this.zzb.zzp(adManagerAdViewOptions);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to specify Ad Manager banner ad options", (Throwable)remoteException);
        }
        return this;
    }

    @Deprecated
    public AdLoader.Builder withNativeAdOptions(com.google.android.gms.ads.formats.NativeAdOptions nativeAdOptions) {
        try {
            zzbfj zzbfj2 = this.zzb;
            zzblv zzblv2 = new zzblv(nativeAdOptions);
            zzbfj2.zzj(zzblv2);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to specify native ad options", (Throwable)remoteException);
        }
        return this;
    }

    public AdLoader.Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
        try {
            zzbfj zzbfj2 = this.zzb;
            boolean bl = nativeAdOptions.shouldReturnUrlsForImageAssets();
            boolean bl2 = nativeAdOptions.shouldRequestMultipleImages();
            int n = nativeAdOptions.getAdChoicesPlacement();
            Object object = nativeAdOptions.getVideoOptions() != null ? new zzbis(nativeAdOptions.getVideoOptions()) : null;
            zzblv zzblv2 = new zzblv(4, bl, -1, bl2, n, object, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio());
            zzbfj2.zzj(zzblv2);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to specify native ad options", (Throwable)remoteException);
        }
        return this;
    }
}
