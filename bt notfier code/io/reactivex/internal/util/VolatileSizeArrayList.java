/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T>
extends AtomicInteger
implements List<T>,
RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList();
    }

    public VolatileSizeArrayList(int n) {
        this.list = new ArrayList(n);
    }

    @Override
    public void add(int n, T t) {
        this.list.add(n, t);
        this.lazySet(this.list.size());
    }

    @Override
    public boolean add(T t) {
        boolean bl = this.list.add(t);
        this.lazySet(this.list.size());
        return bl;
    }

    @Override
    public boolean addAll(int n, Collection<? extends T> collection) {
        boolean bl = this.list.addAll(n, collection);
        this.lazySet(this.list.size());
        return bl;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean bl = this.list.addAll(collection);
        this.lazySet(this.list.size());
        return bl;
    }

    @Override
    public void clear() {
        this.list.clear();
        this.lazySet(0);
    }

    @Override
    public boolean contains(Object object) {
        return this.list.contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof VolatileSizeArrayList)) return this.list.equals(object);
        return this.list.equals(((VolatileSizeArrayList)object).list);
    }

    @Override
    public T get(int n) {
        return this.list.get(n);
    }

    @Override
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override
    public int indexOf(Object object) {
        return this.list.indexOf(object);
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.get() == 0;
        return bl;
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.list.lastIndexOf(object);
    }

    @Override
    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int n) {
        return this.list.listIterator(n);
    }

    @Override
    public T remove(int n) {
        T t = this.list.remove(n);
        this.lazySet(this.list.size());
        return t;
    }

    @Override
    public boolean remove(Object object) {
        boolean bl = this.list.remove(object);
        this.lazySet(this.list.size());
        return bl;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean bl = this.list.removeAll(collection);
        this.lazySet(this.list.size());
        return bl;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean bl = this.list.retainAll(collection);
        this.lazySet(this.list.size());
        return bl;
    }

    @Override
    public T set(int n, T t) {
        return this.list.set(n, t);
    }

    @Override
    public int size() {
        return this.get();
    }

    @Override
    public List<T> subList(int n, int n2) {
        return this.list.subList(n, n2);
    }

    @Override
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override
    public <E> E[] toArray(E[] EArray) {
        return this.list.toArray(EArray);
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}
