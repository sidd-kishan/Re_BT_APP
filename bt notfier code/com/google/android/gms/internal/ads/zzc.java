/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzb
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzb;
import java.util.Arrays;

public final class zzc {
    public static final zzadw<zzc> zzh = com.google.android.gms.internal.ads.zzb.zza;
    public final long zza;
    public final int zzb;
    public final Uri[] zzc;
    public final int[] zzd;
    public final long[] zze;
    public final long zzf;
    public final boolean zzg;

    public zzc(long l) {
        this(0L, -1, new int[0], new Uri[0], new long[0], 0L, false);
    }

    private zzc(long l, int n, int[] nArray, Uri[] uriArray, long[] lArray, long l2, boolean bl) {
        bl = nArray.length == uriArray.length;
        zzakt.zza((boolean)bl);
        this.zza = 0L;
        this.zzb = n;
        this.zzd = nArray;
        this.zzc = uriArray;
        this.zze = lArray;
        this.zzf = 0L;
        this.zzg = false;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzc)object;
        if (this.zzb != ((zzc)object).zzb) return false;
        if (!Arrays.equals(this.zzc, ((zzc)object).zzc)) return false;
        if (!Arrays.equals(this.zzd, ((zzc)object).zzd)) return false;
        if (!Arrays.equals(this.zze, ((zzc)object).zze)) return false;
        return true;
    }

    public final int hashCode() {
        return (((this.zzb * 961 + Arrays.hashCode(this.zzc)) * 31 + Arrays.hashCode(this.zzd)) * 31 + Arrays.hashCode(this.zze)) * 961;
    }

    public final int zza(int n) {
        int[] nArray;
        ++n;
        while (n < (nArray = this.zzd).length) {
            int n2 = nArray[n];
            if (n2 == 0) return n;
            if (n2 == 1) {
                return n;
            }
            ++n;
        }
        return n;
    }

    public final zzc zzb(int n) {
        int[] nArray = this.zzd;
        int n2 = nArray.length;
        n = Math.max(0, n2);
        nArray = Arrays.copyOf(nArray, n);
        Arrays.fill(nArray, n2, n, 0);
        long[] lArray = this.zze;
        n2 = lArray.length;
        n = Math.max(0, n2);
        lArray = Arrays.copyOf(lArray, n);
        Arrays.fill(lArray, n2, n, -9223372036854775807L);
        return new zzc(0L, 0, nArray, Arrays.copyOf(this.zzc, 0), lArray, 0L, false);
    }
}
