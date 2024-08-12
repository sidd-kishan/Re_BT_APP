/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzhe
 *  com.google.android.gms.internal.measurement.zzhf
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhf;

final class zzhg {
    private static final zzhe<?> zza;
    private static final zzhe<?> zzb;

    static {
        zzhe zzhe2;
        zza = new zzhf();
        try {
            zzhe2 = (zzhe)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            zzhe2 = null;
        }
        zzb = zzhe2;
    }

    static zzhe<?> zza() {
        return zza;
    }

    static zzhe<?> zzb() {
        zzhe<?> zzhe2 = zzb;
        if (zzhe2 == null) throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        return zzhe2;
    }
}
