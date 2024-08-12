/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfoj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfoj;

final class zzfpx<E>
extends zzfoj<E> {
    static final zzfoj<Object> zza = new zzfpx<Object>(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzfpx(Object[] objectArray, int n) {
        this.zzb = objectArray;
        this.zzc = n;
    }

    public final E get(int n) {
        zzflx.zze((int)n, (int)this.zzc, (String)"index");
        Object object = this.zzb[n];
        object.getClass();
        return (E)object;
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
        System.arraycopy(this.zzb, 0, objectArray, n, this.zzc);
        return n + this.zzc;
    }
}
