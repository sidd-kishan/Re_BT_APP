/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
static final class SequencesKt__SequencesKt.generateSequence.2
extends Lambda
implements Function0<T> {
    final Object $seed;

    SequencesKt__SequencesKt.generateSequence.2(Object object) {
        this.$seed = object;
        super(0);
    }

    public final T invoke() {
        return this.$seed;
    }
}
