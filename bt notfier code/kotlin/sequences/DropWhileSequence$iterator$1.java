/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.sequences.DropWhileSequence
 */
package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.DropWhileSequence;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000!\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2={"kotlin/sequences/DropWhileSequence$iterator$1", "", "dropState", "", "getDropState", "()I", "setDropState", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "drop", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class DropWhileSequence.iterator.1
implements Iterator<T>,
KMappedMarker {
    private int dropState;
    private final Iterator<T> iterator;
    private T nextItem;
    final DropWhileSequence this$0;

    DropWhileSequence.iterator.1(DropWhileSequence dropWhileSequence) {
        this.this$0 = dropWhileSequence;
        this.iterator = DropWhileSequence.access$getSequence$p((DropWhileSequence)dropWhileSequence).iterator();
        this.dropState = -1;
    }

    private final void drop() {
        Object t;
        do {
            if (!this.iterator.hasNext()) {
                this.dropState = 0;
                return;
            }
            t = this.iterator.next();
        } while (((Boolean)DropWhileSequence.access$getPredicate$p((DropWhileSequence)this.this$0).invoke(t)).booleanValue());
        this.nextItem = t;
        this.dropState = 1;
    }

    public final int getDropState() {
        return this.dropState;
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final T getNextItem() {
        return this.nextItem;
    }

    @Override
    public boolean hasNext() {
        boolean bl;
        if (this.dropState == -1) {
            this.drop();
        }
        int n = this.dropState;
        boolean bl2 = bl = true;
        if (n == 1) return bl2;
        bl2 = this.iterator.hasNext() ? bl : false;
        return bl2;
    }

    @Override
    public T next() {
        if (this.dropState == -1) {
            this.drop();
        }
        if (this.dropState != 1) return this.iterator.next();
        Object t = this.nextItem;
        this.nextItem = null;
        this.dropState = 0;
        return t;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setDropState(int n) {
        this.dropState = n;
    }

    public final void setNextItem(T t) {
        this.nextItem = t;
    }
}
