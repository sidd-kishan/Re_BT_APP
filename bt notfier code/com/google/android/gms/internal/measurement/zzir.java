/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzip
 *  com.google.android.gms.internal.measurement.zziq
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzip;
import com.google.android.gms.internal.measurement.zziq;
import java.util.Map;

final class zzir {
    zzir() {
    }

    public static final int zza(int n, Object object, Object object2) {
        object = (zziq)object;
        object2 = (zzip)object2;
        if (object.isEmpty()) return 0;
        if (!(object = object.entrySet().iterator()).hasNext()) return 0;
        object = (Map.Entry)object.next();
        object.getKey();
        object.getValue();
        throw null;
    }

    public static final Object zzb(Object object, Object object2) {
        zziq zziq2 = (zziq)object;
        object2 = (zziq)object2;
        object = zziq2;
        if (object2.isEmpty()) return object;
        object = zziq2;
        if (!zziq2.zze()) {
            object = zziq2.zzc();
        }
        object.zzb((zziq)object2);
        return object;
    }
}
