/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzalu
 *  com.google.android.gms.internal.ads.zzalv
 *  com.google.android.gms.internal.ads.zzamg
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzalu;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzamg;

public final class zzalw {
    public static final byte[] zza = new byte[]{0, 0, 0, 1};
    public static final float[] zzb = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    /*
     * Exception decompiling
     */
    public static int zza(byte[] var0, int var1_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 0[TRYBLOCK] [0 : 69->106)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static zzalv zzb(byte[] var0, int var1_1, int var2_2) {
        block22: {
            block21: {
                block20: {
                    var0 = new zzamg((byte[])var0, var1_1, var2_2);
                    var0.zzc(8);
                    var2_2 = var0.zze(8);
                    var15_3 = var0.zze(8);
                    var14_4 = var0.zze(8);
                    var13_5 = var0.zzf();
                    var12_6 = 1;
                    var11_7 = 1;
                    var1_1 = var2_2;
                    if (var2_2 == 100) ** GOTO lbl32
                    var1_1 = var2_2;
                    if (var2_2 == 110) ** GOTO lbl32
                    var1_1 = var2_2;
                    if (var2_2 == 122) ** GOTO lbl32
                    var1_1 = var2_2;
                    if (var2_2 == 244) ** GOTO lbl32
                    var1_1 = var2_2;
                    if (var2_2 == 44) ** GOTO lbl32
                    var1_1 = var2_2;
                    if (var2_2 == 83) ** GOTO lbl32
                    var1_1 = var2_2;
                    if (var2_2 == 86) ** GOTO lbl32
                    var1_1 = var2_2;
                    if (var2_2 == 118) ** GOTO lbl32
                    var1_1 = var2_2;
                    if (var2_2 == 128) ** GOTO lbl32
                    if (var2_2 != 138) {
                        var4_8 = 1;
                        var23_9 = false;
                    } else {
                        var1_1 = 138;
lbl32:
                        // 10 sources

                        if ((var5_10 = var0.zzf()) == 3) {
                            var22_11 = var0.zzd();
                            var6_12 = 3;
                        } else {
                            var6_12 = var5_10;
                            var22_11 = false;
                        }
                        var0.zzf();
                        var0.zzf();
                        var0.zzb();
                        var2_2 = var1_1;
                        var4_8 = var5_10;
                        var23_9 = var22_11;
                        if (var0.zzd()) {
                            var6_12 = var6_12 != 3 ? 8 : 12;
                            var7_13 = 0;
                            while (true) {
                                var2_2 = var1_1;
                                var4_8 = var5_10;
                                var23_9 = var22_11;
                                if (var7_13 >= var6_12) break;
                                if (var0.zzd()) {
                                    var4_8 = var7_13 < 6 ? 16 : 64;
                                    var10_16 = 8;
                                    var8_14 = 8;
                                    for (var9_15 = 0; var9_15 < var4_8; ++var9_15) {
                                        var2_2 = var10_16;
                                        if (var10_16 != 0) {
                                            var2_2 = (var8_14 + var0.zzg() + 256) % 256;
                                        }
                                        if (var2_2 != 0) {
                                            var8_14 = var2_2;
                                        }
                                        var10_16 = var2_2;
                                    }
                                }
                                ++var7_13;
                            }
                        }
                    }
                    var16_17 = var0.zzf();
                    var5_10 = var0.zzf();
                    if (var5_10 != 0) break block20;
                    var1_1 = var0.zzf() + 4;
                    ** GOTO lbl91
                }
                if (var5_10 == 1) {
                    var22_11 = var0.zzd();
                    var0.zzg();
                    var0.zzg();
                    var24_18 = var0.zzf();
                    var1_1 = 0;
                    while ((long)var1_1 < var24_18) {
                        var0.zzf();
                        ++var1_1;
                    }
                    var5_10 = 1;
                    var6_12 = 0;
                } else {
                    var1_1 = 0;
lbl91:
                    // 2 sources

                    var22_11 = false;
                    var6_12 = var1_1;
                }
                var0.zzf();
                var0.zzb();
                var7_13 = var0.zzf();
                var1_1 = var0.zzf();
                var17_19 = var0.zzd();
                var10_16 = 2 - var17_19;
                if (var17_19 == 0) {
                    var0.zzb();
                }
                var0.zzb();
                var8_14 = (var7_13 + 1) * 16;
                var9_15 = (var1_1 + 1) * var10_16 * 16;
                var7_13 = var8_14;
                var1_1 = var9_15;
                if (var0.zzd()) {
                    var20_20 = var0.zzf();
                    var21_21 = var0.zzf();
                    var18_22 = var0.zzf();
                    var19_23 = var0.zzf();
                    if (var4_8 == 0) {
                        var4_8 = var12_6;
                        var1_1 = var10_16;
                    } else {
                        var1_1 = var4_8 == 3 ? 1 : 2;
                        var7_13 = var11_7;
                        if (var4_8 == 1) {
                            var7_13 = 2;
                        }
                        var7_13 = var10_16 * var7_13;
                        var4_8 = var1_1;
                        var1_1 = var7_13;
                    }
                    var7_13 = var8_14 - (var20_20 + var21_21) * var4_8;
                    var1_1 = var9_15 - (var18_22 + var19_23) * var1_1;
                }
                if (!var0.zzd() || !var0.zzd()) ** GOTO lbl144
                var4_8 = var0.zze(8);
                if (var4_8 != 255) break block21;
                var4_8 = var0.zze(16);
                var8_14 = var0.zze(16);
                if (var4_8 == 0 || var8_14 == 0) ** GOTO lbl144
                var3_24 = (float)var4_8 / (float)var8_14;
                break block22;
            }
            if (var4_8 < 17) {
                var3_24 = zzalw.zzb[var4_8];
            } else {
                var0 = new StringBuilder(46);
                var0.append("Unexpected aspect_ratio_idc value: ");
                var0.append(var4_8);
                Log.w((String)"NalUnitUtil", (String)var0.toString());
lbl144:
                // 3 sources

                var3_24 = 1.0f;
            }
        }
        return new zzalv(var2_2, var15_3, var14_4, var13_5, var7_13, var1_1, var3_24, var23_9, (boolean)var17_19, var16_17 + 4, var5_10, var6_12, var22_11);
    }

    public static zzalu zzc(byte[] object, int n, int n2) {
        object = new zzamg(object, 3, n2);
        object.zzc(8);
        n2 = object.zzf();
        n = object.zzf();
        object.zzb();
        return new zzalu(n2, n, object.zzd());
    }

    /*
     * Unable to fully structure code
     */
    public static int zzd(byte[] var0, int var1_1, int var2_2, boolean[] var3_3) {
        block10: {
            var5_4 = var2_2 - var1_1;
            var9_5 = false;
            var8_6 = var5_4 >= 0;
            zzakt.zzd((boolean)var8_6);
            if (var5_4 == 0) {
                return var2_2;
            }
            if (var3_3[0]) {
                zzalw.zze(var3_3);
                return var1_1 - 3;
            }
            if (var5_4 > 1 && var3_3[1] && var0[var1_1] == 1) {
                zzalw.zze(var3_3);
                return var1_1 - 2;
            }
            if (var5_4 > 2 && var3_3[2] && var0[var1_1] == 0 && var0[var1_1 + 1] == 1) {
                zzalw.zze(var3_3);
                return var1_1 - 1;
            }
            var6_7 = var2_2 - 1;
            var1_1 += 2;
            while (var1_1 < var6_7) {
                var7_9 = var0[var1_1];
                if ((var7_9 & 254) == 0) {
                    var4_8 = var1_1 - 2;
                    if (var0[var4_8] == 0 && var0[var1_1 - 1] == 0 && var7_9 == 1) {
                        zzalw.zze(var3_3);
                        return var4_8;
                    }
                    var1_1 = var4_8;
                }
                var1_1 += 3;
            }
            if (var5_4 <= 2) break block10;
            if (var0[var2_2 - 3] != 0 || var0[var2_2 - 2] != 0 || var0[var6_7] != 1) ** GOTO lbl-1000
            ** GOTO lbl-1000
        }
        if (!(var5_4 != 2 ? var3_3[1] != false && var0[var6_7] == 1 : var3_3[2] != false && var0[var2_2 - 2] == 0 && var0[var6_7] == 1)) lbl-1000:
        // 2 sources

        {
            var8_6 = false;
        } else lbl-1000:
        // 2 sources

        {
            var8_6 = true;
        }
        var3_3[0] = var8_6;
        var8_6 = var5_4 > 1 ? var0[var2_2 - 2] == 0 && var0[var6_7] == 0 : var3_3[2] != false && var0[var6_7] == 0;
        var3_3[1] = var8_6;
        var8_6 = var9_5;
        if (var0[var6_7] == 0) {
            var8_6 = true;
        }
        var3_3[2] = var8_6;
        return var2_2;
    }

    public static void zze(boolean[] blArray) {
        blArray[0] = false;
        blArray[1] = false;
        blArray[2] = false;
    }
}
