/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbu
 *  com.google.android.gms.internal.ads.zzggd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbu;
import com.google.android.gms.internal.ads.zzggd;

public final class zzgbv {
    private static final zzggd<zzgbv> zza = new zzgbu();

    public static int zza(int n) {
        if (n == 1) throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        return n - 2;
    }

    public static int zzb(int n) {
        if (n == 0) return 2;
        if (n == 1) return 3;
        if (n == 2) return 4;
        if (n == 3) return 5;
        if (n == 4) return 6;
        return 0;
    }
}
