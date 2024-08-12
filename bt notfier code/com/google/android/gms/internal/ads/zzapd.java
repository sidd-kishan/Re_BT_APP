/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CryptoInfo
 *  android.media.MediaCodec$CryptoInfo$Pattern
 *  com.google.android.gms.internal.ads.zzapc
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import com.google.android.gms.internal.ads.zzapc;

final class zzapd {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb;

    /* synthetic */ zzapd(MediaCodec.CryptoInfo cryptoInfo, zzapc zzapc2) {
        this.zza = cryptoInfo;
        this.zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    static /* synthetic */ void zza(zzapd zzapd2, int n, int n2) {
        zzapd2.zzb.set(0, 0);
        zzapd2.zza.setPattern(zzapd2.zzb);
    }
}
