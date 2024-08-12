/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationInterstitialAd
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdCallback
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbxe
 *  com.google.android.gms.internal.ads.zzbxy
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbxe;
import com.google.android.gms.internal.ads.zzbxy;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbxu
implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    final zzbxe zza;
    final zzbvm zzb;
    final zzbxy zzc;

    zzbxu(zzbxy zzbxy2, zzbxe zzbxe2, zzbvm zzbvm2) {
        this.zzc = zzbxy2;
        this.zza = zzbxe2;
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
