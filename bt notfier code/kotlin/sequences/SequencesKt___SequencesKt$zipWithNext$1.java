/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"<anonymous>", "Lkotlin/Pair;", "T", "a", "b", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.zipWithNext.1
extends Lambda
implements Function2<T, T, Pair<? extends T, ? extends T>> {
    public static final SequencesKt___SequencesKt.zipWithNext.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    SequencesKt___SequencesKt.zipWithNext.1() {
    }

    public final Pair<T, T> invoke(T t, T t2) {
        return TuplesKt.to(t, t2);
    }
}
