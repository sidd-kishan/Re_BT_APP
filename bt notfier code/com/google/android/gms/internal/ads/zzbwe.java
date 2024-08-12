/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationRewardedAd
 *  com.google.android.gms.ads.mediation.MediationRewardedAdCallback
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbwf
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbwe
implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    final zzbvm zza;
    final zzbwf zzb;

    zzbwe(zzbwf zzbwf2, zzbvm zzbvm2) {
        this.zzb = zzbwf2;
        this.zza = zzbvm2;
    }

    public final void onFailure(AdError adError) {
        try {
            String string = zzbwf.zzb((zzbwf)this.zzb).getClass().getCanonicalName();
            int n = adError.getCode();
            String string2 = adError.getMessage();
            String string3 = adError.getDomain();
            int n2 = String.valueOf(string).length();
            int n3 = String.valueOf(string2).length();
            int n4 = String.valueOf(string3).length();
            StringBuilder stringBuilder = new StringBuilder(n2 + 85 + n3 + n4);
            stringBuilder.append(string);
            stringBuilder.append("failed to load mediation ad: ErrorCode = ");
            stringBuilder.append(n);
            stringBuilder.append(". ErrorMessage = ");
            stringBuilder.append(string2);
            stringBuilder.append(". ErrorDomain = ");
            stringBuilder.append(string3);
            zzcgt.zzd((String)stringBuilder.toString());
            this.zza.zzx(adError.zza());
            this.zza.zzw(adError.getCode(), adError.getMessage());
            this.zza.zzg(adError.getCode());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void onFailure(String string) {
        try {
            String string2 = zzbwf.zzb((zzbwf)this.zzb).getClass().getCanonicalName();
            int n = String.valueOf(string2).length();
            int n2 = String.valueOf(string).length();
            StringBuilder stringBuilder = new StringBuilder(n + 31 + n2);
            stringBuilder.append(string2);
            stringBuilder.append("failed to loaded mediation ad: ");
            stringBuilder.append(string);
            zzcgt.zzd((String)stringBuilder.toString());
            this.zza.zzw(0, string);
            this.zza.zzg(0);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }
}
