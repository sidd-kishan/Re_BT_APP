/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.AdRequest$ErrorCode
 *  com.google.ads.mediation.MediationInterstitialAdapter
 *  com.google.ads.mediation.MediationInterstitialListener
 *  com.google.ads.mediation.customevent.CustomEventAdapter
 *  com.google.ads.mediation.customevent.CustomEventInterstitialListener
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.ads.mediation.customevent;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.customevent.CustomEventAdapter;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;
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

    public final void onDismissScreen() {
        zzcgt.zzd((String)"Custom event adapter called onDismissScreen.");
        this.zzc.onDismissScreen((MediationInterstitialAdapter)this.zzb);
    }

    public final void onFailedToReceiveAd() {
        zzcgt.zzd((String)"Custom event adapter called onFailedToReceiveAd.");
        this.zzc.onFailedToReceiveAd((MediationInterstitialAdapter)this.zzb, AdRequest.ErrorCode.NO_FILL);
    }

    public final void onLeaveApplication() {
        zzcgt.zzd((String)"Custom event adapter called onLeaveApplication.");
        this.zzc.onLeaveApplication((MediationInterstitialAdapter)this.zzb);
    }

    public final void onPresentScreen() {
        zzcgt.zzd((String)"Custom event adapter called onPresentScreen.");
        this.zzc.onPresentScreen((MediationInterstitialAdapter)this.zzb);
    }

    public final void onReceivedAd() {
        zzcgt.zzd((String)"Custom event adapter called onReceivedAd.");
        this.zzc.onReceivedAd((MediationInterstitialAdapter)this.zza);
    }
}
