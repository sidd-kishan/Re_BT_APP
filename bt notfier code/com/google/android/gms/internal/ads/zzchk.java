/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchl;

public final class zzchk<T>
extends zzchl<T> {
    private final T zza;

    private zzchk(T t) {
        this.zza = t;
    }

    public static <T> zzchk<T> zza(T t) {
        return new zzchk<T>(t);
    }

    public final void zzb() {
        this.zzc(this.zza);
    }
}
