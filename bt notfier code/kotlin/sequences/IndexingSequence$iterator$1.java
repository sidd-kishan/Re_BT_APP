/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.sequences.IndexingSequence
 */
package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.IndexingSequence;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\t\u0010\f\u001a\u00020\rH\u0096\u0002J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2={"kotlin/sequences/IndexingSequence$iterator$1", "", "Lkotlin/collections/IndexedValue;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class IndexingSequence.iterator.1
implements Iterator<IndexedValue<? extends T>>,
KMappedMarker {
    private int index;
    private final Iterator<T> iterator;
    final IndexingSequence this$0;

    IndexingSequence.iterator.1(IndexingSequence indexingSequence) {
        this.this$0 = indexingSequence;
        this.iterator = IndexingSequence.access$getSequence$p((IndexingSequence)indexingSequence).iterator();
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
    public IndexedValue<T> next() {
        int n = this.index;
        this.index = n + 1;
        if (n >= 0) return new IndexedValue(n, this.iterator.next());
        CollectionsKt.throwIndexOverflow();
        return new IndexedValue(n, this.iterator.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int n) {
        this.index = n;
    }
}
