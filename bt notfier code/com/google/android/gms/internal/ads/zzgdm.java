/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzgdm {
    static byte[] zza(byte[] byArray, byte[] byArray2) {
        long l;
        long l2;
        long l3 = zzgdm.zzc(byArray, 0, 0);
        long l4 = zzgdm.zzc(byArray, 3, 2) & 0x3FFFF03L;
        long l5 = zzgdm.zzc(byArray, 6, 4) & 0x3FFC0FFL;
        long l6 = zzgdm.zzc(byArray, 9, 6) & 0x3F03FFFL;
        long l7 = zzgdm.zzc(byArray, 12, 8) & 0xFFFFFL;
        long l8 = l5 * 5L;
        long l9 = l6 * 5L;
        long l10 = l7 * 5L;
        byte[] byArray3 = new byte[17];
        long l11 = 0L;
        long l12 = 0L;
        long l13 = l2 = (l = 0L);
        int n = 0;
        long l14 = l2;
        l2 = l12;
        while (true) {
            int n2;
            if (n >= (n2 = byArray2.length)) {
                l12 = l11 + (l2 >> 26);
                l11 = l12 & 0x3FFFFFFL;
                l12 = l + (l12 >> 26);
                l = l12 & 0x3FFFFFFL;
                l12 = l14 + (l12 >> 26);
                l14 = l12 & 0x3FFFFFFL;
                l5 = (l13 += (l12 >> 26) * 5L) & 0x3FFFFFFL;
                l8 = (l2 & 0x3FFFFFFL) + (l13 >> 26);
                l3 = l5 + 5L;
                l4 = (l3 >> 26) + l8;
                l6 = l11 + (l4 >> 26);
                l7 = l + (l6 >> 26);
                l12 = l14 + (l7 >> 26) - 0x4000000L;
                l13 = l12 >> 63;
                l2 = l13 ^ 0xFFFFFFFFFFFFFFFFL;
                l8 = l8 & l13 | l4 & 0x3FFFFFFL & l2;
                l11 = l11 & l13 | l6 & 0x3FFFFFFL & l2;
                l = l & l13 | l7 & 0x3FFFFFFL & l2;
                l5 = ((l5 & l13 | l3 & 0x3FFFFFFL & l2 | l8 << 26) & 0xFFFFFFFFL) + zzgdm.zzb(byArray, 16);
                l3 = ((l8 >> 6 | l11 << 20) & 0xFFFFFFFFL) + zzgdm.zzb(byArray, 20) + (l5 >> 32);
                l7 = ((l11 >> 12 | l << 14) & 0xFFFFFFFFL) + zzgdm.zzb(byArray, 24) + (l3 >> 32);
                l11 = zzgdm.zzb(byArray, 28);
                byArray = new byte[16];
                zzgdm.zzd(byArray, l5 & 0xFFFFFFFFL, 0);
                zzgdm.zzd(byArray, l3 & 0xFFFFFFFFL, 4);
                zzgdm.zzd(byArray, l7 & 0xFFFFFFFFL, 8);
                zzgdm.zzd(byArray, ((l >> 18 | (l14 & l13 | l12 & l2) << 8) & 0xFFFFFFFFL) + l11 + (l7 >> 32) & 0xFFFFFFFFL, 12);
                return byArray;
            }
            n2 = Math.min(16, n2 - n);
            System.arraycopy(byArray2, n, byArray3, 0, n2);
            byArray3[n2] = 1;
            if (n2 != 16) {
                Arrays.fill(byArray3, n2 + 1, 17, (byte)0);
            }
            l12 = l2 + zzgdm.zzc(byArray3, 3, 2);
            long l15 = l11 + zzgdm.zzc(byArray3, 6, 4);
            long l16 = l + zzgdm.zzc(byArray3, 9, 6);
            long l17 = (l13 += zzgdm.zzc(byArray3, 0, 0)) * l3 + l12 * l10 + l15 * l9 + l16 * l8 + (l14 += zzgdm.zzc(byArray3, 12, 8) | (long)(byArray3[16] << 24)) * (l4 * 5L);
            l2 = l13 * l4 + l12 * l3 + l15 * l10 + l16 * l9 + l14 * l8 + (l17 >> 26);
            l11 = l13 * l5 + l12 * l4 + l15 * l3 + l16 * l10 + l14 * l9 + (l2 >> 26);
            l = l13 * l6 + l12 * l5 + l15 * l4 + l16 * l3 + l14 * l10 + (l11 >> 26);
            l13 = l13 * l7 + l12 * l6 + l15 * l5 + l16 * l4 + l14 * l3 + (l >> 26);
            l14 = l13 & 0x3FFFFFFL;
            l12 = (l17 & 0x3FFFFFFL) + (l13 >> 26) * 5L;
            l13 = l12 & 0x3FFFFFFL;
            l2 = (l2 & 0x3FFFFFFL) + (l12 >> 26);
            n += 16;
            l &= 0x3FFFFFFL;
            l11 &= 0x3FFFFFFL;
        }
    }

    private static long zzb(byte[] byArray, int n) {
        byte by = byArray[n];
        byte by2 = byArray[n + 1];
        byte by3 = byArray[n + 2];
        return (long)((byArray[n + 3] & 0xFF) << 24 | (by & 0xFF | (by2 & 0xFF) << 8 | (by3 & 0xFF) << 16)) & 0xFFFFFFFFL;
    }

    private static long zzc(byte[] byArray, int n, int n2) {
        return zzgdm.zzb(byArray, n) >> n2 & 0x3FFFFFFL;
    }

    private static void zzd(byte[] byArray, long l, int n) {
        int n2 = 0;
        while (n2 < 4) {
            byArray[n + n2] = (byte)(0xFFL & l);
            ++n2;
            l >>= 8;
        }
    }
}
