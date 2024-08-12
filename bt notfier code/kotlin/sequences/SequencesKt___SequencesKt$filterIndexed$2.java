/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.IndexedValue
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "T", "it", "Lkotlin/collections/IndexedValue;", "invoke", "(Lkotlin/collections/IndexedValue;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.filterIndexed.2
extends Lambda
implements Function1<IndexedValue<? extends T>, T> {
    public static final SequencesKt___SequencesKt.filterIndexed.2 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    SequencesKt___SequencesKt.filterIndexed.2() {
    }

    public final T invoke(IndexedValue<? extends T> indexedValue) {
        Intrinsics.checkNotNullParameter(indexedValue, (String)"it");
        return indexedValue.getValue();
    }
}
