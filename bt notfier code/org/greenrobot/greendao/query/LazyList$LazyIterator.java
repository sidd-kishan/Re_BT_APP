/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.query.CloseableListIterator
 *  org.greenrobot.greendao.query.LazyList
 */
package org.greenrobot.greendao.query;

import java.util.NoSuchElementException;
import org.greenrobot.greendao.query.CloseableListIterator;
import org.greenrobot.greendao.query.LazyList;

/*
 * Exception performing whole class analysis ignored.
 */
protected class LazyList.LazyIterator
implements CloseableListIterator<E> {
    private final boolean closeWhenDone;
    private int index;
    final LazyList this$0;

    public LazyList.LazyIterator(LazyList lazyList, int n, boolean bl) {
        this.this$0 = lazyList;
        this.index = n;
        this.closeWhenDone = bl;
    }

    public void add(E e) {
        throw new UnsupportedOperationException();
    }

    public void close() {
        this.this$0.close();
    }

    public boolean hasNext() {
        boolean bl = this.index < LazyList.access$000((LazyList)this.this$0);
        return bl;
    }

    public boolean hasPrevious() {
        boolean bl = this.index > 0;
        return bl;
    }

    public E next() {
        int n;
        if (this.index >= LazyList.access$000((LazyList)this.this$0)) throw new NoSuchElementException();
        Object object = this.this$0.get(this.index);
        this.index = n = this.index + 1;
        if (n != LazyList.access$000((LazyList)this.this$0)) return object;
        if (!this.closeWhenDone) return object;
        this.close();
        return object;
    }

    public int nextIndex() {
        return this.index;
    }

    public E previous() {
        int n = this.index;
        if (n <= 0) throw new NoSuchElementException();
        this.index = --n;
        return this.this$0.get(n);
    }

    public int previousIndex() {
        return this.index - 1;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void set(E e) {
        throw new UnsupportedOperationException();
    }
}
