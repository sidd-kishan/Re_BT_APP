/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzio
 *  com.google.android.gms.internal.measurement.zzjh
 *  com.google.android.gms.internal.measurement.zzji
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzio;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzji;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzje {
    private static final zzje zza = new zzje();
    private final zzji zzb;
    private final ConcurrentMap<Class<?>, zzjh<?>> zzc = new ConcurrentHashMap();

    private zzje() {
        this.zzb = new zzio();
    }

    public static zzje zza() {
        return zza;
    }

    public final <T> zzjh<T> zzb(Class<T> zzjh2) {
        zzjh zzjh3;
        zzhz.zzb(zzjh2, (String)"messageType");
        zzjh zzjh4 = zzjh3 = (zzjh)this.zzc.get(zzjh2);
        if (zzjh3 != null) return zzjh4;
        zzjh4 = this.zzb.zza(zzjh2);
        zzhz.zzb(zzjh2, (String)"messageType");
        zzhz.zzb((Object)zzjh4, (String)"schema");
        zzjh2 = this.zzc.putIfAbsent((Class<?>)zzjh2, (zzjh<?>)zzjh4);
        if (zzjh2 != null) return zzjh2;
        return zzjh4;
    }
}
