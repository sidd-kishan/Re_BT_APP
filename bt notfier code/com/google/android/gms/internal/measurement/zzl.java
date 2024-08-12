/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzi
 *  com.google.android.gms.internal.measurement.zzk
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzi;
import com.google.android.gms.internal.measurement.zzk;

public final class zzl {
    private static final zzi zza;
    private static volatile zzi zzb;

    static {
        zzk zzk2 = new zzk(null);
        zza = zzk2;
        zzb = zzk2;
    }

    public static zzi zza() {
        return zzb;
    }
}
