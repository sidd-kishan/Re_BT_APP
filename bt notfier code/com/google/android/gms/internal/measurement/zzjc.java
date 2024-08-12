/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzjb
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjb;

final class zzjc {
    private static final zzjb zza;
    private static final zzjb zzb;

    static {
        zzjb zzjb2;
        try {
            zzjb2 = (zzjb)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            zzjb2 = null;
        }
        zza = zzjb2;
        zzb = new zzjb();
    }

    static zzjb zza() {
        return zza;
    }

    static zzjb zzb() {
        return zzb;
    }
}
