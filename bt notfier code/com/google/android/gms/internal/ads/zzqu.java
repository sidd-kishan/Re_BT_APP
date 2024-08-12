/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzon
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzou
 *  com.google.android.gms.internal.ads.zzqs
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzon;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzou;
import com.google.android.gms.internal.ads.zzqs;

final class zzqu
implements zzqs {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long[] zzf;

    private zzqu(long l, int n, long l2, long l3, long[] lArray) {
        this.zza = l;
        this.zzb = n;
        this.zzc = l2;
        this.zzf = lArray;
        this.zzd = l3;
        l2 = -1L;
        l = l3 == -1L ? l2 : (l += l3);
        this.zze = l;
    }

    public static zzqu zza(long l, long l2, zzon zzon2, zzamf object) {
        int n = zzon2.zzg;
        int n2 = zzon2.zzd;
        int n3 = object.zzv();
        if ((n3 & 1) != 1) return null;
        int n4 = object.zzB();
        if (n4 == 0) {
            return null;
        }
        long l3 = zzamq.zzH((long)n4, (long)((long)n * 1000000L), (long)n2);
        if ((n3 & 6) != 6) {
            return new zzqu(l2, zzon2.zzc, l3, -1L, null);
        }
        long l4 = object.zzt();
        long[] lArray = new long[100];
        n = 0;
        while (true) {
            if (n >= 100) {
                if (l == -1L) return new zzqu(l2, zzon2.zzc, l3, l4, lArray);
                long l5 = l2 + l4;
                if (l == l5) return new zzqu(l2, zzon2.zzc, l3, l4, lArray);
                object = new StringBuilder(67);
                ((StringBuilder)object).append("XING data size mismatch: ");
                ((StringBuilder)object).append(l);
                ((StringBuilder)object).append(", ");
                ((StringBuilder)object).append(l5);
                Log.w((String)"XingSeeker", (String)((StringBuilder)object).toString());
                return new zzqu(l2, zzon2.zzc, l3, l4, lArray);
            }
            lArray[n] = object.zzn();
            ++n;
        }
    }

    private final long zzd(int n) {
        return this.zzc * (long)n / 100L;
    }

    public final long zzb(long l) {
        if (!this.zze()) return 0L;
        if ((l -= this.zza) <= (long)this.zzb) {
            return 0L;
        }
        long[] lArray = (long[])zzakt.zze((Object)this.zzf);
        double d = l;
        Double.isNaN(d);
        double d2 = this.zzd;
        Double.isNaN(d2);
        double d3 = d * 256.0 / d2;
        int n = zzamq.zzD((long[])lArray, (long)((long)d3), (boolean)true, (boolean)true);
        long l2 = this.zzd(n);
        long l3 = lArray[n];
        int n2 = n + 1;
        long l4 = this.zzd(n2);
        l = n == 99 ? 256L : lArray[n2];
        if (l3 == l) {
            d = 0.0;
        } else {
            d = l3;
            Double.isNaN(d);
            d2 = l - l3;
            Double.isNaN(d2);
            d = (d3 - d) / d2;
        }
        d2 = l4 - l2;
        Double.isNaN(d2);
        return l2 + Math.round(d * d2);
    }

    public final long zzc() {
        return this.zze;
    }

    public final boolean zze() {
        if (this.zzf == null) return false;
        return true;
    }

    public final zzor zzf(long l) {
        Object object;
        int n;
        if (!this.zze()) {
            zzou zzou2 = new zzou(0L, this.zza + (long)this.zzb);
            return new zzor(zzou2, zzou2);
        }
        l = zzamq.zzy((long)l, (long)0L, (long)this.zzc);
        double d = l;
        Double.isNaN(d);
        double d2 = this.zzc;
        Double.isNaN(d2);
        d2 = d * 100.0 / d2;
        d = 0.0;
        if (!(d2 <= 0.0)) {
            if (d2 >= 100.0) {
                d = 256.0;
            } else {
                n = (int)d2;
                object = (long[])zzakt.zze((Object)this.zzf);
                double d3 = object[n];
                d = n == 99 ? 256.0 : (double)object[n + 1];
                double d4 = n;
                Double.isNaN(d4);
                Double.isNaN(d3);
                Double.isNaN(d3);
                d = d3 + (d2 - d4) * (d - d3);
            }
        }
        long l2 = this.zzd;
        d2 = d / 256.0;
        d = l2;
        Double.isNaN(d);
        long l3 = Math.round(d2 * d);
        n = this.zzb;
        l2 = this.zzd;
        l2 = zzamq.zzy((long)l3, (long)n, (long)(l2 - 1L));
        object = new zzou(l, this.zza + l2);
        return new zzor((zzou)object, (zzou)object);
    }

    public final long zzg() {
        return this.zzc;
    }
}
