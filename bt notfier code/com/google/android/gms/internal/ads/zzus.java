/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzamf
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
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzamf;
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

final class zzus
implements zzut {
    private static final int[] zza = new int[]{-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, Short.MAX_VALUE};
    private final zznx zzc;
    private final zzox zzd;
    private final zzuw zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzamf zzh;
    private final int zzi;
    private final zzafv zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzus(zznx object, zzox zzox2, zzuw zzuw2) throws zzaha {
        int n;
        this.zzc = object;
        this.zzd = zzox2;
        this.zze = zzuw2;
        this.zzi = Math.max(1, zzuw2.zzc / 10);
        object = new zzamf(zzuw2.zzf);
        object.zzp();
        this.zzf = n = object.zzp();
        int n2 = zzuw2.zzb;
        int n3 = (zzuw2.zzd - n2 * 4) * 8 / (zzuw2.zze * n2) + 1;
        if (n == n3) {
            n3 = zzamq.zzw((int)this.zzi, (int)n);
            this.zzg = new byte[zzuw2.zzd * n3];
            n = this.zzf;
            this.zzh = new zzamf(n3 * ((n + n) * n2));
            n3 = zzuw2.zzc * zzuw2.zzd * 8 / this.zzf;
            object = new zzaft();
            object.zzN("audio/raw");
            object.zzI(n3);
            object.zzJ(n3);
            n3 = this.zzi;
            object.zzO((n3 + n3) * n2);
            object.zzaa(zzuw2.zzb);
            object.zzab(zzuw2.zzc);
            object.zzac(2);
            this.zzj = object.zzah();
            return;
        }
        object = new StringBuilder(56);
        ((StringBuilder)object).append("Expected frames per block: ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append("; got: ");
        ((StringBuilder)object).append(n);
        throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
    }

    private final void zzd(int n) {
        long l = this.zzl;
        long l2 = zzamq.zzH((long)this.zzn, (long)1000000L, (long)this.zze.zzc);
        int n2 = this.zzf(n);
        int n3 = this.zzm;
        this.zzd.zzv(l + l2, 1, n2, n3 - n2, null);
        this.zzn += (long)n;
        this.zzm -= n2;
    }

    private final int zze(int n) {
        int n2 = this.zze.zzb;
        return n / (n2 + n2);
    }

    private final int zzf(int n) {
        return (n + n) * this.zze.zzb;
    }

    public final void zza(long l) {
        this.zzk = 0;
        this.zzl = l;
        this.zzm = 0;
        this.zzn = 0L;
    }

    public final void zzb(int n, long l) {
        this.zzc.zzD((zzot)new zzuz(this.zze, this.zzf, (long)n, l));
        this.zzd.zzs(this.zzj);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final boolean zzc(zznv var1_1, long var2_2) throws IOException {
        block10: {
            var4_3 = zzamq.zzw((int)(this.zzi - this.zze(this.zzm)), (int)this.zzf) * this.zze.zzd;
            if (var2_2 == 0L) break block10;
            var19_5 = false;
            ** GOTO lbl8
        }
        block0: while (true) {
            var19_5 = true;
            while (!var19_5 && (var5_6 = this.zzk) < var4_3) {
                var17_4 = Math.min((long)(var4_3 - var5_6), var2_2);
                if ((var5_6 = var1_1 /* !! */ .zzg(this.zzg, this.zzk, (int)var17_4)) == -1) continue block0;
                this.zzk += var5_6;
            }
            break;
        }
        var14_7 = this.zzk / this.zze.zzd;
        if (var14_7 > 0) {
            var1_1 /* !! */  = (zznv)this.zzg;
            var20_8 = this.zzh;
            var4_3 = 0;
            block2: while (true) {
                if (var4_3 >= var14_7) {
                    var4_3 = this.zzf(this.zzf * var14_7);
                    var20_8.zzh(0);
                    var20_8.zzf(var4_3);
                    this.zzk -= var14_7 * this.zze.zzd;
                    var4_3 = this.zzh.zze();
                    zzov.zzb((zzox)this.zzd, (zzamf)this.zzh, (int)var4_3);
                    this.zzm = var4_3 = this.zzm + var4_3;
                    var5_6 = this.zze(var4_3);
                    var4_3 = this.zzi;
                    if (var5_6 < var4_3) break;
                    this.zzd(var4_3);
                    break;
                }
                var5_6 = 0;
                while (true) {
                    if (var5_6 < this.zze.zzb) {
                        var21_19 = var20_8.zzi();
                        var22_20 = this.zze;
                        var6_9 = var22_20.zzd;
                        var15_17 = var22_20.zzb;
                        var16_18 = var4_3 * var6_9 + var5_6 * 4;
                        var6_9 = var6_9 / var15_17 - 4;
                        var10_13 = (var1_1 /* !! */ [var16_18 + 1] & 255) << 8 | var1_1 /* !! */ [var16_18] & 255;
                        var8_11 = Math.min(var1_1 /* !! */ [var16_18 + 2] & 255, 88);
                        var11_14 = zzus.zzb[var8_11];
                        var7_10 = this.zzf * var4_3 * var15_17 + var5_6;
                        var9_12 = var7_10 + var7_10;
                        var21_19[var9_12] = (byte)(var10_13 & 255);
                        var21_19[var9_12 + 1] = (byte)(var10_13 >> 8);
                    } else {
                        ++var4_3;
                        continue block2;
                    }
                    for (var7_10 = 0; var7_10 < var6_9 + var6_9; ++var7_10) {
                        var12_15 = var1_1 /* !! */ [var7_10 / 8 * var15_17 * 4 + (var15_17 * 4 + var16_18) + var7_10 / 2 % 4] & 255;
                        var12_15 = var7_10 % 2 == 0 ? (var12_15 &= 15) : (var12_15 >>= 4);
                        var13_16 = var12_15 & 7;
                        var11_14 = var13_16 = (var13_16 + var13_16 + 1) * var11_14 >> 3;
                        if ((var12_15 & 8) != 0) {
                            var11_14 = -var13_16;
                        }
                        var10_13 = zzamq.zzx((int)(var10_13 + var11_14), (int)-32768, (int)32767);
                        var21_19[var9_12 += var15_17 + var15_17] = (byte)(var10_13 & 255);
                        var21_19[var9_12 + 1] = (byte)(var10_13 >> 8);
                        var8_11 = zzamq.zzx((int)(var8_11 + zzus.zza[var12_15]), (int)0, (int)88);
                        var11_14 = zzus.zzb[var8_11];
                    }
                    ++var5_6;
                }
                break;
            }
        }
        if (var19_5 == false) return var19_5;
        var4_3 = this.zze(this.zzm);
        if (var4_3 <= 0) return var19_5;
        this.zzd(var4_3);
        return var19_5;
    }
}
