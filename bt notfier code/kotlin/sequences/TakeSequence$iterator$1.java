/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.sequences.TakeSequence
 */
package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.TakeSequence;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2={"kotlin/sequences/TakeSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class TakeSequence.iterator.1
implements Iterator<T>,
KMappedMarker {
    private final Iterator<T> iterator;
    private int left;
    final TakeSequence this$0;

    TakeSequence.iterator.1(TakeSequence takeSequence) {
        this.this$0 = takeSequence;
        this.left = TakeSequence.access$getCount$p((TakeSequence)takeSequence);
        this.iterator = TakeSequence.access$getSequence$p((TakeSequence)takeSequence).iterator();
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getLeft() {
        return this.left;
    }

    @Override
    public boolean hasNext() {
        boolean bl = this.left > 0 && this.iterator.hasNext();
        return bl;
    }

    @Override
    public T next() {
        int n = this.left;
        if (n == 0) throw (Throwable)new NoSuchElementException();
        this.left = n - 1;
        return this.iterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setLeft(int n) {
        this.left = n;
    }
}
