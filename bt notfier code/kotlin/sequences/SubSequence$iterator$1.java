/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.sequences.SubSequence
 */
package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SubSequence;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2={"kotlin/sequences/SubSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class SubSequence.iterator.1
implements Iterator<T>,
KMappedMarker {
    private final Iterator<T> iterator;
    private int position;
    final SubSequence this$0;

    SubSequence.iterator.1(SubSequence subSequence) {
        this.this$0 = subSequence;
        this.iterator = SubSequence.access$getSequence$p((SubSequence)subSequence).iterator();
    }

    private final void drop() {
        while (this.position < SubSequence.access$getStartIndex$p((SubSequence)this.this$0)) {
            if (!this.iterator.hasNext()) return;
            this.iterator.next();
            ++this.position;
        }
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getPosition() {
        return this.position;
    }

    @Override
    public boolean hasNext() {
        this.drop();
        boolean bl = this.position < SubSequence.access$getEndIndex$p((SubSequence)this.this$0) && this.iterator.hasNext();
        return bl;
    }

    @Override
    public T next() {
        this.drop();
        if (this.position >= SubSequence.access$getEndIndex$p((SubSequence)this.this$0)) throw (Throwable)new NoSuchElementException();
        ++this.position;
        return this.iterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setPosition(int n) {
        this.position = n;
    }
}
