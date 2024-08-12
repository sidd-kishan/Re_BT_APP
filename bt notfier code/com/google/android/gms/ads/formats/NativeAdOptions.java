/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.ads.formats.NativeAdOptions$Builder
 *  com.google.android.gms.ads.formats.zzd
 */
package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.zzd;

/*
 * Exception performing whole class analysis ignored.
 */
@Deprecated
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final int zze;
    private final VideoOptions zzf;
    private final boolean zzg;

    /* synthetic */ NativeAdOptions(Builder builder, zzd zzd2) {
        this.zza = Builder.zza((Builder)builder);
        this.zzb = Builder.zzb((Builder)builder);
        this.zzc = Builder.zzc((Builder)builder);
        this.zzd = Builder.zzd((Builder)builder);
        this.zze = Builder.zzf((Builder)builder);
        this.zzf = Builder.zze((Builder)builder);
        this.zzg = Builder.zzg((Builder)builder);
    }

    public int getAdChoicesPlacement() {
        return this.zze;
    }

    @Deprecated
    public int getImageOrientation() {
        return this.zzb;
    }

    public int getMediaAspectRatio() {
        return this.zzc;
    }

    public VideoOptions getVideoOptions() {
        return this.zzf;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zzd;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zza;
    }

    public final boolean zza() {
        return this.zzg;
    }
}
