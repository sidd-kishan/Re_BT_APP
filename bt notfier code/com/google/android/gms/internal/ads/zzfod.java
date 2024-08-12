/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public abstract class zzfod<E> {
    zzfod() {
    }

    static int zzd(int n, int n2) {
        int n3;
        n = n3 = n + (n >> 1) + 1;
        if (n3 < n2) {
            n = Integer.highestOneBit(n2 - 1);
            n += n;
        }
        n2 = n;
        if (n >= 0) return n2;
        n2 = Integer.MAX_VALUE;
        return n2;
    }

    public abstract zzfod<E> zzc(E var1);
}
