/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.text.CharsKt
 *  kotlin.text.CharsKt__CharJVMKt
 *  kotlin.text._OneToManyTitlecaseMappingsKt
 */
package kotlin.text;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.text.CharsKt;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text._OneToManyTitlecaseMappingsKt;

@Metadata(d1={"\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007\u00a8\u0006\u0010"}, d2={"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/CharsKt")
class CharsKt__CharKt
extends CharsKt__CharJVMKt {
    public static final char digitToChar(int n) {
        if (n >= 0 && 9 >= n) {
            return (char)(n + 48);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Int ");
        stringBuilder.append(n);
        stringBuilder.append(" is not a decimal digit");
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
    }

    public static final char digitToChar(int n, int n2) {
        if (2 <= n2 && 36 >= n2) {
            if (n >= 0 && n < n2) {
                n = n < 10 ? (n += 48) : (char)(n + 65) - 10;
                return (char)n;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Digit ");
            stringBuilder.append(n);
            stringBuilder.append(" does not represent a valid digit in radix ");
            stringBuilder.append(n2);
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid radix: ");
        stringBuilder.append(n2);
        stringBuilder.append(". Valid radix values are in range 2..36");
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
    }

    public static final int digitToInt(char c) {
        int n = CharsKt.digitOf((char)c, (int)10);
        if (n >= 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Char ");
        stringBuilder.append(c);
        stringBuilder.append(" is not a decimal digit");
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
    }

    public static final int digitToInt(char c, int n) {
        Serializable serializable = CharsKt.digitToIntOrNull((char)c, (int)n);
        if (serializable != null) {
            return (Integer)serializable;
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("Char ");
        ((StringBuilder)serializable).append(c);
        ((StringBuilder)serializable).append(" is not a digit in the given radix=");
        ((StringBuilder)serializable).append(n);
        throw (Throwable)new IllegalArgumentException(((StringBuilder)serializable).toString());
    }

    public static final Integer digitToIntOrNull(char c) {
        Integer n = CharsKt.digitOf((char)c, (int)10);
        boolean bl = ((Number)n).intValue() >= 0;
        if (bl) return n;
        n = null;
        return n;
    }

    public static final Integer digitToIntOrNull(char c, int n) {
        CharsKt.checkRadix((int)n);
        Integer n2 = CharsKt.digitOf((char)c, (int)n);
        n = ((Number)n2).intValue() >= 0 ? 1 : 0;
        if (n != 0) return n2;
        n2 = null;
        return n2;
    }

    public static final boolean equals(char c, char c2, boolean bl) {
        boolean bl2 = true;
        if (c == c2) {
            return true;
        }
        if (!bl) {
            return false;
        }
        c = Character.toUpperCase(c);
        c2 = Character.toUpperCase(c2);
        bl = bl2;
        if (c == c2) return bl;
        bl = Character.toLowerCase(c) == Character.toLowerCase(c2) ? bl2 : false;
        return bl;
    }

    public static /* synthetic */ boolean equals$default(char c, char c2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return CharsKt.equals((char)c, (char)c2, (boolean)bl);
        bl = false;
        return CharsKt.equals((char)c, (char)c2, (boolean)bl);
    }

    public static final boolean isSurrogate(char c) {
        boolean bl = '\ud800' <= c && '\udfff' >= c;
        return bl;
    }

    private static final String plus(char c, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(c));
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static final String titlecase(char c) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl((char)c);
    }
}
