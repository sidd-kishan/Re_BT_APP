/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.IndexedValue
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n\u00a2\u0006\u0002\b\u0005"}, d2={"<anonymous>", "", "T", "it", "Lkotlin/collections/IndexedValue;", "invoke"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.filterIndexed.1
extends Lambda
implements Function1<IndexedValue<? extends T>, Boolean> {
    final Function2 $predicate;

    SequencesKt___SequencesKt.filterIndexed.1(Function2 function2) {
        this.$predicate = function2;
        super(1);
    }

    public final boolean invoke(IndexedValue<? extends T> indexedValue) {
        Intrinsics.checkNotNullParameter(indexedValue, (String)"it");
        return (Boolean)this.$predicate.invoke((Object)indexedValue.getIndex(), indexedValue.getValue());
    }
}
