/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzapn
 *  com.google.android.gms.internal.ads.zzaqk
 *  com.google.android.gms.internal.ads.zzaux
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzaqk;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzave;
import java.io.IOException;

final class zzarb {
    private static final int[] zza = new int[]{zzave.zzl((String)"isom"), zzave.zzl((String)"iso2"), zzave.zzl((String)"iso3"), zzave.zzl((String)"iso4"), zzave.zzl((String)"iso5"), zzave.zzl((String)"iso6"), zzave.zzl((String)"avc1"), zzave.zzl((String)"hvc1"), zzave.zzl((String)"hev1"), zzave.zzl((String)"mp41"), zzave.zzl((String)"mp42"), zzave.zzl((String)"3g2a"), zzave.zzl((String)"3g2b"), zzave.zzl((String)"3gr6"), zzave.zzl((String)"3gs6"), zzave.zzl((String)"3ge6"), zzave.zzl((String)"3gg6"), zzave.zzl((String)"M4V "), zzave.zzl((String)"M4A "), zzave.zzl((String)"f4v "), zzave.zzl((String)"kddi"), zzave.zzl((String)"M4VP"), zzave.zzl((String)"qt  "), zzave.zzl((String)"MSNV")};

    public static boolean zza(zzapn zzapn2) throws IOException, InterruptedException {
        return zzarb.zzc(zzapn2, true);
    }

    public static boolean zzb(zzapn zzapn2) throws IOException, InterruptedException {
        return zzarb.zzc(zzapn2, false);
    }

    /*
     * Unable to fully structure code
     */
    private static boolean zzc(zzapn var0, boolean var1_1) throws IOException, InterruptedException {
        block17: {
            block16: {
                var12_2 = var0.zzi();
                if (var12_2 == -1L) break block16;
                var10_3 = var12_2;
                if (var12_2 <= 4096L) break block17;
            }
            var10_3 = 4096L;
        }
        var6_4 = (int)var10_3;
        var14_5 = new zzaux(64);
        var2_6 = 0;
        var3_7 = 0;
        block0: while (true) {
            block21: {
                block22: {
                    block18: {
                        block19: {
                            block20: {
                                if (var2_6 >= var6_4) break block18;
                                var14_5.zza(8);
                                var0.zze(var14_5.zza, 0, 8, false);
                                var10_3 = var14_5.zzp();
                                var8_11 = var14_5.zzr();
                                var4_8 = 16;
                                if (var10_3 == 1L) {
                                    var0.zze(var14_5.zza, 8, 8, false);
                                    var14_5.zzf(16);
                                    var10_3 = var14_5.zzv();
                                } else {
                                    var4_8 = 8;
                                }
                                var12_2 = var4_8;
                                if (var10_3 < var12_2) {
                                    return false;
                                }
                                var2_6 = var4_8 = var2_6 + var4_8;
                                if (var8_11 == zzaqk.zzE) continue;
                                if (var8_11 == zzaqk.zzN || var8_11 == zzaqk.zzP) break block19;
                                if ((long)var4_8 + var10_3 - var12_2 >= (long)var6_4) break block18;
                                var7_10 = (int)(var10_3 - var12_2);
                                var5_9 = var4_8 + var7_10;
                                if (var8_11 != zzaqk.zzd) break block20;
                                if (var7_10 < 8) {
                                    return false;
                                }
                                break block21;
                            }
                            var2_6 = var5_9;
                            if (var7_10 == 0) continue;
                            var0.zzf(var7_10, false);
                            var2_6 = var5_9;
                            continue;
                        }
                        var9_13 = true;
                        break block22;
                    }
                    var9_13 = false;
                }
                if (var3_7 == 0) return false;
                if (var1_1 != var9_13) return false;
                return true;
            }
            var14_5.zza(var7_10);
            var0.zze(var14_5.zza, 0, var7_10, false);
            var2_6 = 0;
            while (true) {
                var4_8 = var3_7;
                if (var2_6 >= var7_10 >> 2) ** GOTO lbl74
                if (var2_6 == 1) {
                    var14_5.zzj(4);
                } else {
                    var8_11 = var14_5.zzr();
                    if (var8_11 >>> 8 != zzave.zzl((String)"3gp")) {
                        var15_12 = zzarb.zza;
                        var4_8 = var15_12.length;
                    } else {
                        while (true) {
                            var4_8 = 1;
lbl74:
                            // 2 sources

                            if (var4_8 == 0) return false;
                            var2_6 = var5_9;
                            var3_7 = var4_8;
                            continue block0;
                            break;
                        }
                    }
                    for (var4_8 = 0; var4_8 < 24; ++var4_8) {
                        if (var15_12[var4_8] == var8_11) ** continue;
                    }
                }
                ++var2_6;
            }
            break;
        }
    }
}
