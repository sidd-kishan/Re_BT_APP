/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractList
 *  kotlin.jvm.internal.markers.KMappedMarker
 */
package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0092\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2={"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private class AbstractList.IteratorImpl
implements Iterator<E>,
KMappedMarker {
    private int index;
    final AbstractList this$0;

    public AbstractList.IteratorImpl(AbstractList abstractList) {
        this.this$0 = abstractList;
    }

    protected final int getIndex() {
        return this.index;
    }

    @Override
    public boolean hasNext() {
        boolean bl = this.index < this.this$0.size();
        return bl;
    }

    @Override
    public E next() {
        if (!this.hasNext()) throw (Throwable)new NoSuchElementException();
        AbstractList abstractList = this.this$0;
        int n = this.index;
        this.index = n + 1;
        return abstractList.get(n);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected final void setIndex(int n) {
        this.index = n;
    }
}
