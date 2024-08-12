/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 */
package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002\u00a8\u0006\u0004"}, d2={"kotlin/sequences/SequencesKt___SequencesKt$minus$2", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class SequencesKt___SequencesKt.minus.2
implements Sequence<T> {
    final Object[] $elements;
    final Sequence $this_minus;

    SequencesKt___SequencesKt.minus.2(Sequence<? extends T> sequence, Object[] objectArray) {
        this.$this_minus = sequence;
        this.$elements = objectArray;
    }

    public Iterator<T> iterator() {
        HashSet hashSet = ArraysKt.toHashSet((Object[])this.$elements);
        return SequencesKt.filterNot((Sequence)this.$this_minus, (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */)).iterator();
    }
}
