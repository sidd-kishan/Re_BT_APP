/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzave;
import java.util.UUID;

public final class zzamx {
    public static final int zza;
    public static final UUID zzb;
    public static final UUID zzc;
    public static final UUID zzd;
    public static final UUID zze;

    static {
        int n = zzave.zza < 23 ? 1020 : 6396;
        zza = n;
        zzb = new UUID(0L, 0L);
        zzc = new UUID(1186680826959645954L, -5988876978535335093L);
        zzd = new UUID(-1301668207276963122L, -6645017420763422227L);
        zze = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long zza(long l) {
        if (l != -9223372036854775807L) return l / 1000L;
        return -9223372036854775807L;
    }

    public static long zzb(long l) {
        if (l != -9223372036854775807L) return l * 1000L;
        return -9223372036854775807L;
    }
}
