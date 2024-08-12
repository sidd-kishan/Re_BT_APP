/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzka
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzka;
import java.util.ListIterator;

final class zzjy
implements ListIterator<String> {
    final ListIterator<String> zza;
    final int zzb;
    final zzka zzc;

    zzjy(zzka zzka2, int n) {
        this.zzc = zzka2;
        this.zzb = n;
        this.zza = zzka.zza((zzka)this.zzc).listIterator(this.zzb);
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    @Override
    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    @Override
    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
