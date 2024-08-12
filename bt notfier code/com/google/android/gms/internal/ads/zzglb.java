/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgku
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgku;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;

public final class zzglb<T>
implements zzgla,
zzgku {
    private static final zzglb<Object> zza = new zzglb<Object>(null);
    private final T zzb;

    private zzglb(T t) {
        this.zzb = t;
    }

    public static <T> zzgla<T> zza(T t) {
        zzgli.zza(t, (String)"instance cannot be null");
        return new zzglb<T>(t);
    }

    public static <T> zzgla<T> zzc(T object) {
        object = object == null ? zza : new zzglb<T>(object);
        return object;
    }

    public final T zzb() {
        return this.zzb;
    }
}
