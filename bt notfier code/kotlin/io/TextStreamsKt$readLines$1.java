/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.io;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 5, 1})
static final class TextStreamsKt.readLines.1
extends Lambda
implements Function1<String, Unit> {
    final ArrayList $result;

    TextStreamsKt.readLines.1(ArrayList arrayList) {
        this.$result = arrayList;
        super(1);
    }

    public final void invoke(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"it");
        this.$result.add(string);
    }
}
