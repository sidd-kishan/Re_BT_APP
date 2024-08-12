/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationBannerAdCallback
 *  com.google.android.gms.ads.mediation.MediationInterscrollerAd
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbxb
 *  com.google.android.gms.internal.ads.zzbxy
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbxb;
import com.google.android.gms.internal.ads.zzbxy;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbxt
implements MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> {
    final zzbxb zza;
    final zzbvm zzb;

    zzbxt(zzbxy zzbxy2, zzbxb zzbxb2, zzbvm zzbvm2) {
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
