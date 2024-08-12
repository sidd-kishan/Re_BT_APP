/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbez
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbez;

public final class zzbdb
extends zzbez {
    private final AdListener zza;

    public zzbdb(AdListener adListener) {
        this.zza = adListener;
    }

    public final void zzb() {
        AdListener adListener = this.zza;
        if (adListener == null) return;
        adListener.onAdClosed();
    }

    public final void zzc(int n) {
    }

    public final void zzd(zzbcz zzbcz2) {
        AdListener adListener = this.zza;
        if (adListener == null) return;
        adListener.onAdFailedToLoad(zzbcz2.zzb());
    }

    public final void zze() {
    }

    public final void zzf() {
        AdListener adListener = this.zza;
        if (adListener == null) return;
        adListener.onAdLoaded();
    }

    public final void zzg() {
        AdListener adListener = this.zza;
        if (adListener == null) return;
        adListener.onAdOpened();
    }

    public final void zzh() {
        AdListener adListener = this.zza;
        if (adListener == null) return;
        adListener.onAdClicked();
    }

    public final void zzi() {
        AdListener adListener = this.zza;
        if (adListener == null) return;
        adListener.onAdImpression();
    }

    public final AdListener zzj() {
        return this.zza;
    }
}
