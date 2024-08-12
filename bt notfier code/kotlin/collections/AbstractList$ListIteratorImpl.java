/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractList
 *  kotlin.collections.AbstractList$IteratorImpl
 *  kotlin.jvm.internal.markers.KMappedMarker
 */
package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0092\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\r\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2={"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private class AbstractList.ListIteratorImpl
extends AbstractList.IteratorImpl
implements ListIterator<E>,
KMappedMarker {
    final AbstractList this$0;

    public AbstractList.ListIteratorImpl(AbstractList abstractList, int n) {
        this.this$0 = abstractList;
        super(abstractList);
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(n, abstractList.size());
        this.setIndex(n);
    }

    @Override
    public void add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean hasPrevious() {
        boolean bl = this.getIndex() > 0;
        return bl;
    }

    @Override
    public int nextIndex() {
        return this.getIndex();
    }

    @Override
    public E previous() {
        if (!this.hasPrevious()) throw (Throwable)new NoSuchElementException();
        AbstractList abstractList = this.this$0;
        this.setIndex(this.getIndex() - 1);
        return abstractList.get(this.getIndex());
    }

    @Override
    public int previousIndex() {
        return this.getIndex() - 1;
    }

    @Override
    public void set(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
