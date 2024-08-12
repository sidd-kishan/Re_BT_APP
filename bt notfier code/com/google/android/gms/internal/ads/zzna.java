/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzmz
 *  com.google.android.gms.internal.ads.zzn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzmz;
import com.google.android.gms.internal.ads.zzn;

public final class zzna {
    public static final int zza = 0;
    private static final int[] zzb = new int[]{1, 2, 3, 6};
    private static final int[] zzc = new int[]{48000, 44100, 32000};
    private static final int[] zzd = new int[]{24000, 22050, 16000};
    private static final int[] zze = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzafv zza(zzamf zzamf2, String string, String string2, zzn zzn2) {
        int n;
        int n2 = zzamf2.zzn();
        int n3 = zzc[(n2 & 0xC0) >> 6];
        int n4 = zzamf2.zzn();
        n2 = n = zze[(n4 & 0x38) >> 3];
        if ((n4 & 4) != 0) {
            n2 = n + 1;
        }
        zzamf2 = new zzaft();
        zzamf2.zzD(string);
        zzamf2.zzN("audio/ac3");
        zzamf2.zzaa(n2);
        zzamf2.zzab(n3);
        zzamf2.zzQ(zzn2);
        zzamf2.zzG(string2);
        return zzamf2.zzah();
    }

    public static zzafv zzb(zzamf object, String string, String string2, zzn zzn2) {
        int n;
        object.zzk(2);
        int n2 = object.zzn();
        int n3 = zzc[(n2 & 0xC0) >> 6];
        int n4 = object.zzn();
        n2 = n = zze[(n4 & 0xE) >> 1];
        if ((n4 & 1) != 0) {
            n2 = n + 1;
        }
        n = n2;
        if ((object.zzn() & 0x1E) >> 1 > 0) {
            n = n2;
            if ((2 & object.zzn()) != 0) {
                n = n2 + 2;
            }
        }
        object = object.zzd() > 0 && (object.zzn() & 1) != 0 ? "audio/eac3-joc" : "audio/eac3";
        zzaft zzaft2 = new zzaft();
        zzaft2.zzD(string);
        zzaft2.zzN((String)object);
        zzaft2.zzaa(n);
        zzaft2.zzab(n3);
        zzaft2.zzQ(zzn2);
        zzaft2.zzG(string2);
        return zzaft2.zzah();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static zzmz zzc(zzame var0) {
        block59: {
            block57: {
                block58: {
                    var1_1 = var0 /* !! */ .zzc();
                    var0 /* !! */ .zzf(40);
                    var2_2 = var0 /* !! */ .zzh(5);
                    var0 /* !! */ .zzd(var1_1);
                    var1_1 = -1;
                    if (var2_2 <= 10) break block57;
                    var0 /* !! */ .zzf(16);
                    var2_2 = var0 /* !! */ .zzh(2);
                    if (var2_2 != 0) {
                        if (var2_2 != 1) {
                            if (var2_2 == 2) {
                                var1_1 = 2;
                            }
                        } else {
                            var1_1 = 1;
                        }
                    } else {
                        var1_1 = 0;
                    }
                    var0 /* !! */ .zzf(3);
                    var10_3 = var0 /* !! */ .zzh(11) + 1;
                    var11_4 = var0 /* !! */ .zzh(2);
                    if (var11_4 == 3) {
                        var2_2 = zzna.zzd[var0 /* !! */ .zzh(2)];
                        var3_5 = 3;
                        var7_6 = 6;
                    } else {
                        var3_5 = var0 /* !! */ .zzh(2);
                        var7_6 = zzna.zzb[var3_5];
                        var2_2 = zzna.zzc[var11_4];
                    }
                    var8_7 = var0 /* !! */ .zzh(3);
                    var12_8 = var0 /* !! */ .zzg();
                    var13_9 = zzna.zze[var8_7];
                    var0 /* !! */ .zzf(10);
                    if (var0 /* !! */ .zzg()) {
                        var0 /* !! */ .zzf(8);
                    }
                    if (var8_7 == 0) {
                        var0 /* !! */ .zzf(5);
                        if (var0 /* !! */ .zzg()) {
                            var0 /* !! */ .zzf(8);
                        }
                        var4_10 = 0;
                        var8_7 = 0;
                    } else {
                        var4_10 = var8_7;
                    }
                    if (var1_1 == 1) {
                        if (var0 /* !! */ .zzg()) {
                            var0 /* !! */ .zzf(16);
                        }
                        var6_11 = 1;
                    } else {
                        var6_11 = var1_1;
                    }
                    var5_12 = var6_11;
                    var9_13 = var3_5;
                    if (!var0 /* !! */ .zzg()) break block58;
                    if (var4_10 > 2) {
                        var0 /* !! */ .zzf(2);
                    }
                    if ((var4_10 & 1) != 0 && var4_10 > 2) {
                        var0 /* !! */ .zzf(6);
                    }
                    if ((var4_10 & 4) != 0) {
                        var0 /* !! */ .zzf(6);
                    }
                    if (var12_8 != 0 && var0 /* !! */ .zzg()) {
                        var0 /* !! */ .zzf(5);
                    }
                    var5_12 = var6_11;
                    var9_13 = var3_5;
                    if (var6_11 != 0) break block58;
                    if (var0 /* !! */ .zzg()) {
                        var0 /* !! */ .zzf(6);
                    }
                    if (var4_10 == 0 && var0 /* !! */ .zzg()) {
                        var0 /* !! */ .zzf(6);
                    }
                    if (var0 /* !! */ .zzg()) {
                        var0 /* !! */ .zzf(6);
                    }
                    if ((var5_12 = var0 /* !! */ .zzh(2)) == 1) {
                        var0 /* !! */ .zzf(5);
                    } else if (var5_12 == 2) {
                        var0 /* !! */ .zzf(12);
                    } else if (var5_12 == 3) {
                        var5_12 = var0 /* !! */ .zzh(5);
                        if (var0 /* !! */ .zzg()) {
                            var0 /* !! */ .zzf(5);
                            if (var0 /* !! */ .zzg()) {
                                var0 /* !! */ .zzf(4);
                            }
                            if (var0 /* !! */ .zzg()) {
                                var0 /* !! */ .zzf(4);
                            }
                            if (var0 /* !! */ .zzg()) {
                                var0 /* !! */ .zzf(4);
                            }
                            if (var0 /* !! */ .zzg()) {
                                var0 /* !! */ .zzf(4);
                            }
                            if (var0 /* !! */ .zzg()) {
                                var0 /* !! */ .zzf(4);
                            }
                            if (var0 /* !! */ .zzg()) {
                                var0 /* !! */ .zzf(4);
                            }
                            if (var0 /* !! */ .zzg()) {
                                var0 /* !! */ .zzf(4);
                            }
                            if (var0 /* !! */ .zzg()) {
                                if (var0 /* !! */ .zzg()) {
                                    var0 /* !! */ .zzf(4);
                                }
                                if (var0 /* !! */ .zzg()) {
                                    var0 /* !! */ .zzf(4);
                                }
                            }
                        }
                        if (var0 /* !! */ .zzg()) {
                            var0 /* !! */ .zzf(5);
                            if (var0 /* !! */ .zzg()) {
                                var0 /* !! */ .zzf(7);
                                if (var0 /* !! */ .zzg()) {
                                    var0 /* !! */ .zzf(8);
                                }
                            }
                        }
                        var0 /* !! */ .zzf((var5_12 + 2) * 8);
                        var0 /* !! */ .zzj();
                    }
                    if (var4_10 < 2) {
                        if (var0 /* !! */ .zzg()) {
                            var0 /* !! */ .zzf(14);
                        }
                        if (var8_7 == 0 && var0 /* !! */ .zzg()) {
                            var0 /* !! */ .zzf(14);
                        }
                    }
                    if (!var0 /* !! */ .zzg()) ** GOTO lbl120
                    if (var3_5 == 0) {
                        var0 /* !! */ .zzf(5);
                        var5_12 = 0;
                        var9_13 = 0;
                    } else {
                        for (var5_12 = 0; var5_12 < var7_6; ++var5_12) {
                            if (!var0 /* !! */ .zzg()) continue;
                            var0 /* !! */ .zzf(5);
                        }
lbl120:
                        // 2 sources

                        var5_12 = 0;
                        var9_13 = var3_5;
                    }
                }
                if (var0 /* !! */ .zzg()) {
                    var0 /* !! */ .zzf(5);
                    var3_5 = var4_10;
                    if (var4_10 == 2) {
                        var0 /* !! */ .zzf(4);
                        var3_5 = 2;
                    }
                    if (var3_5 >= 6) {
                        var0 /* !! */ .zzf(2);
                    }
                    if (var0 /* !! */ .zzg()) {
                        var0 /* !! */ .zzf(8);
                    }
                    if (var3_5 == 0 && var0 /* !! */ .zzg()) {
                        var0 /* !! */ .zzf(8);
                    }
                    if (var11_4 < 3) {
                        var0 /* !! */ .zze();
                    }
                }
                if (var5_12 == 0 && var9_13 != 3) {
                    var0 /* !! */ .zze();
                }
                if (var5_12 == 2 && (var9_13 == 3 || var0 /* !! */ .zzg())) {
                    var0 /* !! */ .zzf(6);
                }
                var0 /* !! */  = var0 /* !! */ .zzg() != false && var0 /* !! */ .zzh(6) == 1 && var0 /* !! */ .zzh(8) == 1 ? "audio/eac3-joc" : "audio/eac3";
                var6_11 = var10_3 + var10_3;
                var4_10 = var7_6 * 256;
                var3_5 = var2_2;
                var2_2 = var13_9 + var12_8;
                var5_12 = var1_1;
                var1_1 = var3_5;
                var3_5 = var6_11;
                break block59;
            }
            var0 /* !! */ .zzf(32);
            var1_1 = var0 /* !! */ .zzh(2);
            var14_14 = var1_1 == 3 ? null : "audio/ac3";
            var3_5 = zzna.zze(var1_1, var0 /* !! */ .zzh(6));
            var0 /* !! */ .zzf(8);
            var2_2 = var0 /* !! */ .zzh(3);
            if ((var2_2 & 1) != 0 && var2_2 != 1) {
                var0 /* !! */ .zzf(2);
            }
            if ((var2_2 & 4) != 0) {
                var0 /* !! */ .zzf(2);
            }
            if (var2_2 == 2) {
                var0 /* !! */ .zzf(2);
            }
            var1_1 = var1_1 < 3 ? zzna.zzc[var1_1] : -1;
            var4_10 = var0 /* !! */ .zzg();
            var2_2 = zzna.zze[var2_2];
            var0 /* !! */  = var14_14;
            var2_2 += var4_10;
            var5_12 = -1;
            var4_10 = 1536;
        }
        return new zzmz((String)var0 /* !! */ , var5_12, var2_2, var1_1, var3_5, var4_10, null);
    }

    public static int zzd(byte[] byArray) {
        if (byArray.length < 6) {
            return -1;
        }
        if ((byArray[5] & 0xF8) >> 3 > 10) {
            int n = byArray[2];
            n = (byArray[3] & 0xFF | (n & 7) << 8) + 1;
            return n + n;
        }
        byte by = byArray[4];
        return zzna.zze((by & 0xC0) >> 6, by & 0x3F);
    }

    private static int zze(int n, int n2) {
        int n3 = n2 / 2;
        if (n < 0) return -1;
        if (n >= 3) return -1;
        if (n2 < 0) return -1;
        if (n3 >= 19) {
            return -1;
        }
        if ((n = zzc[n]) == 44100) {
            n = zzg[n3] + (n2 & 1);
            return n + n;
        }
        n2 = zzf[n3];
        if (n != 32000) return n2 * 4;
        return n2 * 6;
    }
}
