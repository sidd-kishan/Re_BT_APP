/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgac
 *  com.google.android.gms.internal.ads.zzggd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgac;
import com.google.android.gms.internal.ads.zzggd;

public final class zzgad {
    private static final zzggd<zzgad> zza = new zzgac();

    public static int zza(int n) {
        if (n == 1) throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        return n - 2;
    }
}
