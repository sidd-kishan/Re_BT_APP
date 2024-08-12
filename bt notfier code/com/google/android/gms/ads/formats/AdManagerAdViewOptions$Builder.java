/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.formats.AdManagerAdViewOptions
 *  com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener
 */
package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;

public static final class AdManagerAdViewOptions.Builder {
    private boolean zza = false;
    private ShouldDelayBannerRenderingListener zzb;

    static /* synthetic */ boolean zza(AdManagerAdViewOptions.Builder builder) {
        return builder.zza;
    }

    static /* synthetic */ ShouldDelayBannerRenderingListener zzb(AdManagerAdViewOptions.Builder builder) {
        return builder.zzb;
    }

    public AdManagerAdViewOptions build() {
        return new AdManagerAdViewOptions(this, null);
    }

    public AdManagerAdViewOptions.Builder setManualImpressionsEnabled(boolean bl) {
        this.zza = bl;
        return this;
    }

    public AdManagerAdViewOptions.Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zzb = shouldDelayBannerRenderingListener;
        return this;
    }
}
