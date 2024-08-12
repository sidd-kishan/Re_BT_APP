/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  kotlin.ranges.IntRange
 *  kotlin.text.StringsKt
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, k=3, mv={1, 5, 1})
static final class StringsKt__StringsKt.splitToSequence.2
extends Lambda
implements Function1<IntRange, String> {
    final CharSequence $this_splitToSequence;

    StringsKt__StringsKt.splitToSequence.2(CharSequence charSequence) {
        this.$this_splitToSequence = charSequence;
        super(1);
    }

    public final String invoke(IntRange intRange) {
        Intrinsics.checkNotNullParameter((Object)intRange, (String)"it");
        return StringsKt.substring((CharSequence)this.$this_splitToSequence, (IntRange)intRange);
    }
}
