/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.LoadAdError
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

public class zzbes
extends AdListener {
    private final Object zza = new Object();
    private AdListener zzb;

    public final void onAdClicked() {
        Object object = this.zza;
        synchronized (object) {
            AdListener adListener = this.zzb;
            if (adListener == null) return;
            adListener.onAdClicked();
            return;
        }
    }

    public final void onAdClosed() {
        Object object = this.zza;
        synchronized (object) {
            AdListener adListener = this.zzb;
            if (adListener == null) return;
            adListener.onAdClosed();
            return;
        }
    }

    public void onAdFailedToLoad(LoadAdError loadAdError) {
        Object object = this.zza;
        synchronized (object) {
            AdListener adListener = this.zzb;
            if (adListener == null) return;
            adListener.onAdFailedToLoad(loadAdError);
            return;
        }
    }

    public final void onAdImpression() {
        Object object = this.zza;
        synchronized (object) {
            AdListener adListener = this.zzb;
            if (adListener == null) return;
            adListener.onAdImpression();
            return;
        }
    }

    public void onAdLoaded() {
        Object object = this.zza;
        synchronized (object) {
            AdListener adListener = this.zzb;
            if (adListener == null) return;
            adListener.onAdLoaded();
            return;
        }
    }

    public final void onAdOpened() {
        Object object = this.zza;
        synchronized (object) {
            AdListener adListener = this.zzb;
            if (adListener == null) return;
            adListener.onAdOpened();
            return;
        }
    }

    public final void zza(AdListener adListener) {
        Object object = this.zza;
        synchronized (object) {
            this.zzb = adListener;
            return;
        }
    }
}
