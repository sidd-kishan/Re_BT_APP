/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdcl
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeeg
 *  com.google.android.gms.internal.ads.zzejc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdcl;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeeg;
import com.google.android.gms.internal.ads.zzejc;

final class zzejb
implements zzdcl {
    boolean zza;
    final zzeef zzb;
    final zzchl zzc;
    final zzejc zzd;

    zzejb(zzejc zzejc2, zzeef zzeef2, zzchl zzchl2) {
        this.zzd = zzejc2;
        this.zzb = zzeef2;
        this.zzc = zzchl2;
        this.zza = false;
    }

    private final void zze(zzbcz zzbcz2) {
        zzbjd zzbjd2 = zzbjl.zzdM;
        boolean bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
        int n = 1;
        if (bl) {
            n = 3;
        }
        this.zzc.zzd((Throwable)new zzeeg(n, zzbcz2));
    }

    public final void zza() {
        synchronized (this) {
            this.zzc.zzc(null);
            return;
        }
    }

    public final void zzb(int n) {
        if (this.zza) {
            return;
        }
        this.zze(new zzbcz(n, zzejc.zze((String)this.zzb.zza, (int)n), "undefined", null, null));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc(int n, String string) {
        synchronized (this) {
            boolean bl = this.zza;
            if (bl) {
                return;
            }
            this.zza = true;
            String string2 = string;
            if (string == null) {
                string2 = zzejc.zze((String)this.zzb.zza, (int)n);
            }
            string = new zzbcz(n, string2, "undefined", null, null);
            this.zze((zzbcz)string);
            return;
        }
    }

    public final void zzd(zzbcz zzbcz2) {
        synchronized (this) {
            this.zza = true;
            this.zze(zzbcz2);
            return;
        }
    }
}
