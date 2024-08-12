/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;

public final class zzup {
    public static int zza(byte[] byArray, int n, int n2) {
        while (n < n2) {
            if (byArray[n] == 71) return n;
            ++n;
        }
        return n;
    }

    public static long zzb(zzamf zzamf2, int n, int n2) {
        zzamf2.zzh(n);
        if (zzamf2.zzd() < 5) {
            return -9223372036854775807L;
        }
        n = zzamf2.zzv();
        if ((0x800000 & n) != 0) {
            return -9223372036854775807L;
        }
        if ((n >> 8 & 0x1FFF) != n2) {
            return -9223372036854775807L;
        }
        if ((n & 0x20) == 0) return -9223372036854775807L;
        if (zzamf2.zzn() < 7) return -9223372036854775807L;
        if (zzamf2.zzd() < 7) return -9223372036854775807L;
        if ((zzamf2.zzn() & 0x10) != 16) return -9223372036854775807L;
        byte[] byArray = new byte[6];
        zzamf2.zzm(byArray, 0, 6);
        n2 = byArray[0];
        n = byArray[1];
        byte by = byArray[2];
        long l = (long)byArray[3] & 0xFFL;
        long l2 = n2;
        return ((long)n & 0xFFL) << 17 | (l2 & 0xFFL) << 25 | ((long)by & 0xFFL) << 9 | l + l | ((long)byArray[4] & 0xFFL) >> 7;
    }
}
