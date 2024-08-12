/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbga
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbga;

public final class zzbeu
extends zzbga {
    private final FullScreenContentCallback zza;

    public zzbeu(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
    }

    public final void zzb(zzbcz zzbcz2) {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzbcz2.zza());
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

    public final void zze() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdImpression();
    }

    public final void zzf() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback == null) return;
        fullScreenContentCallback.onAdClicked();
    }
}
