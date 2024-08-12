/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nativead.NativeAd
 *  com.google.android.gms.ads.nativead.NativeAd$OnNativeAdLoadedListener
 *  com.google.android.gms.internal.ads.zzbnu
 *  com.google.android.gms.internal.ads.zzboe
 *  com.google.android.gms.internal.ads.zzbyu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.internal.ads.zzbnu;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzbyu;

public final class zzbza
extends zzbnu {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbza(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzboe zzboe2) {
        this.zza.onNativeAdLoaded((NativeAd)new zzbyu(zzboe2));
    }
}
