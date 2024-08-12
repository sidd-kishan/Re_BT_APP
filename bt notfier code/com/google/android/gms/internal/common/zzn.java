/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzl
 *  com.google.android.gms.internal.common.zzy
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzl;
import com.google.android.gms.internal.common.zzy;
import java.util.NoSuchElementException;

abstract class zzn<E>
extends zzy<E> {
    private final int zza;
    private int zzb;

    protected zzn(int n, int n2) {
        zzl.zzb((int)n2, (int)n, (String)"index");
        this.zza = n;
        this.zzb = n2;
    }

    public final boolean hasNext() {
        if (this.zzb >= this.zza) return false;
        return true;
    }

    public final boolean hasPrevious() {
        if (this.zzb <= 0) return false;
        return true;
    }

    public final E next() {
        if (!this.hasNext()) throw new NoSuchElementException();
        int n = this.zzb;
        this.zzb = n + 1;
        return this.zza(n);
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final E previous() {
        int n;
        if (!this.hasPrevious()) throw new NoSuchElementException();
        this.zzb = n = this.zzb - 1;
        return this.zza(n);
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }

    protected abstract E zza(int var1);
}
