/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaup
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaup;
import java.nio.Buffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzaoz {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final short[] zzf;
    private int zzg;
    private short[] zzh;
    private int zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private int zzn;
    private float zzo;
    private float zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private int zzx;

    public zzaoz(int n, int n2) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = n / 400;
        this.zzd = n /= 65;
        n += n;
        this.zze = n;
        this.zzf = new short[n];
        this.zzg = n;
        this.zzh = new short[n2 *= n];
        this.zzi = n;
        this.zzj = new short[n2];
        this.zzk = n;
        this.zzl = new short[n2];
        this.zzm = 0;
        this.zzn = 0;
        this.zzu = 0;
        this.zzo = 1.0f;
        this.zzp = 1.0f;
    }

    private final void zzg(int n) {
        int n2 = this.zzr;
        int n3 = this.zzi;
        if (n2 + n <= n3) return;
        this.zzi = n = n3 + (n3 / 2 + n);
        this.zzj = Arrays.copyOf(this.zzj, n * this.zzb);
    }

    private final void zzh(int n) {
        int n2 = this.zzq;
        int n3 = this.zzg;
        if (n2 + n <= n3) return;
        this.zzg = n = n3 + (n3 / 2 + n);
        this.zzh = Arrays.copyOf(this.zzh, n * this.zzb);
    }

    private final void zzi(short[] sArray, int n, int n2) {
        this.zzg(n2);
        int n3 = this.zzb;
        System.arraycopy(sArray, n * n3, this.zzj, this.zzr * n3, n3 * n2);
        this.zzr += n2;
    }

    private final void zzj(short[] sArray, int n, int n2) {
        int n3 = this.zze / n2;
        int n4 = this.zzb;
        int n5 = n2 * n4;
        n2 = 0;
        while (n2 < n3) {
            int n6 = 0;
            for (int i = 0; i < n5; n6 += sArray[n2 * n5 + n * n4 + i], ++i) {
            }
            this.zzf[n2] = (short)(n6 /= n5);
            ++n2;
        }
    }

    private final int zzk(short[] sArray, int n, int n2, int n3) {
        int n4 = n * this.zzb;
        int n5 = 1;
        int n6 = 255;
        int n7 = 0;
        int n8 = 0;
        while (true) {
            int n9;
            int n10;
            if (n2 > n3) {
                this.zzw = n5 / n7;
                this.zzx = n8 / n6;
                return n7;
            }
            n = 0;
            for (n9 = 0; n9 < n2; n += n10, ++n9) {
                n10 = sArray[n4 + n9];
                short s = sArray[n4 + n2 + n9];
                if (n10 >= s) {
                    n10 -= s;
                    continue;
                }
                n10 = s - n10;
            }
            n10 = n * n7;
            n9 = n5 * n2;
            if (n10 < n9) {
                n5 = n;
            }
            if (n10 < n9) {
                n7 = n2;
            }
            if ((n10 = n * n6) > (n9 = n8 * n2)) {
                n8 = n;
            }
            if (n10 > n9) {
                n6 = n2;
            }
            ++n2;
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void zzl() {
        block28: {
            var9_1 = this.zzr;
            var3_2 = this.zzo / this.zzp;
            var1_3 = var3_2;
            if (var1_3 > 1.00001 || var1_3 < 0.99999) break block28;
            this.zzi(this.zzh, 0, this.zzq);
            this.zzq = 0;
            ** GOTO lbl83
        }
        var10_4 = this.zzq;
        if (var10_4 < this.zze) ** GOTO lbl83
        var6_5 = 0;
        while (true) {
            block29: {
                if ((var4_7 = this.zzt) > 0) {
                    var4_7 = Math.min(this.zze, var4_7);
                    this.zzi(this.zzh, var6_5, var4_7);
                    this.zzt -= var4_7;
                    var4_7 = var6_5 + var4_7;
                } else {
                    var16_6 = this.zzh;
                    var4_7 = this.zza;
                    var4_7 = var4_7 > 4000 ? (var4_7 /= 4000) : 1;
                    if (this.zzb == 1 && var4_7 == 1) {
                        var4_7 = this.zzk(var16_6, var6_5, this.zzc, this.zzd);
                    } else {
                        this.zzj(var16_6, var6_5, var4_7);
                        var5_8 = this.zzk(this.zzf, 0, this.zzc / var4_7, this.zzd / var4_7);
                        if (var4_7 != 1) {
                            var5_8 *= var4_7;
                            var7_9 = var4_7 * 4;
                            var4_7 = var5_8 - var7_9;
                            var7_9 = var5_8 + var7_9;
                            var5_8 = this.zzc;
                            if (var4_7 < var5_8) {
                                var4_7 = var5_8;
                            }
                            var8_10 = this.zzd;
                            var5_8 = var7_9;
                            if (var7_9 > var8_10) {
                                var5_8 = var8_10;
                            }
                            if (this.zzb == 1) {
                                var4_7 = this.zzk(var16_6, var6_5, var4_7, var5_8);
                            } else {
                                this.zzj(var16_6, var6_5, 1);
                                var4_7 = this.zzk(this.zzf, 0, var4_7, var5_8);
                            }
                        } else {
                            var4_7 = var5_8;
                        }
                    }
                    var7_9 = this.zzw;
                    var8_10 = this.zzx;
                    if (var7_9 == 0 || (var5_8 = this.zzu) == 0 || var8_10 > var7_9 * 3 || var7_9 + var7_9 <= this.zzv * 3) {
                        var5_8 = var4_7;
                    }
                    this.zzv = var7_9;
                    this.zzu = var4_7;
                    if (var1_3 > 1.0) {
                        var16_6 = this.zzh;
                        if (var3_2 >= 2.0f) {
                            var4_7 = (int)((float)var5_8 / (-1.0f + var3_2));
                        } else {
                            this.zzt = (int)((float)var5_8 * (2.0f - var3_2) / (-1.0f + var3_2));
                            var4_7 = var5_8;
                        }
                        this.zzg(var4_7);
                        zzaoz.zzm(var4_7, this.zzb, this.zzj, this.zzr, var16_6, var6_5, var16_6, var6_5 + var5_8);
                        this.zzr += var4_7;
                        var4_7 = var6_5 + (var5_8 + var4_7);
                    } else {
                        var16_6 = this.zzh;
                        if (var3_2 < 0.5f) {
                            var4_7 = (int)((float)var5_8 * var3_2 / (1.0f - var3_2));
                        } else {
                            this.zzt = (int)((float)var5_8 * (var3_2 + var3_2 - 1.0f) / (1.0f - var3_2));
                            var4_7 = var5_8;
                        }
                        var8_10 = var5_8 + var4_7;
                        this.zzg(var8_10);
                        var7_9 = this.zzb;
                        System.arraycopy(var16_6, var6_5 * var7_9, this.zzj, this.zzr * var7_9, var7_9 * var5_8);
                        zzaoz.zzm(var4_7, this.zzb, this.zzj, this.zzr + var5_8, var16_6, var5_8 + var6_5, var16_6, var6_5);
                        this.zzr += var8_10;
                        var4_7 = var6_5 + var4_7;
                    }
                }
                if (this.zze + var4_7 <= var10_4) break block29;
                var5_8 = this.zzq - var4_7;
                var16_6 = this.zzh;
                var6_5 = this.zzb;
                System.arraycopy(var16_6, var4_7 * var6_5, var16_6, 0, var6_5 * var5_8);
                this.zzq = var5_8;
lbl83:
                // 3 sources

                var3_2 = this.zzp;
                if (var3_2 == 1.0f) return;
                if (this.zzr == var9_1) {
                    return;
                }
                break;
            }
            var6_5 = var4_7;
        }
        var4_7 = this.zza;
        var5_8 = (int)((float)var4_7 / var3_2);
        while (true) {
            if (var5_8 <= 16384 && var4_7 <= 16384) {
                var7_9 = this.zzs;
                var6_5 = this.zzr - var9_1;
                var8_10 = this.zzk;
                if (var7_9 + var6_5 > var8_10) {
                    this.zzk = var7_9 = var8_10 + (var8_10 / 2 + var6_5);
                    this.zzl = Arrays.copyOf(this.zzl, var7_9 * this.zzb);
                }
                var16_6 = this.zzj;
                var7_9 = this.zzb;
                System.arraycopy(var16_6, var9_1 * var7_9, this.zzl, this.zzs * var7_9, var7_9 * var6_5);
                this.zzr = var9_1;
                this.zzs += var6_5;
                break;
            }
            var5_8 /= 2;
            var4_7 /= 2;
        }
        var6_5 = 0;
        while (true) {
            if (var6_5 >= (var8_10 = (var7_9 = this.zzs) - 1)) {
                if (var8_10 == 0) return;
                var16_6 = this.zzl;
                var4_7 = this.zzb;
                System.arraycopy(var16_6, var8_10 * var4_7, var16_6, 0, (var7_9 - var8_10) * var4_7);
                this.zzs -= var8_10;
                return;
            }
            while ((var7_9 = this.zzm + 1) * var5_8 > (var8_10 = ++this.zzn) * var4_7) {
                this.zzg(1);
                for (var7_9 = 0; var7_9 < (var9_1 = this.zzb); ++var7_9) {
                    var17_16 = this.zzj;
                    var10_4 = this.zzr;
                    var16_6 = this.zzl;
                    var11_11 = var6_5 * var9_1 + var7_9;
                    var8_10 = var16_6[var11_11];
                    var11_11 = var16_6[var11_11 + var9_1];
                    var12_12 = this.zzn;
                    var14_14 = this.zzm;
                    var13_13 = (var14_14 + 1) * var5_8;
                    var12_12 = var13_13 - var12_12 * var4_7;
                    var17_16[var10_4 * var9_1 + var7_9] = (short)((var8_10 * var12_12 + ((var13_13 -= var14_14 * var5_8) - var12_12) * var11_11) / var13_13);
                }
                ++this.zzr;
            }
            this.zzm = var7_9;
            if (var7_9 == var4_7) {
                this.zzm = 0;
                var15_15 = var8_10 == var5_8;
                zzaup.zzd((boolean)var15_15);
                this.zzn = 0;
            }
            ++var6_5;
        }
    }

    private static void zzm(int n, int n2, short[] sArray, int n3, short[] sArray2, int n4, short[] sArray3, int n5) {
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

    public final void zza(float f) {
        this.zzo = f;
    }

    public final void zzb(float f) {
        this.zzp = f;
    }

    public final void zzc(ShortBuffer shortBuffer) {
        int n = shortBuffer.remaining();
        int n2 = this.zzb;
        n /= n2;
        this.zzh(n);
        shortBuffer.get(this.zzh, this.zzq * this.zzb, ((n2 *= n) + n2) / 2);
        this.zzq += n;
        this.zzl();
    }

    public final void zzd(ShortBuffer object) {
        int n;
        int n2 = Math.min(((Buffer)object).remaining() / this.zzb, this.zzr);
        ((ShortBuffer)object).put(this.zzj, 0, this.zzb * n2);
        this.zzr = n = this.zzr - n2;
        object = this.zzj;
        int n3 = this.zzb;
        System.arraycopy(object, n2 * n3, object, 0, n * n3);
    }

    public final void zze() {
        int n;
        int n2 = this.zzq;
        float f = this.zzo;
        float f2 = this.zzp;
        int n3 = this.zzr + (int)(((float)n2 / (f / f2) + (float)this.zzs) / f2 + 0.5f);
        int n4 = this.zze;
        this.zzh(n4 + n4 + n2);
        n4 = 0;
        while (true) {
            int n5 = this.zze;
            n = n5 + n5;
            if (n4 >= n * (n5 = this.zzb)) break;
            this.zzh[n5 * n2 + n4] = 0;
            ++n4;
        }
        this.zzq += n;
        this.zzl();
        if (this.zzr > n3) {
            this.zzr = n3;
        }
        this.zzq = 0;
        this.zzt = 0;
        this.zzs = 0;
    }

    public final int zzf() {
        return this.zzr;
    }
}
