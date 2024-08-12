/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 *  com.google.android.gms.ads.mediation.MediationInterstitialListener
 *  com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
 *  com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;
import com.google.android.gms.internal.ads.zzcgt;

final class zzb
implements CustomEventInterstitialListener {
    final CustomEventAdapter zza;
    private final CustomEventAdapter zzb;
    private final MediationInterstitialListener zzc;

    public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
        this.zza = customEventAdapter;
        this.zzb = customEventAdapter2;
        this.zzc = mediationInterstitialListener;
    }

    public final void onAdClicked() {
        zzcgt.zzd((String)"Custom event adapter called onAdClicked.");
        this.zzc.onAdClicked((MediationInterstitialAdapter)this.zzb);
    }

    public final void onAdClosed() {
        zzcgt.zzd((String)"Custom event adapter called onAdClosed.");
        this.zzc.onAdClosed((MediationInterstitialAdapter)this.zzb);
    }

    public final void onAdFailedToLoad(int n) {
        zzcgt.zzd((String)"Custom event adapter called onFailedToReceiveAd.");
        this.zzc.onAdFailedToLoad((MediationInterstitialAdapter)this.zzb, n);
    }

    public final void onAdFailedToLoad(AdError adError) {
        zzcgt.zzd((String)"Custom event adapter called onFailedToReceiveAd.");
        this.zzc.onAdFailedToLoad((MediationInterstitialAdapter)this.zzb, adError);
    }

    public final void onAdLeftApplication() {
        zzcgt.zzd((String)"Custom event adapter called onAdLeftApplication.");
        this.zzc.onAdLeftApplication((MediationInterstitialAdapter)this.zzb);
    }

    public final void onAdLoaded() {
        zzcgt.zzd((String)"Custom event adapter called onReceivedAd.");
        this.zzc.onAdLoaded((MediationInterstitialAdapter)this.zza);
    }

    public final void onAdOpened() {
        zzcgt.zzd((String)"Custom event adapter called onAdOpened.");
        this.zzc.onAdOpened((MediationInterstitialAdapter)this.zzb);
    }
}
