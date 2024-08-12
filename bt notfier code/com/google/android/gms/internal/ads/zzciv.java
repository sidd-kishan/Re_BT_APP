/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcih
 *  com.google.android.gms.internal.ads.zzciu
 */
package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcih;
import com.google.android.gms.internal.ads.zzciu;
import java.util.concurrent.TimeUnit;

public final class zzciv {
    private final long zza;
    private long zzb;
    private boolean zzc;

    zzciv() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zzbjd zzbjd2 = zzbjl.zzy;
        this.zza = timeUnit.toNanos((Long)zzbet.zzc().zzc(zzbjd2));
        this.zzc = true;
    }

    public final void zza() {
        this.zzc = true;
    }

    public final void zzb(SurfaceTexture surfaceTexture, zzcih zzcih2) {
        if (zzcih2 == null) {
            return;
        }
        long l = surfaceTexture.getTimestamp();
        if (!this.zzc) {
            if (Math.abs(l - this.zzb) < this.zza) return;
        }
        this.zzc = false;
        this.zzb = l;
        zzs.zza.post((Runnable)new zzciu(this, zzcih2));
    }
}
