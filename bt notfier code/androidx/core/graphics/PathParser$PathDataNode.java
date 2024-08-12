/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.util.Log
 *  androidx.core.graphics.PathParser
 */
package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.core.graphics.PathParser;

/*
 * Exception performing whole class analysis ignored.
 */
public static class PathParser.PathDataNode {
    public float[] mParams;
    public char mType;

    PathParser.PathDataNode(char c, float[] fArray) {
        this.mType = c;
        this.mParams = fArray;
    }

    PathParser.PathDataNode(PathParser.PathDataNode object) {
        this.mType = ((PathParser.PathDataNode)object).mType;
        object = ((PathParser.PathDataNode)object).mParams;
        this.mParams = PathParser.copyOfRange((float[])object, (int)0, (int)((Object)object).length);
    }

    /*
     * Unable to fully structure code
     */
    private static void addCommand(Path var0, float[] var1_1, char var2_2, char var3_3, float[] var4_4) {
        var13_5 = var1_1[0];
        var12_6 = var1_1[1];
        var11_7 = var1_1[2];
        var14_8 = var1_1[3];
        var10_9 = var1_1[4];
        var9_10 = var1_1[5];
        var5_11 = var13_5;
        var6_12 = var12_6;
        var7_13 = var11_7;
        var8_14 = var14_8;
        switch (var3_3) {
            default: {
                var8_14 = var14_8;
                var7_13 = var11_7;
                var6_12 = var12_6;
                var5_11 = var13_5;
                ** GOTO lbl23
            }
            case 'Z': 
            case 'z': {
                var0.close();
                var0.moveTo(var10_9, var9_10);
                var7_13 = var5_11 = var10_9;
                var8_14 = var6_12 = var9_10;
            }
lbl23:
            // 3 sources

            case 'L': 
            case 'M': 
            case 'T': 
            case 'l': 
            case 'm': 
            case 't': {
                var15_15 = 2;
                break;
            }
            case 'Q': 
            case 'S': 
            case 'q': 
            case 's': {
                var15_15 = 4;
                var5_11 = var13_5;
                var6_12 = var12_6;
                var7_13 = var11_7;
                var8_14 = var14_8;
                break;
            }
            case 'H': 
            case 'V': 
            case 'h': 
            case 'v': {
                var15_15 = 1;
                var5_11 = var13_5;
                var6_12 = var12_6;
                var7_13 = var11_7;
                var8_14 = var14_8;
                break;
            }
            case 'C': 
            case 'c': {
                var15_15 = 6;
                var5_11 = var13_5;
                var6_12 = var12_6;
                var7_13 = var11_7;
                var8_14 = var14_8;
                break;
            }
            case 'A': 
            case 'a': {
                var15_15 = 7;
                var8_14 = var14_8;
                var7_13 = var11_7;
                var6_12 = var12_6;
                var5_11 = var13_5;
            }
        }
        var17_16 = 0;
        var16_17 = var2_2;
        var11_7 = var9_10;
        var12_6 = var10_9;
        var2_2 = var17_16;
        while (true) {
            block42: {
                block51: {
                    block25: {
                        block26: {
                            block27: {
                                block28: {
                                    block29: {
                                        block30: {
                                            block50: {
                                                block43: {
                                                    block31: {
                                                        block32: {
                                                            block33: {
                                                                block45: {
                                                                    block34: {
                                                                        block35: {
                                                                            block36: {
                                                                                block49: {
                                                                                    block48: {
                                                                                        block37: {
                                                                                            block47: {
                                                                                                block46: {
                                                                                                    block38: {
                                                                                                        block39: {
                                                                                                            block44: {
                                                                                                                block40: {
                                                                                                                    block41: {
                                                                                                                        if (var2_2 >= var4_4.length) {
                                                                                                                            var1_1[0] = var5_11;
                                                                                                                            var1_1[1] = var6_12;
                                                                                                                            var1_1[2] = var7_13;
                                                                                                                            var1_1[3] = var8_14;
                                                                                                                            var1_1[4] = var12_6;
                                                                                                                            var1_1[5] = var11_7;
                                                                                                                            return;
                                                                                                                        }
                                                                                                                        if (var3_3 == 'A') break block25;
                                                                                                                        if (var3_3 == 'C') break block26;
                                                                                                                        if (var3_3 == 'H') break block27;
                                                                                                                        if (var3_3 == 'Q') break block28;
                                                                                                                        if (var3_3 == 'V') break block29;
                                                                                                                        if (var3_3 == 'a') break block30;
                                                                                                                        if (var3_3 == 'c') break block31;
                                                                                                                        if (var3_3 == 'h') break block32;
                                                                                                                        if (var3_3 == 'q') break block33;
                                                                                                                        if (var3_3 == 'v') break block34;
                                                                                                                        if (var3_3 == 'L') break block35;
                                                                                                                        if (var3_3 == 'M') break block36;
                                                                                                                        if (var3_3 == 'S') break block37;
                                                                                                                        if (var3_3 == 'T') break block38;
                                                                                                                        if (var3_3 == 'l') break block39;
                                                                                                                        if (var3_3 == 'm') break block40;
                                                                                                                        if (var3_3 == 's') break block41;
                                                                                                                        if (var3_3 == 't') {
                                                                                                                            if (var16_17 != 113 && var16_17 != 116 && var16_17 != 81 && var16_17 != 84) {
                                                                                                                                var8_14 = 0.0f;
                                                                                                                                var7_13 = 0.0f;
                                                                                                                            } else {
                                                                                                                                var7_13 = var5_11 - var7_13;
                                                                                                                                var8_14 = var6_12 - var8_14;
                                                                                                                            }
                                                                                                                            var16_17 = var2_2 + 0;
                                                                                                                            var9_10 = var4_4[var16_17];
                                                                                                                            var17_16 = var2_2 + 1;
                                                                                                                            var0.rQuadTo(var7_13, var8_14, var9_10, var4_4[var17_16]);
                                                                                                                            var9_10 = var5_11 + var4_4[var16_17];
                                                                                                                            var10_9 = var6_12 + var4_4[var17_16];
                                                                                                                            var8_14 += var6_12;
                                                                                                                            var7_13 += var5_11;
                                                                                                                            var6_12 = var10_9;
                                                                                                                            var5_11 = var9_10;
                                                                                                                        }
                                                                                                                        break block42;
                                                                                                                    }
                                                                                                                    if (var16_17 != 99 && var16_17 != 115 && var16_17 != 67 && var16_17 != 83) {
                                                                                                                        var8_14 = 0.0f;
                                                                                                                        var7_13 = 0.0f;
                                                                                                                    } else {
                                                                                                                        var9_10 = var6_12 - var8_14;
                                                                                                                        var8_14 = var5_11 - var7_13;
                                                                                                                        var7_13 = var9_10;
                                                                                                                    }
                                                                                                                    var16_17 = var2_2 + 0;
                                                                                                                    var10_9 = var4_4[var16_17];
                                                                                                                    var17_16 = var2_2 + 1;
                                                                                                                    var13_5 = var4_4[var17_16];
                                                                                                                    var18_18 = var2_2 + 2;
                                                                                                                    var9_10 = var4_4[var18_18];
                                                                                                                    var19_19 = var2_2 + 3;
                                                                                                                    var0.rCubicTo(var8_14, var7_13, var10_9, var13_5, var9_10, var4_4[var19_19]);
                                                                                                                    var10_9 = var4_4[var16_17] + var5_11;
                                                                                                                    var7_13 = var4_4[var17_16] + var6_12;
                                                                                                                    var8_14 = var5_11 + var4_4[var18_18];
                                                                                                                    var9_10 = var4_4[var19_19];
                                                                                                                    var5_11 = var10_9;
                                                                                                                    break block43;
                                                                                                                }
                                                                                                                var17_16 = var2_2 + 0;
                                                                                                                var5_11 += var4_4[var17_16];
                                                                                                                var16_17 = var2_2 + 1;
                                                                                                                var6_12 += var4_4[var16_17];
                                                                                                                if (var2_2 <= 0) break block44;
                                                                                                                var0.rLineTo(var4_4[var17_16], var4_4[var16_17]);
                                                                                                                break block42;
                                                                                                            }
                                                                                                            var0.rMoveTo(var4_4[var17_16], var4_4[var16_17]);
                                                                                                            ** GOTO lbl192
                                                                                                        }
                                                                                                        var16_17 = var2_2 + 0;
                                                                                                        var9_10 = var4_4[var16_17];
                                                                                                        var17_16 = var2_2 + 1;
                                                                                                        var0.rLineTo(var9_10, var4_4[var17_16]);
                                                                                                        var5_11 += var4_4[var16_17];
                                                                                                        var9_10 = var4_4[var17_16];
                                                                                                        break block45;
                                                                                                    }
                                                                                                    if (var16_17 == 113 || var16_17 == 116 || var16_17 == 81) break block46;
                                                                                                    var10_9 = var6_12;
                                                                                                    var9_10 = var5_11;
                                                                                                    if (var16_17 != 84) break block47;
                                                                                                }
                                                                                                var9_10 = var5_11 * 2.0f - var7_13;
                                                                                                var10_9 = var6_12 * 2.0f - var8_14;
                                                                                            }
                                                                                            var17_16 = var2_2 + 0;
                                                                                            var5_11 = var4_4[var17_16];
                                                                                            var16_17 = var2_2 + 1;
                                                                                            var0.quadTo(var9_10, var10_9, var5_11, var4_4[var16_17]);
                                                                                            var5_11 = var4_4[var17_16];
                                                                                            var6_12 = var4_4[var16_17];
                                                                                            var8_14 = var10_9;
                                                                                            var7_13 = var9_10;
                                                                                            break block42;
                                                                                        }
                                                                                        if (var16_17 == 99 || var16_17 == 115 || var16_17 == 67) break block48;
                                                                                        var10_9 = var6_12;
                                                                                        var9_10 = var5_11;
                                                                                        if (var16_17 != 83) break block49;
                                                                                    }
                                                                                    var9_10 = var5_11 * 2.0f - var7_13;
                                                                                    var10_9 = var6_12 * 2.0f - var8_14;
                                                                                }
                                                                                var18_18 = var2_2 + 0;
                                                                                var6_12 = var4_4[var18_18];
                                                                                var17_16 = var2_2 + 1;
                                                                                var7_13 = var4_4[var17_16];
                                                                                var16_17 = var2_2 + 2;
                                                                                var5_11 = var4_4[var16_17];
                                                                                var19_19 = var2_2 + 3;
                                                                                var0.cubicTo(var9_10, var10_9, var6_12, var7_13, var5_11, var4_4[var19_19]);
                                                                                var5_11 = var4_4[var18_18];
                                                                                var7_13 = var4_4[var17_16];
                                                                                var9_10 = var4_4[var16_17];
                                                                                var6_12 = var4_4[var19_19];
                                                                                break block50;
                                                                            }
                                                                            var17_16 = var2_2 + 0;
                                                                            var5_11 = var4_4[var17_16];
                                                                            var16_17 = var2_2 + 1;
                                                                            var6_12 = var4_4[var16_17];
                                                                            if (var2_2 > 0) {
                                                                                var0.lineTo(var4_4[var17_16], var4_4[var16_17]);
                                                                            } else {
                                                                                var0.moveTo(var4_4[var17_16], var4_4[var16_17]);
lbl192:
                                                                                // 2 sources

                                                                                var11_7 = var6_12;
                                                                                var12_6 = var5_11;
                                                                            }
                                                                            break block42;
                                                                        }
                                                                        var17_16 = var2_2 + 0;
                                                                        var5_11 = var4_4[var17_16];
                                                                        var16_17 = var2_2 + 1;
                                                                        var0.lineTo(var5_11, var4_4[var16_17]);
                                                                        var5_11 = var4_4[var17_16];
                                                                        var6_12 = var4_4[var16_17];
                                                                        break block42;
                                                                    }
                                                                    var16_17 = var2_2 + 0;
                                                                    var0.rLineTo(0.0f, var4_4[var16_17]);
                                                                    var9_10 = var4_4[var16_17];
                                                                }
                                                                var6_12 += var9_10;
                                                                break block42;
                                                            }
                                                            var19_19 = var2_2 + 0;
                                                            var7_13 = var4_4[var19_19];
                                                            var17_16 = var2_2 + 1;
                                                            var9_10 = var4_4[var17_16];
                                                            var16_17 = var2_2 + 2;
                                                            var8_14 = var4_4[var16_17];
                                                            var18_18 = var2_2 + 3;
                                                            var0.rQuadTo(var7_13, var9_10, var8_14, var4_4[var18_18]);
                                                            var10_9 = var4_4[var19_19] + var5_11;
                                                            var7_13 = var4_4[var17_16] + var6_12;
                                                            var8_14 = var5_11 + var4_4[var16_17];
                                                            var9_10 = var4_4[var18_18];
                                                            var5_11 = var10_9;
                                                            break block43;
                                                        }
                                                        var16_17 = var2_2 + 0;
                                                        var0.rLineTo(var4_4[var16_17], 0.0f);
                                                        var5_11 += var4_4[var16_17];
                                                        break block42;
                                                    }
                                                    var8_14 = var4_4[var2_2 + 0];
                                                    var7_13 = var4_4[var2_2 + 1];
                                                    var19_19 = var2_2 + 2;
                                                    var10_9 = var4_4[var19_19];
                                                    var18_18 = var2_2 + 3;
                                                    var13_5 = var4_4[var18_18];
                                                    var16_17 = var2_2 + 4;
                                                    var9_10 = var4_4[var16_17];
                                                    var17_16 = var2_2 + 5;
                                                    var0.rCubicTo(var8_14, var7_13, var10_9, var13_5, var9_10, var4_4[var17_16]);
                                                    var10_9 = var4_4[var19_19] + var5_11;
                                                    var7_13 = var4_4[var18_18] + var6_12;
                                                    var8_14 = var5_11 + var4_4[var16_17];
                                                    var9_10 = var4_4[var17_16];
                                                    var5_11 = var10_9;
                                                }
                                                var6_12 += var9_10;
                                                var9_10 = var8_14;
                                            }
                                            var8_14 = var7_13;
                                            var7_13 = var5_11;
                                            var5_11 = var9_10;
                                            break block42;
                                        }
                                        var17_16 = var2_2 + 5;
                                        var9_10 = var4_4[var17_16];
                                        var16_17 = var2_2 + 6;
                                        var8_14 = var4_4[var16_17];
                                        var10_9 = var4_4[var2_2 + 0];
                                        var7_13 = var4_4[var2_2 + 1];
                                        var13_5 = var4_4[var2_2 + 2];
                                        var20_20 = var4_4[var2_2 + 3] != 0.0f;
                                        var21_21 = var4_4[var2_2 + 4] != 0.0f;
                                        PathParser.PathDataNode.drawArc(var0, var5_11, var6_12, var9_10 + var5_11, var8_14 + var6_12, var10_9, var7_13, var13_5, var20_20, var21_21);
                                        var5_11 += var4_4[var17_16];
                                        var6_12 += var4_4[var16_17];
                                        break block51;
                                    }
                                    var16_17 = var2_2 + 0;
                                    var0.lineTo(var5_11, var4_4[var16_17]);
                                    var6_12 = var4_4[var16_17];
                                    break block42;
                                }
                                var19_19 = var2_2 + 0;
                                var7_13 = var4_4[var19_19];
                                var17_16 = var2_2 + 1;
                                var6_12 = var4_4[var17_16];
                                var16_17 = var2_2 + 2;
                                var5_11 = var4_4[var16_17];
                                var18_18 = var2_2 + 3;
                                var0.quadTo(var7_13, var6_12, var5_11, var4_4[var18_18]);
                                var7_13 = var4_4[var19_19];
                                var8_14 = var4_4[var17_16];
                                var5_11 = var4_4[var16_17];
                                var6_12 = var4_4[var18_18];
                                break block42;
                            }
                            var16_17 = var2_2 + 0;
                            var0.lineTo(var4_4[var16_17], var6_12);
                            var5_11 = var4_4[var16_17];
                            break block42;
                        }
                        var8_14 = var4_4[var2_2 + 0];
                        var9_10 = var4_4[var2_2 + 1];
                        var16_17 = var2_2 + 2;
                        var5_11 = var4_4[var16_17];
                        var17_16 = var2_2 + 3;
                        var7_13 = var4_4[var17_16];
                        var19_19 = var2_2 + 4;
                        var6_12 = var4_4[var19_19];
                        var18_18 = var2_2 + 5;
                        var0.cubicTo(var8_14, var9_10, var5_11, var7_13, var6_12, var4_4[var18_18]);
                        var5_11 = var4_4[var19_19];
                        var6_12 = var4_4[var18_18];
                        var7_13 = var4_4[var16_17];
                        var8_14 = var4_4[var17_16];
                        break block42;
                    }
                    var17_16 = var2_2 + 5;
                    var9_10 = var4_4[var17_16];
                    var16_17 = var2_2 + 6;
                    var10_9 = var4_4[var16_17];
                    var7_13 = var4_4[var2_2 + 0];
                    var13_5 = var4_4[var2_2 + 1];
                    var8_14 = var4_4[var2_2 + 2];
                    var20_20 = var4_4[var2_2 + 3] != 0.0f;
                    var21_21 = var4_4[var2_2 + 4] != 0.0f;
                    PathParser.PathDataNode.drawArc(var0, var5_11, var6_12, var9_10, var10_9, var7_13, var13_5, var8_14, var20_20, var21_21);
                    var5_11 = var4_4[var17_16];
                    var6_12 = var4_4[var16_17];
                }
                var8_14 = var6_12;
                var7_13 = var5_11;
            }
            var2_2 += var15_15;
            var16_17 = var3_3;
        }
    }

    private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        int n = (int)Math.ceil(Math.abs(d9 * 4.0 / Math.PI));
        double d10 = Math.cos(d7);
        d7 = Math.sin(d7);
        double d11 = Math.cos(d8);
        double d12 = Math.sin(d8);
        double d13 = -d3;
        double d14 = d13 * d10;
        double d15 = d4 * d7;
        d13 *= d7;
        double d16 = d4 * d10;
        d4 = n;
        Double.isNaN(d4);
        double d17 = d9 / d4;
        d4 = d12 * d13 + d11 * d16;
        d12 = d14 * d12 - d15 * d11;
        int n2 = 0;
        d9 = d5;
        d5 = d6;
        d6 = d4;
        d11 = d8;
        d4 = d13;
        d13 = d17;
        d8 = d10;
        while (n2 < n) {
            double d18 = d11 + d13;
            double d19 = Math.sin(d18);
            double d20 = Math.cos(d18);
            double d21 = d + d3 * d8 * d20 - d15 * d19;
            d10 = d2 + d3 * d7 * d20 + d16 * d19;
            d17 = d14 * d19 - d15 * d20;
            d19 = d19 * d4 + d20 * d16;
            d11 = d18 - d11;
            d20 = Math.tan(d11 / 2.0);
            d11 = Math.sin(d11) * (Math.sqrt(d20 * 3.0 * d20 + 4.0) - 1.0) / 3.0;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float)(d9 + d12 * d11), (float)(d5 + d6 * d11), (float)(d21 - d11 * d17), (float)(d10 - d11 * d19), (float)d21, (float)d10);
            ++n2;
            d9 = d21;
            d11 = d18;
            d6 = d19;
            d12 = d17;
            d5 = d10;
        }
    }

    private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean bl, boolean bl2) {
        double d = Math.toRadians(f7);
        double d2 = Math.cos(d);
        double d3 = Math.sin(d);
        double d4 = f;
        Double.isNaN(d4);
        double d5 = f2;
        Double.isNaN(d5);
        double d6 = f5;
        Double.isNaN(d6);
        double d7 = (d4 * d2 + d5 * d3) / d6;
        double d8 = -f;
        Double.isNaN(d8);
        Double.isNaN(d5);
        double d9 = f6;
        Double.isNaN(d9);
        double d10 = (d8 * d3 + d5 * d2) / d9;
        double d11 = f3;
        Double.isNaN(d11);
        d8 = f4;
        Double.isNaN(d8);
        Double.isNaN(d6);
        double d12 = (d11 * d2 + d8 * d3) / d6;
        d11 = -f3;
        Double.isNaN(d11);
        Double.isNaN(d8);
        Double.isNaN(d9);
        double d13 = (d11 * d3 + d8 * d2) / d9;
        double d14 = d7 - d12;
        double d15 = d10 - d13;
        d11 = (d7 + d12) / 2.0;
        d8 = (d10 + d13) / 2.0;
        double d16 = d14 * d14 + d15 * d15;
        if (d16 == 0.0) {
            Log.w((String)"PathParser", (String)" Points are coincident");
            return;
        }
        double d17 = 1.0 / d16 - 0.25;
        if (d17 < 0.0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Points are too far apart ");
            stringBuilder.append(d16);
            Log.w((String)"PathParser", (String)stringBuilder.toString());
            float f8 = (float)(Math.sqrt(d16) / 1.99999);
            PathParser.PathDataNode.drawArc(path, f, f2, f3, f4, f5 * f8, f6 * f8, f7, bl, bl2);
            return;
        }
        d17 = Math.sqrt(d17);
        d14 *= d17;
        d15 = d17 * d15;
        if (bl == bl2) {
            d11 -= d15;
            d8 += d14;
        } else {
            d11 += d15;
            d8 -= d14;
        }
        d15 = Math.atan2(d10 - d8, d7 - d11);
        d10 = Math.atan2(d13 - d8, d12 - d11) - d15;
        bl = d10 >= 0.0;
        d7 = d10;
        if (bl2 != bl) {
            d7 = d10 > 0.0 ? d10 - Math.PI * 2 : d10 + Math.PI * 2;
        }
        Double.isNaN(d6);
        Double.isNaN(d9);
        PathParser.PathDataNode.arcToBezier(path, (d11 *= d6) * d2 - (d8 *= d9) * d3, d11 * d3 + d8 * d2, d6, d9, d4, d5, d, d15, d7);
    }

    public static void nodesToPath(PathParser.PathDataNode[] pathDataNodeArray, Path path) {
        float[] fArray = new float[6];
        char c = 'm';
        int n = 0;
        while (n < pathDataNodeArray.length) {
            PathParser.PathDataNode.addCommand(path, fArray, c, pathDataNodeArray[n].mType, pathDataNodeArray[n].mParams);
            c = pathDataNodeArray[n].mType;
            ++n;
        }
    }

    public void interpolatePathDataNode(PathParser.PathDataNode pathDataNode, PathParser.PathDataNode pathDataNode2, float f) {
        float[] fArray;
        this.mType = pathDataNode.mType;
        int n = 0;
        while (n < (fArray = pathDataNode.mParams).length) {
            this.mParams[n] = fArray[n] * (1.0f - f) + pathDataNode2.mParams[n] * f;
            ++n;
        }
    }
}
