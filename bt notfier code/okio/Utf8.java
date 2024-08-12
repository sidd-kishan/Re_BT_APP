/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\b\u00f8\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007\u00a2\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006 "}, d2={"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '\ufffd';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int n) {
        boolean bl = true;
        boolean bl2 = n >= 0 && n <= 31;
        boolean bl3 = bl;
        if (bl2) return bl3;
        n = 127 <= n && n <= 159 ? 1 : 0;
        bl3 = n != 0 ? bl : false;
        return bl3;
    }

    public static final boolean isUtf8Continuation(byte by) {
        boolean bl = (by & 0xC0) == 128;
        return bl;
    }

    public static final int process2Utf8Bytes(byte[] byArray, int n, int n2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"yield");
        int n3 = n + 1;
        Integer n4 = 65533;
        if (n2 <= n3) {
            function1.invoke((Object)n4);
            return 1;
        }
        n2 = byArray[n];
        n = ((n3 = byArray[n3]) & 0xC0) == 128 ? 1 : 0;
        if (n == 0) {
            function1.invoke((Object)n4);
            return 1;
        }
        n = n3 ^ 0xF80 ^ n2 << 6;
        if (n < 128) {
            function1.invoke((Object)n4);
        } else {
            function1.invoke((Object)n);
        }
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] byArray, int n, int n2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"yield");
        int n3 = n + 2;
        int n4 = 0;
        int n5 = 0;
        Integer n6 = 65533;
        if (n2 <= n3) {
            function1.invoke((Object)n6);
            n4 = n + 1;
            if (n2 <= n4) return 1;
            n = n5;
            if ((byArray[n4] & 0xC0) == 128) {
                n = 1;
            }
            if (n != 0) return 2;
            return 1;
        }
        n2 = byArray[n];
        n5 = byArray[n + 1];
        if ((n = (n5 & 0xC0) == 128 ? 1 : 0) == 0) {
            function1.invoke((Object)n6);
            return 1;
        }
        n = ((n3 = byArray[n3]) & 0xC0) == 128 ? 1 : 0;
        if (n == 0) {
            function1.invoke((Object)n6);
            return 2;
        }
        if ((n2 = n3 ^ 0xFFFE1F80 ^ n5 << 6 ^ n2 << 12) < 2048) {
            function1.invoke((Object)n6);
        } else {
            n = n4;
            if (55296 <= n2) {
                n = n4;
                if (n2 <= 57343) {
                    n = 1;
                }
            }
            if (n != 0) {
                function1.invoke((Object)n6);
            } else {
                function1.invoke((Object)n2);
            }
        }
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] byArray, int n, int n2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"yield");
        int n3 = n + 3;
        int n4 = 0;
        int n5 = 0;
        Integer n6 = 65533;
        if (n2 <= n3) {
            function1.invoke((Object)n6);
            n4 = n + 1;
            if (n2 <= n4) return 1;
            n4 = (byArray[n4] & 0xC0) == 128 ? 1 : 0;
            if (n4 == 0) {
                return 1;
            }
            n4 = n + 2;
            if (n2 <= n4) return 2;
            n = n5;
            if ((byArray[n4] & 0xC0) == 128) {
                n = 1;
            }
            if (n != 0) return 3;
            return 2;
        }
        byte by = byArray[n];
        n5 = byArray[n + 1];
        n2 = (n5 & 0xC0) == 128 ? 1 : 0;
        if (n2 == 0) {
            function1.invoke((Object)n6);
            return 1;
        }
        n2 = byArray[n + 2];
        if ((n = (n2 & 0xC0) == 128 ? 1 : 0) == 0) {
            function1.invoke((Object)n6);
            return 2;
        }
        n = ((n3 = byArray[n3]) & 0xC0) == 128 ? 1 : 0;
        if (n == 0) {
            function1.invoke((Object)n6);
            return 3;
        }
        if ((n2 = n3 ^ 0x381F80 ^ n2 << 6 ^ n5 << 12 ^ by << 18) > 0x10FFFF) {
            function1.invoke((Object)n6);
        } else {
            n = n4;
            if (55296 <= n2) {
                n = n4;
                if (n2 <= 57343) {
                    n = 1;
                }
            }
            if (n != 0) {
                function1.invoke((Object)n6);
            } else if (n2 < 65536) {
                function1.invoke((Object)n6);
            } else {
                function1.invoke((Object)n2);
            }
        }
        return 4;
    }

    /*
     * Unable to fully structure code
     */
    public static final void processUtf16Chars(byte[] var0, int var1_1, int var2_2, Function1<? super Character, Unit> var3_3) {
        Intrinsics.checkNotNullParameter((Object)var0, (String)"<this>");
        Intrinsics.checkNotNullParameter(var3_3, (String)"yield");
        block0: while (var1_1 < var2_2) {
            block24: {
                block27: {
                    block29: {
                        block23: {
                            block28: {
                                block18: {
                                    block26: {
                                        block17: {
                                            block25: {
                                                block19: {
                                                    block22: {
                                                        block21: {
                                                            block20: {
                                                                block14: {
                                                                    block16: {
                                                                        block15: {
                                                                            var10_10 = var0[var1_1];
                                                                            if (var10_10 >= 0) {
                                                                                var3_3.invoke((Object)Character.valueOf((char)var10_10));
                                                                                var5_5 = var1_1 + 1;
                                                                                while (true) {
                                                                                    var1_1 = var5_5;
                                                                                    if (var5_5 >= var2_2) continue block0;
                                                                                    var1_1 = var5_5;
                                                                                    if (var0[var5_5] < 0) continue block0;
                                                                                    var3_3.invoke((Object)Character.valueOf((char)var0[var5_5]));
                                                                                    ++var5_5;
                                                                                }
                                                                            }
                                                                            var9_9 = 0;
                                                                            var7_7 = 0;
                                                                            var8_8 = 0;
                                                                            var6_6 = 0;
                                                                            var5_5 = 0;
                                                                            if (var10_10 >> 5 != -2) break block14;
                                                                            var7_7 = var1_1 + 1;
                                                                            if (var2_2 <= var7_7) break block15;
                                                                            var6_6 = var0[var1_1];
                                                                            if (((var7_7 = var0[var7_7]) & 192) == 128) {
                                                                                var5_5 = 1;
                                                                            }
                                                                            if (var5_5 != 0) break block16;
                                                                        }
                                                                        var3_3.invoke((Object)Character.valueOf((char)65533));
                                                                        var11_11 = Unit.INSTANCE;
                                                                        break block17;
                                                                    }
                                                                    var5_5 = var7_7 ^ 3968 ^ var6_6 << 6;
                                                                    var4_4 = var5_5 < 128 ? (char)65533 : (char)var5_5;
                                                                    var3_3.invoke((Object)Character.valueOf(var4_4));
                                                                    var11_11 = Unit.INSTANCE;
                                                                    break block18;
                                                                }
                                                                if (var10_10 >> 4 != -2) break block19;
                                                                var10_10 = var1_1 + 2;
                                                                if (var2_2 > var10_10) break block20;
                                                                var3_3.invoke((Object)Character.valueOf((char)65533));
                                                                var11_11 = Unit.INSTANCE;
                                                                var6_6 = var1_1 + 1;
                                                                if (var2_2 <= var6_6) break block17;
                                                                var5_5 = var9_9;
                                                                if ((var0[var6_6] & 192) == 128) {
                                                                    var5_5 = 1;
                                                                }
                                                                if (var5_5 != 0) break block18;
                                                                break block17;
                                                            }
                                                            var8_8 = var0[var1_1];
                                                            var6_6 = var0[var1_1 + 1];
                                                            var5_5 = (var6_6 & 192) == 128 ? 1 : 0;
                                                            if (var5_5 != 0) break block21;
                                                            var3_3.invoke((Object)Character.valueOf((char)65533));
                                                            var11_11 = Unit.INSTANCE;
                                                            break block17;
                                                        }
                                                        var9_9 = var0[var10_10];
                                                        var5_5 = (var9_9 & 192) == 128 ? 1 : 0;
                                                        if (var5_5 != 0) break block22;
                                                        var3_3.invoke((Object)Character.valueOf((char)65533));
                                                        var11_11 = Unit.INSTANCE;
                                                        break block18;
                                                    }
                                                    if ((var6_6 = var9_9 ^ -123008 ^ var6_6 << 6 ^ var8_8 << 12) < 2048) ** GOTO lbl-1000
                                                    var5_5 = var7_7;
                                                    if (55296 <= var6_6) {
                                                        var5_5 = var7_7;
                                                        if (var6_6 <= 57343) {
                                                            var5_5 = 1;
                                                        }
                                                    }
                                                    if (var5_5 != 0) lbl-1000:
                                                    // 2 sources

                                                    {
                                                        var4_4 = (char)65533;
                                                    } else {
                                                        var4_4 = (char)var6_6;
                                                    }
                                                    var3_3.invoke((Object)Character.valueOf(var4_4));
                                                    var11_11 = Unit.INSTANCE;
                                                    break block23;
                                                }
                                                if (var10_10 >> 3 != -2) break block24;
                                                var9_9 = var1_1 + 3;
                                                if (var2_2 > var9_9) break block25;
                                                var3_3.invoke((Object)Character.valueOf('\ufffd'));
                                                var11_11 = Unit.INSTANCE;
                                                var5_5 = var1_1 + 1;
                                                if (var2_2 <= var5_5 || (var5_5 = (var0[var5_5] & 192) == 128 ? 1 : 0) == 0) break block17;
                                                var6_6 = var1_1 + 2;
                                                if (var2_2 <= var6_6) break block18;
                                                var5_5 = var8_8;
                                                if ((var0[var6_6] & 192) == 128) {
                                                    var5_5 = 1;
                                                }
                                                if (var5_5 != 0) break block23;
                                                break block18;
                                            }
                                            var7_7 = var0[var1_1];
                                            var8_8 = var0[var1_1 + 1];
                                            var5_5 = (var8_8 & 192) == 128 ? 1 : 0;
                                            if (var5_5 != 0) break block26;
                                            var3_3.invoke((Object)Character.valueOf('\ufffd'));
                                            var11_11 = Unit.INSTANCE;
                                        }
                                        var5_5 = 1;
                                        break block27;
                                    }
                                    var10_10 = var0[var1_1 + 2];
                                    var5_5 = (var10_10 & 192) == 128 ? 1 : 0;
                                    if (var5_5 != 0) break block28;
                                    var3_3.invoke((Object)Character.valueOf('\ufffd'));
                                    var11_11 = Unit.INSTANCE;
                                }
                                var5_5 = 2;
                                break block27;
                            }
                            var5_5 = ((var9_9 = var0[var9_9]) & 192) == 128 ? 1 : 0;
                            if (var5_5 != 0) break block29;
                            var3_3.invoke((Object)Character.valueOf('\ufffd'));
                            var11_11 = Unit.INSTANCE;
                        }
                        var5_5 = 3;
                        break block27;
                    }
                    if ((var7_7 = var9_9 ^ 3678080 ^ var10_10 << 6 ^ var8_8 << 12 ^ var7_7 << 18) > 0x10FFFF) ** GOTO lbl-1000
                    var5_5 = var6_6;
                    if (55296 <= var7_7) {
                        var5_5 = var6_6;
                        if (var7_7 <= 57343) {
                            var5_5 = 1;
                        }
                    }
                    if (var5_5 == 0 && var7_7 >= 65536 && var7_7 != 65533) {
                        var3_3.invoke((Object)Character.valueOf((char)((var7_7 >>> 10) + 55232)));
                        var3_3.invoke((Object)Character.valueOf((char)((var7_7 & 1023) + 56320)));
                    } else lbl-1000:
                    // 2 sources

                    {
                        var3_3.invoke((Object)Character.valueOf('\ufffd'));
                    }
                    var11_11 = Unit.INSTANCE;
                    var5_5 = 4;
                }
                var1_1 += var5_5;
                continue;
            }
            var3_3.invoke((Object)Character.valueOf('\ufffd'));
            ++var1_1;
        }
    }

    public static final void processUtf8Bytes(String string, int n, int n2, Function1<? super Byte, Unit> function1) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"yield");
        block0: while (n < n2) {
            int n3;
            char c = string.charAt(n);
            if (Intrinsics.compare((int)c, (int)128) < 0) {
                function1.invoke((Object)((byte)c));
                n3 = n + 1;
                while (true) {
                    n = n3;
                    if (n3 >= n2) continue block0;
                    n = n3;
                    if (Intrinsics.compare((int)string.charAt(n3), (int)128) >= 0) continue block0;
                    function1.invoke((Object)((byte)string.charAt(n3)));
                    ++n3;
                }
            }
            if (Intrinsics.compare((int)c, (int)2048) < 0) {
                function1.invoke((Object)((byte)(c >> 6 | 0xC0)));
                function1.invoke((Object)((byte)(c & 0x3F | 0x80)));
            } else {
                int n4 = 0;
                n3 = '\ud800' <= c && c <= '\udfff' ? 1 : 0;
                if (n3 == 0) {
                    function1.invoke((Object)((byte)(c >> 12 | 0xE0)));
                    function1.invoke((Object)((byte)(c >> 6 & 0x3F | 0x80)));
                    function1.invoke((Object)((byte)(c & 0x3F | 0x80)));
                } else {
                    int n5;
                    if (Intrinsics.compare((int)c, (int)56319) <= 0 && n2 > (n5 = n + 1)) {
                        char c2 = string.charAt(n5);
                        n3 = n4;
                        if ('\udc00' <= c2) {
                            n3 = n4;
                            if (c2 <= '\udfff') {
                                n3 = 1;
                            }
                        }
                        if (n3 != 0) {
                            n3 = (c << 10) + string.charAt(n5) - 56613888;
                            function1.invoke((Object)((byte)(n3 >> 18 | 0xF0)));
                            function1.invoke((Object)((byte)(n3 >> 12 & 0x3F | 0x80)));
                            function1.invoke((Object)((byte)(n3 >> 6 & 0x3F | 0x80)));
                            function1.invoke((Object)((byte)(n3 & 0x3F | 0x80)));
                            n += 2;
                            continue;
                        }
                    }
                    function1.invoke((Object)63);
                }
            }
            ++n;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final void processUtf8CodePoints(byte[] var0, int var1_1, int var2_2, Function1<? super Integer, Unit> var3_3) {
        Intrinsics.checkNotNullParameter((Object)var0, (String)"<this>");
        Intrinsics.checkNotNullParameter(var3_3, (String)"yield");
        block0: while (var1_1 < var2_2) {
            block24: {
                block27: {
                    block29: {
                        block23: {
                            block28: {
                                block18: {
                                    block26: {
                                        block17: {
                                            block25: {
                                                block19: {
                                                    block22: {
                                                        block21: {
                                                            block20: {
                                                                block14: {
                                                                    block16: {
                                                                        block15: {
                                                                            var9_9 = var0[var1_1];
                                                                            if (var9_9 >= 0) {
                                                                                var3_3.invoke((Object)var9_9);
                                                                                var4_4 = var1_1 + 1;
                                                                                while (true) {
                                                                                    var1_1 = var4_4;
                                                                                    if (var4_4 >= var2_2) continue block0;
                                                                                    var1_1 = var4_4;
                                                                                    if (var0[var4_4] < 0) continue block0;
                                                                                    var3_3.invoke((Object)((int)var0[var4_4]));
                                                                                    ++var4_4;
                                                                                }
                                                                            }
                                                                            var8_8 = 0;
                                                                            var6_6 = 0;
                                                                            var7_7 = 0;
                                                                            var5_5 = 0;
                                                                            var4_4 = 0;
                                                                            if (var9_9 >> 5 != -2) break block14;
                                                                            var6_6 = var1_1 + 1;
                                                                            if (var2_2 <= var6_6) break block15;
                                                                            var5_5 = var0[var1_1];
                                                                            if (((var6_6 = var0[var6_6]) & 192) == 128) {
                                                                                var4_4 = 1;
                                                                            }
                                                                            if (var4_4 != 0) break block16;
                                                                        }
                                                                        var3_3.invoke((Object)65533);
                                                                        var10_10 /* !! */  = Unit.INSTANCE;
                                                                        break block17;
                                                                    }
                                                                    var4_4 = var6_6 ^ 3968 ^ var5_5 << 6;
                                                                    var10_10 /* !! */  = var4_4 < 128 ? Integer.valueOf(65533) : Integer.valueOf(var4_4);
                                                                    var3_3.invoke((Object)var10_10 /* !! */ );
                                                                    var10_10 /* !! */  = Unit.INSTANCE;
                                                                    break block18;
                                                                }
                                                                if (var9_9 >> 4 != -2) break block19;
                                                                var9_9 = var1_1 + 2;
                                                                if (var2_2 > var9_9) break block20;
                                                                var3_3.invoke((Object)65533);
                                                                var10_10 /* !! */  = Unit.INSTANCE;
                                                                var5_5 = var1_1 + 1;
                                                                if (var2_2 <= var5_5) break block17;
                                                                var4_4 = var8_8;
                                                                if ((var0[var5_5] & 192) == 128) {
                                                                    var4_4 = 1;
                                                                }
                                                                if (var4_4 != 0) break block18;
                                                                break block17;
                                                            }
                                                            var5_5 = var0[var1_1];
                                                            var7_7 = var0[var1_1 + 1];
                                                            var4_4 = (var7_7 & 192) == 128 ? 1 : 0;
                                                            if (var4_4 != 0) break block21;
                                                            var3_3.invoke((Object)65533);
                                                            var10_10 /* !! */  = Unit.INSTANCE;
                                                            break block17;
                                                        }
                                                        var8_8 = var0[var9_9];
                                                        var4_4 = (var8_8 & 192) == 128 ? 1 : 0;
                                                        if (var4_4 != 0) break block22;
                                                        var3_3.invoke((Object)65533);
                                                        var10_10 /* !! */  = Unit.INSTANCE;
                                                        break block18;
                                                    }
                                                    if ((var5_5 = var8_8 ^ -123008 ^ var7_7 << 6 ^ var5_5 << 12) < 2048) ** GOTO lbl-1000
                                                    var4_4 = var6_6;
                                                    if (55296 <= var5_5) {
                                                        var4_4 = var6_6;
                                                        if (var5_5 <= 57343) {
                                                            var4_4 = 1;
                                                        }
                                                    }
                                                    if (var4_4 != 0) lbl-1000:
                                                    // 2 sources

                                                    {
                                                        var10_10 /* !! */  = Integer.valueOf(65533);
                                                    } else {
                                                        var10_10 /* !! */  = Integer.valueOf(var5_5);
                                                    }
                                                    var3_3.invoke((Object)var10_10 /* !! */ );
                                                    var10_10 /* !! */  = Unit.INSTANCE;
                                                    break block23;
                                                }
                                                if (var9_9 >> 3 != -2) break block24;
                                                var8_8 = var1_1 + 3;
                                                if (var2_2 > var8_8) break block25;
                                                var3_3.invoke((Object)65533);
                                                var10_10 /* !! */  = Unit.INSTANCE;
                                                var4_4 = var1_1 + 1;
                                                if (var2_2 <= var4_4 || (var4_4 = (var0[var4_4] & 192) == 128 ? 1 : 0) == 0) break block17;
                                                var5_5 = var1_1 + 2;
                                                if (var2_2 <= var5_5) break block18;
                                                var4_4 = var7_7;
                                                if ((var0[var5_5] & 192) == 128) {
                                                    var4_4 = 1;
                                                }
                                                if (var4_4 != 0) break block23;
                                                break block18;
                                            }
                                            var6_6 = var0[var1_1];
                                            var7_7 = var0[var1_1 + 1];
                                            var4_4 = (var7_7 & 192) == 128 ? 1 : 0;
                                            if (var4_4 != 0) break block26;
                                            var3_3.invoke((Object)65533);
                                            var10_10 /* !! */  = Unit.INSTANCE;
                                        }
                                        var4_4 = 1;
                                        break block27;
                                    }
                                    var9_9 = var0[var1_1 + 2];
                                    var4_4 = (var9_9 & 192) == 128 ? 1 : 0;
                                    if (var4_4 != 0) break block28;
                                    var3_3.invoke((Object)65533);
                                    var10_10 /* !! */  = Unit.INSTANCE;
                                }
                                var4_4 = 2;
                                break block27;
                            }
                            var4_4 = ((var8_8 = var0[var8_8]) & 192) == 128 ? 1 : 0;
                            if (var4_4 != 0) break block29;
                            var3_3.invoke((Object)65533);
                            var10_10 /* !! */  = Unit.INSTANCE;
                        }
                        var4_4 = 3;
                        break block27;
                    }
                    if ((var6_6 = var8_8 ^ 3678080 ^ var9_9 << 6 ^ var7_7 << 12 ^ var6_6 << 18) > 0x10FFFF) ** GOTO lbl-1000
                    var4_4 = var5_5;
                    if (55296 <= var6_6) {
                        var4_4 = var5_5;
                        if (var6_6 <= 57343) {
                            var4_4 = 1;
                        }
                    }
                    if (var4_4 != 0 || var6_6 < 65536) lbl-1000:
                    // 2 sources

                    {
                        var10_10 /* !! */  = Integer.valueOf(65533);
                    } else {
                        var10_10 /* !! */  = Integer.valueOf(var6_6);
                    }
                    var3_3.invoke((Object)var10_10 /* !! */ );
                    var10_10 /* !! */  = Unit.INSTANCE;
                    var4_4 = 4;
                }
                var1_1 += var4_4;
                continue;
            }
            var3_3.invoke((Object)65533);
            ++var1_1;
        }
    }

    public static final long size(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    public static final long size(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        return Utf8.size$default(string, n, 0, 2, null);
    }

    public static final long size(String object, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        int n3 = 1;
        int n4 = n >= 0 ? 1 : 0;
        if (n4 == 0) {
            object = new IllegalArgumentException(Intrinsics.stringPlus((String)"beginIndex < 0: ", (Object)n).toString());
            throw object;
        }
        n4 = n2 >= n ? 1 : 0;
        if (n4 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex < beginIndex: ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(" < ");
            ((StringBuilder)object).append(n);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        n4 = n2 <= ((String)object).length() ? n3 : 0;
        if (n4 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > string.length: ");
            stringBuilder.append(n2);
            stringBuilder.append(" > ");
            stringBuilder.append(((String)object).length());
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
        }
        long l = 0L;
        while (n < n2) {
            char c = ((String)object).charAt(n);
            if (c < '\u0080') {
                ++l;
            } else {
                if (c < '\u0800') {
                    n4 = 2;
                } else {
                    if (c >= '\ud800' && c <= '\udfff') {
                        n3 = n + 1;
                        n4 = n3 < n2 ? (int)((String)object).charAt(n3) : 0;
                        if (c <= '\udbff' && n4 >= 56320 && n4 <= 57343) {
                            l += (long)4;
                            n += 2;
                            continue;
                        }
                        ++l;
                        n = n3;
                        continue;
                    }
                    n4 = 3;
                }
                l += (long)n4;
            }
            ++n;
        }
        return l;
    }

    public static /* synthetic */ long size$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) == 0) return Utf8.size(string, n, n2);
        n2 = string.length();
        return Utf8.size(string, n, n2);
    }
}
