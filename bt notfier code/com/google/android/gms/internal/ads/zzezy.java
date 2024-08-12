/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;

public final class zzezy {
    private final Clock zza;
    private final Object zzb = new Object();
    private volatile long zzc = 0L;
    private volatile int zzd = 1;

    public zzezy(Clock clock) {
        this.zza = clock;
    }

    private final void zze() {
        long l = this.zza.currentTimeMillis();
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzd != 3) return;
            long l2 = this.zzc;
            zzbjd zzbjd2 = zzbjl.zzel;
            if (l2 + (Long)zzbet.zzc().zzc(zzbjd2) > l) return;
            this.zzd = 1;
            return;
        }
    }

    private final void zzf(int n, int n2) {
        this.zze();
        long l = this.zza.currentTimeMillis();
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzd != n) {
                return;
            }
            this.zzd = n2;
            if (this.zzd != 3) return;
            this.zzc = l;
            return;
        }
    }

    public final void zza(boolean bl) {
        if (bl) {
            this.zzf(1, 2);
            return;
        }
        this.zzf(2, 1);
    }

    public final boolean zzb() {
        Object object = this.zzb;
        synchronized (object) {
            this.zze();
            boolean bl = this.zzd == 2;
            return bl;
        }
    }

    public final boolean zzc() {
        Object object = this.zzb;
        synchronized (object) {
            this.zze();
            boolean bl = this.zzd == 3;
            return bl;
        }
    }

    public final void zzd() {
        this.zzf(2, 3);
    }
}
