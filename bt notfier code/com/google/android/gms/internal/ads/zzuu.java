/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzut
 *  com.google.android.gms.internal.ads.zzuw
 *  com.google.android.gms.internal.ads.zzuz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzut;
import com.google.android.gms.internal.ads.zzuw;
import com.google.android.gms.internal.ads.zzuz;
import java.io.IOException;

final class zzuu
implements zzut {
    private final zznx zza;
    private final zzox zzb;
    private final zzuw zzc;
    private final zzafv zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzuu(zznx object, zzox zzox2, zzuw zzuw2, String string, int n) throws zzaha {
        this.zza = object;
        this.zzb = zzox2;
        this.zzc = zzuw2;
        int n2 = zzuw2.zzb * zzuw2.zze / 8;
        int n3 = zzuw2.zzd;
        if (n3 == n2) {
            int n4 = zzuw2.zzc * n2;
            n3 = n4 * 8;
            this.zze = Math.max(n2, n4 / 10);
            object = new zzaft();
            object.zzN(string);
            object.zzI(n3);
            object.zzJ(n3);
            object.zzO(this.zze);
            object.zzaa(zzuw2.zzb);
            object.zzab(zzuw2.zzc);
            object.zzac(n);
            this.zzd = object.zzah();
            return;
        }
        object = new StringBuilder(50);
        ((StringBuilder)object).append("Expected block size: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append("; got: ");
        ((StringBuilder)object).append(n3);
        throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
    }

    public final void zza(long l) {
        this.zzf = l;
        this.zzg = 0;
        this.zzh = 0L;
    }

    public final void zzb(int n, long l) {
        this.zza.zzD((zzot)new zzuz(this.zzc, 1, (long)n, l));
        this.zzb.zzs(this.zzd);
    }

    public final boolean zzc(zznv zznv2, long l) throws IOException {
        long l2;
        int n;
        int n2;
        while (l > 0L && (n2 = this.zzg) < (n = this.zze)) {
            l2 = Math.min((long)(n - n2), l);
            if ((n2 = zzov.zza((zzox)this.zzb, (zzah)zznv2, (int)((int)l2), (boolean)true)) == -1) {
                l = 0L;
                continue;
            }
            this.zzg += n2;
            l -= (long)n2;
        }
        zznv2 = this.zzc;
        n = zznv2.zzd;
        n2 = this.zzg / n;
        if (n2 > 0) {
            l2 = this.zzf;
            long l3 = zzamq.zzH((long)this.zzh, (long)1000000L, (long)zznv2.zzc);
            int n3 = n2 * n;
            n = this.zzg - n3;
            this.zzb.zzv(l2 + l3, 1, n3, n, null);
            this.zzh += (long)n2;
            this.zzg = n;
        }
        if (l > 0L) return false;
        return true;
    }
}
