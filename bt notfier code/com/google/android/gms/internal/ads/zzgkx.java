/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class zzgkx {
    public static <T> List<T> zza(int n) {
        if (n != 0) return new ArrayList(n);
        return Collections.emptyList();
    }

    static <T> HashSet<T> zzb(int n) {
        return new HashSet(zzgkx.zzd(n));
    }

    public static <K, V> LinkedHashMap<K, V> zzc(int n) {
        return new LinkedHashMap(zzgkx.zzd(n));
    }

    private static int zzd(int n) {
        if (n < 3) {
            return n + 1;
        }
        if (n >= 0x40000000) return Integer.MAX_VALUE;
        return (int)((float)n / 0.75f + 1.0f);
    }
}
