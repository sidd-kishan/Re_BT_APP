/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Iterator;

abstract class zzfqj<F, T>
implements Iterator<T> {
    final Iterator<? extends F> zzb;

    zzfqj(Iterator<? extends F> iterator) {
        if (iterator == null) throw null;
        this.zzb = iterator;
    }

    @Override
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    @Override
    public final T next() {
        return this.zza(this.zzb.next());
    }

    @Override
    public final void remove() {
        this.zzb.remove();
    }

    abstract T zza(F var1);
}
