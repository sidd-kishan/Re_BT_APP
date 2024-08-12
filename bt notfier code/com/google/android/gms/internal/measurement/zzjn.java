/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzjl
 *  com.google.android.gms.internal.measurement.zzjm
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjl;
import com.google.android.gms.internal.measurement.zzjm;
import java.util.Iterator;

final class zzjn {
    private static final Iterator<Object> zza = new zzjl();
    private static final Iterable<Object> zzb = new zzjm();

    static <T> Iterable<T> zza() {
        return zzb;
    }

    static /* synthetic */ Iterator zzb() {
        return zza;
    }
}
