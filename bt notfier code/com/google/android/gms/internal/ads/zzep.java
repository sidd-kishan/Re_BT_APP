/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzdt
 *  com.google.android.gms.internal.ads.zzeq
 *  com.google.android.gms.internal.ads.zzer
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzdt;
import com.google.android.gms.internal.ads.zzeq;
import com.google.android.gms.internal.ads.zzer;

final class zzep
implements zzdt {
    final zzer zza;

    /* synthetic */ zzep(zzer zzer2, zzeq zzeq2) {
        this.zza = zzer2;
    }

    public final void zza() {
        if (zzer.zzb((zzer)this.zza) == null) return;
        zzer.zzb((zzer)this.zza).zzb();
    }

    public final void zzb(Exception exception) {
        zzaln.zzb((String)"MediaCodecAudioRenderer", (String)"Audio sink error", (Throwable)exception);
        zzer.zza((zzer)this.zza).zzi(exception);
    }
}
