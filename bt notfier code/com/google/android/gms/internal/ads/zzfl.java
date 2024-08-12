/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzfo
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzfo;

public final class zzfl {
    public final zzfo zza;
    public final MediaFormat zzb;
    public final zzafv zzc;
    public final Surface zzd;
    public final MediaCrypto zze;

    private zzfl(zzfo zzfo2, MediaFormat mediaFormat, zzafv zzafv2, Surface surface, MediaCrypto mediaCrypto, int n, boolean bl) {
        this.zza = zzfo2;
        this.zzb = mediaFormat;
        this.zzc = zzafv2;
        this.zzd = surface;
        this.zze = null;
    }

    public static zzfl zza(zzfo zzfo2, MediaFormat mediaFormat, zzafv zzafv2, MediaCrypto mediaCrypto) {
        return new zzfl(zzfo2, mediaFormat, zzafv2, null, null, 0, false);
    }

    public static zzfl zzb(zzfo zzfo2, MediaFormat mediaFormat, zzafv zzafv2, Surface surface, MediaCrypto mediaCrypto) {
        return new zzfl(zzfo2, mediaFormat, zzafv2, surface, null, 0, false);
    }
}
