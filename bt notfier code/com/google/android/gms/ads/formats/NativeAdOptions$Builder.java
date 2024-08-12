/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.ads.formats.NativeAdOptions
 */
package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;

public static final class NativeAdOptions.Builder {
    private boolean zza = false;
    private int zzb = -1;
    private int zzc = 0;
    private boolean zzd = false;
    private VideoOptions zze;
    private int zzf = 1;
    private boolean zzg = false;

    static /* synthetic */ boolean zza(NativeAdOptions.Builder builder) {
        return builder.zza;
    }

    static /* synthetic */ int zzb(NativeAdOptions.Builder builder) {
        return builder.zzb;
    }

    static /* synthetic */ int zzc(NativeAdOptions.Builder builder) {
        return builder.zzc;
    }

    static /* synthetic */ boolean zzd(NativeAdOptions.Builder builder) {
        return builder.zzd;
    }

    static /* synthetic */ VideoOptions zze(NativeAdOptions.Builder builder) {
        return builder.zze;
    }

    static /* synthetic */ int zzf(NativeAdOptions.Builder builder) {
        return builder.zzf;
    }

    static /* synthetic */ boolean zzg(NativeAdOptions.Builder builder) {
        return builder.zzg;
    }

    public NativeAdOptions build() {
        return new NativeAdOptions(this, null);
    }

    public NativeAdOptions.Builder setAdChoicesPlacement(int n) {
        this.zzf = n;
        return this;
    }

    @Deprecated
    public NativeAdOptions.Builder setImageOrientation(int n) {
        this.zzb = n;
        return this;
    }

    public NativeAdOptions.Builder setMediaAspectRatio(int n) {
        this.zzc = n;
        return this;
    }

    public NativeAdOptions.Builder setRequestCustomMuteThisAd(boolean bl) {
        this.zzg = bl;
        return this;
    }

    public NativeAdOptions.Builder setRequestMultipleImages(boolean bl) {
        this.zzd = bl;
        return this;
    }

    public NativeAdOptions.Builder setReturnUrlsForImageAssets(boolean bl) {
        this.zza = bl;
        return this;
    }

    public NativeAdOptions.Builder setVideoOptions(VideoOptions videoOptions) {
        this.zze = videoOptions;
        return this;
    }
}
