/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzaju
 *  com.google.android.gms.internal.ads.zzajw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzog
 *  com.google.android.gms.internal.ads.zzol
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzaju;
import com.google.android.gms.internal.ads.zzajw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzog;
import com.google.android.gms.internal.ads.zzol;
import java.io.IOException;
import java.util.Arrays;

public final class zzoe {
    public static zzaiv zza(zznv zznv2, boolean bl) throws IOException {
        zzaju zzaju2 = bl ? null : zzajw.zza;
        zznv2 = new zzol().zza(zznv2, zzaju2);
        if (zznv2 == null) return null;
        if (zznv2.zza() != 0) return zznv2;
        return null;
    }

    public static zzog zzb(zzamf zzamf2) {
        long[] lArray;
        long[] lArray2;
        zzamf2.zzk(1);
        int n = zzamf2.zzr();
        long l = zzamf2.zzg();
        long l2 = n;
        int n2 = n / 18;
        long[] lArray3 = new long[n2];
        long[] lArray4 = new long[n2];
        n = 0;
        while (true) {
            lArray2 = lArray3;
            lArray = lArray4;
            if (n >= n2) break;
            long l3 = zzamf2.zzx();
            if (l3 == -1L) {
                lArray2 = Arrays.copyOf(lArray3, n);
                lArray = Arrays.copyOf(lArray4, n);
                break;
            }
            lArray3[n] = l3;
            lArray4[n] = zzamf2.zzx();
            zzamf2.zzk(2);
            ++n;
        }
        zzamf2.zzk((int)(l + l2 - (long)zzamf2.zzg()));
        return new zzog(lArray2, lArray);
    }
}
