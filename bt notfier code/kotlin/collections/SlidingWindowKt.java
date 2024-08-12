/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.EmptyIterator
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 */
package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u00a8\u0006\u000f"}, d2={"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", "T", "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int n, int n2) {
        CharSequence charSequence;
        boolean bl = n > 0 && n2 > 0;
        if (bl) return;
        if (n != n2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Both size ");
            ((StringBuilder)charSequence).append(n);
            ((StringBuilder)charSequence).append(" and step ");
            ((StringBuilder)charSequence).append(n2);
            ((StringBuilder)charSequence).append(" must be greater than zero.");
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("size ");
            ((StringBuilder)charSequence).append(n);
            ((StringBuilder)charSequence).append(" must be greater than zero.");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        throw (Throwable)new IllegalArgumentException(((Object)charSequence).toString());
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> iterator, int n, int n2, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter(iterator, (String)"iterator");
        if (iterator.hasNext()) return SequencesKt.iterator((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
        return (Iterator)EmptyIterator.INSTANCE;
    }

    public static final <T> Sequence<List<T>> windowedSequence(Sequence<? extends T> sequence, int n, int n2, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter(sequence, (String)"$this$windowedSequence");
        SlidingWindowKt.checkWindowSizeStep(n, n2);
        return (Sequence)new /* Unavailable Anonymous Inner Class!! */;
    }
}
