/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;
import java.util.Arrays;

public final class zznn
implements zzot {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zznn(int[] nArray, long[] lArray, long[] lArray2, long[] lArray3) {
        int n;
        this.zzb = nArray;
        this.zzc = lArray;
        this.zzd = lArray2;
        this.zze = lArray3;
        this.zza = n = nArray.length;
        if (n > 0) {
            this.zzf = lArray2[--n] + lArray3[n];
            return;
        }
        this.zzf = 0L;
    }

    public final String toString() {
        int n = this.zza;
        String string = Arrays.toString(this.zzb);
        String string2 = Arrays.toString(this.zzc);
        String string3 = Arrays.toString(this.zze);
        String string4 = Arrays.toString(this.zzd);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 71 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length());
        stringBuilder.append("ChunkIndex(length=");
        stringBuilder.append(n);
        stringBuilder.append(", sizes=");
        stringBuilder.append(string);
        stringBuilder.append(", offsets=");
        stringBuilder.append(string2);
        stringBuilder.append(", timeUs=");
        stringBuilder.append(string3);
        stringBuilder.append(", durationsUs=");
        stringBuilder.append(string4);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final boolean zze() {
        return true;
    }

    public final zzor zzf(long l) {
        int n = zzamq.zzD((long[])this.zze, (long)l, (boolean)true, (boolean)true);
        zzou zzou2 = new zzou(this.zze[n], this.zzc[n]);
        if (zzou2.zzb >= l) return new zzor(zzou2, zzou2);
        if (n != this.zza - 1) return new zzor(zzou2, new zzou(this.zze[++n], this.zzc[n]));
        return new zzor(zzou2, zzou2);
    }

    public final long zzg() {
        return this.zzf;
    }
}
