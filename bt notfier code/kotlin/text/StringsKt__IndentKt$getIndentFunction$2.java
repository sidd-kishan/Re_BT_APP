/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2={"<anonymous>", "", "line", "invoke"}, k=3, mv={1, 5, 1})
static final class StringsKt__IndentKt.getIndentFunction.2
extends Lambda
implements Function1<String, String> {
    final String $indent;

    StringsKt__IndentKt.getIndentFunction.2(String string) {
        this.$indent = string;
        super(1);
    }

    public final String invoke(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"line");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.$indent);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }
}
