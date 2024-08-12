/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.ads.OnUserEarnedRewardListener
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
 *  com.google.android.gms.ads.rewarded.RewardItem
 *  com.google.android.gms.ads.rewarded.RewardedAd
 *  com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
 *  com.google.android.gms.ads.rewarded.ServerSideVerificationOptions
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdk
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbgt
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhj
 *  com.google.android.gms.internal.ads.zzbik
 *  com.google.android.gms.internal.ads.zzbil
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzccs
 *  com.google.android.gms.internal.ads.zzccv
 *  com.google.android.gms.internal.ads.zzccz
 *  com.google.android.gms.internal.ads.zzcdc
 *  com.google.android.gms.internal.ads.zzcdf
 *  com.google.android.gms.internal.ads.zzcdg
 *  com.google.android.gms.internal.ads.zzcdk
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbik;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzccz;
import com.google.android.gms.internal.ads.zzcdc;
import com.google.android.gms.internal.ads.zzcdf;
import com.google.android.gms.internal.ads.zzcdg;
import com.google.android.gms.internal.ads.zzcdk;
import com.google.android.gms.internal.ads.zzcgt;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcdb
extends RewardedAd {
    private final String zza;
    private final zzccs zzb;
    private final Context zzc;
    private final zzcdk zzd;
    private OnAdMetadataChangedListener zze;
    private OnPaidEventListener zzf;
    private FullScreenContentCallback zzg;

    public zzcdb(Context context, String string) {
        this.zzc = context.getApplicationContext();
        this.zza = string;
        this.zzb = zzber.zzb().zzo(context, string, (zzbvg)new zzbvd());
        this.zzd = new zzcdk();
    }

    public final Bundle getAdMetadata() {
        try {
            zzccs zzccs2 = this.zzb;
            if (zzccs2 == null) return new Bundle();
            zzccs2 = zzccs2.zzg();
            return zzccs2;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zza;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zze;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzf;
    }

    public final ResponseInfo getResponseInfo() {
        zzbgz zzbgz2;
        zzbgz zzbgz3 = null;
        try {
            zzccs zzccs2 = this.zzb;
            zzbgz2 = zzbgz3;
            if (zzccs2 == null) return ResponseInfo.zzc(zzbgz2);
            zzbgz2 = zzccs2.zzm();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            zzbgz2 = zzbgz3;
        }
        return ResponseInfo.zzc(zzbgz2);
    }

    public final RewardItem getRewardItem() {
        try {
            Object object = this.zzb;
            object = object != null ? object.zzl() : null;
            object = object == null ? RewardItem.DEFAULT_REWARD : new zzcdc((zzccp)object);
            return object;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return RewardItem.DEFAULT_REWARD;
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzg = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean bl) {
        try {
            zzccs zzccs2 = this.zzb;
            if (zzccs2 == null) return;
            zzccs2.zzo(bl);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zze = onAdMetadataChangedListener;
            zzccs zzccs2 = this.zzb;
            if (zzccs2 == null) return;
            zzbik zzbik2 = new zzbik(onAdMetadataChangedListener);
            zzccs2.zzf((zzbgt)zzbik2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzf = onPaidEventListener;
            zzccs zzccs2 = this.zzb;
            if (zzccs2 == null) return;
            zzbil zzbil2 = new zzbil(onPaidEventListener);
            zzccs2.zzn((zzbgw)zzbil2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        if (serverSideVerificationOptions == null) return;
        try {
            zzccs zzccs2 = this.zzb;
            if (zzccs2 == null) return;
            zzcdg zzcdg2 = new zzcdg(serverSideVerificationOptions);
            zzccs2.zzh(zzcdg2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        if (activity == null) {
            zzcgt.zzi((String)"The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            onUserEarnedRewardListener = this.zzb;
            if (onUserEarnedRewardListener == null) return;
            onUserEarnedRewardListener.zze((zzccv)this.zzd);
            this.zzb.zzb(ObjectWrapper.wrap((Object)activity));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zza(zzbhj zzbhj2, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            zzccs zzccs2 = this.zzb;
            if (zzccs2 == null) return;
            zzbhj2 = zzbdk.zza.zza(this.zzc, zzbhj2);
            zzcdf zzcdf2 = new zzcdf(rewardedAdLoadCallback, (RewardedAd)this);
            zzccs2.zzc((zzbdg)zzbhj2, (zzccz)zzcdf2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
