/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.CharsKt
 *  kotlin.text.StringsKt
 *  kotlin.text.StringsKt__StringNumberConversionsJVMKt
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2={"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt
extends StringsKt__StringNumberConversionsJVMKt {
    public static final Void numberFormatError(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"input");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid number format: '");
        stringBuilder.append(string);
        stringBuilder.append('\'');
        throw (Throwable)new NumberFormatException(stringBuilder.toString());
    }

    public static final Byte toByteOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toByteOrNull");
        return StringsKt.toByteOrNull((String)string, (int)10);
    }

    public static final Byte toByteOrNull(String object, int n) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$toByteOrNull");
        object = StringsKt.toIntOrNull((String)object, (int)n);
        if (object == null) return null;
        n = (Integer)object;
        if (n < -128) return null;
        if (n <= 127) return (byte)n;
        return null;
    }

    public static final Integer toIntOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toIntOrNull");
        return StringsKt.toIntOrNull((String)string, (int)10);
    }

    public static final Integer toIntOrNull(String object, int n) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$toIntOrNull");
        CharsKt.checkRadix((int)n);
        int n2 = ((String)object).length();
        if (n2 == 0) {
            return null;
        }
        int n3 = 0;
        int n4 = ((String)object).charAt(0);
        int n5 = Intrinsics.compare((int)n4, (int)48);
        int n6 = -2147483647;
        int n7 = 1;
        if (n5 < 0) {
            if (n2 == 1) {
                return null;
            }
            if (n4 == 45) {
                n6 = Integer.MIN_VALUE;
                n5 = 1;
            } else {
                if (n4 != 43) return null;
                n5 = 0;
            }
        } else {
            n5 = 0;
            n7 = 0;
        }
        int n8 = -59652323;
        for (n4 = n7; n4 < n2; ++n4) {
            int n9 = CharsKt.digitOf((char)((String)object).charAt(n4), (int)n);
            if (n9 < 0) {
                return null;
            }
            n7 = n8;
            if (n3 < n8) {
                if (n8 != -59652323) return null;
                n7 = n8 = n6 / n;
                if (n3 < n8) {
                    return null;
                }
            }
            if ((n8 = n3 * n) < n6 + n9) {
                return null;
            }
            n3 = n8 - n9;
            n8 = n7;
        }
        object = n5 != 0 ? Integer.valueOf(n3) : Integer.valueOf(-n3);
        return object;
    }

    public static final Long toLongOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toLongOrNull");
        return StringsKt.toLongOrNull((String)string, (int)10);
    }

    /*
     * Unable to fully structure code
     */
    public static final Long toLongOrNull(String var0, int var1_1) {
        Intrinsics.checkNotNullParameter((Object)var0, (String)"$this$toLongOrNull");
        CharsKt.checkRadix((int)var1_1);
        var4_2 = var0.length();
        if (var4_2 == 0) {
            return null;
        }
        var2_3 = 0;
        var6_4 = var0.charAt(0);
        var5_5 = Intrinsics.compare((int)var6_4, (int)48);
        var7_6 = -9223372036854775807L;
        var3_7 = true;
        if (var5_5 >= 0) ** GOTO lbl21
        if (var4_2 == 1) {
            return null;
        }
        if (var6_4 == '-') {
            var7_6 = -9223372036854775808L;
            var2_3 = 1;
        } else {
            if (var6_4 != '+') return null;
            var2_3 = 1;
lbl21:
            // 2 sources

            var3_7 = false;
        }
        var13_8 = 0L;
        var11_9 = -256204778801521550L;
        while (var2_3 < var4_2) {
            var5_5 = CharsKt.digitOf((char)var0.charAt(var2_3), (int)var1_1);
            if (var5_5 < 0) {
                return null;
            }
            var9_10 = var11_9;
            if (var13_8 < var11_9) {
                if (var11_9 != -256204778801521550L) return null;
                var9_10 = var11_9 = var7_6 / (long)var1_1;
                if (var13_8 < var11_9) {
                    return null;
                }
            }
            if ((var11_9 = var13_8 * (long)var1_1) < var7_6 + (var13_8 = (long)var5_5)) {
                return null;
            }
            var13_8 = var11_9 - var13_8;
            ++var2_3;
            var11_9 = var9_10;
        }
        var0 = var3_7 != false ? Long.valueOf(var13_8) : Long.valueOf(-var13_8);
        return var0;
    }

    public static final Short toShortOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toShortOrNull");
        return StringsKt.toShortOrNull((String)string, (int)10);
    }

    public static final Short toShortOrNull(String object, int n) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$toShortOrNull");
        object = StringsKt.toIntOrNull((String)object, (int)n);
        if (object == null) return null;
        n = (Integer)object;
        if (n < Short.MIN_VALUE) return null;
        if (n <= Short.MAX_VALUE) return (short)n;
        return null;
    }
}
