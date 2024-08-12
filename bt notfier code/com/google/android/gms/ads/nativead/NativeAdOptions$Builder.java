/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.ads.nativead.NativeAdOptions
 */
package com.google.android.gms.ads.nativead;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;

public static final class NativeAdOptions.Builder {
    private boolean zza = false;
    private int zzb = 0;
    private boolean zzc = false;
    private VideoOptions zzd;
    private int zze = 1;
    private boolean zzf = false;

    static /* synthetic */ boolean zza(NativeAdOptions.Builder builder) {
        return builder.zza;
    }

    static /* synthetic */ int zzb(NativeAdOptions.Builder builder) {
        return builder.zzb;
    }

    static /* synthetic */ boolean zzc(NativeAdOptions.Builder builder) {
        return builder.zzc;
    }

    static /* synthetic */ VideoOptions zzd(NativeAdOptions.Builder builder) {
        return builder.zzd;
    }

    static /* synthetic */ int zze(NativeAdOptions.Builder builder) {
        return builder.zze;
    }

    static /* synthetic */ boolean zzf(NativeAdOptions.Builder builder) {
        return builder.zzf;
    }

    public NativeAdOptions build() {
        return new NativeAdOptions(this, null);
    }

    public NativeAdOptions.Builder setAdChoicesPlacement(int n) {
        this.zze = n;
        return this;
    }

    public NativeAdOptions.Builder setMediaAspectRatio(int n) {
        this.zzb = n;
        return this;
    }

    public NativeAdOptions.Builder setRequestCustomMuteThisAd(boolean bl) {
        this.zzf = bl;
        return this;
    }

    public NativeAdOptions.Builder setRequestMultipleImages(boolean bl) {
        this.zzc = bl;
        return this;
    }

    public NativeAdOptions.Builder setReturnUrlsForImageAssets(boolean bl) {
        this.zza = bl;
        return this;
    }

    public NativeAdOptions.Builder setVideoOptions(VideoOptions videoOptions) {
        this.zzd = videoOptions;
        return this;
    }
}
