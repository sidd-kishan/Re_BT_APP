/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghf
 *  com.google.android.gms.internal.ads.zzghg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghf;
import com.google.android.gms.internal.ads.zzghg;

final class zzgfv
implements zzghg {
    private static final zzgfv zza = new zzgfv();

    private zzgfv() {
    }

    public static zzgfv zza() {
        return zza;
    }

    public final boolean zzb(Class<?> clazz) {
        return zzgga.class.isAssignableFrom(clazz);
    }

    public final zzghf zzc(Class<?> object) {
        if (!zzgga.class.isAssignableFrom((Class<?>)object)) {
            object = ((String)(object = String.valueOf(((Class)object).getName()))).length() != 0 ? "Unsupported message type: ".concat((String)object) : new String("Unsupported message type: ");
            throw new IllegalArgumentException((String)object);
        }
        try {
            zzghf zzghf2 = (zzghf)zzgga.zzax(((Class)object).asSubclass(zzgga.class)).zzb(3, null, null);
            return zzghf2;
        }
        catch (Exception exception) {
            object = String.valueOf(((Class)object).getName());
            object = ((String)object).length() != 0 ? "Unable to get message info for ".concat((String)object) : new String("Unable to get message info for ");
            throw new RuntimeException((String)object, exception);
        }
    }
}
