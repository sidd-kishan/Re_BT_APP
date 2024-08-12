/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.ads.AdRequest$ErrorCode
 *  com.google.ads.mediation.MediationBannerAdapter
 *  com.google.ads.mediation.MediationBannerListener
 *  com.google.ads.mediation.MediationInterstitialAdapter
 *  com.google.ads.mediation.MediationInterstitialListener
 *  com.google.ads.mediation.MediationServerParameters
 *  com.google.ads.mediation.NetworkExtras
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbwl
 *  com.google.android.gms.internal.ads.zzbwm
 *  com.google.android.gms.internal.ads.zzbwn
 *  com.google.android.gms.internal.ads.zzbwo
 *  com.google.android.gms.internal.ads.zzbwp
 *  com.google.android.gms.internal.ads.zzbwq
 *  com.google.android.gms.internal.ads.zzbwr
 *  com.google.android.gms.internal.ads.zzbws
 *  com.google.android.gms.internal.ads.zzbwt
 *  com.google.android.gms.internal.ads.zzbwu
 *  com.google.android.gms.internal.ads.zzbwv
 *  com.google.android.gms.internal.ads.zzbwx
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbwl;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbwn;
import com.google.android.gms.internal.ads.zzbwo;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzbwq;
import com.google.android.gms.internal.ads.zzbwr;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzbwt;
import com.google.android.gms.internal.ads.zzbwu;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbwx;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbww<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
implements MediationBannerListener,
MediationInterstitialListener {
    private final zzbvm zza;

    public zzbww(zzbvm zzbvm2) {
        this.zza = zzbvm2;
    }

    static /* synthetic */ zzbvm zza(zzbww zzbww2) {
        return zzbww2.zza;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgt.zzd((String)"Adapter called onClick.");
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbwn(this));
            return;
        }
        try {
            this.zza.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgt.zzd((String)"Adapter called onDismissScreen.");
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzi((String)"#008 Must be called on the main UI thread.");
            zzcgm.zza.post((Runnable)new zzbwo(this));
            return;
        }
        try {
            this.zza.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzcgt.zzd((String)"Adapter called onDismissScreen.");
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbwt(this));
            return;
        }
        try {
            this.zza.zzf();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> object, AdRequest.ErrorCode errorCode) {
        object = String.valueOf(errorCode);
        String.valueOf(object).length();
        zzcgt.zzd((String)"Adapter called onFailedToReceiveAd with error. ".concat(String.valueOf(object)));
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbwp(this, errorCode));
            return;
        }
        try {
            this.zza.zzg(zzbwx.zza((AdRequest.ErrorCode)errorCode));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> object, AdRequest.ErrorCode errorCode) {
        object = String.valueOf(errorCode);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 47);
        stringBuilder.append("Adapter called onFailedToReceiveAd with error ");
        stringBuilder.append((String)object);
        stringBuilder.append(".");
        zzcgt.zzd((String)stringBuilder.toString());
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbwu(this, errorCode));
            return;
        }
        try {
            this.zza.zzg(zzbwx.zza((AdRequest.ErrorCode)errorCode));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgt.zzd((String)"Adapter called onLeaveApplication.");
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbwq(this));
            return;
        }
        try {
            this.zza.zzh();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzcgt.zzd((String)"Adapter called onLeaveApplication.");
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbwv(this));
            return;
        }
        try {
            this.zza.zzh();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgt.zzd((String)"Adapter called onPresentScreen.");
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbwr(this));
            return;
        }
        try {
            this.zza.zzi();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzcgt.zzd((String)"Adapter called onPresentScreen.");
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbwl(this));
            return;
        }
        try {
            this.zza.zzi();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzcgt.zzd((String)"Adapter called onReceivedAd.");
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbws(this));
            return;
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

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzcgt.zzd((String)"Adapter called onReceivedAd.");
        zzber.zza();
        if (!zzcgm.zzp()) {
            zzcgt.zzl((String)"#008 Must be called on the main UI thread.", null);
            zzcgm.zza.post((Runnable)new zzbwm(this));
            return;
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
}
