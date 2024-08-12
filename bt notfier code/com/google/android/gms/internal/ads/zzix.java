/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Random;

public final class zzix {
    private final Random zza;
    private final int[] zzb;
    private final int[] zzc;

    public zzix(int n) {
        this(0, new Random());
    }

    private zzix(int n, Random random) {
        this(new int[0], random);
    }

    private zzix(int[] nArray, Random random) {
        this.zzb = nArray;
        this.zza = random;
        this.zzc = new int[nArray.length];
        int n = 0;
        while (n < nArray.length) {
            this.zzc[nArray[n]] = n;
            ++n;
        }
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final int zzb(int n) {
        int[] nArray = this.zzb;
        if ((n = this.zzc[n] + 1) >= nArray.length) return -1;
        return nArray[n];
    }

    public final int zzc(int n) {
        if ((n = this.zzc[n] - 1) < 0) return -1;
        return this.zzb[n];
    }

    public final int zzd() {
        int[] nArray = this.zzb;
        int n = nArray.length;
        if (n <= 0) return -1;
        return nArray[n - 1];
    }

    public final int zze() {
        int[] nArray = this.zzb;
        if (nArray.length <= 0) return -1;
        return nArray[0];
    }

    public final zzix zzf(int n, int n2) {
        int[] nArray;
        int n3;
        int n4;
        int[] nArray2 = new int[n2];
        int[] nArray3 = new int[n2];
        int n5 = 0;
        n = 0;
        while (n < n2) {
            nArray2[n] = this.zza.nextInt(this.zzb.length + 1);
            n4 = n + 1;
            n3 = this.zza.nextInt(n4);
            nArray3[n] = nArray3[n3];
            nArray3[n3] = n;
            n = n4;
        }
        Arrays.sort(nArray2);
        int[] nArray4 = new int[this.zzb.length + n2];
        n3 = 0;
        n4 = 0;
        n = n5;
        while (n < (nArray = this.zzb).length + n2) {
            if (n3 < n2 && n4 == nArray2[n3]) {
                nArray4[n] = nArray3[n3];
                ++n3;
            } else {
                nArray4[n] = n5 = nArray[n4];
                if (n5 >= 0) {
                    nArray4[n] = n5 + n2;
                }
                ++n4;
            }
            ++n;
        }
        return new zzix(nArray4, new Random(this.zza.nextLong()));
    }

    public final zzix zzg(int n, int n2) {
        int[] nArray;
        int[] nArray2 = new int[this.zzb.length - n2];
        n = 0;
        int n3 = 0;
        while (n < (nArray = this.zzb).length) {
            int n4 = nArray[n];
            if (n4 >= 0 && n4 < n2) {
                ++n3;
            } else {
                int n5 = n4;
                if (n4 >= 0) {
                    n5 = n4 - n2;
                }
                nArray2[n - n3] = n5;
            }
            ++n;
        }
        return new zzix(nArray2, new Random(this.zza.nextLong()));
    }

    public final zzix zzh() {
        return new zzix(0, new Random(this.zza.nextLong()));
    }
}
