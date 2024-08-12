/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzaus {
    private int zza;
    private long[] zzb = new long[32];

    public zzaus() {
        this(32);
    }

    public zzaus(int n) {
    }

    public final void zza(long l) {
        int n = this.zza;
        long[] lArray = this.zzb;
        if (n == lArray.length) {
            this.zzb = Arrays.copyOf(lArray, n + n);
        }
        lArray = this.zzb;
        n = this.zza;
        this.zza = n + 1;
        lArray[n] = l;
    }

    public final long zzb(int n) {
        if (n >= 0 && n < this.zza) {
            return this.zzb[n];
        }
        int n2 = this.zza;
        StringBuilder stringBuilder = new StringBuilder(46);
        stringBuilder.append("Invalid index ");
        stringBuilder.append(n);
        stringBuilder.append(", size is ");
        stringBuilder.append(n2);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final int zzc() {
        return this.zza;
    }
}
