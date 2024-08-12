/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzkh
 *  com.google.android.gms.internal.measurement.zzkk
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkh;
import com.google.android.gms.internal.measurement.zzkk;

final class zzki
extends zzkh {
    zzki() {
    }

    final int zzb(int n, byte[] byArray, int n2, int n3) {
        block10: {
            while (n2 < n3 && byArray[n2] >= 0) {
                ++n2;
            }
            int n4 = 0;
            n = n2;
            if (n2 >= n3) {
                n = n4;
            } else {
                while (true) {
                    if (n >= n3) {
                        n = n4;
                        break block10;
                    }
                    int n5 = n + 1;
                    n2 = byArray[n];
                    n = n5;
                    if (n2 >= 0) continue;
                    if (n2 < -32) {
                        if (n5 < n3) {
                            if (n2 < -62) break;
                            n = n5 + 1;
                            if (byArray[n5] <= -65) continue;
                            break;
                        }
                        n = n2;
                        break block10;
                    }
                    if (n2 < -16) {
                        if (n5 >= n3 - 1) {
                            n = zzkk.zzf((byte[])byArray, (int)n5, (int)n3);
                            break block10;
                        }
                        int n6 = n5 + 1;
                        n = byArray[n5];
                        if (n > -65 || n2 == -32 && n < -96 || n2 == -19 && n >= -96) break;
                        n = n6 + 1;
                        if (byArray[n6] <= -65) continue;
                        break;
                    }
                    if (n5 >= n3 - 2) {
                        n = zzkk.zzf((byte[])byArray, (int)n5, (int)n3);
                        break block10;
                    }
                    n = n5 + 1;
                    if ((n5 = byArray[n5]) > -65 || (n2 << 28) + (n5 + 112) >> 30 != 0) break;
                    n2 = n + 1;
                    if (byArray[n] > -65) break;
                    n = n2 + 1;
                    if (byArray[n2] > -65) break;
                }
                n = -1;
            }
        }
        return n;
    }
}
