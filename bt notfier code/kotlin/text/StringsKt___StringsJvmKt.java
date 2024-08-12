/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  kotlin.text.StringsKt__StringsKt
 */
package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a)\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\b\t\u001a)\u0010\u0005\u001a\u00020\n*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\b\u000b\u001a\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r*\u00020\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000e"}, d2={"elementAt", "", "", "index", "", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt___StringsJvmKt
extends StringsKt__StringsKt {
    private static final char elementAt(CharSequence charSequence, int n) {
        return charSequence.charAt(n);
    }

    private static final BigDecimal sumOfBigDecimal(CharSequence charSequence, Function1<? super Character, ? extends BigDecimal> function1) {
        int n = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"BigDecimal.valueOf(this.toLong())");
        while (n < charSequence.length()) {
            bigDecimal = bigDecimal.add((BigDecimal)function1.invoke((Object)Character.valueOf(charSequence.charAt(n))));
            Intrinsics.checkNotNullExpressionValue((Object)bigDecimal, (String)"this.add(other)");
            ++n;
        }
        return bigDecimal;
    }

    private static final BigInteger sumOfBigInteger(CharSequence charSequence, Function1<? super Character, ? extends BigInteger> function1) {
        int n = 0;
        BigInteger bigInteger = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"BigInteger.valueOf(this.toLong())");
        while (n < charSequence.length()) {
            bigInteger = bigInteger.add((BigInteger)function1.invoke((Object)Character.valueOf(charSequence.charAt(n))));
            Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.add(other)");
            ++n;
        }
        return bigInteger;
    }

    public static final SortedSet<Character> toSortedSet(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$toSortedSet");
        return (SortedSet)StringsKt.toCollection((CharSequence)charSequence, (Collection)new TreeSet());
    }
}
