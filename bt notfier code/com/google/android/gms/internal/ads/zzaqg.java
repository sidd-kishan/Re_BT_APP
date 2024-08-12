/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzapn
 *  com.google.android.gms.internal.ads.zzaux
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzaux;
import java.io.IOException;

final class zzaqg {
    private final zzaux zza = new zzaux(8);
    private int zzb;

    private final long zzb(zzapn zzapn2) throws IOException, InterruptedException {
        byte[] byArray = this.zza.zza;
        int n = 0;
        zzapn2.zze(byArray, 0, 1, false);
        int n2 = this.zza.zza[0] & 0xFF;
        if (n2 == 0) return Long.MIN_VALUE;
        int n3 = 128;
        int n4 = 0;
        while ((n2 & n3) == 0) {
            n3 >>= 1;
            ++n4;
        }
        n3 = n2 & ~n3;
        zzapn2.zze(this.zza.zza, 1, n4, false);
        while (true) {
            if (n >= n4) {
                this.zzb += n4 + 1;
                return n3;
            }
            n3 = (this.zza.zza[++n] & 0xFF) + (n3 << 8);
        }
    }

    public final boolean zza(zzapn zzapn2) throws IOException, InterruptedException {
        long l;
        long l2 = zzapn2.zzi();
        long l3 = l = 1024L;
        if (l2 != -1L) {
            l3 = l2 > 1024L ? l : l2;
        }
        int n = (int)l3;
        zzapn2.zze(this.zza.zza, 0, 4, false);
        l3 = this.zza.zzp();
        this.zzb = 4;
        while (l3 != 440786851L) {
            int n2;
            this.zzb = n2 = this.zzb + 1;
            if (n2 == n) {
                return false;
            }
            zzapn2.zze(this.zza.zza, 0, 1, false);
            l3 = l3 << 8 & 0xFFFFFFFFFFFFFF00L | (long)(this.zza.zza[0] & 0xFF);
        }
        l3 = this.zzb(zzapn2);
        l = this.zzb;
        if (l3 == Long.MIN_VALUE) return false;
        if (l2 != -1L && l + l3 >= l2) {
            return false;
        }
        while (true) {
            long l4;
            if ((l4 = (long)this.zzb) >= (l2 = l + l3)) {
                if (l4 != l2) return false;
                return true;
            }
            if (this.zzb(zzapn2) == Long.MIN_VALUE) {
                return false;
            }
            l2 = this.zzb(zzapn2);
            if (l2 < 0L) return false;
            if (l2 == 0L) continue;
            zzapn2.zzf((int)l2, false);
            this.zzb = (int)((long)this.zzb + l2);
        }
    }
}
