/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdLoadCallback
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.ads.admanager.AdManagerInterstitialAd
 *  com.google.android.gms.ads.admanager.AppEventListener
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzawr
 *  com.google.android.gms.internal.ads.zzbdc
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdk
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbeu
 *  com.google.android.gms.internal.ads.zzbfd
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbgb
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhj
 *  com.google.android.gms.internal.ads.zzbil
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbsh<AdT>
extends AdManagerInterstitialAd {
    private final Context zza;
    private final zzbdk zzb;
    private final zzbfn zzc;
    private final String zzd;
    private final zzbvd zze = new zzbvd();
    private AppEventListener zzf;
    private FullScreenContentCallback zzg;
    private OnPaidEventListener zzh;

    public zzbsh(Context context, String string) {
        this.zza = context;
        this.zzd = string;
        this.zzb = zzbdk.zza;
        this.zzc = zzber.zzb().zzk(context, new zzbdl(), string, (zzbvg)this.zze);
    }

    public final String getAdUnitId() {
        return this.zzd;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzf;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzh;
    }

    public final ResponseInfo getResponseInfo() {
        zzbgz zzbgz2;
        zzbgz zzbgz3 = null;
        try {
            zzbfn zzbfn2 = this.zzc;
            zzbgz2 = zzbgz3;
            if (zzbfn2 == null) return ResponseInfo.zzc(zzbgz2);
            zzbgz2 = zzbfn2.zzA();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            zzbgz2 = zzbgz3;
        }
        return ResponseInfo.zzc(zzbgz2);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzf = appEventListener;
            zzbfn zzbfn2 = this.zzc;
            if (zzbfn2 == null) return;
            if (appEventListener != null) {
                zzawr zzawr2 = new zzawr(appEventListener);
                appEventListener = zzawr2;
            } else {
                appEventListener = null;
            }
            zzbfn2.zzp((zzbfu)appEventListener);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzg = fullScreenContentCallback;
            zzbfn zzbfn2 = this.zzc;
            if (zzbfn2 == null) return;
            zzbeu zzbeu2 = new zzbeu(fullScreenContentCallback);
            zzbfn2.zzaa((zzbgb)zzbeu2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void setImmersiveMode(boolean bl) {
        try {
            zzbfn zzbfn2 = this.zzc;
            if (zzbfn2 == null) return;
            zzbfn2.zzQ(bl);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzh = onPaidEventListener;
            zzbfn zzbfn2 = this.zzc;
            if (zzbfn2 == null) return;
            zzbil zzbil2 = new zzbil(onPaidEventListener);
            zzbfn2.zzX((zzbgw)zzbil2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void show(Activity activity) {
        if (activity == null) {
            zzcgt.zzi((String)"The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzbfn zzbfn2 = this.zzc;
            if (zzbfn2 == null) return;
            zzbfn2.zzZ(ObjectWrapper.wrap((Object)activity));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zza(zzbhj zzbhj2, AdLoadCallback<AdT> adLoadCallback) {
        try {
            if (this.zzc == null) return;
            this.zze.zze(zzbhj2.zzn());
            zzbfn zzbfn2 = this.zzc;
            zzbhj2 = this.zzb.zza(this.zza, zzbhj2);
            zzbdc zzbdc2 = new zzbdc(adLoadCallback, (Object)this);
            zzbfn2.zzY((zzbdg)zzbhj2, (zzbfd)zzbdc2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", "com.google.android.gms.ads", null, null));
            return;
        }
    }
}
