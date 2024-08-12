/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.FunctionReferenceImpl
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 */
package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\b\u0006"}, d2={"<anonymous>", "", "R", "T", "p1", "Lkotlin/sequences/Sequence;", "invoke"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.flatMapIndexed.2
extends FunctionReferenceImpl
implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt.flatMapIndexed.2 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    SequencesKt___SequencesKt.flatMapIndexed.2() {
    }

    public final Iterator<R> invoke(Sequence<? extends R> sequence) {
        Intrinsics.checkNotNullParameter(sequence, (String)"p1");
        return sequence.iterator();
    }
}
