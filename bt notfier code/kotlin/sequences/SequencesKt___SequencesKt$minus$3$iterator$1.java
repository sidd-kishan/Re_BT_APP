/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.sequences;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Z"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.minus.iterator.1
extends Lambda
implements Function1<T, Boolean> {
    final Collection $other;

    SequencesKt___SequencesKt.minus.iterator.1(Collection collection) {
        this.$other = collection;
        super(1);
    }

    public final boolean invoke(T t) {
        return this.$other.contains(t);
    }
}
