/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2={"<anonymous>", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.onEach.1
extends Lambda
implements Function1<T, T> {
    final Function1 $action;

    SequencesKt___SequencesKt.onEach.1(Function1 function1) {
        this.$action = function1;
        super(1);
    }

    public final T invoke(T t) {
        this.$action.invoke(t);
        return t;
    }
}
