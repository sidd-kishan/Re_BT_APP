/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.sequences.FilteringSequence
 */
package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.FilteringSequence;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2={"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class FilteringSequence.iterator.1
implements Iterator<T>,
KMappedMarker {
    private final Iterator<T> iterator;
    private T nextItem;
    private int nextState;
    final FilteringSequence this$0;

    FilteringSequence.iterator.1(FilteringSequence filteringSequence) {
        this.this$0 = filteringSequence;
        this.iterator = FilteringSequence.access$getSequence$p((FilteringSequence)filteringSequence).iterator();
        this.nextState = -1;
    }

    private final void calcNext() {
        Object t;
        do {
            if (!this.iterator.hasNext()) {
                this.nextState = 0;
                return;
            }
            t = this.iterator.next();
        } while ((Boolean)FilteringSequence.access$getPredicate$p((FilteringSequence)this.this$0).invoke(t) != FilteringSequence.access$getSendWhen$p((FilteringSequence)this.this$0));
        this.nextItem = t;
        this.nextState = 1;
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final T getNextItem() {
        return this.nextItem;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override
    public boolean hasNext() {
        if (this.nextState == -1) {
            this.calcNext();
        }
        int n = this.nextState;
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    @Override
    public T next() {
        if (this.nextState == -1) {
            this.calcNext();
        }
        if (this.nextState == 0) throw (Throwable)new NoSuchElementException();
        Object t = this.nextItem;
        this.nextItem = null;
        this.nextState = -1;
        return t;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNextItem(T t) {
        this.nextItem = t;
    }

    public final void setNextState(int n) {
        this.nextState = n;
    }
}
