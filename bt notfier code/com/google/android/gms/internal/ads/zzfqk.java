/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqj;
import java.util.ListIterator;

abstract class zzfqk<F, T>
extends zzfqj<F, T>
implements ListIterator<T> {
    zzfqk(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override
    public final void add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasPrevious() {
        return ((ListIterator)this.zzb).hasPrevious();
    }

    @Override
    public final int nextIndex() {
        return ((ListIterator)this.zzb).nextIndex();
    }

    @Override
    public final T previous() {
        return (T)this.zza(((ListIterator)this.zzb).previous());
    }

    @Override
    public final int previousIndex() {
        return ((ListIterator)this.zzb).previousIndex();
    }

    @Override
    public final void set(T t) {
        throw new UnsupportedOperationException();
    }
}
