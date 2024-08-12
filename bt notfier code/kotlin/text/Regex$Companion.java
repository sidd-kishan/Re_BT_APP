/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  kotlin.text.RegexOption
 */
package kotlin.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\f"}, d2={"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class Regex.Companion {
    private Regex.Companion() {
    }

    public /* synthetic */ Regex.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ int access$ensureUnicodeCase(Regex.Companion companion, int n) {
        return companion.ensureUnicodeCase(n);
    }

    private final int ensureUnicodeCase(int n) {
        int n2 = n;
        if ((n & 2) == 0) return n2;
        n2 = n | 0x40;
        return n2;
    }

    public final String escape(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"literal");
        string = Pattern.quote(string);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"Pattern.quote(literal)");
        return string;
    }

    public final String escapeReplacement(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"literal");
        string = Matcher.quoteReplacement(string);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"Matcher.quoteReplacement(literal)");
        return string;
    }

    public final Regex fromLiteral(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"literal");
        return new Regex(string, RegexOption.LITERAL);
    }
}
