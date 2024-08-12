/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzawd
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdmh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdmh;

final class zzdmg
implements zzawd {
    final String zza;
    final zzdmh zzb;

    zzdmg(zzdmh zzdmh2, String string) {
        this.zzb = zzdmh2;
        this.zza = string;
    }

    public final void zzc(zzawc zzawc2) {
        Object object = zzbjl.zzbf;
        boolean bl = (Boolean)zzbet.zzc().zzc(object);
        object = true;
        if (!bl) {
            if (!zzawc2.zzj) return;
            zzdmh.zzb((zzdmh)this.zzb).put(this.zza, object);
            zzawc2 = this.zzb;
            zzawc2.zzr(zzdmh.zza((zzdmh)zzawc2).zzbx(), zzdmh.zza((zzdmh)this.zzb).zzj(), zzdmh.zza((zzdmh)this.zzb).zzk(), true);
            return;
        }
        synchronized (this) {
            if (!zzawc2.zzj) return;
            if (zzdmh.zza((zzdmh)this.zzb) == null) {
                return;
            }
            zzdmh.zzb((zzdmh)this.zzb).put(this.zza, object);
            zzawc2 = this.zzb;
            zzawc2.zzr(zzdmh.zza((zzdmh)zzawc2).zzbx(), zzdmh.zza((zzdmh)this.zzb).zzj(), zzdmh.zza((zzdmh)this.zzb).zzk(), true);
            return;
        }
    }
}
