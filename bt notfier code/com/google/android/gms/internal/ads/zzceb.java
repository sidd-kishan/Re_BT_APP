/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcfa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcfa;

final class zzceb {
    private final Clock zza;
    private final zzg zzb;
    private final zzcfa zzc;

    zzceb(Clock clock, zzg zzg2, zzcfa zzcfa2) {
        this.zza = clock;
        this.zzb = zzg2;
        this.zzc = zzcfa2;
    }

    public final void zza(int n, long l) {
        zzbjd zzbjd2 = zzbjl.zzak;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        if (l - this.zzb.zzE() < 0L) {
            zze.zza((String)"Receiving npa decision in the past, ignoring.");
            return;
        }
        zzbjd2 = zzbjl.zzal;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            this.zzb.zzD(-1);
            this.zzb.zzF(l);
        } else {
            this.zzb.zzD(n);
            this.zzb.zzF(l);
        }
        this.zzb();
    }

    public final void zzb() {
        zzbjd zzbjd2 = zzbjl.zzal;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        this.zzc.zza();
    }
}
