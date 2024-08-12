/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"<anonymous>", "T", "index", "", "element", "invoke", "(ILjava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.onEachIndexed.1
extends Lambda
implements Function2<Integer, T, T> {
    final Function2 $action;

    SequencesKt___SequencesKt.onEachIndexed.1(Function2 function2) {
        this.$action = function2;
        super(2);
    }

    public final T invoke(int n, T t) {
        this.$action.invoke((Object)n, t);
        return t;
    }
}
