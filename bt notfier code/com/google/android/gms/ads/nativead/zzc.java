/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView$ScaleType
 *  com.google.android.gms.ads.nativead.NativeAdView
 *  com.google.android.gms.internal.ads.zzblu
 */
package com.google.android.gms.ads.nativead;

import android.widget.ImageView;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.internal.ads.zzblu;

final class zzc
implements zzblu {
    private final NativeAdView zza;

    zzc(NativeAdView nativeAdView) {
        this.zza = nativeAdView;
    }

    public final void zza(ImageView.ScaleType scaleType) {
        this.zza.zzb(scaleType);
    }
}
