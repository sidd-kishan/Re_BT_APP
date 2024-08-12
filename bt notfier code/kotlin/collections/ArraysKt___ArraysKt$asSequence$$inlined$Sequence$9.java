/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.ArrayIteratorsKt
 *  kotlin.sequences.Sequence
 */
package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class ArraysKt___ArraysKt$asSequence$.inlined.Sequence.9
implements Sequence<Character> {
    final char[] $this_asSequence$inlined;

    public ArraysKt___ArraysKt$asSequence$.inlined.Sequence.9(char[] cArray) {
        this.$this_asSequence$inlined = cArray;
    }

    public Iterator<Character> iterator() {
        return (Iterator)ArrayIteratorsKt.iterator((char[])this.$this_asSequence$inlined);
    }
}
