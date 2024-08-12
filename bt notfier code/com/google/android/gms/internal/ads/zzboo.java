/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.formats.UnifiedNativeAd
 *  com.google.android.gms.ads.formats.UnifiedNativeAd$OnUnifiedNativeAdLoadedListener
 *  com.google.android.gms.internal.ads.zzbnu
 *  com.google.android.gms.internal.ads.zzboe
 *  com.google.android.gms.internal.ads.zzbof
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.internal.ads.zzbnu;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzbof;

public final class zzboo
extends zzbnu {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zza;

    public zzboo(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zza = onUnifiedNativeAdLoadedListener;
    }

    public final void zze(zzboe zzboe2) {
        this.zza.onUnifiedNativeAdLoaded((UnifiedNativeAd)new zzbof(zzboe2));
    }
}
