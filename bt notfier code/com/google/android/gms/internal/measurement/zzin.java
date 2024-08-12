/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzit
 *  com.google.android.gms.internal.measurement.zziu
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;

final class zzin
implements zziu {
    private final zziu[] zza;

    zzin(zziu ... zziuArray) {
        this.zza = zziuArray;
    }

    public final boolean zzb(Class<?> clazz) {
        zziu[] zziuArray = this.zza;
        int n = 0;
        while (n < 2) {
            if (zziuArray[n].zzb(clazz)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public final zzit zzc(Class<?> object) {
        zziu[] zziuArray = this.zza;
        for (int i = 0; i < 2; ++i) {
            zziu zziu2 = zziuArray[i];
            if (!zziu2.zzb((Class)object)) continue;
            return zziu2.zzc((Class)object);
        }
        object = ((String)(object = String.valueOf(((Class)object).getName()))).length() != 0 ? "No factory is available for message type: ".concat((String)object) : new String("No factory is available for message type: ");
        object = new UnsupportedOperationException((String)object);
        throw object;
    }
}
