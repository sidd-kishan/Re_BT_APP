/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.RemoteException
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.ads.appopen.AppOpenAd
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzaxt
 *  com.google.android.gms.internal.ads.zzaxw
 *  com.google.android.gms.internal.ads.zzayd
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbil
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaxt;
import com.google.android.gms.internal.ads.zzaxw;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzaxs
extends AppOpenAd {
    FullScreenContentCallback zza;
    private final zzaxw zzb;
    private final String zzc;
    private final zzaxt zzd = new zzaxt();
    private OnPaidEventListener zze;

    public zzaxs(zzaxw zzaxw2, String string) {
        this.zzb = zzaxw2;
        this.zzc = string;
    }

    public final String getAdUnitId() {
        return this.zzc;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zza;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zze;
    }

    public final ResponseInfo getResponseInfo() {
        zzbgz zzbgz2;
        try {
            zzbgz2 = this.zzb.zzg();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            zzbgz2 = null;
        }
        return ResponseInfo.zzc((zzbgz)zzbgz2);
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean bl) {
        try {
            this.zzb.zzh(bl);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zze = onPaidEventListener;
        try {
            zzaxw zzaxw2 = this.zzb;
            zzbil zzbil2 = new zzbil(onPaidEventListener);
            zzaxw2.zzi((zzbgw)zzbil2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void show(Activity activity) {
        try {
            this.zzb.zzf(ObjectWrapper.wrap((Object)activity), (zzayd)this.zzd);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
