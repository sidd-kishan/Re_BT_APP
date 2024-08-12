/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.ads.AdRequest$ErrorCode
 *  com.google.ads.mediation.MediationBannerAdapter
 *  com.google.ads.mediation.MediationBannerListener
 *  com.google.ads.mediation.customevent.CustomEventAdapter
 *  com.google.ads.mediation.customevent.CustomEventBannerListener
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.customevent.CustomEventAdapter;
import com.google.ads.mediation.customevent.CustomEventBannerListener;
import com.google.android.gms.internal.ads.zzcgt;

final class zza
implements CustomEventBannerListener {
    private final CustomEventAdapter zza;
    private final MediationBannerListener zzb;

    public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
        this.zza = customEventAdapter;
        this.zzb = mediationBannerListener;
    }

    public final void onClick() {
        zzcgt.zzd((String)"Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onClick((MediationBannerAdapter)this.zza);
    }

    public final void onDismissScreen() {
        zzcgt.zzd((String)"Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onDismissScreen((MediationBannerAdapter)this.zza);
    }

    public final void onFailedToReceiveAd() {
        zzcgt.zzd((String)"Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onFailedToReceiveAd((MediationBannerAdapter)this.zza, AdRequest.ErrorCode.NO_FILL);
    }

    public final void onLeaveApplication() {
        zzcgt.zzd((String)"Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onLeaveApplication((MediationBannerAdapter)this.zza);
    }

    public final void onPresentScreen() {
        zzcgt.zzd((String)"Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onPresentScreen((MediationBannerAdapter)this.zza);
    }

    public final void onReceivedAd(View view) {
        zzcgt.zzd((String)"Custom event adapter called onReceivedAd.");
        CustomEventAdapter.zza((CustomEventAdapter)this.zza, (View)view);
        this.zzb.onReceivedAd((MediationBannerAdapter)this.zza);
    }
}
