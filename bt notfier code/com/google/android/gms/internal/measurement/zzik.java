/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzih
 *  com.google.android.gms.internal.measurement.zzii
 *  com.google.android.gms.internal.measurement.zzij
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzij;

abstract class zzik {
    private static final zzik zza = new zzii(null);
    private static final zzik zzb = new zzij(null);

    /* synthetic */ zzik(zzih zzih2) {
    }

    static zzik zzc() {
        return zza;
    }

    static zzik zzd() {
        return zzb;
    }

    abstract void zza(Object var1, long var2);

    abstract <L> void zzb(Object var1, Object var2, long var3);
}
