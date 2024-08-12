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
 *  com.google.android.gms.internal.ads.zzbxk
 *  com.google.android.gms.internal.ads.zzbxy
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzbxy;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbxx
implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    final zzbxk zza;
    final zzbvm zzb;
    final zzbxy zzc;

    zzbxx(zzbxy zzbxy2, zzbxk zzbxk2, zzbvm zzbvm2) {
        this.zzc = zzbxy2;
        this.zza = zzbxk2;
        this.zzb = zzbvm2;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void onFailure(String string) {
        this.onFailure(new AdError(0, string, "undefined"));
    }
}
