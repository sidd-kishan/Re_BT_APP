/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  kotlin.sequences.Sequence
 */
package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n\u00a2\u0006\u0002\b\u0005"}, d2={"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"}, k=3, mv={1, 5, 1})
static final class SequencesKt__SequencesKt.flatten.1
extends Lambda
implements Function1<Sequence<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt.flatten.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    SequencesKt__SequencesKt.flatten.1() {
    }

    public final Iterator<T> invoke(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, (String)"it");
        return sequence.iterator();
    }
}
