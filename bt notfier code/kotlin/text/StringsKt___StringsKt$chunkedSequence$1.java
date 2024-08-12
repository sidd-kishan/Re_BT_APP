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

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 5, 1})
static final class StringsKt___StringsKt.chunkedSequence.1
extends Lambda
implements Function1<CharSequence, String> {
    public static final StringsKt___StringsKt.chunkedSequence.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    StringsKt___StringsKt.chunkedSequence.1() {
    }

    public final String invoke(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"it");
        return ((Object)charSequence).toString();
    }
}
