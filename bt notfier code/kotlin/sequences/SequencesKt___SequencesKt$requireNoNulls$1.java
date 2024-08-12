/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 *  kotlin.sequences.Sequence
 */
package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.requireNoNulls.1
extends Lambda
implements Function1<T, T> {
    final Sequence $this_requireNoNulls;

    SequencesKt___SequencesKt.requireNoNulls.1(Sequence sequence) {
        this.$this_requireNoNulls = sequence;
        super(1);
    }

    public final T invoke(T object) {
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("null element found in ");
        ((StringBuilder)object).append(this.$this_requireNoNulls);
        ((StringBuilder)object).append('.');
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
    }
}
