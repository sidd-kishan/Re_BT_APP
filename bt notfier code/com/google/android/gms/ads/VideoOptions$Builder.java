/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoOptions
 */
package com.google.android.gms.ads;

import com.google.android.gms.ads.VideoOptions;

public static final class VideoOptions.Builder {
    private boolean zza = true;
    private boolean zzb = false;
    private boolean zzc = false;

    static /* synthetic */ boolean zza(VideoOptions.Builder builder) {
        return builder.zza;
    }

    static /* synthetic */ boolean zzb(VideoOptions.Builder builder) {
        return builder.zzb;
    }

    static /* synthetic */ boolean zzc(VideoOptions.Builder builder) {
        return builder.zzc;
    }

    public VideoOptions build() {
        return new VideoOptions(this, null);
    }

    public VideoOptions.Builder setClickToExpandRequested(boolean bl) {
        this.zzc = bl;
        return this;
    }

    public VideoOptions.Builder setCustomControlsRequested(boolean bl) {
        this.zzb = bl;
        return this;
    }

    public VideoOptions.Builder setStartMuted(boolean bl) {
        this.zza = bl;
        return this;
    }
}
