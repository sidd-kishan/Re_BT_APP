/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzhc
 *  com.google.android.gms.internal.measurement.zzhl
 *  com.google.android.gms.internal.measurement.zzhp
 *  com.google.android.gms.internal.measurement.zziw
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhc;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzhp;
import com.google.android.gms.internal.measurement.zziw;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzhd {
    static final zzhd zza = new zzhd(true);
    private static volatile boolean zzb;
    private static volatile zzhd zzc;
    private static volatile zzhd zzd;
    private final Map<zzhc, zzhp<?, ?>> zze;

    zzhd() {
        this.zze = new HashMap();
    }

    zzhd(boolean bl) {
        this.zze = Collections.emptyMap();
    }

    public static zzhd zza() {
        zzhd zzhd2;
        zzhd zzhd3 = zzhd2 = zzc;
        if (zzhd2 != null) return zzhd3;
        synchronized (zzhd.class) {
            zzhd3 = zzhd2 = zzc;
            if (zzhd2 != null) return zzhd3;
            zzc = zzhd3 = zza;
        }
        return zzhd3;
    }

    public static zzhd zzb() {
        zzhd zzhd2 = zzd;
        if (zzhd2 != null) {
            return zzhd2;
        }
        synchronized (zzhd.class) {
            zzhd2 = zzd;
            if (zzhd2 != null) {
                return zzhd2;
            }
            zzd = zzhd2 = zzhl.zzb(zzhd.class);
            return zzhd2;
        }
    }

    public final <ContainingType extends zziw> zzhp<ContainingType, ?> zzc(ContainingType ContainingType, int n) {
        return this.zze.get(new zzhc(ContainingType, n));
    }
}
