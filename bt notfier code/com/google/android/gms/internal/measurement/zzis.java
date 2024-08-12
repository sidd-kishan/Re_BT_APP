/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzir
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzir;

final class zzis {
    private static final zzir zza;
    private static final zzir zzb;

    static {
        zzir zzir2;
        try {
            zzir2 = (zzir)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            zzir2 = null;
        }
        zza = zzir2;
        zzb = new zzir();
    }

    static zzir zza() {
        return zza;
    }

    static zzir zzb() {
        return zzb;
    }
}
