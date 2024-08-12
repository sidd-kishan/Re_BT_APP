/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationRewardedAdCallback
 *  com.google.android.gms.ads.rewarded.RewardItem
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzcdj
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzcdj;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzcdi
implements MediationRewardedAdCallback {
    private final zzbvm zza;

    public zzcdi(zzbvm zzbvm2) {
        this.zza = zzbvm2;
    }

    public final void onAdClosed() {
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

    public final void onAdFailedToShow(AdError adError) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdFailedToShow.");
        int n = adError.getCode();
        String string = adError.getMessage();
        String string2 = adError.getDomain();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 87 + String.valueOf(string2).length());
        stringBuilder.append("Mediation ad failed to show: Error Code = ");
        stringBuilder.append(n);
        stringBuilder.append(". Error Message = ");
        stringBuilder.append(string);
        stringBuilder.append(" Error Domain = ");
        stringBuilder.append(string2);
        zzcgt.zzi((String)stringBuilder.toString());
        try {
            this.zza.zzy(adError.zza());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdFailedToShow(String string) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onAdFailedToShow.");
        String string2 = String.valueOf(string);
        string2 = string2.length() != 0 ? "Mediation ad failed to show: ".concat(string2) : new String("Mediation ad failed to show: ");
        zzcgt.zzi((String)string2);
        try {
            this.zza.zzv(string);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onAdOpened() {
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

    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onUserEarnedReward.");
        try {
            zzbvm zzbvm2 = this.zza;
            zzcdj zzcdj2 = new zzcdj(rewardItem);
            zzbvm2.zzr((zzccp)zzcdj2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onVideoComplete() {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onVideoComplete.");
        try {
            this.zza.zzt();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void onVideoStart() {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called onVideoStart.");
        try {
            this.zza.zzo();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void reportAdClicked() {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called reportAdClicked.");
        try {
            this.zza.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void reportAdImpression() {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzcgt.zzd((String)"Adapter called reportAdImpression.");
        try {
            this.zza.zzk();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
