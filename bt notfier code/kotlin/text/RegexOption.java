/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.text.FlagEnum
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.FlagEnum;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2={"Lkotlin/text/RegexOption;", "", "Lkotlin/text/FlagEnum;", "value", "", "mask", "(Ljava/lang/String;III)V", "getMask", "()I", "getValue", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class RegexOption
extends Enum<RegexOption>
implements FlagEnum {
    private static final RegexOption[] $VALUES;
    public static final /* enum */ RegexOption CANON_EQ;
    public static final /* enum */ RegexOption COMMENTS;
    public static final /* enum */ RegexOption DOT_MATCHES_ALL;
    public static final /* enum */ RegexOption IGNORE_CASE;
    public static final /* enum */ RegexOption LITERAL;
    public static final /* enum */ RegexOption MULTILINE;
    public static final /* enum */ RegexOption UNIX_LINES;
    private final int mask;
    private final int value;

    static {
        RegexOption regexOption;
        RegexOption regexOption2;
        RegexOption regexOption3;
        RegexOption regexOption4;
        RegexOption regexOption5;
        RegexOption regexOption6;
        RegexOption regexOption7;
        IGNORE_CASE = regexOption7 = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
        MULTILINE = regexOption6 = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
        LITERAL = regexOption5 = new RegexOption("LITERAL", 2, 16, 0, 2, null);
        UNIX_LINES = regexOption4 = new RegexOption("UNIX_LINES", 3, 1, 0, 2, null);
        COMMENTS = regexOption3 = new RegexOption("COMMENTS", 4, 4, 0, 2, null);
        DOT_MATCHES_ALL = regexOption2 = new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, 2, null);
        CANON_EQ = regexOption = new RegexOption("CANON_EQ", 6, 128, 0, 2, null);
        $VALUES = new RegexOption[]{regexOption7, regexOption6, regexOption5, regexOption4, regexOption3, regexOption2, regexOption};
    }

    private RegexOption(int n2, int n3) {
        this.value = n2;
        this.mask = n3;
    }

    /* synthetic */ RegexOption(String string, int n, int n2, int n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 2) != 0) {
            n3 = n2;
        }
        this(n2, n3);
    }

    public static RegexOption valueOf(String string) {
        return Enum.valueOf(RegexOption.class, string);
    }

    public static RegexOption[] values() {
        return (RegexOption[])$VALUES.clone();
    }

    public int getMask() {
        return this.mask;
    }

    public int getValue() {
        return this.value;
    }
}
