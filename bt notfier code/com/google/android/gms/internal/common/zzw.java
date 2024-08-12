/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzl
 *  com.google.android.gms.internal.common.zzu
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzl;
import com.google.android.gms.internal.common.zzu;

final class zzw<E>
extends zzu<E> {
    static final zzu<Object> zza = new zzw<Object>(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzw(Object[] objectArray, int n) {
        this.zzb = objectArray;
        this.zzc = n;
    }

    public final E get(int n) {
        zzl.zza((int)n, (int)this.zzc, (String)"index");
        return (E)this.zzb[n];
    }

    public final int size() {
        return this.zzc;
    }

    final Object[] zzb() {
        return this.zzb;
    }

    final int zzc() {
        return 0;
    }

    final int zzd() {
        return this.zzc;
    }

    final boolean zzf() {
        return false;
    }

    final int zzg(Object[] objectArray, int n) {
        System.arraycopy(this.zzb, 0, objectArray, 0, this.zzc);
        return this.zzc;
    }
}
