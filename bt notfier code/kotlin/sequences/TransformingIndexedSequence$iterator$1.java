/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.sequences.TransformingIndexedSequence
 */
package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.TransformingIndexedSequence;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2={"kotlin/sequences/TransformingIndexedSequence$iterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class TransformingIndexedSequence.iterator.1
implements Iterator<R>,
KMappedMarker {
    private int index;
    private final Iterator<T> iterator;
    final TransformingIndexedSequence this$0;

    TransformingIndexedSequence.iterator.1(TransformingIndexedSequence transformingIndexedSequence) {
        this.this$0 = transformingIndexedSequence;
        this.iterator = TransformingIndexedSequence.access$getSequence$p((TransformingIndexedSequence)transformingIndexedSequence).iterator();
    }

    public final int getIndex() {
        return this.index;
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public R next() {
        Function2 function2 = TransformingIndexedSequence.access$getTransformer$p((TransformingIndexedSequence)this.this$0);
        int n = this.index;
        this.index = n + 1;
        if (n >= 0) return function2.invoke((Object)n, this.iterator.next());
        CollectionsKt.throwIndexOverflow();
        return function2.invoke((Object)n, this.iterator.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int n) {
        this.index = n;
    }
}
