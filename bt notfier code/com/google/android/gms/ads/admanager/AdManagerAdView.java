/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.BaseAdView
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.ads.admanager.AdManagerAdRequest
 *  com.google.android.gms.ads.admanager.AppEventListener
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbfn
 */
package com.google.android.gms.ads.admanager;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbfn;

public final class AdManagerAdView
extends BaseAdView {
    public AdManagerAdView(Context context) {
        super(context, 0);
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null");
    }

    public AdManagerAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, true);
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null");
    }

    public AdManagerAdView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n, 0, true);
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null");
    }

    public AdSize[] getAdSizes() {
        return this.zza.zze();
    }

    public AppEventListener getAppEventListener() {
        return this.zza.zzg();
    }

    public VideoController getVideoController() {
        return this.zza.zzw();
    }

    public VideoOptions getVideoOptions() {
        return this.zza.zzz();
    }

    public void loadAd(AdManagerAdRequest adManagerAdRequest) {
        this.zza.zzh(adManagerAdRequest.zza());
    }

    public void recordManualImpression() {
        this.zza.zzj();
    }

    public void setAdSizes(AdSize ... adSizeArray) {
        if (adSizeArray == null) throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        if (adSizeArray.length <= 0) throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        this.zza.zzo(adSizeArray);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zza.zzq(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean bl) {
        this.zza.zzr(bl);
    }

    public void setVideoOptions(VideoOptions videoOptions) {
        this.zza.zzy(videoOptions);
    }

    public final boolean zza(zzbfn zzbfn2) {
        return this.zza.zzA(zzbfn2);
    }
}
