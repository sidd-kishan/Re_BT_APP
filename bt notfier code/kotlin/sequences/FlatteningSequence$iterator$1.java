/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.sequences.FlatteningSequence
 */
package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.FlatteningSequence;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0096\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004\u00a8\u0006\u000e"}, d2={"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class FlatteningSequence.iterator.1
implements Iterator<E>,
KMappedMarker {
    private Iterator<? extends E> itemIterator;
    private final Iterator<T> iterator;
    final FlatteningSequence this$0;

    FlatteningSequence.iterator.1(FlatteningSequence flatteningSequence) {
        this.this$0 = flatteningSequence;
        this.iterator = FlatteningSequence.access$getSequence$p((FlatteningSequence)flatteningSequence).iterator();
    }

    private final boolean ensureItemIterator() {
        Iterator iterator2 = this.itemIterator;
        if (iterator2 != null && !iterator2.hasNext()) {
            this.itemIterator = null;
        }
        do {
            if (this.itemIterator != null) return true;
            if (!this.iterator.hasNext()) {
                return false;
            }
            iterator2 = this.iterator.next();
        } while (!(iterator2 = (Iterator)FlatteningSequence.access$getIterator$p((FlatteningSequence)this.this$0).invoke(FlatteningSequence.access$getTransformer$p((FlatteningSequence)this.this$0).invoke(iterator2))).hasNext());
        this.itemIterator = iterator2;
        return true;
    }

    public final Iterator<E> getItemIterator() {
        return this.itemIterator;
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    @Override
    public boolean hasNext() {
        return this.ensureItemIterator();
    }

    @Override
    public E next() {
        if (!this.ensureItemIterator()) throw (Throwable)new NoSuchElementException();
        Iterator iterator2 = this.itemIterator;
        Intrinsics.checkNotNull(iterator2);
        return iterator2.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setItemIterator(Iterator<? extends E> iterator2) {
        this.itemIterator = iterator2;
    }
}
