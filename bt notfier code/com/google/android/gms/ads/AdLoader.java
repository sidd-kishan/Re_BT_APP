/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.admanager.AdManagerAdRequest
 *  com.google.android.gms.internal.ads.zzbdk
 *  com.google.android.gms.internal.ads.zzbfg
 *  com.google.android.gms.internal.ads.zzbhj
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzcgt;

public class AdLoader {
    private final zzbdk zza;
    private final Context zzb;
    private final zzbfg zzc;

    AdLoader(Context context, zzbfg zzbfg2, zzbdk zzbdk2) {
        this.zzb = context;
        this.zzc = zzbfg2;
        this.zza = zzbdk2;
    }

    private final void zza(zzbhj zzbhj2) {
        try {
            this.zzc.zze(this.zza.zza(this.zzb, zzbhj2));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Failed to load ad.", (Throwable)remoteException);
            return;
        }
    }

    public boolean isLoading() {
        try {
            boolean bl = this.zzc.zzg();
            return bl;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Failed to check if ad is loading.", (Throwable)remoteException);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        this.zza(adRequest.zza());
    }

    public void loadAd(AdManagerAdRequest adManagerAdRequest) {
        this.zza(adManagerAdRequest.zza);
    }

    public void loadAds(AdRequest adRequest, int n) {
        adRequest = adRequest.zza();
        try {
            this.zzc.zzi(this.zza.zza(this.zzb, (zzbhj)adRequest), n);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Failed to load ads.", (Throwable)remoteException);
            return;
        }
    }
}
