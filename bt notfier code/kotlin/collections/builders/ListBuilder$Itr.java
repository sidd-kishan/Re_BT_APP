/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.builders.ListBuilder
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableListIterator
 */
package kotlin.collections.builders;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private static final class ListBuilder.Itr<E>
implements ListIterator<E>,
KMutableListIterator {
    private int index;
    private int lastIndex;
    private final ListBuilder<E> list;

    public ListBuilder.Itr(ListBuilder<E> listBuilder, int n) {
        Intrinsics.checkNotNullParameter(listBuilder, (String)"list");
        this.list = listBuilder;
        this.index = n;
        this.lastIndex = -1;
    }

    @Override
    public void add(E e) {
        ListBuilder<E> listBuilder = this.list;
        int n = this.index;
        this.index = n + 1;
        listBuilder.add(n, e);
        this.lastIndex = -1;
    }

    @Override
    public boolean hasNext() {
        boolean bl = this.index < ListBuilder.access$getLength$p(this.list);
        return bl;
    }

    @Override
    public boolean hasPrevious() {
        boolean bl = this.index > 0;
        return bl;
    }

    @Override
    public E next() {
        if (this.index >= ListBuilder.access$getLength$p(this.list)) throw (Throwable)new NoSuchElementException();
        int n = this.index;
        this.index = n + 1;
        this.lastIndex = n;
        return (E)ListBuilder.access$getArray$p(this.list)[ListBuilder.access$getOffset$p(this.list) + this.lastIndex];
    }

    @Override
    public int nextIndex() {
        return this.index;
    }

    @Override
    public E previous() {
        int n = this.index;
        if (n <= 0) throw (Throwable)new NoSuchElementException();
        this.index = --n;
        this.lastIndex = n;
        return (E)ListBuilder.access$getArray$p(this.list)[ListBuilder.access$getOffset$p(this.list) + this.lastIndex];
    }

    @Override
    public int previousIndex() {
        return this.index - 1;
    }

    @Override
    public void remove() {
        boolean bl = this.lastIndex != -1;
        if (!bl) throw (Throwable)new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        this.list.remove(this.lastIndex);
        this.index = this.lastIndex;
        this.lastIndex = -1;
    }

    @Override
    public void set(E e) {
        boolean bl = this.lastIndex != -1;
        if (!bl) throw (Throwable)new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        this.list.set(this.lastIndex, e);
    }
}
