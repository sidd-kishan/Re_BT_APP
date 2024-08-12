/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzatd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzatd;

public final class zzasd
implements zzatd {
    private final zzatd[] zza;

    public zzasd(zzatd[] zzatdArray) {
        this.zza = zzatdArray;
    }

    public final long zza() {
        zzatd[] zzatdArray = this.zza;
        int n = zzatdArray.length;
        int n2 = 0;
        long l = Long.MAX_VALUE;
        while (true) {
            if (n2 >= n) {
                if (l != Long.MAX_VALUE) return l;
                return Long.MIN_VALUE;
            }
            long l2 = zzatdArray[n2].zza();
            long l3 = l;
            if (l2 != Long.MIN_VALUE) {
                l3 = Math.min(l, l2);
            }
            ++n2;
            l = l3;
        }
    }

    public final boolean zzb(long l) {
        long l2;
        boolean bl = false;
        while ((l2 = this.zza()) != Long.MIN_VALUE) {
            boolean bl2;
            zzatd[] zzatdArray = this.zza;
            int n = zzatdArray.length;
            boolean bl3 = false;
            for (int i = 0; i < n; ++i) {
                zzatd zzatd2 = zzatdArray[i];
                boolean bl4 = bl3;
                if (zzatd2.zza() == l2) {
                    bl4 = bl3 | zzatd2.zzb(l);
                }
                bl3 = bl4;
            }
            bl = bl2 = bl | bl3;
            if (bl3) continue;
            bl = bl2;
            break;
        }
        return bl;
    }
}
