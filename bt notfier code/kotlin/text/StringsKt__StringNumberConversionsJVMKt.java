/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecatedSinceKotlin
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.CharsKt
 *  kotlin.text.ScreenFloatValueRegEx
 *  kotlin.text.StringsKt
 *  kotlin.text.StringsKt__StringBuilderKt
 */
package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.ScreenFloatValueRegEx;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringBuilderKt;

@Metadata(d1={"\u0000Z\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\u0082\b\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\r\u0010\u0012\u001a\u00020\u0013*\u00020\u0003H\u0087\b\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0003H\u0087\b\u00a2\u0006\u0002\b\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0010*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010 \u001a\u00020!*\u00020\u0003H\u0087\b\u001a\u0015\u0010 \u001a\u00020!*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\"\u001a\u00020#*\u00020\u0003H\u0087\b\u001a\u0015\u0010\"\u001a\u00020#*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020#2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u00a8\u0006%"}, d2={"screenFloatValue", "T", "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toBooleanNullable", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsJVMKt
extends StringsKt__StringBuilderKt {
    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String string, Function1<? super String, ? extends T> function1) {
        Object object;
        Object object2 = object = null;
        try {
            if (!ScreenFloatValueRegEx.value.matches((CharSequence)string)) return (T)object2;
            object2 = function1.invoke((Object)string);
        }
        catch (NumberFormatException numberFormatException) {
            object2 = object;
        }
        return (T)object2;
    }

    private static final BigDecimal toBigDecimal(String string) {
        return new BigDecimal(string);
    }

    private static final BigDecimal toBigDecimal(String string, MathContext mathContext) {
        return new BigDecimal(string, mathContext);
    }

    /*
     * Enabled force condition propagation
     */
    public static final BigDecimal toBigDecimalOrNull(String string) {
        BigDecimal bigDecimal;
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toBigDecimalOrNull");
        BigDecimal bigDecimal2 = bigDecimal = null;
        try {
            if (!ScreenFloatValueRegEx.value.matches((CharSequence)string)) return bigDecimal2;
            return new BigDecimal(string);
        }
        catch (NumberFormatException numberFormatException) {
            return bigDecimal;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public static final BigDecimal toBigDecimalOrNull(String string, MathContext mathContext) {
        BigDecimal bigDecimal;
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toBigDecimalOrNull");
        Intrinsics.checkNotNullParameter((Object)mathContext, (String)"mathContext");
        BigDecimal bigDecimal2 = bigDecimal = null;
        try {
            if (!ScreenFloatValueRegEx.value.matches((CharSequence)string)) return bigDecimal2;
            return new BigDecimal(string, mathContext);
        }
        catch (NumberFormatException numberFormatException) {
            return bigDecimal;
        }
    }

    private static final BigInteger toBigInteger(String string) {
        return new BigInteger(string);
    }

    private static final BigInteger toBigInteger(String string, int n) {
        return new BigInteger(string, CharsKt.checkRadix((int)n));
    }

    public static final BigInteger toBigIntegerOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toBigIntegerOrNull");
        return StringsKt.toBigIntegerOrNull((String)string, (int)10);
    }

    public static final BigInteger toBigIntegerOrNull(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toBigIntegerOrNull");
        CharsKt.checkRadix((int)n);
        int n2 = string.length();
        if (n2 == 0) return null;
        int n3 = 0;
        if (n2 == 1) {
            if (CharsKt.digitOf((char)string.charAt(0), (int)n) >= 0) return new BigInteger(string, CharsKt.checkRadix((int)n));
            return null;
        }
        if (string.charAt(0) == '-') {
            n3 = 1;
        }
        while (n3 < n2) {
            if (CharsKt.digitOf((char)string.charAt(n3), (int)n) < 0) {
                return null;
            }
            ++n3;
        }
        return new BigInteger(string, CharsKt.checkRadix((int)n));
    }

    @Deprecated(message="Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince="1.4")
    private static final /* synthetic */ boolean toBoolean(String string) {
        return Boolean.parseBoolean(string);
    }

    private static final boolean toBooleanNullable(String string) {
        return Boolean.parseBoolean(string);
    }

    private static final byte toByte(String string) {
        return Byte.parseByte(string);
    }

    private static final byte toByte(String string, int n) {
        return Byte.parseByte(string, CharsKt.checkRadix((int)n));
    }

    private static final double toDouble(String string) {
        return Double.parseDouble(string);
    }

    public static final Double toDoubleOrNull(String string) {
        Double d;
        block2: {
            double d2;
            Double d3;
            Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toDoubleOrNull");
            d = d3 = null;
            try {
                if (!ScreenFloatValueRegEx.value.matches((CharSequence)string)) return d;
                d2 = Double.parseDouble(string);
            }
            catch (NumberFormatException numberFormatException) {
                d = d3;
                break block2;
            }
            d = d2;
        }
        return d;
    }

    private static final float toFloat(String string) {
        return Float.parseFloat(string);
    }

    public static final Float toFloatOrNull(String string) {
        Float f;
        block2: {
            float f2;
            Float f3;
            Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toFloatOrNull");
            f = f3 = null;
            try {
                if (!ScreenFloatValueRegEx.value.matches((CharSequence)string)) return f;
                f2 = Float.parseFloat(string);
            }
            catch (NumberFormatException numberFormatException) {
                f = f3;
                break block2;
            }
            f = Float.valueOf(f2);
        }
        return f;
    }

    private static final int toInt(String string) {
        return Integer.parseInt(string);
    }

    private static final int toInt(String string, int n) {
        return Integer.parseInt(string, CharsKt.checkRadix((int)n));
    }

    private static final long toLong(String string) {
        return Long.parseLong(string);
    }

    private static final long toLong(String string, int n) {
        return Long.parseLong(string, CharsKt.checkRadix((int)n));
    }

    private static final short toShort(String string) {
        return Short.parseShort(string);
    }

    private static final short toShort(String string, int n) {
        return Short.parseShort(string, CharsKt.checkRadix((int)n));
    }

    private static final String toString(byte by, int n) {
        String string = Integer.toString(by, CharsKt.checkRadix((int)CharsKt.checkRadix((int)n)));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    private static final String toString(int n, int n2) {
        String string = Integer.toString(n, CharsKt.checkRadix((int)n2));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    private static final String toString(long l, int n) {
        String string = Long.toString(l, CharsKt.checkRadix((int)n));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Long.toString(this, checkRadix(radix))");
        return string;
    }

    private static final String toString(short s, int n) {
        String string = Integer.toString(s, CharsKt.checkRadix((int)CharsKt.checkRadix((int)n)));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }
}
