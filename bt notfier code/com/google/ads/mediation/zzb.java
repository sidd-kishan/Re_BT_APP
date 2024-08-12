/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.AbstractAdViewAdapter
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.admanager.AppEventListener
 *  com.google.android.gms.ads.mediation.MediationBannerAdapter
 *  com.google.android.gms.ads.mediation.MediationBannerListener
 *  com.google.android.gms.internal.ads.zzbcv
 */
package com.google.ads.mediation;

import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.ads.zzbcv;

final class zzb
extends AdListener
implements AppEventListener,
zzbcv {
    final AbstractAdViewAdapter zza;
    final MediationBannerListener zzb;

    public zzb(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationBannerListener;
    }

    public final void onAdClicked() {
        this.zzb.onAdClicked((MediationBannerAdapter)this.zza);
    }

    public final void onAdClosed() {
        this.zzb.onAdClosed((MediationBannerAdapter)this.zza);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad((MediationBannerAdapter)this.zza, (AdError)loadAdError);
    }

    public final void onAdLoaded() {
        this.zzb.onAdLoaded((MediationBannerAdapter)this.zza);
    }

    public final void onAdOpened() {
        this.zzb.onAdOpened((MediationBannerAdapter)this.zza);
    }

    public final void onAppEvent(String string, String string2) {
        this.zzb.zza((MediationBannerAdapter)this.zza, string, string2);
    }
}
