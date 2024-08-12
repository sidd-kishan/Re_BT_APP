/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzb
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbjo
 *  com.google.android.gms.internal.ads.zzbjq
 *  com.google.android.gms.internal.ads.zzbjr
 *  com.google.android.gms.internal.ads.zzcge
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjo;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbjr;
import com.google.android.gms.internal.ads.zzcge;

final class zzcgb
extends zzb {
    final zzcge zza;

    zzcgb(zzcge zzcge2) {
        this.zza = zzcge2;
    }

    public final void zza() {
        zzbjo zzbjo2 = new zzbjo(zzcge.zzb((zzcge)this.zza), zzcge.zzc((zzcge)this.zza).zza);
        Object object = zzcge.zza((zzcge)this.zza);
        synchronized (object) {
            try {
                try {
                    zzt.zzl();
                    zzbjr.zza((zzbjq)zzcge.zzd((zzcge)this.zza), (zzbjo)zzbjo2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    zze.zzj((String)"Cannot config CSI reporter.", (Throwable)illegalArgumentException);
                }
                return;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }
}
