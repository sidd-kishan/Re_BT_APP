/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzady
 *  com.google.android.gms.internal.ads.zzagh
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzady;
import com.google.android.gms.internal.ads.zzagh;
import com.google.android.gms.internal.ads.zzamq;

public final class zzadz {
    private final long zza;
    private final long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private long zzl;
    private long zzm;
    private long zzn;

    /* synthetic */ zzadz(float f, float f2, long l, float f3, long l2, long l3, float f4, zzady zzady2) {
        this.zza = l2;
        this.zzb = l3;
        this.zzc = -9223372036854775807L;
        this.zzd = -9223372036854775807L;
        this.zzf = -9223372036854775807L;
        this.zzg = -9223372036854775807L;
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        this.zzk = 1.0f;
        this.zzl = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        this.zzh = -9223372036854775807L;
        this.zzm = -9223372036854775807L;
        this.zzn = -9223372036854775807L;
    }

    private final void zzf() {
        long l = this.zzc;
        if (l != -9223372036854775807L) {
            long l2 = this.zzd;
            if (l2 != -9223372036854775807L) {
                l = l2;
            }
            long l3 = this.zzf;
            l2 = l;
            if (l3 != -9223372036854775807L) {
                l2 = l;
                if (l < l3) {
                    l2 = l3;
                }
            }
            l3 = this.zzg;
            l = l2;
            if (l3 != -9223372036854775807L) {
                l = l2;
                if (l2 > l3) {
                    l = l3;
                }
            }
        } else {
            l = -9223372036854775807L;
        }
        if (this.zze == l) {
            return;
        }
        this.zze = l;
        this.zzh = l;
        this.zzm = -9223372036854775807L;
        this.zzn = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
    }

    private static long zzg(long l, long l2, float f) {
        return (long)((float)l * 0.999f + (float)l2 * 9.999871E-4f);
    }

    public final void zza(zzagh zzagh2) {
        long l = zzagh2.zzb;
        this.zzc = zzadx.zzb((long)-9223372036854775807L);
        l = zzagh2.zzc;
        this.zzf = zzadx.zzb((long)-9223372036854775807L);
        l = zzagh2.zzd;
        this.zzg = zzadx.zzb((long)-9223372036854775807L);
        float f = zzagh2.zze;
        this.zzj = 0.97f;
        f = zzagh2.zzf;
        this.zzi = 1.03f;
        this.zzf();
    }

    public final void zzb(long l) {
        this.zzd = l;
        this.zzf();
    }

    public final void zzc() {
        long l = this.zzh;
        if (l == -9223372036854775807L) {
            return;
        }
        this.zzh = l += this.zzb;
        long l2 = this.zzg;
        if (l2 != -9223372036854775807L && l > l2) {
            this.zzh = l2;
        }
        this.zzl = -9223372036854775807L;
    }

    public final float zzd(long l, long l2) {
        float f;
        if (this.zzc == -9223372036854775807L) return 1.0f;
        l2 = l - l2;
        long l3 = this.zzm;
        if (l3 == -9223372036854775807L) {
            this.zzm = l2;
            this.zzn = 0L;
        } else {
            this.zzm = l3 = Math.max(l2, zzadz.zzg(l3, l2, 0.999f));
            l2 = Math.abs(l2 - l3);
            this.zzn = zzadz.zzg(this.zzn, l2, 0.999f);
        }
        if (this.zzl != -9223372036854775807L) {
            if (SystemClock.elapsedRealtime() - this.zzl < 1000L) return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        l3 = this.zzm + this.zzn * 3L;
        if (this.zzh > l3) {
            l2 = zzadx.zzb((long)1000L);
            float f2 = this.zzk;
            float f3 = l2;
            f = this.zzi;
            long[] lArray = new long[3];
            lArray[0] = l3;
            l2 = this.zze;
            lArray[1] = l2;
            lArray[2] = this.zzh - ((long)((f2 - 1.0f) * f3) + (long)((f - 1.0f) * f3));
            l2 = lArray[0];
            for (int i = 1; i < 3; ++i) {
                long l4 = lArray[i];
                l3 = l2;
                if (l4 > l2) {
                    l3 = l4;
                }
                l2 = l3;
            }
            this.zzh = l2;
        } else {
            this.zzh = l3 = zzamq.zzy((long)(l - (long)(Math.max(0.0f, this.zzk - 1.0f) / 1.0E-7f)), (long)this.zzh, (long)l3);
            long l5 = this.zzg;
            l2 = l3;
            if (l5 != -9223372036854775807L) {
                l2 = l3;
                if (l3 > l5) {
                    this.zzh = l5;
                    l2 = l5;
                }
            }
        }
        l -= l2;
        l2 = Math.abs(l);
        l3 = this.zza;
        f = 1.0f;
        this.zzk = l2 < l3 ? 1.0f : (f = zzamq.zzz((float)((float)l * 1.0E-7f + 1.0f), (float)this.zzj, (float)this.zzi));
        return f;
    }

    public final long zze() {
        return this.zzh;
    }
}
