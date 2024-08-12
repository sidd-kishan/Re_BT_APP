/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u00a8\u0006\u0003"}, d2={"titlecaseImpl", "", "", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char c) {
        String string = String.valueOf(c);
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026.toUpperCase(Locale.ROOT)");
        if (string.length() <= 1) return String.valueOf(Character.toTitleCase(c));
        if (c == '\u0149') return string;
        c = string.charAt(0);
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026.toLowerCase(Locale.ROOT)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(c));
        stringBuilder.append(string);
        string = stringBuilder.toString();
        return string;
    }
}
