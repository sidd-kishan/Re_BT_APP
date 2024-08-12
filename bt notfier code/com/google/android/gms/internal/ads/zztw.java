/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzoq
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzoq;
import java.io.IOException;

final class zztw {
    private final zzamn zza = new zzamn(0L);
    private final zzamf zzb = new zzamf();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    zztw() {
    }

    public static long zze(zzamf zzamf2) {
        int n = zzamf2.zzg();
        if (zzamf2.zzd() < 9) {
            return -9223372036854775807L;
        }
        byte[] byArray = new byte[9];
        zzamf2.zzm(byArray, 0, 9);
        zzamf2.zzh(n);
        if ((byArray[0] & 0xC4) != 68) {
            return -9223372036854775807L;
        }
        if ((byArray[2] & 4) != 4) return -9223372036854775807L;
        if ((byArray[4] & 4) != 4) return -9223372036854775807L;
        if ((byArray[5] & 1) != 1) return -9223372036854775807L;
        if ((byArray[8] & 3) != 3) return -9223372036854775807L;
        long l = byArray[0];
        n = byArray[1];
        long l2 = byArray[2];
        long l3 = n;
        return ((long)byArray[3] & 0xFFL) << 5 | ((l & 3L) << 28 | (0x38L & l) >> 3 << 30 | (l3 & 0xFFL) << 20 | (l2 & 0xF8L) >> 3 << 15 | (l2 & 3L) << 13) | ((long)byArray[4] & 0xF8L) >> 3;
    }

    private final int zzf(zznv zznv2) {
        zzamf zzamf2 = this.zzb;
        byte[] byArray = zzamq.zzf;
        int n = byArray.length;
        zzamf2.zzb(byArray, 0);
        this.zzc = true;
        zznv2.zzl();
        return 0;
    }

    private static final int zzg(byte[] byArray, int n) {
        byte by = byArray[n];
        byte by2 = byArray[n + 1];
        byte by3 = byArray[n + 2];
        return byArray[n + 3] & 0xFF | ((by & 0xFF) << 24 | (by2 & 0xFF) << 16 | (by3 & 0xFF) << 8);
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final zzamn zzb() {
        return this.zza;
    }

    public final int zzc(zznv zznv2, zzoq object) throws IOException {
        int n;
        block12: {
            long l;
            long l2;
            int n2;
            block11: {
                block9: {
                    long l3;
                    block8: {
                        block10: {
                            block7: {
                                boolean bl = this.zze;
                                n = 1;
                                n2 = 1;
                                l2 = -9223372036854775807L;
                                if (bl) break block7;
                                l3 = zznv2.zzo();
                                n = (int)Math.min(20000L, l3);
                                if (zznv2.zzn() == (l3 -= (long)n)) break block8;
                                ((zzoq)object).zza = l3;
                                n = n2;
                                break block9;
                            }
                            if (this.zzg == -9223372036854775807L) {
                                this.zzf(zznv2);
                                return 0;
                            }
                            if (this.zzd) break block10;
                            n2 = (int)Math.min(20000L, zznv2.zzo());
                            if (zznv2.zzn() == 0L) break block11;
                            ((zzoq)object).zza = 0L;
                            break block12;
                        }
                        l2 = this.zzf;
                        if (l2 == -9223372036854775807L) {
                            this.zzf(zznv2);
                            return 0;
                        }
                        l2 = this.zza.zze(l2);
                        this.zzh = l2 = this.zza.zze(this.zzg) - l2;
                        if (l2 < 0L) {
                            object = new StringBuilder(65);
                            ((StringBuilder)object).append("Invalid duration: ");
                            ((StringBuilder)object).append(l2);
                            ((StringBuilder)object).append(". Using TIME_UNSET instead.");
                            Log.w((String)"PsDurationReader", (String)((StringBuilder)object).toString());
                            this.zzh = -9223372036854775807L;
                        }
                        this.zzf(zznv2);
                        return 0;
                    }
                    this.zzb.zza(n);
                    zznv2.zzl();
                    object = this.zzb.zzi();
                    ((zznp)zznv2).zzh((byte[])object, 0, n, false);
                    zznv2 = this.zzb;
                    n2 = zznv2.zzg();
                    n = zznv2.zze() - 4;
                    while (true) {
                        l3 = l2;
                        if (n < n2) break;
                        if (zztw.zzg(zznv2.zzi(), n) == 442) {
                            zznv2.zzh(n + 4);
                            l3 = zztw.zze((zzamf)zznv2);
                            if (l3 != -9223372036854775807L) break;
                        }
                        --n;
                    }
                    this.zzg = l3;
                    this.zze = true;
                    n = 0;
                }
                return n;
            }
            this.zzb.zza(n2);
            zznv2.zzl();
            object = this.zzb.zzi();
            ((zznp)zznv2).zzh((byte[])object, 0, n2, false);
            zznv2 = this.zzb;
            n = zznv2.zzg();
            n2 = zznv2.zze();
            while (true) {
                l = l2;
                if (n >= n2 - 3) break;
                if (zztw.zzg(zznv2.zzi(), n) == 442) {
                    zznv2.zzh(n + 4);
                    l = zztw.zze((zzamf)zznv2);
                    if (l != -9223372036854775807L) break;
                }
                ++n;
            }
            this.zzf = l;
            this.zzd = true;
            n = 0;
        }
        return n;
    }

    public final long zzd() {
        return this.zzh;
    }
}
