/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import java.io.IOException;

final class zzqj {
    private final zzamf zza = new zzamf(8);
    private int zzb;

    private final long zzb(zznv zznv2) throws IOException {
        byte[] byArray = this.zza.zzi();
        zznv2 = (zznp)zznv2;
        int n = 0;
        zznv2.zzh(byArray, 0, 1, false);
        int n2 = this.zza.zzi()[0] & 0xFF;
        if (n2 == 0) return Long.MIN_VALUE;
        int n3 = 128;
        int n4 = 0;
        while ((n2 & n3) == 0) {
            n3 >>= 1;
            ++n4;
        }
        n3 = n2 & ~n3;
        zznv2.zzh(this.zza.zzi(), 1, n4, false);
        while (true) {
            if (n >= n4) {
                this.zzb += n4 + 1;
                return n3;
            }
            n3 = (this.zza.zzi()[++n] & 0xFF) + (n3 << 8);
        }
    }

    public final boolean zza(zznv zznv2) throws IOException {
        long l;
        long l2 = zznv2.zzo();
        long l3 = l = 1024L;
        if (l2 != -1L) {
            l3 = l2 > 1024L ? l : l2;
        }
        int n = (int)l3;
        byte[] byArray = this.zza.zzi();
        zznp zznp2 = (zznp)zznv2;
        zznp2.zzh(byArray, 0, 4, false);
        l3 = this.zza.zzt();
        this.zzb = 4;
        while (l3 != 440786851L) {
            int n2;
            this.zzb = n2 = this.zzb + 1;
            if (n2 == n) {
                return false;
            }
            zznp2.zzh(this.zza.zzi(), 0, 1, false);
            l3 = l3 << 8 & 0xFFFFFFFFFFFFFF00L | (long)(this.zza.zzi()[0] & 0xFF);
        }
        l3 = this.zzb(zznv2);
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
            if (this.zzb(zznv2) == Long.MIN_VALUE) {
                return false;
            }
            l2 = this.zzb(zznv2);
            if (l2 < 0L) return false;
            if (l2 == 0L) continue;
            n = (int)l2;
            zznp2.zzj(n, false);
            this.zzb += n;
        }
    }
}
