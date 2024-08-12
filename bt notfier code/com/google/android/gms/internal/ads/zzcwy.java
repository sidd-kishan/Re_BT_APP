/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzawd
 *  com.google.android.gms.internal.ads.zzdbu
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzdcz
 *  com.google.android.gms.internal.ads.zzezz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzdbu;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzdcz;
import com.google.android.gms.internal.ads.zzezz;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcwy
implements zzdcq,
zzawd {
    private final zzezz zza;
    private final zzdbu zzb;
    private final zzdcz zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzcwy(zzezz zzezz2, zzdbu zzdbu2, zzdcz zzdcz2) {
        this.zza = zzezz2;
        this.zzb = zzdbu2;
        this.zzc = zzdcz2;
    }

    private final void zza() {
        if (!this.zzd.compareAndSet(false, true)) return;
        this.zzb.zza();
    }

    public final void zzc(zzawc zzawc2) {
        if (this.zza.zzf == 1 && zzawc2.zzj) {
            this.zza();
        }
        if (!zzawc2.zzj) return;
        if (!this.zze.compareAndSet(false, true)) return;
        this.zzc.zza();
    }

    public final void zzf() {
        synchronized (this) {
            if (this.zza.zzf == 1) return;
            this.zza();
            return;
        }
    }
}
