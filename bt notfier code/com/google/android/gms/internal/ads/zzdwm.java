/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbqm
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzdwk
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzdwk;

public final class zzdwm {
    private final zzbqm zza;

    zzdwm(zzbqm zzbqm2) {
        this.zza = zzbqm2;
    }

    private final void zzs(zzdwk object) throws RemoteException {
        String string = zzdwk.zzf((zzdwk)object);
        object = string.length() != 0 ? "Dispatching AFMA event on publisher webview: ".concat(string) : new String("Dispatching AFMA event on publisher webview: ");
        zze.zzh((String)object);
        this.zza.zzb(string);
    }

    public final void zza() throws RemoteException {
        this.zzs(new zzdwk("initialize", null));
    }

    public final void zzb(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("creation", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"nativeObjectCreated");
        this.zzs(zzdwk2);
    }

    public final void zzc(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("creation", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"nativeObjectNotCreated");
        this.zzs(zzdwk2);
    }

    public final void zzd(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("interstitial", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onNativeAdObjectNotAvailable");
        this.zzs(zzdwk2);
    }

    public final void zze(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("interstitial", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onAdLoaded");
        this.zzs(zzdwk2);
    }

    public final void zzf(long l, int n) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("interstitial", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onAdFailedToLoad");
        zzdwk.zzc((zzdwk)zzdwk2, (Integer)n);
        this.zzs(zzdwk2);
    }

    public final void zzg(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("interstitial", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onAdOpened");
        this.zzs(zzdwk2);
    }

    public final void zzh(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("interstitial", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onAdClicked");
        this.zza.zzb(zzdwk.zzf((zzdwk)zzdwk2));
    }

    public final void zzi(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("interstitial", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onAdClosed");
        this.zzs(zzdwk2);
    }

    public final void zzj(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("rewarded", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onNativeAdObjectNotAvailable");
        this.zzs(zzdwk2);
    }

    public final void zzk(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("rewarded", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onRewardedAdLoaded");
        this.zzs(zzdwk2);
    }

    public final void zzl(long l, int n) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("rewarded", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onRewardedAdFailedToLoad");
        zzdwk.zzc((zzdwk)zzdwk2, (Integer)n);
        this.zzs(zzdwk2);
    }

    public final void zzm(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("rewarded", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onRewardedAdOpened");
        this.zzs(zzdwk2);
    }

    public final void zzn(long l, int n) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("rewarded", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onRewardedAdFailedToShow");
        zzdwk.zzc((zzdwk)zzdwk2, (Integer)n);
        this.zzs(zzdwk2);
    }

    public final void zzo(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("rewarded", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onRewardedAdClosed");
        this.zzs(zzdwk2);
    }

    public final void zzp(long l, zzccp zzccp2) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("rewarded", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onUserEarnedReward");
        zzdwk.zzd((zzdwk)zzdwk2, (String)zzccp2.zze());
        zzdwk.zze((zzdwk)zzdwk2, (Integer)zzccp2.zzf());
        this.zzs(zzdwk2);
    }

    public final void zzq(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("rewarded", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onAdImpression");
        this.zzs(zzdwk2);
    }

    public final void zzr(long l) throws RemoteException {
        zzdwk zzdwk2 = new zzdwk("rewarded", null);
        zzdwk.zza((zzdwk)zzdwk2, (Long)l);
        zzdwk.zzb((zzdwk)zzdwk2, (String)"onAdClicked");
        this.zzs(zzdwk2);
    }
}
