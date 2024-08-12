/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationBannerAdapter
 *  com.google.android.gms.ads.mediation.MediationBannerListener
 *  com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
 *  com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;
import com.google.android.gms.internal.ads.zzcgt;

final class zza
implements CustomEventBannerListener {
    private final CustomEventAdapter zza;
    private final MediationBannerListener zzb;

    public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
        this.zza = customEventAdapter;
        this.zzb = mediationBannerListener;
    }

    public final void onAdClicked() {
        zzcgt.zzd((String)"Custom event adapter called onAdClicked.");
        this.zzb.onAdClicked((MediationBannerAdapter)this.zza);
    }

    public final void onAdClosed() {
        zzcgt.zzd((String)"Custom event adapter called onAdClosed.");
        this.zzb.onAdClosed((MediationBannerAdapter)this.zza);
    }

    public final void onAdFailedToLoad(int n) {
        zzcgt.zzd((String)"Custom event adapter called onAdFailedToLoad.");
        this.zzb.onAdFailedToLoad((MediationBannerAdapter)this.zza, n);
    }

    public final void onAdFailedToLoad(AdError adError) {
        zzcgt.zzd((String)"Custom event adapter called onAdFailedToLoad.");
        this.zzb.onAdFailedToLoad((MediationBannerAdapter)this.zza, adError);
    }

    public final void onAdLeftApplication() {
        zzcgt.zzd((String)"Custom event adapter called onAdLeftApplication.");
        this.zzb.onAdLeftApplication((MediationBannerAdapter)this.zza);
    }

    public final void onAdLoaded(View view) {
        zzcgt.zzd((String)"Custom event adapter called onAdLoaded.");
        CustomEventAdapter.zza((CustomEventAdapter)this.zza, (View)view);
        this.zzb.onAdLoaded((MediationBannerAdapter)this.zza);
    }

    public final void onAdOpened() {
        zzcgt.zzd((String)"Custom event adapter called onAdOpened.");
        this.zzb.onAdOpened((MediationBannerAdapter)this.zza);
    }
}
