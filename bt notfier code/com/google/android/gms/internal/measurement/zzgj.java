/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgl
 *  com.google.android.gms.internal.measurement.zzgr
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgr;
import java.util.NoSuchElementException;

final class zzgj
extends zzgl {
    final zzgr zza;
    private int zzb;
    private final int zzc;

    zzgj(zzgr zzgr2) {
        this.zza = zzgr2;
        this.zzb = 0;
        this.zzc = this.zza.zzc();
    }

    public final boolean hasNext() {
        if (this.zzb >= this.zzc) return false;
        return true;
    }

    public final byte zza() {
        int n = this.zzb;
        if (n >= this.zzc) throw new NoSuchElementException();
        this.zzb = n + 1;
        return this.zza.zzb(n);
    }
}
