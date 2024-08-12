/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  kotlin.text.StringsKt
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n\u00a2\u0006\u0002\b\u0005"}, d2={"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k=3, mv={1, 5, 1})
static final class StringsKt__StringsKt.rangesDelimitedBy.1
extends Lambda
implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final char[] $delimiters;
    final boolean $ignoreCase;

    StringsKt__StringsKt.rangesDelimitedBy.1(char[] cArray, boolean bl) {
        this.$delimiters = cArray;
        this.$ignoreCase = bl;
        super(2);
    }

    public final Pair<Integer, Integer> invoke(CharSequence charSequence, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$receiver");
        n = StringsKt.indexOfAny((CharSequence)charSequence, (char[])this.$delimiters, (int)n, (boolean)this.$ignoreCase);
        charSequence = n < 0 ? null : TuplesKt.to((Object)n, (Object)1);
        return charSequence;
    }
}
