/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import java.nio.Buffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzeu {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    public zzeu(int n, int n2, float f, float f2, int n3) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = f;
        this.zzd = f2;
        this.zze = (float)n / (float)n3;
        this.zzf = n / 400;
        this.zzg = n /= 65;
        n += n;
        this.zzh = n;
        this.zzi = new short[n];
        this.zzj = new short[n *= n2];
        this.zzl = new short[n];
        this.zzn = new short[n];
    }

    private final short[] zzg(short[] sArray, int n, int n2) {
        int n3 = sArray.length;
        int n4 = this.zzb;
        if (n + n2 > (n3 /= n4)) return Arrays.copyOf(sArray, (n3 * 3 / 2 + n2) * n4);
        return sArray;
    }

    private final void zzh(short[] sArray, int n, int n2) {
        short[] sArray2 = this.zzg(this.zzl, this.zzm, n2);
        this.zzl = sArray2;
        int n3 = this.zzb;
        System.arraycopy(sArray, n * n3, sArray2, this.zzm * n3, n3 * n2);
        this.zzm += n2;
    }

    private final void zzi(short[] sArray, int n, int n2) {
        int n3 = this.zzh / n2;
        int n4 = this.zzb;
        int n5 = n2 * n4;
        n2 = 0;
        while (n2 < n3) {
            int n6;
            int n7 = 0;
            for (n6 = 0; n6 < n5; n7 += sArray[n2 * n5 + n * n4 + n6], ++n6) {
            }
            n6 = n7 / n5;
            this.zzi[n2] = (short)n6;
            ++n2;
        }
    }

    private final int zzj(short[] sArray, int n, int n2, int n3) {
        int n4 = n * this.zzb;
        int n5 = 1;
        int n6 = 255;
        int n7 = 0;
        int n8 = 0;
        while (true) {
            int n9;
            if (n2 > n3) {
                this.zzu = n5 / n7;
                this.zzv = n8 / n6;
                return n7;
            }
            n = 0;
            for (n9 = 0; n9 < n2; n += Math.abs(sArray[n4 + n9] - sArray[n4 + n2 + n9]), ++n9) {
            }
            n9 = n * n7;
            int n10 = n5 * n2;
            if (n9 < n10) {
                n5 = n;
            }
            if (n9 < n10) {
                n7 = n2;
            }
            if ((n9 = n * n6) > (n10 = n8 * n2)) {
                n8 = n;
            }
            if (n9 > n10) {
                n6 = n2;
            }
            ++n2;
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void zzk() {
        block27: {
            var10_1 = this.zzm;
            var4_2 = this.zzc;
            var3_3 = this.zzd;
            var4_2 /= var3_3;
            var3_3 = this.zze * var3_3;
            var1_4 = var4_2;
            if (var1_4 > 1.00001 || var1_4 < 0.99999) break block27;
            this.zzh(this.zzj, 0, this.zzk);
            this.zzk = 0;
            ** GOTO lbl88
        }
        var11_5 = this.zzk;
        if (var11_5 < this.zzh) ** GOTO lbl88
        var7_6 = 0;
        while (true) {
            block28: {
                if ((var5_7 = this.zzr) > 0) {
                    var5_7 = Math.min(this.zzh, var5_7);
                    this.zzh(this.zzj, var7_6, var5_7);
                    this.zzr -= var5_7;
                    var5_7 = var7_6 + var5_7;
                } else {
                    var17_11 = this.zzj;
                    var5_7 = this.zza;
                    var5_7 = var5_7 > 4000 ? (var5_7 /= 4000) : 1;
                    if (this.zzb == 1 && var5_7 == 1) {
                        var5_7 = this.zzj(var17_11, var7_6, this.zzf, this.zzg);
                    } else {
                        this.zzi(var17_11, var7_6, var5_7);
                        var6_8 = this.zzj(this.zzi, 0, this.zzf / var5_7, this.zzg / var5_7);
                        if (var5_7 != 1) {
                            var6_8 *= var5_7;
                            var8_9 = var5_7 * 4;
                            var5_7 = var6_8 - var8_9;
                            var8_9 = var6_8 + var8_9;
                            var6_8 = this.zzf;
                            if (var5_7 < var6_8) {
                                var5_7 = var6_8;
                            }
                            var9_10 = this.zzg;
                            var6_8 = var8_9;
                            if (var8_9 > var9_10) {
                                var6_8 = var9_10;
                            }
                            if (this.zzb == 1) {
                                var5_7 = this.zzj(var17_11, var7_6, var5_7, var6_8);
                            } else {
                                this.zzi(var17_11, var7_6, 1);
                                var5_7 = this.zzj(this.zzi, 0, var5_7, var6_8);
                            }
                        } else {
                            var5_7 = var6_8;
                        }
                    }
                    var8_9 = this.zzu;
                    var9_10 = this.zzv;
                    if (var8_9 == 0 || (var6_8 = this.zzs) == 0 || var9_10 > var8_9 * 3 || var8_9 + var8_9 <= this.zzt * 3) {
                        var6_8 = var5_7;
                    }
                    this.zzt = var8_9;
                    this.zzs = var5_7;
                    if (var1_4 > 1.0) {
                        var17_11 = this.zzj;
                        if (var4_2 >= 2.0f) {
                            var5_7 = (int)((float)var6_8 / (-1.0f + var4_2));
                        } else {
                            this.zzr = (int)((float)var6_8 * (2.0f - var4_2) / (-1.0f + var4_2));
                            var5_7 = var6_8;
                        }
                        var18_12 = this.zzg(this.zzl, this.zzm, var5_7);
                        this.zzl = var18_12;
                        zzeu.zzl(var5_7, this.zzb, var18_12, this.zzm, var17_11, var7_6, var17_11, var7_6 + var6_8);
                        this.zzm += var5_7;
                        var5_7 = var7_6 + (var6_8 + var5_7);
                    } else {
                        var17_11 = this.zzj;
                        if (var4_2 < 0.5f) {
                            var5_7 = (int)((float)var6_8 * var4_2 / (1.0f - var4_2));
                        } else {
                            this.zzr = (int)((float)var6_8 * (var4_2 + var4_2 - 1.0f) / (1.0f - var4_2));
                            var5_7 = var6_8;
                        }
                        var8_9 = var6_8 + var5_7;
                        var18_12 = this.zzg(this.zzl, this.zzm, var8_9);
                        this.zzl = var18_12;
                        var9_10 = this.zzb;
                        System.arraycopy(var17_11, var7_6 * var9_10, var18_12, this.zzm * var9_10, var9_10 * var6_8);
                        zzeu.zzl(var5_7, this.zzb, this.zzl, this.zzm + var6_8, var17_11, var7_6 + var6_8, var17_11, var7_6);
                        this.zzm += var8_9;
                        var5_7 = var7_6 + var5_7;
                    }
                }
                if (this.zzh + var5_7 <= var11_5) break block28;
                var6_8 = this.zzk - var5_7;
                var17_11 = this.zzj;
                var7_6 = this.zzb;
                System.arraycopy(var17_11, var5_7 * var7_6, var17_11, 0, var7_6 * var6_8);
                this.zzk = var6_8;
lbl88:
                // 3 sources

                if (var3_3 == 1.0f) return;
                if (this.zzm == var10_1) {
                    return;
                }
                break;
            }
            var7_6 = var5_7;
        }
        var5_7 = this.zza;
        var6_8 = (int)((float)var5_7 / var3_3);
        while (true) {
            if (var6_8 <= 16384 && var5_7 <= 16384) {
                var8_9 = this.zzm - var10_1;
                var18_12 = this.zzg(this.zzn, this.zzo, var8_9);
                this.zzn = var18_12;
                var17_11 = this.zzl;
                var7_6 = this.zzb;
                System.arraycopy(var17_11, var10_1 * var7_6, var18_12, this.zzo * var7_6, var7_6 * var8_9);
                this.zzm = var10_1;
                this.zzo += var8_9;
                break;
            }
            var6_8 /= 2;
            var5_7 /= 2;
        }
        var7_6 = 0;
        while (true) {
            if (var7_6 >= (var8_9 = (var9_10 = this.zzo) - 1)) {
                if (var8_9 == 0) return;
                var17_11 = this.zzn;
                var5_7 = this.zzb;
                System.arraycopy(var17_11, var8_9 * var5_7, var17_11, 0, (var9_10 - var8_9) * var5_7);
                this.zzo -= var8_9;
                return;
            }
            while ((var8_9 = this.zzp + 1) * var6_8 > (var9_10 = ++this.zzq) * var5_7) {
                this.zzl = this.zzg(this.zzl, this.zzm, 1);
                for (var8_9 = 0; var8_9 < (var10_1 = this.zzb); ++var8_9) {
                    var18_12 = this.zzl;
                    var9_10 = this.zzm;
                    var17_11 = this.zzn;
                    var12_13 = var7_6 * var10_1 + var8_9;
                    var11_5 = var17_11[var12_13];
                    var12_13 = var17_11[var12_13 + var10_1];
                    var15_16 = this.zzq;
                    var14_15 = this.zzp;
                    var13_14 = (var14_15 + 1) * var6_8;
                    var15_16 = var13_14 - var15_16 * var5_7;
                    var18_12[var9_10 * var10_1 + var8_9] = (short)((var11_5 * var15_16 + ((var13_14 -= var14_15 * var6_8) - var15_16) * var12_13) / var13_14);
                }
                ++this.zzm;
            }
            this.zzp = var8_9;
            if (var8_9 == var5_7) {
                this.zzp = 0;
                var16_17 = var9_10 == var6_8;
                zzakt.zzd((boolean)var16_17);
                this.zzq = 0;
            }
            ++var7_6;
        }
    }

    private static void zzl(int n, int n2, short[] sArray, int n3, short[] sArray2, int n4, short[] sArray3, int n5) {
        int n6 = 0;
        while (n6 < n2) {
            int n7 = n3 * n2 + n6;
            int n8 = n5 * n2 + n6;
            int n9 = n4 * n2 + n6;
            for (int i = 0; i < n; n7 += n2, n9 += n2, n8 += n2, ++i) {
                sArray[n7] = (short)((sArray2[n9] * (n - i) + sArray3[n8] * i) / n);
            }
            ++n6;
        }
    }

    public final int zza() {
        int n = this.zzk * this.zzb;
        return n + n;
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int n = shortBuffer.remaining();
        int n2 = this.zzb;
        n /= n2;
        short[] sArray = this.zzg(this.zzj, this.zzk, n);
        this.zzj = sArray;
        shortBuffer.get(sArray, this.zzk * this.zzb, ((n2 *= n) + n2) / 2);
        this.zzk += n;
        this.zzk();
    }

    public final void zzc(ShortBuffer object) {
        int n;
        int n2 = Math.min(((Buffer)object).remaining() / this.zzb, this.zzm);
        ((ShortBuffer)object).put(this.zzl, 0, this.zzb * n2);
        this.zzm = n = this.zzm - n2;
        object = this.zzl;
        int n3 = this.zzb;
        System.arraycopy(object, n2 * n3, object, 0, n * n3);
    }

    public final void zzd() {
        int n;
        int n2 = this.zzk;
        float f = this.zzc;
        float f2 = this.zzd;
        float f3 = this.zze;
        int n3 = this.zzm + (int)(((float)n2 / (f / f2) + (float)this.zzo) / (f3 * f2) + 0.5f);
        short[] sArray = this.zzj;
        int n4 = this.zzh;
        this.zzj = this.zzg(sArray, n2, n4 + n4 + n2);
        n4 = 0;
        while (true) {
            n = this.zzh;
            int n5 = this.zzb;
            if (n4 >= (n += n) * n5) break;
            this.zzj[n5 * n2 + n4] = 0;
            ++n4;
        }
        this.zzk += n;
        this.zzk();
        if (this.zzm > n3) {
            this.zzm = n3;
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zze() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
    }

    public final int zzf() {
        int n = this.zzm * this.zzb;
        return n + n;
    }
}
