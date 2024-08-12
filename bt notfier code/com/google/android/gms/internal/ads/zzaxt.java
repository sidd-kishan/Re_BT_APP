/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.internal.ads.zzayc
 *  com.google.android.gms.internal.ads.zzbcz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.internal.ads.zzayc;
import com.google.android.gms.internal.ads.zzbcz;

public final class zzaxt
extends zzayc {
    private FullScreenContentCallback zza;

    public final void zzb(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
    }

    public final void zzc() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdShowedFullScreenContent();
    }

    public final void zzd() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdDismissedFullScreenContent();
    }

    public final void zze(zzbcz zzbcz2) {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzbcz2.zza());
    }

    public final void zzf() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdImpression();
    }

    public final void zzg() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdClicked();
    }
}
