/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzka
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzka;
import java.util.Iterator;

final class zzjz
implements Iterator<String> {
    final Iterator<String> zza;
    final zzka zzb;

    zzjz(zzka zzka2) {
        this.zzb = zzka2;
        this.zza = zzka.zza((zzka)this.zzb).iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
