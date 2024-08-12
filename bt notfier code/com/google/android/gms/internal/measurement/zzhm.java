/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzhr
 *  com.google.android.gms.internal.measurement.zzit
 *  com.google.android.gms.internal.measurement.zziu
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;

final class zzhm
implements zziu {
    private static final zzhm zza = new zzhm();

    private zzhm() {
    }

    public static zzhm zza() {
        return zza;
    }

    public final boolean zzb(Class<?> clazz) {
        return zzhr.class.isAssignableFrom(clazz);
    }

    public final zzit zzc(Class<?> object) {
        if (!zzhr.class.isAssignableFrom((Class<?>)object)) {
            object = ((String)(object = String.valueOf(((Class)object).getName()))).length() != 0 ? "Unsupported message type: ".concat((String)object) : new String("Unsupported message type: ");
            throw new IllegalArgumentException((String)object);
        }
        try {
            zzit zzit2 = (zzit)zzhr.zzbx(((Class)object).asSubclass(zzhr.class)).zzl(3, null, null);
            return zzit2;
        }
        catch (Exception exception) {
            object = String.valueOf(((Class)object).getName());
            object = ((String)object).length() != 0 ? "Unable to get message info for ".concat((String)object) : new String("Unable to get message info for ");
            throw new RuntimeException((String)object, exception);
        }
    }
}
