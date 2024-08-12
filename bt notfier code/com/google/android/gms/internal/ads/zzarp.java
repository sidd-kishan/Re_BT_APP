/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecList
 *  com.google.android.gms.internal.ads.zzarn
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.android.gms.internal.ads.zzarn;

final class zzarp
implements zzarn {
    private final int zza;
    private MediaCodecInfo[] zzb;

    public zzarp(boolean bl) {
        this.zza = bl ? 1 : 0;
    }

    private final void zze() {
        if (this.zzb != null) return;
        this.zzb = new MediaCodecList(this.zza).getCodecInfos();
    }

    public final int zza() {
        this.zze();
        return this.zzb.length;
    }

    public final MediaCodecInfo zzb(int n) {
        this.zze();
        return this.zzb[n];
    }

    public final boolean zzc() {
        return true;
    }

    public final boolean zzd(String string, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }
}
