/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgep
 *  com.google.android.gms.internal.ads.zzgex
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgep;
import com.google.android.gms.internal.ads.zzgex;
import java.util.NoSuchElementException;

final class zzgen
extends zzgep {
    final zzgex zza;
    private int zzb;
    private final int zzc;

    zzgen(zzgex zzgex2) {
        this.zza = zzgex2;
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
