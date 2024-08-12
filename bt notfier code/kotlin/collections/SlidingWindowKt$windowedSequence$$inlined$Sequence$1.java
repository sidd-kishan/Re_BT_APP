/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.SlidingWindowKt
 *  kotlin.sequences.Sequence
 */
package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SlidingWindowKt;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class SlidingWindowKt$windowedSequence$.inlined.Sequence.1
implements Sequence<List<? extends T>> {
    final boolean $partialWindows$inlined;
    final boolean $reuseBuffer$inlined;
    final int $size$inlined;
    final int $step$inlined;
    final Sequence $this_windowedSequence$inlined;

    public SlidingWindowKt$windowedSequence$.inlined.Sequence.1(Sequence sequence, int n, int n2, boolean bl, boolean bl2) {
        this.$this_windowedSequence$inlined = sequence;
        this.$size$inlined = n;
        this.$step$inlined = n2;
        this.$partialWindows$inlined = bl;
        this.$reuseBuffer$inlined = bl2;
    }

    public Iterator<List<? extends T>> iterator() {
        return SlidingWindowKt.windowedIterator((Iterator)this.$this_windowedSequence$inlined.iterator(), (int)this.$size$inlined, (int)this.$step$inlined, (boolean)this.$partialWindows$inlined, (boolean)this.$reuseBuffer$inlined);
    }
}
