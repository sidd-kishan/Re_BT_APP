/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CryptoInfo
 *  android.media.MediaCodec$CryptoInfo$Pattern
 *  com.google.android.gms.internal.ads.zzaa
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import com.google.android.gms.internal.ads.zzaa;

final class zzab {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb;

    /* synthetic */ zzab(MediaCodec.CryptoInfo cryptoInfo, zzaa zzaa2) {
        this.zza = cryptoInfo;
        this.zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    static /* synthetic */ void zza(zzab zzab2, int n, int n2) {
        zzab2.zzb.set(n, n2);
        zzab2.zza.setPattern(zzab2.zzb);
    }
}
