/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;

public final class zzoy {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzoy(byte[] byArray) {
        this.zza = byArray;
        this.zzb = byArray.length;
    }

    public final boolean zza() {
        byte by = this.zza[this.zzc];
        int n = this.zzd;
        this.zzc(1);
        if (1 == ((by & 0xFF) >> n & 1)) return true;
        return false;
    }

    public final int zzb(int n) {
        int n2 = this.zzc;
        int n3 = Math.min(n, 8 - this.zzd);
        int n4 = n2 + 1;
        n2 = (this.zza[n2] & 0xFF) >> this.zzd & 255 >> 8 - n3;
        while (true) {
            if (n3 >= n) {
                this.zzc(n);
                return -1 >>> 32 - n & n2;
            }
            n2 |= (this.zza[n4] & 0xFF) << n3;
            n3 += 8;
            ++n4;
        }
    }

    public final void zzc(int n) {
        boolean bl;
        block4: {
            block5: {
                boolean bl2;
                int n2;
                int n3;
                int n4 = n / 8;
                this.zzc = n3 = this.zzc + n4;
                this.zzd = n2 = this.zzd + (n - n4 * 8);
                n4 = n3;
                n = n2;
                if (n2 > 7) {
                    this.zzc = n4 = n3 + 1;
                    this.zzd = n = n2 - 8;
                }
                bl = bl2 = false;
                if (n4 < 0) break block4;
                n3 = this.zzb;
                if (n4 < n3) break block5;
                bl = bl2;
                if (n4 != n3) break block4;
                bl = bl2;
                if (n != 0) break block4;
            }
            bl = true;
        }
        zzakt.zzd((boolean)bl);
    }

    public final int zzd() {
        return this.zzc * 8 + this.zzd;
    }
}
