/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoOptions$Builder
 *  com.google.android.gms.ads.zzd
 *  com.google.android.gms.internal.ads.zzbis
 */
package com.google.android.gms.ads;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.zzd;
import com.google.android.gms.internal.ads.zzbis;

/*
 * Exception performing whole class analysis ignored.
 */
public final class VideoOptions {
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;

    /* synthetic */ VideoOptions(Builder builder, zzd zzd2) {
        this.zza = Builder.zza((Builder)builder);
        this.zzb = Builder.zzb((Builder)builder);
        this.zzc = Builder.zzc((Builder)builder);
    }

    public VideoOptions(zzbis zzbis2) {
        this.zza = zzbis2.zza;
        this.zzb = zzbis2.zzb;
        this.zzc = zzbis2.zzc;
    }

    public boolean getClickToExpandRequested() {
        return this.zzc;
    }

    public boolean getCustomControlsRequested() {
        return this.zzb;
    }

    public boolean getStartMuted() {
        return this.zza;
    }
}
