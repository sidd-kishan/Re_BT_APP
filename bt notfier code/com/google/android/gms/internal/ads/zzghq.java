/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzgha
 *  com.google.android.gms.internal.ads.zzghz
 *  com.google.android.gms.internal.ads.zzgia
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzgha;
import com.google.android.gms.internal.ads.zzghz;
import com.google.android.gms.internal.ads.zzgia;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzghq {
    private static final zzghq zza = new zzghq();
    private final zzgia zzb;
    private final ConcurrentMap<Class<?>, zzghz<?>> zzc = new ConcurrentHashMap();

    private zzghq() {
        this.zzb = new zzgha();
    }

    public static zzghq zza() {
        return zza;
    }

    public final <T> zzghz<T> zzb(Class<T> zzghz2) {
        zzghz zzghz3;
        zzggk.zzb(zzghz2, (String)"messageType");
        zzghz zzghz4 = zzghz3 = (zzghz)this.zzc.get(zzghz2);
        if (zzghz3 != null) return zzghz4;
        zzghz4 = this.zzb.zza(zzghz2);
        zzggk.zzb(zzghz2, (String)"messageType");
        zzggk.zzb((Object)zzghz4, (String)"schema");
        zzghz2 = this.zzc.putIfAbsent((Class<?>)zzghz2, (zzghz<?>)zzghz4);
        if (zzghz2 != null) return zzghz2;
        return zzghz4;
    }
}
