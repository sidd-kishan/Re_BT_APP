/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzgcn {
    static byte[] zza(byte[] object) {
        if (((byte[])object).length != 16) {
            object = new IllegalArgumentException("value must be a block.");
            throw object;
        }
        byte[] byArray = new byte[16];
        int n = 0;
        while (true) {
            byte by;
            if (n >= 16) {
                n = byArray[15];
                byArray[15] = (byte)((byte)(object[0] >> 7 & 0x87) ^ n);
                return byArray;
            }
            byte by2 = object[n];
            byArray[n] = by = (byte)(by2 + by2 & 0xFE);
            if (n < 15) {
                byArray[n] = (byte)(object[n + 1] >> 7 & 1 | by);
            }
            ++n;
        }
    }

    static byte[] zzb(byte[] byArray) {
        int n = byArray.length;
        if (n >= 16) throw new IllegalArgumentException("x must be smaller than a block.");
        byArray = Arrays.copyOf(byArray, 16);
        byArray[n] = -128;
        return byArray;
    }
}
