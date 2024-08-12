/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.ads.formats.UnifiedNativeAd
 *  com.google.android.gms.ads.formats.zze
 *  com.google.android.gms.ads.formats.zzg
 *  com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 */
package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.zze;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.util.Map;

final class zza
extends UnifiedNativeAdMapper {
    private final UnifiedNativeAd zza;

    public zza(UnifiedNativeAd unifiedNativeAd) {
        this.zza = unifiedNativeAd;
        this.setHeadline(unifiedNativeAd.getHeadline());
        this.setImages(unifiedNativeAd.getImages());
        this.setBody(unifiedNativeAd.getBody());
        this.setIcon(unifiedNativeAd.getIcon());
        this.setCallToAction(unifiedNativeAd.getCallToAction());
        this.setAdvertiser(unifiedNativeAd.getAdvertiser());
        this.setStarRating(unifiedNativeAd.getStarRating());
        this.setStore(unifiedNativeAd.getStore());
        this.setPrice(unifiedNativeAd.getPrice());
        this.zzb(unifiedNativeAd.zza());
        this.setOverrideImpressionRecording(true);
        this.setOverrideClickHandling(true);
        this.zza(unifiedNativeAd.getVideoController());
    }

    public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        if (!(view instanceof zzg)) {
            if ((zze)zze.zza.get(view) != null) throw null;
            return;
        }
        view = (zzg)view;
        throw null;
    }
}
