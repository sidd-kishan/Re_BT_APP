/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzapn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzapn;
import java.io.IOException;

final class zzaqh {
    private static final long[] zza = new long[]{128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L};
    private final byte[] zzb = new byte[8];
    private int zzc;
    private int zzd;

    public static int zzc(int n) {
        int n2;
        block1: {
            int n3 = 0;
            while (n3 < 8) {
                long l = zza[n3];
                long l2 = n;
                n3 = n2 = n3 + 1;
                if ((l & l2) == 0L) continue;
                break block1;
            }
            n2 = -1;
        }
        return n2;
    }

    public static long zzd(byte[] byArray, int n, boolean bl) {
        long l;
        long l2 = l = (long)byArray[0] & 0xFFL;
        if (bl) {
            l2 = l & (zza[n - 1] ^ 0xFFFFFFFFFFFFFFFFL);
        }
        int n2 = 1;
        while (n2 < n) {
            l2 = l2 << 8 | (long)byArray[n2] & 0xFFL;
            ++n2;
        }
        return l2;
    }

    public final void zza() {
        this.zzc = 0;
        this.zzd = 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final long zze(zzapn zzapn2, boolean bl, boolean bl2, int n) throws IOException, InterruptedException {
        int n2;
        if (this.zzc == 0) {
            if (!zzapn2.zzb(this.zzb, 0, 1, bl)) {
                return -1L;
            }
            this.zzd = n2 = zzaqh.zzc(this.zzb[0] & 0xFF);
            if (n2 == -1) throw new IllegalStateException("No valid varint length mask found");
            this.zzc = 1;
        }
        if ((n2 = this.zzd) > n) {
            this.zzc = 0;
            return -2L;
        }
        if (n2 != 1) {
            zzapn2.zzb(this.zzb, 1, n2 - 1, false);
        }
        this.zzc = 0;
        return zzaqh.zzd(this.zzb, this.zzd, bl2);
    }
}
