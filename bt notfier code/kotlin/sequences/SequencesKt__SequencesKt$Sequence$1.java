/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.sequences.Sequence
 */
package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002\u00a8\u0006\u0004"}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class SequencesKt__SequencesKt.Sequence.1
implements Sequence<T> {
    final Function0 $iterator;

    public SequencesKt__SequencesKt.Sequence.1(Function0 function0) {
        this.$iterator = function0;
    }

    public Iterator<T> iterator() {
        return (Iterator)this.$iterator.invoke();
    }
}
