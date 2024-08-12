/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractCollection
 *  kotlin.collections.AbstractList$Companion
 *  kotlin.collections.AbstractList$IteratorImpl
 *  kotlin.collections.AbstractList$ListIteratorImpl
 *  kotlin.collections.AbstractList$SubList
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMappedMarker
 */
package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b'\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H\u00a6\u0002\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006 "}, d2={"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class AbstractList<E>
extends AbstractCollection<E>
implements List<E>,
KMappedMarker {
    public static final Companion Companion = new Companion(null);

    protected AbstractList() {
    }

    @Override
    public void add(int n, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(int n, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof List) return Companion.orderedEquals$kotlin_stdlib((Collection)this, (Collection)object);
        return false;
    }

    @Override
    public abstract E get(int var1);

    public abstract int getSize();

    @Override
    public int hashCode() {
        return Companion.orderedHashCode$kotlin_stdlib((Collection)this);
    }

    @Override
    public int indexOf(Object object) {
        Iterator iterator = this.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (Intrinsics.areEqual(iterator.next(), (Object)object)) return n;
            ++n;
        }
        n = -1;
        return n;
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator)new IteratorImpl(this);
    }

    @Override
    public int lastIndexOf(Object object) {
        int n;
        block1: {
            ListIterator listIterator = this.listIterator(this.size());
            while (listIterator.hasPrevious()) {
                if (!Intrinsics.areEqual(listIterator.previous(), (Object)object)) continue;
                n = listIterator.nextIndex();
                break block1;
            }
            n = -1;
        }
        return n;
    }

    @Override
    public ListIterator<E> listIterator() {
        return (ListIterator)new ListIteratorImpl(this, 0);
    }

    @Override
    public ListIterator<E> listIterator(int n) {
        return (ListIterator)new ListIteratorImpl(this, n);
    }

    @Override
    public E remove(int n) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public E set(int n, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public List<E> subList(int n, int n2) {
        return (List)new SubList(this, n, n2);
    }
}
