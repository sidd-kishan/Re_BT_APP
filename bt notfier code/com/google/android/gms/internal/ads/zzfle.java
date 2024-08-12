/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

abstract class zzfle<T>
implements Iterator<T> {
    @CheckForNull
    private T zza;
    private int zzb = 2;

    protected zzfle() {
    }

    @Override
    public final boolean hasNext() {
        int n = this.zzb;
        if (n == 4) throw new IllegalStateException();
        int n2 = n - 1;
        if (n == 0) throw null;
        if (n2 == 0) return true;
        if (n2 == 2) return false;
        this.zzb = 4;
        this.zza = this.zza();
        if (this.zzb == 3) return false;
        this.zzb = 1;
        return true;
    }

    @Override
    public final T next() {
        if (!this.hasNext()) throw new NoSuchElementException();
        this.zzb = 2;
        T t = this.zza;
        this.zza = null;
        return t;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    protected abstract T zza();

    @CheckForNull
    protected final T zzb() {
        this.zzb = 3;
        return null;
    }
}
