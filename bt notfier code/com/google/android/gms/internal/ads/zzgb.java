/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecList
 *  com.google.android.gms.internal.ads.zzfz
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.android.gms.internal.ads.zzfz;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class zzgb
implements zzfz {
    private final int zza;
    private MediaCodecInfo[] zzb;

    public zzgb(boolean bl, boolean bl2) {
        int n;
        int n2 = n = 1;
        if (!bl) {
            n2 = bl2 ? n : 0;
        }
        this.zza = n2;
    }

    @EnsuresNonNull(value={"mediaCodecInfos"})
    private final void zzf() {
        if (this.zzb != null) return;
        this.zzb = new MediaCodecList(this.zza).getCodecInfos();
    }

    public final int zza() {
        this.zzf();
        return this.zzb.length;
    }

    public final MediaCodecInfo zzb(int n) {
        this.zzf();
        return this.zzb[n];
    }

    public final boolean zzc() {
        return true;
    }

    public final boolean zzd(String string, String string2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(string);
    }

    public final boolean zze(String string, String string2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(string);
    }
}
