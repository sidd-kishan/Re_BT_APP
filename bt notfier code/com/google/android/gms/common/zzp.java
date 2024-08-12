/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common;

final class zzp {
    static int zza(int n) {
        int n2 = 0;
        while (n2 < 5) {
            int n3 = (new int[]{1, 2, 3, 4, 5})[n2];
            if (n3 == 0) throw null;
            if (n3 - 1 == n) {
                return n3;
            }
            ++n2;
        }
        return 1;
    }
}
