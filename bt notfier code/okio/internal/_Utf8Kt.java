/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2={"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _Utf8Kt {
    /*
     * Unable to fully structure code
     */
    public static final byte[] commonAsUtf8ToByteArray(String var0) {
        Intrinsics.checkNotNullParameter((Object)var0, (String)"<this>");
        var9_1 = new byte[var0.length() * 4];
        var4_2 = var0.length();
        if (var4_2 > 0) {
            var2_3 = 0;
            while (true) {
                var3_4 = var2_3 + 1;
                var5_5 = var0.charAt(var2_3);
                if (Intrinsics.compare((int)var5_5, (int)128) < 0) {
                    var9_1[var2_3] = (byte)var5_5;
                    if (var3_4 >= var4_2) break;
                    var2_3 = var3_4;
                    continue;
                }
                break;
            }
        } else {
            var0 = Arrays.copyOf(var9_1, var0.length());
            Intrinsics.checkNotNullExpressionValue((Object)var0, (String)"java.util.Arrays.copyOf(this, newSize)");
            return var0;
        }
        var6_6 = var0.length();
        var4_2 = var2_3;
        var3_4 = var2_3;
        block1: while (true) {
            block11: {
                block10: {
                    if (var3_4 >= var6_6) {
                        var0 = Arrays.copyOf(var9_1, var4_2);
                        Intrinsics.checkNotNullExpressionValue((Object)var0, (String)"java.util.Arrays.copyOf(this, newSize)");
                        return var0;
                    }
                    var7_8 = var0.charAt(var3_4);
                    if (Intrinsics.compare((int)var7_8, (int)128) < 0) {
                        var1_7 = (byte)var7_8;
                        var2_3 = var4_2 + 1;
                        var9_1[var4_2] = var1_7;
                        var4_2 = var3_4 + 1;
                        var3_4 = var2_3;
                        var2_3 = var4_2;
                        while (true) {
                            var5_5 = var3_4;
                            var3_4 = var2_3;
                            var4_2 = var5_5;
                            if (var2_3 >= var6_6) continue block1;
                            var3_4 = var2_3;
                            var4_2 = var5_5;
                            if (Intrinsics.compare((int)var0.charAt(var2_3), (int)128) >= 0) continue block1;
                            var1_7 = (byte)var0.charAt(var2_3);
                            var3_4 = var5_5 + 1;
                            var9_1[var5_5] = var1_7;
                            ++var2_3;
                        }
                    }
                    if (Intrinsics.compare((int)var7_8, (int)2048) >= 0) break block10;
                    var1_7 = (byte)(var7_8 >> 6 | 192);
                    var5_5 = var4_2 + 1;
                    var9_1[var4_2] = var1_7;
                    var1_7 = (byte)(var7_8 & 63 | 128);
                    var2_3 = var5_5 + 1;
                    var9_1[var5_5] = var1_7;
                    ** GOTO lbl88
                }
                var5_5 = 1;
                var2_3 = 55296 <= var7_8 && var7_8 <= 57343 ? 1 : 0;
                if (var2_3 != 0) break block11;
                var1_7 = (byte)(var7_8 >> 12 | 224);
                var2_3 = var4_2 + 1;
                var9_1[var4_2] = var1_7;
                var1_7 = (byte)(var7_8 >> 6 & 63 | 128);
                var4_2 = var2_3 + 1;
                var9_1[var2_3] = var1_7;
                var1_7 = (byte)(var7_8 & 63 | 128);
                var2_3 = var4_2 + 1;
                var9_1[var4_2] = var1_7;
                ** GOTO lbl88
            }
            if (Intrinsics.compare((int)var7_8, (int)56319) <= 0 && var6_6 > (var8_9 = var3_4 + 1) && (var2_3 = 56320 <= (var2_3 = (int)var0.charAt(var8_9)) && var2_3 <= 57343 ? var5_5 : 0) != 0) {
                var2_3 = (var7_8 << 10) + var0.charAt(var8_9) - 56613888;
                var1_7 = (byte)(var2_3 >> 18 | 240);
                var7_8 = var4_2 + 1;
                var9_1[var4_2] = var1_7;
                var1_7 = (byte)(var2_3 >> 12 & 63 | 128);
                var5_5 = var7_8 + 1;
                var9_1[var7_8] = var1_7;
                var1_7 = (byte)(var2_3 >> 6 & 63 | 128);
                var4_2 = var5_5 + 1;
                var9_1[var5_5] = var1_7;
                var1_7 = (byte)(var2_3 & 63 | 128);
                var2_3 = var4_2 + 1;
                var9_1[var4_2] = var1_7;
                var3_4 += 2;
            } else {
                var2_3 = var4_2 + 1;
                var9_1[var4_2] = 63;
lbl88:
                // 3 sources

                ++var3_4;
            }
            var4_2 = var2_3;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final String commonToUtf8String(byte[] var0, int var1_1, int var2_2) {
        var4_3 = var1_1;
        Intrinsics.checkNotNullParameter((Object)var0 /* !! */ , (String)"<this>");
        if (var4_3 < 0 || var2_2 > var0 /* !! */ .length || var4_3 > var2_2) {
            var10_5 = new StringBuilder();
            var10_5.append("size=");
            var10_5.append(var0 /* !! */ .length);
            var10_5.append(" beginIndex=");
            var10_5.append(var4_3);
            var10_5.append(" endIndex=");
            var10_5.append(var2_2);
            var0 /* !! */  = (byte[])new ArrayIndexOutOfBoundsException(var10_5.toString());
            throw var0 /* !! */ ;
        }
        var10_4 = new char[var2_2 - var4_3];
        var1_1 = 0;
        block0: while (var4_3 < var2_2) {
            block32: {
                block33: {
                    block34: {
                        block28: {
                            block31: {
                                block30: {
                                    block29: {
                                        block24: {
                                            block27: {
                                                block26: {
                                                    block25: {
                                                        var5_7 = var0 /* !! */ [var4_3];
                                                        if (var5_7 >= 0) {
                                                            var3_6 = (char)var5_7;
                                                            var5_7 = var1_1 + 1;
                                                            var10_4[var1_1] = var3_6;
                                                            var1_1 = var5_7;
                                                            var5_7 = ++var4_3;
                                                            while (true) {
                                                                var6_8 = var1_1;
                                                                var4_3 = var5_7;
                                                                var1_1 = var6_8;
                                                                if (var5_7 >= var2_2) continue block0;
                                                                var4_3 = var5_7;
                                                                var1_1 = var6_8;
                                                                if (var0 /* !! */ [var5_7] < 0) continue block0;
                                                                var3_6 = (char)var0 /* !! */ [var5_7];
                                                                var1_1 = var6_8 + 1;
                                                                var10_4[var6_8] = var3_6;
                                                                ++var5_7;
                                                            }
                                                        }
                                                        if (var5_7 >> 5 != -2) break block24;
                                                        var5_7 = var4_3 + 1;
                                                        if (var2_2 > var5_7) break block25;
                                                        var3_6 = (char)65533;
                                                        var5_7 = var1_1 + 1;
                                                        var10_4[var1_1] = var3_6;
                                                        var1_1 = var5_7;
                                                        break block26;
                                                    }
                                                    var6_8 = var0 /* !! */ [var4_3];
                                                    var7_9 = var0 /* !! */ [var5_7];
                                                    if ((var5_7 = (var7_9 & 192) == 128 ? 1 : 0) != 0) break block27;
                                                    var3_6 = (char)65533;
                                                    var5_7 = var1_1 + 1;
                                                    var10_4[var1_1] = var3_6;
                                                    var1_1 = var5_7;
                                                }
                                                var11_12 = Unit.INSTANCE;
                                                ** GOTO lbl163
                                            }
                                            var5_7 = var7_9 ^ 3968 ^ var6_8 << 6;
                                            if (var5_7 < 128) {
                                                var3_6 = (char)65533;
                                                var5_7 = var1_1 + 1;
                                                var10_4[var1_1] = var3_6;
                                                var1_1 = var5_7;
                                            } else {
                                                var3_6 = (char)var5_7;
                                                var5_7 = var1_1 + 1;
                                                var10_4[var1_1] = var3_6;
                                                var1_1 = var5_7;
                                            }
                                            var11_12 = Unit.INSTANCE;
                                            ** GOTO lbl172
                                        }
                                        if (var5_7 >> 4 != -2) break block28;
                                        var8_10 = var4_3 + 2;
                                        if (var2_2 > var8_10) break block29;
                                        var3_6 = (char)65533;
                                        var5_7 = var1_1 + 1;
                                        var10_4[var1_1] = var3_6;
                                        var11_12 = Unit.INSTANCE;
                                        var6_8 = var4_3 + 1;
                                        var1_1 = var5_7;
                                        if (var2_2 <= var6_8) ** GOTO lbl163
                                        var6_8 = (var0 /* !! */ [var6_8] & 192) == 128 ? 1 : 0;
                                        var1_1 = var5_7;
                                        if (var6_8 != 0) ** GOTO lbl172
                                        var1_1 = var5_7;
                                        ** GOTO lbl163
                                    }
                                    var7_9 = var0 /* !! */ [var4_3];
                                    var6_8 = var0 /* !! */ [var4_3 + 1];
                                    var5_7 = (var6_8 & 192) == 128 ? 1 : 0;
                                    if (var5_7 != 0) break block30;
                                    var3_6 = (char)65533;
                                    var5_7 = var1_1 + 1;
                                    var10_4[var1_1] = var3_6;
                                    var11_12 = Unit.INSTANCE;
                                    var1_1 = var5_7;
                                    ** GOTO lbl163
                                }
                                var5_7 = ((var8_10 = var0 /* !! */ [var8_10]) & 192) == 128 ? 1 : 0;
                                if (var5_7 != 0) break block31;
                                var3_6 = (char)65533;
                                var5_7 = var1_1 + 1;
                                var10_4[var1_1] = var3_6;
                                var11_12 = Unit.INSTANCE;
                                var1_1 = var5_7;
                                ** GOTO lbl172
                            }
                            if ((var6_8 = var8_10 ^ -123008 ^ var6_8 << 6 ^ var7_9 << 12) < 2048) {
                                var3_6 = (char)65533;
                                var5_7 = var1_1 + 1;
                                var10_4[var1_1] = var3_6;
                                var1_1 = var5_7;
                            } else {
                                var5_7 = 55296 <= var6_8 && var6_8 <= 57343 ? 1 : 0;
                                if (var5_7 != 0) {
                                    var3_6 = (char)65533;
                                    var5_7 = var1_1 + 1;
                                    var10_4[var1_1] = var3_6;
                                    var1_1 = var5_7;
                                } else {
                                    var3_6 = (char)var6_8;
                                    var5_7 = var1_1 + 1;
                                    var10_4[var1_1] = var3_6;
                                    var1_1 = var5_7;
                                }
                            }
                            var11_12 = Unit.INSTANCE;
                            ** GOTO lbl180
                        }
                        if (var5_7 >> 3 != -2) break block32;
                        var9_11 = var4_3 + 3;
                        if (var2_2 > var9_11) break block33;
                        var5_7 = var1_1 + 1;
                        var10_4[var1_1] = 65533;
                        var11_12 = Unit.INSTANCE;
                        var6_8 = var4_3 + 1;
                        var1_1 = var5_7;
                        if (var2_2 <= var6_8) ** GOTO lbl163
                        var1_1 = (var0 /* !! */ [var6_8] & 192) == 128 ? 1 : 0;
                        if (var1_1 != 0) break block34;
                        var1_1 = var5_7;
                        ** GOTO lbl163
                    }
                    var6_8 = var4_3 + 2;
                    var1_1 = var5_7;
                    if (var2_2 <= var6_8) ** GOTO lbl172
                    var6_8 = (var0 /* !! */ [var6_8] & 192) == 128 ? 1 : 0;
                    var1_1 = var5_7;
                    if (var6_8 != 0) ** GOTO lbl180
                    var1_1 = var5_7;
                    ** GOTO lbl172
                }
                var6_8 = var0 /* !! */ [var4_3];
                var7_9 = var0 /* !! */ [var4_3 + 1];
                var5_7 = (var7_9 & 192) == 128 ? 1 : 0;
                if (var5_7 == 0) {
                    var5_7 = var1_1 + 1;
                    var10_4[var1_1] = 65533;
                    var11_12 = Unit.INSTANCE;
                    var1_1 = var5_7;
lbl163:
                    // 7 sources

                    var5_7 = 1;
                } else {
                    var8_10 = var0 /* !! */ [var4_3 + 2];
                    var5_7 = (var8_10 & 192) == 128 ? 1 : 0;
                    if (var5_7 == 0) {
                        var5_7 = var1_1 + 1;
                        var10_4[var1_1] = 65533;
                        var11_12 = Unit.INSTANCE;
                        var1_1 = var5_7;
lbl172:
                        // 6 sources

                        var5_7 = 2;
                    } else {
                        var5_7 = ((var9_11 = var0 /* !! */ [var9_11]) & 192) == 128 ? 1 : 0;
                        if (var5_7 == 0) {
                            var5_7 = var1_1 + 1;
                            var10_4[var1_1] = 65533;
                            var11_12 = Unit.INSTANCE;
                            var1_1 = var5_7;
lbl180:
                            // 3 sources

                            var5_7 = 3;
                        } else {
                            if ((var6_8 = var9_11 ^ 3678080 ^ var8_10 << 6 ^ var7_9 << 12 ^ var6_8 << 18) > 0x10FFFF) {
                                var5_7 = var1_1 + 1;
                                var10_4[var1_1] = 65533;
                                var1_1 = var5_7;
                            } else {
                                var5_7 = 55296 <= var6_8 && var6_8 <= 57343 ? 1 : 0;
                                if (var5_7 != 0) {
                                    var5_7 = var1_1 + 1;
                                    var10_4[var1_1] = 65533;
                                    var1_1 = var5_7;
                                } else if (var6_8 < 65536) {
                                    var5_7 = var1_1 + 1;
                                    var10_4[var1_1] = 65533;
                                    var1_1 = var5_7;
                                } else if (var6_8 != 65533) {
                                    var3_6 = (char)((var6_8 >>> 10) + 55232);
                                    var5_7 = var1_1 + 1;
                                    var10_4[var1_1] = var3_6;
                                    var3_6 = (char)((var6_8 & 1023) + 56320);
                                    var1_1 = var5_7 + 1;
                                    var10_4[var5_7] = var3_6;
                                } else {
                                    var5_7 = var1_1 + 1;
                                    var10_4[var1_1] = 65533;
                                    var1_1 = var5_7;
                                }
                            }
                            var11_12 = Unit.INSTANCE;
                            var5_7 = 4;
                        }
                    }
                }
                var4_3 += var5_7;
                continue;
            }
            var10_4[var1_1] = 65533;
            ++var4_3;
            ++var1_1;
        }
        return StringsKt.concatToString((char[])var10_4, (int)0, (int)var1_1);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] byArray, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) == 0) return _Utf8Kt.commonToUtf8String(byArray, n, n2);
        n2 = byArray.length;
        return _Utf8Kt.commonToUtf8String(byArray, n, n2);
    }
}
