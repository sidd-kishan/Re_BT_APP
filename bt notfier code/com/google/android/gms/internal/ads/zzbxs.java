/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationBannerAd
 *  com.google.android.gms.ads.mediation.MediationBannerAdCallback
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbxb
 *  com.google.android.gms.internal.ads.zzbxy
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbxb;
import com.google.android.gms.internal.ads.zzbxy;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbxs
implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    final zzbxb zza;
    final zzbvm zzb;

    zzbxs(zzbxy zzbxy2, zzbxb zzbxb2, zzbvm zzbvm2) {
        this.zza = zzbxb2;
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
