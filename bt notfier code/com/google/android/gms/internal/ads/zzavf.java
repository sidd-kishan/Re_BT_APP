/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzanp
 *  com.google.android.gms.internal.ads.zzauq
 *  com.google.android.gms.internal.ads.zzauv
 *  com.google.android.gms.internal.ads.zzaux
 *  com.google.android.gms.internal.ads.zzauy
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzanp;
import com.google.android.gms.internal.ads.zzauq;
import com.google.android.gms.internal.ads.zzauv;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzauy;
import java.util.ArrayList;
import java.util.List;

public final class zzavf {
    public final List<byte[]> zza;
    public final int zzb;
    public final float zzc;

    private zzavf(List<byte[]> list, int n, int n2, int n3, float f) {
        this.zza = list;
        this.zzb = n;
        this.zzc = f;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static zzavf zza(zzaux var0) throws zzanp {
        block25: {
            try {
                var0.zzj(4);
                var3_3 = var0.zzl();
                var12_4 = 1;
                var11_5 = 1;
                var14_6 = (var3_3 & 3) + 1;
                if (var14_6 != 3) {
                    var18_7 = new ArrayList<byte[]>();
                    var4_8 = var0.zzl() & 31;
                    var13_9 = 0;
                    for (var3_3 = 0; var3_3 < var4_8; ++var3_3) {
                        var18_7.add(zzavf.zzb((zzaux)var0));
                    }
                }
                ** GOTO lbl161
            }
            catch (ArrayIndexOutOfBoundsException var0_1) {
                var0_2 = new zzanp("Error parsing AVC config", (Throwable)var0_1);
                throw var0_2;
            }
            {
                var5_10 = var0.zzl();
                for (var3_3 = 0; var3_3 < var5_10; ++var3_3) {
                    var18_7.add(zzavf.zzb((zzaux)var0));
                }
                var2_11 = 1.0f;
                if (var4_8 <= 0) ** GOTO lbl156
            }
            {
                block26: {
                    var19_12 /* !! */  = (byte[])var18_7.get(0);
                    var0 = (byte[])var18_7.get(0);
                    var3_3 = var19_12 /* !! */ .length;
                    var19_12 /* !! */  = (byte[])new zzauy;
                    var19_12 /* !! */ ((byte[])var0, var14_6, var3_3);
                    var19_12 /* !! */ .zza(8);
                    var3_3 = var19_12 /* !! */ .zzc(8);
                    var19_12 /* !! */ .zza(16);
                    var19_12 /* !! */ .zzd();
                    if (var3_3 == 100 || var3_3 == 110 || var3_3 == 122 || var3_3 == 244 || var3_3 == 44 || var3_3 == 83 || var3_3 == 86 || var3_3 == 118 || var3_3 == 128 || var3_3 == 138) break block26;
                    var5_10 = 1;
                    ** GOTO lbl-1000
                }
                var4_8 = var19_12 /* !! */ .zzd();
                if (var4_8 == 3) {
                    var19_12 /* !! */ .zzb();
                    var3_3 = 3;
                } else {
                    var3_3 = var4_8;
                }
                var19_12 /* !! */ .zzd();
                var19_12 /* !! */ .zzd();
                var19_12 /* !! */ .zza(1);
                var5_10 = var4_8;
                if (!var19_12 /* !! */ .zzb()) ** GOTO lbl-1000
                var6_13 = var3_3 != 3 ? 8 : 12;
                var7_14 = 0;
                while (true) {
                    var5_10 = var4_8;
                    if (var7_14 >= var6_13) break;
                    if (var19_12 /* !! */ .zzb()) {
                        var5_10 = var7_14 < 6 ? 16 : 64;
                        var10_17 = 8;
                        var8_15 = 8;
                        for (var9_16 = 0; var9_16 < var5_10; ++var9_16) {
                            var3_3 = var10_17;
                            if (var10_17 != 0) {
                                var3_3 = (var19_12 /* !! */ .zze() + var8_15 + 256) % 256;
                            }
                            if (var3_3 != 0) {
                                var8_15 = var3_3;
                            }
                            var10_17 = var3_3;
                        }
                    }
                    ++var7_14;
                }
            }
lbl-1000:
            // 3 sources

            {
                block27: {
                    var19_12 /* !! */ .zzd();
                    var3_3 = var19_12 /* !! */ .zzd();
                    if (var3_3 != 0) break block27;
                    var19_12 /* !! */ .zzd();
                    ** GOTO lbl-1000
                }
                if (var3_3 != 1) ** GOTO lbl-1000
                var19_12 /* !! */ .zzb();
                var19_12 /* !! */ .zze();
                var19_12 /* !! */ .zze();
                var16_18 = var19_12 /* !! */ .zzd();
                var3_3 = var13_9;
                while ((long)var3_3 < var16_18) {
                    var19_12 /* !! */ .zzd();
                    ++var3_3;
                }
            }
lbl-1000:
            // 3 sources

            {
                var19_12 /* !! */ .zzd();
                var19_12 /* !! */ .zza(1);
                var6_13 = var19_12 /* !! */ .zzd();
                var3_3 = var19_12 /* !! */ .zzd();
                var4_8 = (int)var19_12 /* !! */ .zzb();
                var8_15 = 2 - var4_8;
                if (var4_8 != 0) ** GOTO lbl105
            }
            {
                var19_12 /* !! */ .zza(1);
lbl105:
                // 2 sources

                var19_12 /* !! */ .zza(1);
                var6_13 = (var6_13 + 1) * 16;
                var7_14 = (var3_3 + 1) * var8_15 * 16;
                var3_3 = var6_13;
                var4_8 = var7_14;
            }
            {
                if (var19_12 /* !! */ .zzb()) {
                    var13_9 = var19_12 /* !! */ .zzd();
                    var15_19 = var19_12 /* !! */ .zzd();
                    var9_16 = var19_12 /* !! */ .zzd();
                    var10_17 = var19_12 /* !! */ .zzd();
                    if (var5_10 == 0) {
                        var4_8 = var12_4;
                        var3_3 = var8_15;
                    } else {
                        var3_3 = var5_10 == 3 ? 1 : 2;
                        var4_8 = var11_5;
                        if (var5_10 == 1) {
                            var4_8 = 2;
                        }
                        var5_10 = var8_15 * var4_8;
                        var4_8 = var3_3;
                        var3_3 = var5_10;
                    }
                    var5_10 = var6_13 - (var13_9 + var15_19) * var4_8;
                    var4_8 = var7_14 - (var9_16 + var10_17) * var3_3;
                    var3_3 = var5_10;
                }
                var1_20 = var2_11;
            }
            {
                if (var19_12 /* !! */ .zzb() == false) return new zzavf(var18_7, var14_6, var3_3, var4_8, var1_20);
                var1_20 = var2_11;
                if (var19_12 /* !! */ .zzb() == false) return new zzavf(var18_7, var14_6, var3_3, var4_8, var1_20);
                var5_10 = var19_12 /* !! */ .zzc(8);
                if (var5_10 != 255) break block25;
                var5_10 = var19_12 /* !! */ .zzc(16);
                var6_13 = var19_12 /* !! */ .zzc(16);
                var1_20 = var2_11;
                if (var5_10 == 0) return new zzavf(var18_7, var14_6, var3_3, var4_8, var1_20);
                var1_20 = var2_11;
                if (var6_13 == 0) return new zzavf(var18_7, var14_6, var3_3, var4_8, var1_20);
            }
            var1_20 = (float)var5_10 / (float)var6_13;
            ** GOTO lbl159
        }
        if (var5_10 >= 17) ** GOTO lbl147
        {
            block28: {
                var1_20 = zzauv.zzb[var5_10];
                break block28;
lbl147:
                // 1 sources

                var0 = new StringBuilder(46);
                var0.append("Unexpected aspect_ratio_idc value: ");
                var0.append(var5_10);
                Log.w((String)"NalUnitUtil", (String)var0.toString());
                var1_20 = var2_11;
                break block28;
lbl156:
                // 1 sources

                var3_3 = -1;
                var4_8 = -1;
                var1_20 = 1.0f;
            }
            return new zzavf(var18_7, var14_6, var3_3, var4_8, var1_20);
lbl161:
            // 1 sources

            var0 = new IllegalStateException();
            throw var0;
        }
    }

    private static byte[] zzb(zzaux zzaux2) {
        int n = zzaux2.zzm();
        int n2 = zzaux2.zzg();
        zzaux2.zzj(n);
        return zzauq.zzb((byte[])zzaux2.zza, (int)n2, (int)n);
    }
}
