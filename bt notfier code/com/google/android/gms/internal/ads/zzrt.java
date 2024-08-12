/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznv;
import java.io.IOException;

final class zzrt {
    private static final int[] zza = new int[]{1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 0x33677336, 862414134, 0x33676736, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zznv zznv2) throws IOException {
        return zzrt.zzc(zznv2, true, false);
    }

    public static boolean zzb(zznv zznv2, boolean bl) throws IOException {
        return zzrt.zzc(zznv2, false, false);
    }

    /*
     * Unable to fully structure code
     */
    private static boolean zzc(zznv var0, boolean var1_1, boolean var2_2) throws IOException {
        var12_3 = var0.zzo();
        var10_5 = var14_4 = 4096L;
        if (var12_3 != -1L) {
            var10_5 = var12_3 > 4096L ? var14_4 : var12_3;
        }
        var5_6 = (int)var10_5;
        var19_7 = new zzamf(64);
        var4_8 = 0;
        var3_9 = 0;
        block0: while (true) {
            block23: {
                block24: {
                    block20: {
                        block21: {
                            block22: {
                                if (var4_8 >= var5_6) break block20;
                                var19_7.zza(8);
                                if (!var0.zzh(var19_7.zzi(), 0, 8, true)) break block20;
                                var14_4 = var19_7.zzt();
                                var7_11 = var19_7.zzv();
                                var6_10 = 16;
                                if (var14_4 == 1L) {
                                    var0.zzi(var19_7.zzi(), 8, 8);
                                    var19_7.zzf(16);
                                    var10_5 = var19_7.zzx();
                                } else {
                                    var10_5 = var14_4;
                                    if (var14_4 == 0L) {
                                        var16_14 = var0.zzo();
                                        var10_5 = var14_4;
                                        if (var16_14 != -1L) {
                                            var10_5 = 8L + (var16_14 - var0.zzm());
                                        }
                                    }
                                    var6_10 = 8;
                                }
                                var14_4 = var6_10;
                                if (var10_5 < var14_4) {
                                    return false;
                                }
                                var6_10 = var4_8 + var6_10;
                                if (var7_11 == 1836019574) {
                                    var4_8 = var5_6 += (int)var10_5;
                                    if (var12_3 != -1L) {
                                        var4_8 = var5_6;
                                        if ((long)var5_6 > var12_3) {
                                            var4_8 = (int)var12_3;
                                        }
                                    }
                                    var5_6 = var4_8;
                                    var4_8 = var6_10;
                                    continue;
                                }
                                if (var7_11 == 0x6D6F6F66 || var7_11 == 1836475768) break block21;
                                if ((long)var6_10 + var10_5 - var14_4 >= (long)var5_6) break block20;
                                var9_13 = (int)(var10_5 - var14_4);
                                var8_12 = var6_10 + var9_13;
                                if (var7_11 != 1718909296) break block22;
                                if (var9_13 < 8) {
                                    return false;
                                }
                                break block23;
                            }
                            var6_10 = var3_9;
                            if (var9_13 != 0) {
                                var0.zzk(var9_13);
                                var6_10 = var3_9;
                            }
                            ** GOTO lbl85
                        }
                        var2_2 = true;
                        break block24;
                    }
                    var2_2 = false;
                }
                if (var3_9 == 0) return false;
                if (var1_1 != var2_2) return false;
                return true;
            }
            var19_7.zza(var9_13);
            var0.zzi(var19_7.zzi(), 0, var9_13);
            var6_10 = 0;
            while (true) {
                var4_8 = var3_9;
                if (var6_10 >= var9_13 >> 2) ** GOTO lbl83
                if (var6_10 == 1) {
                    var19_7.zzk(4);
                } else {
                    var7_11 = var19_7.zzv();
                    if (var7_11 >>> 8 != 3368816) {
                        var4_8 = var7_11;
                        if (var7_11 == 1751476579) {
                            var4_8 = 1751476579;
                        }
                        var18_15 = zzrt.zza;
                    } else {
                        while (true) {
                            var4_8 = 1;
lbl83:
                            // 2 sources

                            if (var4_8 == 0) return false;
                            var6_10 = var4_8;
lbl85:
                            // 2 sources

                            var4_8 = var8_12;
                            var3_9 = var6_10;
                            continue block0;
                            break;
                        }
                    }
                    for (var7_11 = 0; var7_11 < 29; ++var7_11) {
                        if (var18_15[var7_11] == var4_8) ** continue;
                    }
                }
                ++var6_10;
            }
            break;
        }
    }
}
