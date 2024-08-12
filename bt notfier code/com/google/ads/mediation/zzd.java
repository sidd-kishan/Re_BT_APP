/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.AbstractAdViewAdapter
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 *  com.google.android.gms.ads.mediation.MediationInterstitialListener
 */
package com.google.ads.mediation;

import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

final class zzd
extends FullScreenContentCallback {
    final AbstractAdViewAdapter zza;
    final MediationInterstitialListener zzb;

    public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationInterstitialListener;
    }

    public final void onAdDismissedFullScreenContent() {
        this.zzb.onAdClosed((MediationInterstitialAdapter)this.zza);
    }

    public final void onAdShowedFullScreenContent() {
        this.zzb.onAdOpened((MediationInterstitialAdapter)this.zza);
    }
}
