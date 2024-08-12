/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecatedSinceKotlin
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.AbstractList
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.StringCompanionObject
 *  kotlin.ranges.RangesKt
 *  kotlin.text.CharsKt
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlin.text.StringsKt__StringNumberConversionsKt
 */
package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;

@Metadata(d1={"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a\f\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'H\u0087\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0087\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0087\b\u001a\f\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a2\u00100\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00a2\u0006\u0002\u00104\u001a6\u00100\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00a2\u0006\u0004\b5\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00a2\u0006\u0002\u00106\u001a:\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00a2\u0006\u0002\u00107\u001a>\u00100\u001a\u00020\u0002*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00a2\u0006\u0004\b5\u00107\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00a2\u0006\u0002\u00108\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\n\u0010:\u001a\u00020#*\u00020'\u001a\r\u0010;\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010;\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010B\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\u0087\b\u001a4\u0010D\u001a\u00020#*\u00020'2\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010D\u001a\u00020#*\u00020\u00022\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020'2\u0006\u0010H\u001a\u00020\u0011\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020P*\u00020'2\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020\u0011\u001a\u001c\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u0017\u0010W\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\r\u0010X\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a3\u0010X\u001a\u00020\u0014*\u00020\u00022\u0006\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a \u0010X\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010[\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010[\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u0017\u0010\\\u001a\u00020R*\u00020\u00022\b\b\u0002\u0010]\u001a\u00020\u0011H\u0087\b\u001a\r\u0010^\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010^\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\r\u0010_\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010_\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006`"}, d2={"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "formatNullable", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringsJVMKt
extends StringsKt__StringNumberConversionsKt {
    private static final String String(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    private static final String String(StringBuilder stringBuilder) {
        return new String(stringBuilder);
    }

    private static final String String(byte[] byArray) {
        return new String(byArray, Charsets.UTF_8);
    }

    private static final String String(byte[] byArray, int n, int n2) {
        return new String(byArray, n, n2, Charsets.UTF_8);
    }

    private static final String String(byte[] byArray, int n, int n2, Charset charset) {
        return new String(byArray, n, n2, charset);
    }

    private static final String String(byte[] byArray, Charset charset) {
        return new String(byArray, charset);
    }

    private static final String String(char[] cArray) {
        return new String(cArray);
    }

    private static final String String(char[] cArray, int n, int n2) {
        return new String(cArray, n, n2);
    }

    private static final String String(int[] nArray, int n, int n2) {
        return new String(nArray, n, n2);
    }

    @Deprecated(message="Use replaceFirstChar instead.", replaceWith=@ReplaceWith(expression="replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports={"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince="1.5")
    public static final String capitalize(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$capitalize");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"Locale.getDefault()");
        return StringsKt.capitalize((String)string, (Locale)locale);
    }

    @Deprecated(message="Use replaceFirstChar instead.", replaceWith=@ReplaceWith(expression="replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.5")
    public static final String capitalize(String string, Locale object) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$capitalize");
        Intrinsics.checkNotNullParameter((Object)object, (String)"locale");
        boolean bl = ((CharSequence)string).length() > 0;
        if (!bl) return string;
        char c = string.charAt(0);
        if (!Character.isLowerCase(c)) return string;
        StringBuilder stringBuilder = new StringBuilder();
        char c2 = Character.toTitleCase(c);
        if (c2 != Character.toUpperCase(c)) {
            stringBuilder.append(c2);
        } else {
            String string2 = string.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            if (string2 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            object = string2.toUpperCase((Locale)object);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).toUpperCase(locale)");
            stringBuilder.append((String)object);
        }
        string = string.substring(1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        stringBuilder.append(string);
        string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final int codePointAt(String string, int n) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.codePointAt(n);
    }

    private static final int codePointBefore(String string, int n) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.codePointBefore(n);
    }

    private static final int codePointCount(String string, int n, int n2) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.codePointCount(n, n2);
    }

    public static final int compareTo(String string, String string2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$compareTo");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"other");
        if (!bl) return string.compareTo(string2);
        return string.compareToIgnoreCase(string2);
    }

    public static /* synthetic */ int compareTo$default(String string, String string2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.compareTo((String)string, (String)string2, (boolean)bl);
        bl = false;
        return StringsKt.compareTo((String)string, (String)string2, (boolean)bl);
    }

    public static final String concatToString(char[] cArray) {
        Intrinsics.checkNotNullParameter((Object)cArray, (String)"$this$concatToString");
        return new String(cArray);
    }

    public static final String concatToString(char[] cArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)cArray, (String)"$this$concatToString");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(n, n2, cArray.length);
        return new String(cArray, n, n2 - n);
    }

    public static /* synthetic */ String concatToString$default(char[] cArray, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) == 0) return StringsKt.concatToString((char[])cArray, (int)n, (int)n2);
        n2 = cArray.length;
        return StringsKt.concatToString((char[])cArray, (int)n, (int)n2);
    }

    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        boolean bl = charSequence instanceof String && charSequence2 != null ? ((String)charSequence).contentEquals(charSequence2) : StringsKt.contentEqualsImpl((CharSequence)charSequence, (CharSequence)charSequence2);
        return bl;
    }

    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2, boolean bl) {
        bl = bl ? StringsKt.contentEqualsIgnoreCaseImpl((CharSequence)charSequence, (CharSequence)charSequence2) : StringsKt.contentEquals((CharSequence)charSequence, (CharSequence)charSequence2);
        return bl;
    }

    private static final boolean contentEquals(String string, CharSequence charSequence) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.contentEquals(charSequence);
    }

    private static final boolean contentEquals(String string, StringBuffer stringBuffer) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.contentEquals(stringBuffer);
    }

    @Deprecated(message="Use replaceFirstChar instead.", replaceWith=@ReplaceWith(expression="replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports={"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince="1.5")
    public static final String decapitalize(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$decapitalize");
        boolean bl = ((CharSequence)string).length() > 0;
        CharSequence charSequence = string;
        if (!bl) return charSequence;
        charSequence = string;
        if (Character.isLowerCase(string.charAt(0))) return charSequence;
        charSequence = new StringBuilder();
        String string2 = string.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        if (string2 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string2 = string2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.String).toLowerCase()");
        ((StringBuilder)charSequence).append(string2);
        string = string.substring(1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        ((StringBuilder)charSequence).append(string);
        charSequence = ((StringBuilder)charSequence).toString();
        return charSequence;
    }

    @Deprecated(message="Use replaceFirstChar instead.", replaceWith=@ReplaceWith(expression="replaceFirstChar { it.lowercase(locale) }", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.5")
    public static final String decapitalize(String string, Locale object) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$decapitalize");
        Intrinsics.checkNotNullParameter((Object)object, (String)"locale");
        boolean bl = ((CharSequence)string).length() > 0;
        CharSequence charSequence = string;
        if (!bl) return charSequence;
        charSequence = string;
        if (Character.isLowerCase(string.charAt(0))) return charSequence;
        charSequence = new StringBuilder();
        String string2 = string.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        if (string2 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        object = string2.toLowerCase((Locale)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).toLowerCase(locale)");
        ((StringBuilder)charSequence).append((String)object);
        string = string.substring(1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        ((StringBuilder)charSequence).append(string);
        charSequence = ((StringBuilder)charSequence).toString();
        return charSequence;
    }

    public static final String decodeToString(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"$this$decodeToString");
        return new String(byArray, Charsets.UTF_8);
    }

    public static final String decodeToString(byte[] object, int n, int n2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$decodeToString");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(n, n2, ((byte[])object).length);
        if (!bl) {
            return new String((byte[])object, n, n2 - n, Charsets.UTF_8);
        }
        object = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(object, n, n2 - n)).toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"decoder.decode(ByteBuffe\u2026- startIndex)).toString()");
        return object;
    }

    public static /* synthetic */ String decodeToString$default(byte[] byArray, int n, int n2, boolean bl, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = byArray.length;
        }
        if ((n3 & 4) == 0) return StringsKt.decodeToString((byte[])byArray, (int)n, (int)n2, (boolean)bl);
        bl = false;
        return StringsKt.decodeToString((byte[])byArray, (int)n, (int)n2, (boolean)bl);
    }

    public static final byte[] encodeToByteArray(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$encodeToByteArray");
        object = ((String)object).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
        return object;
    }

    /*
     * Enabled force condition propagation
     */
    public static final byte[] encodeToByteArray(String object, int n, int n2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$encodeToByteArray");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(n, n2, ((String)object).length());
        if (!bl) {
            String string = ((String)object).substring(n, n2);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            object = Charsets.UTF_8;
            if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            object = string.getBytes((Charset)object);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
            return object;
        }
        ByteBuffer byteBuffer = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap((CharSequence)object, n, n2));
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            n = byteBuffer.remaining();
            object = byteBuffer.array();
            Intrinsics.checkNotNull((Object)object);
            if (n == ((Object)object).length) {
                object = byteBuffer.array();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"byteBuffer.array()");
                return object;
            }
        }
        object = new byte[byteBuffer.remaining()];
        byteBuffer.get((byte[])object);
        return object;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String string, int n, int n2, boolean bl, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) != 0) {
            n2 = string.length();
        }
        if ((n3 & 4) == 0) return StringsKt.encodeToByteArray((String)string, (int)n, (int)n2, (boolean)bl);
        bl = false;
        return StringsKt.encodeToByteArray((String)string, (int)n, (int)n2, (boolean)bl);
    }

    public static final boolean endsWith(String string, String string2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$endsWith");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"suffix");
        if (bl) return StringsKt.regionMatches((String)string, (int)(string.length() - string2.length()), (String)string2, (int)0, (int)string2.length(), (boolean)true);
        return string.endsWith(string2);
    }

    public static /* synthetic */ boolean endsWith$default(String string, String string2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.endsWith((String)string, (String)string2, (boolean)bl);
        bl = false;
        return StringsKt.endsWith((String)string, (String)string2, (boolean)bl);
    }

    public static final boolean equals(String string, String string2, boolean bl) {
        if (string == null) {
            bl = string2 == null;
            return bl;
        }
        bl = !bl ? string.equals(string2) : string.equalsIgnoreCase(string2);
        return bl;
    }

    public static /* synthetic */ boolean equals$default(String string, String string2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.equals((String)string, (String)string2, (boolean)bl);
        bl = false;
        return StringsKt.equals((String)string, (String)string2, (boolean)bl);
    }

    @Deprecated(message="Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince="1.4")
    private static final /* synthetic */ String format(String string, Locale locale, Object ... objectArray) {
        string = String.format(locale, string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.String.format(locale, this, *args)");
        return string;
    }

    private static final String format(String string, Object ... objectArray) {
        string = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.String.format(this, *args)");
        return string;
    }

    private static final String format(StringCompanionObject object, String string, Object ... objectArray) {
        object = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.lang.String.format(format, *args)");
        return object;
    }

    @Deprecated(message="Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince="1.4")
    private static final /* synthetic */ String format(StringCompanionObject object, Locale locale, String string, Object ... objectArray) {
        object = String.format(locale, string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.lang.String.format(locale, format, *args)");
        return object;
    }

    private static final String formatNullable(String string, Locale locale, Object ... objectArray) {
        string = String.format(locale, string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.String.format(locale, this, *args)");
        return string;
    }

    private static final String formatNullable(StringCompanionObject object, Locale locale, String string, Object ... objectArray) {
        object = String.format(locale, string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.lang.String.format(locale, format, *args)");
        return object;
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$CASE_INSENSITIVE_ORDER");
        object = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.lang.String.CASE_INSENSITIVE_ORDER");
        return object;
    }

    private static final String intern(String string) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.intern();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).intern()");
        return string;
    }

    public static final boolean isBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$isBlank");
        int n = charSequence.length();
        boolean bl = false;
        if (n != 0) {
            Object object = (Iterable)StringsKt.getIndices((CharSequence)charSequence);
            if (!(object instanceof Collection) || !((Collection)object).isEmpty()) {
                object = object.iterator();
                while (object.hasNext()) {
                    if (CharsKt.isWhitespace((char)charSequence.charAt(((IntIterator)object).nextInt()))) continue;
                    n = 0;
                    break;
                }
            } else {
                n = 1;
            }
            if (n == 0) return bl;
        }
        bl = true;
        return bl;
    }

    private static final String lowercase(String string) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026.toLowerCase(Locale.ROOT)");
        return string;
    }

    private static final String lowercase(String string, Locale locale) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).toLowerCase(locale)");
        return string;
    }

    private static final int nativeIndexOf(String string, char c, int n) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.indexOf(c, n);
    }

    private static final int nativeIndexOf(String string, String string2, int n) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.indexOf(string2, n);
    }

    private static final int nativeLastIndexOf(String string, char c, int n) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.lastIndexOf(c, n);
    }

    private static final int nativeLastIndexOf(String string, String string2, int n) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.lastIndexOf(string2, n);
    }

    private static final int offsetByCodePoints(String string, int n, int n2) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        return string.offsetByCodePoints(n, n2);
    }

    public static final boolean regionMatches(CharSequence charSequence, int n, CharSequence charSequence2, int n2, int n3, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$regionMatches");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"other");
        if (!(charSequence instanceof String)) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)n, (CharSequence)charSequence2, (int)n2, (int)n3, (boolean)bl);
        if (!(charSequence2 instanceof String)) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)n, (CharSequence)charSequence2, (int)n2, (int)n3, (boolean)bl);
        return StringsKt.regionMatches((String)((String)charSequence), (int)n, (String)((String)charSequence2), (int)n2, (int)n3, (boolean)bl);
    }

    public static final boolean regionMatches(String string, int n, String string2, int n2, int n3, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$regionMatches");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"other");
        bl = !bl ? string.regionMatches(n, string2, n2, n3) : string.regionMatches(bl, n, string2, n2, n3);
        return bl;
    }

    public static /* synthetic */ boolean regionMatches$default(CharSequence charSequence, int n, CharSequence charSequence2, int n2, int n3, boolean bl, int n4, Object object) {
        if ((n4 & 0x10) == 0) return StringsKt.regionMatches((CharSequence)charSequence, (int)n, (CharSequence)charSequence2, (int)n2, (int)n3, (boolean)bl);
        bl = false;
        return StringsKt.regionMatches((CharSequence)charSequence, (int)n, (CharSequence)charSequence2, (int)n2, (int)n3, (boolean)bl);
    }

    public static /* synthetic */ boolean regionMatches$default(String string, int n, String string2, int n2, int n3, boolean bl, int n4, Object object) {
        if ((n4 & 0x10) == 0) return StringsKt.regionMatches((String)string, (int)n, (String)string2, (int)n2, (int)n3, (boolean)bl);
        bl = false;
        return StringsKt.regionMatches((String)string, (int)n, (String)string2, (int)n2, (int)n3, (boolean)bl);
    }

    public static final String repeat(CharSequence object, int n) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$repeat");
        int n2 = 0;
        int n3 = 1;
        int n4 = n >= 0 ? 1 : 0;
        if (n4 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Count 'n' must be non-negative, but was ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append('.');
            object = new IllegalArgumentException(((StringBuilder)object).toString().toString());
            throw object;
        }
        String string = "";
        CharSequence charSequence = string;
        if (n == 0) return charSequence;
        if (n != 1) {
            n4 = object.length();
            charSequence = string;
            if (n4 == 0) return charSequence;
            if (n4 != 1) {
                charSequence = new StringBuilder(object.length() * n);
                if (1 <= n) {
                    n4 = n3;
                    while (true) {
                        ((StringBuilder)charSequence).append((CharSequence)object);
                        if (n4 == n) break;
                        ++n4;
                    }
                }
                charSequence = ((StringBuilder)charSequence).toString();
                Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"sb.toString()");
            } else {
                char c = object.charAt(0);
                object = new char[n];
                for (n4 = n2; n4 < n; ++n4) {
                    object[n4] = c;
                }
                charSequence = new String((char[])object);
            }
        } else {
            charSequence = object.toString();
        }
        return charSequence;
    }

    public static final String replace(String charSequence, char c, char c2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$replace");
        if (!bl) {
            charSequence = ((String)charSequence).replace(c, c2);
            Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"(this as java.lang.Strin\u2026replace(oldChar, newChar)");
            return charSequence;
        }
        StringBuilder stringBuilder = new StringBuilder(((String)charSequence).length());
        charSequence = charSequence;
        int n = 0;
        while (true) {
            char c3;
            if (n >= charSequence.length()) {
                charSequence = stringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"StringBuilder(capacity).\u2026builderAction).toString()");
                return charSequence;
            }
            char c4 = c3 = charSequence.charAt(n);
            if (CharsKt.equals((char)c3, (char)c, (boolean)bl)) {
                c4 = c2;
            }
            stringBuilder.append(c4);
            ++n;
        }
    }

    public static final String replace(String object, String string, String string2, boolean bl) {
        int n;
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$replace");
        Intrinsics.checkNotNullParameter((Object)string, (String)"oldValue");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"newValue");
        CharSequence charSequence = (CharSequence)object;
        int n2 = 0;
        int n3 = StringsKt.indexOf((CharSequence)charSequence, (String)string, (int)0, (boolean)bl);
        if (n3 < 0) {
            return object;
        }
        int n4 = string.length();
        int n5 = RangesKt.coerceAtLeast((int)n4, (int)1);
        int n6 = ((String)object).length() - n4 + string2.length();
        if (n6 < 0) {
            object = new OutOfMemoryError();
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder(n6);
        do {
            stringBuilder.append(charSequence, n2, n3);
            stringBuilder.append(string2);
            n = n3 + n4;
            if (n3 >= ((String)object).length()) break;
            n6 = StringsKt.indexOf((CharSequence)charSequence, (String)string, (int)(n3 + n5), (boolean)bl);
            n2 = n;
            n3 = n6;
        } while (n6 > 0);
        stringBuilder.append(charSequence, n, ((String)object).length());
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"stringBuilder.append(this, i, length).toString()");
        return object;
    }

    public static /* synthetic */ String replace$default(String string, char c, char c2, boolean bl, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replace((String)string, (char)c, (char)c2, (boolean)bl);
        bl = false;
        return StringsKt.replace((String)string, (char)c, (char)c2, (boolean)bl);
    }

    public static /* synthetic */ String replace$default(String string, String string2, String string3, boolean bl, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replace((String)string, (String)string2, (String)string3, (boolean)bl);
        bl = false;
        return StringsKt.replace((String)string, (String)string2, (String)string3, (boolean)bl);
    }

    public static final String replaceFirst(String string, char c, char c2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$replaceFirst");
        CharSequence charSequence = string;
        int n = StringsKt.indexOf$default((CharSequence)charSequence, (char)c, (int)0, (boolean)bl, (int)2, null);
        if (n < 0) return string;
        string = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)n, (int)(n + 1), (CharSequence)String.valueOf(c2))).toString();
        return string;
    }

    public static final String replaceFirst(String string, String string2, String string3, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$replaceFirst");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"oldValue");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"newValue");
        CharSequence charSequence = string;
        int n = StringsKt.indexOf$default((CharSequence)charSequence, (String)string2, (int)0, (boolean)bl, (int)2, null);
        if (n < 0) return string;
        string = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)n, (int)(string2.length() + n), (CharSequence)string3)).toString();
        return string;
    }

    public static /* synthetic */ String replaceFirst$default(String string, char c, char c2, boolean bl, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceFirst((String)string, (char)c, (char)c2, (boolean)bl);
        bl = false;
        return StringsKt.replaceFirst((String)string, (char)c, (char)c2, (boolean)bl);
    }

    public static /* synthetic */ String replaceFirst$default(String string, String string2, String string3, boolean bl, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceFirst((String)string, (String)string2, (String)string3, (boolean)bl);
        bl = false;
        return StringsKt.replaceFirst((String)string, (String)string2, (String)string3, (boolean)bl);
    }

    public static final List<String> split(CharSequence objectArray, Pattern pattern, int n) {
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"$this$split");
        Intrinsics.checkNotNullParameter((Object)pattern, (String)"regex");
        StringsKt.requireNonNegativeLimit((int)n);
        int n2 = n;
        if (n == 0) {
            n2 = -1;
        }
        objectArray = pattern.split((CharSequence)objectArray, n2);
        Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"regex.split(this, if (limit == 0) -1 else limit)");
        return ArraysKt.asList((Object[])objectArray);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return StringsKt.split((CharSequence)charSequence, (Pattern)pattern, (int)n);
        n = 0;
        return StringsKt.split((CharSequence)charSequence, (Pattern)pattern, (int)n);
    }

    public static final boolean startsWith(String string, String string2, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$startsWith");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"prefix");
        if (bl) return StringsKt.regionMatches((String)string, (int)n, (String)string2, (int)0, (int)string2.length(), (boolean)bl);
        return string.startsWith(string2, n);
    }

    public static final boolean startsWith(String string, String string2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$startsWith");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"prefix");
        if (bl) return StringsKt.regionMatches((String)string, (int)0, (String)string2, (int)0, (int)string2.length(), (boolean)bl);
        return string.startsWith(string2);
    }

    public static /* synthetic */ boolean startsWith$default(String string, String string2, int n, boolean bl, int n2, Object object) {
        if ((n2 & 4) == 0) return StringsKt.startsWith((String)string, (String)string2, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.startsWith((String)string, (String)string2, (int)n, (boolean)bl);
    }

    public static /* synthetic */ boolean startsWith$default(String string, String string2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.startsWith((String)string, (String)string2, (boolean)bl);
        bl = false;
        return StringsKt.startsWith((String)string, (String)string2, (boolean)bl);
    }

    private static final String substring(String string, int n) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(n);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        return string;
    }

    private static final String substring(String string, int n, int n2) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(n, n2);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string;
    }

    private static final byte[] toByteArray(String object, Charset charset) {
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        object = ((String)object).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
        return object;
    }

    static /* synthetic */ byte[] toByteArray$default(String object, Charset charset, int n, Object object2) {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        object = ((String)object).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
        return object;
    }

    private static final char[] toCharArray(String object) {
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        object = ((String)object).toCharArray();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).toCharArray()");
        return object;
    }

    public static final char[] toCharArray(String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toCharArray");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(n, n2, string.length());
        char[] cArray = new char[n2 - n];
        string.getChars(n, n2, cArray, 0);
        return cArray;
    }

    private static final char[] toCharArray(String string, char[] cArray, int n, int n2, int n3) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string.getChars(n2, n3, cArray, n);
        return cArray;
    }

    public static /* synthetic */ char[] toCharArray$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) == 0) return StringsKt.toCharArray((String)string, (int)n, (int)n2);
        n2 = string.length();
        return StringsKt.toCharArray((String)string, (int)n, (int)n2);
    }

    static /* synthetic */ char[] toCharArray$default(String string, char[] cArray, int n, int n2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n = 0;
        }
        if ((n4 & 4) != 0) {
            n2 = 0;
        }
        if ((n4 & 8) != 0) {
            n3 = string.length();
        }
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string.getChars(n2, n3, cArray, n);
        return cArray;
    }

    @Deprecated(message="Use lowercase() instead.", replaceWith=@ReplaceWith(expression="lowercase(Locale.getDefault())", imports={"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince="1.5")
    private static final String toLowerCase(String string) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toLowerCase();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).toLowerCase()");
        return string;
    }

    @Deprecated(message="Use lowercase() instead.", replaceWith=@ReplaceWith(expression="lowercase(locale)", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.5")
    private static final String toLowerCase(String string, Locale locale) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).toLowerCase(locale)");
        return string;
    }

    private static final Pattern toPattern(String object, int n) {
        object = Pattern.compile((String)object, n);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.regex.Pattern.compile(this, flags)");
        return object;
    }

    static /* synthetic */ Pattern toPattern$default(String object, int n, int n2, Object object2) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        object = Pattern.compile((String)object, n);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.regex.Pattern.compile(this, flags)");
        return object;
    }

    @Deprecated(message="Use uppercase() instead.", replaceWith=@ReplaceWith(expression="uppercase(Locale.getDefault())", imports={"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince="1.5")
    private static final String toUpperCase(String string) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toUpperCase();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).toUpperCase()");
        return string;
    }

    @Deprecated(message="Use uppercase() instead.", replaceWith=@ReplaceWith(expression="uppercase(locale)", imports={}))
    @DeprecatedSinceKotlin(warningSince="1.5")
    private static final String toUpperCase(String string, Locale locale) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).toUpperCase(locale)");
        return string;
    }

    private static final String uppercase(String string) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026.toUpperCase(Locale.ROOT)");
        return string;
    }

    private static final String uppercase(String string, Locale locale) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).toUpperCase(locale)");
        return string;
    }
}
