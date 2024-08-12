/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzru
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzru;

final class zzrx {
    public final zzru zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final long zzh;

    public zzrx(zzru zzru2, long[] lArray, int[] nArray, int n, long[] lArray2, int[] nArray2, long l) {
        int n2 = nArray.length;
        int n3 = lArray2.length;
        boolean bl = true;
        boolean bl2 = n2 == n3;
        zzakt.zza((boolean)bl2);
        int n4 = lArray.length;
        bl2 = n4 == n3;
        zzakt.zza((boolean)bl2);
        n2 = nArray2.length;
        bl2 = n2 == n3 ? bl : false;
        zzakt.zza((boolean)bl2);
        this.zza = zzru2;
        this.zzc = lArray;
        this.zzd = nArray;
        this.zze = n;
        this.zzf = lArray2;
        this.zzg = nArray2;
        this.zzh = l;
        this.zzb = n4;
        if (n2 <= 0) return;
        n = n2 - 1;
        nArray2[n] = nArray2[n] | 0x20000000;
    }

    public final int zza(long l) {
        int n = zzamq.zzD((long[])this.zzf, (long)l, (boolean)true, (boolean)false);
        while (n >= 0) {
            if ((this.zzg[n] & 1) != 0) {
                return n;
            }
            --n;
        }
        return -1;
    }

    public final int zzb(long l) {
        int n = zzamq.zzE((long[])this.zzf, (long)l, (boolean)true, (boolean)false);
        while (n < this.zzf.length) {
            if ((this.zzg[n] & 1) != 0) {
                return n;
            }
            ++n;
        }
        return -1;
    }
}
