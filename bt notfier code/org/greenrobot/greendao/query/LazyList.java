/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.InternalQueryDaoAccess
 *  org.greenrobot.greendao.query.CloseableListIterator
 *  org.greenrobot.greendao.query.LazyList$LazyIterator
 */
package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;
import org.greenrobot.greendao.query.CloseableListIterator;
import org.greenrobot.greendao.query.LazyList;

public class LazyList<E>
implements List<E>,
Closeable {
    private final Cursor cursor;
    private final InternalQueryDaoAccess<E> daoAccess;
    private final List<E> entities;
    private volatile int loadedCount;
    private final ReentrantLock lock;
    private final int size;

    LazyList(InternalQueryDaoAccess<E> internalQueryDaoAccess, Cursor cursor, boolean bl) {
        this.cursor = cursor;
        this.daoAccess = internalQueryDaoAccess;
        this.size = cursor.getCount();
        if (bl) {
            this.entities = new ArrayList(this.size);
            for (int i = 0; i < this.size; ++i) {
                this.entities.add(null);
            }
        } else {
            this.entities = null;
        }
        if (this.size == 0) {
            cursor.close();
        }
        this.lock = new ReentrantLock();
    }

    static /* synthetic */ int access$000(LazyList lazyList) {
        return lazyList.size;
    }

    @Override
    public void add(int n, E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int n, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    protected void checkCached() {
        if (this.entities == null) throw new DaoException("This operation only works with cached lazy lists");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
        this.cursor.close();
    }

    @Override
    public boolean contains(Object object) {
        this.loadRemaining();
        return this.entities.contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        this.loadRemaining();
        return this.entities.containsAll(collection);
    }

    @Override
    public E get(int n) {
        List<E> list = this.entities;
        if (list != null) {
            E e = list.get(n);
            list = e;
            if (e != null) return (E)list;
            this.lock.lock();
            try {
                e = this.entities.get(n);
                list = e;
                if (e == null) {
                    e = this.loadEntity(n);
                    this.entities.set(n, e);
                    ++this.loadedCount;
                    list = e;
                    if (this.loadedCount == this.size) {
                        this.cursor.close();
                        list = e;
                    }
                }
                this.lock.unlock();
            }
            catch (Throwable throwable) {
                this.lock.unlock();
                throw throwable;
            }
            return (E)list;
        }
        this.lock.lock();
        try {
            list = this.loadEntity(n);
            return (E)list;
        }
        finally {
            this.lock.unlock();
        }
    }

    public int getLoadedCount() {
        return this.loadedCount;
    }

    @Override
    public int indexOf(Object object) {
        this.loadRemaining();
        return this.entities.indexOf(object);
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.size == 0;
        return bl;
    }

    public boolean isLoadedCompletely() {
        boolean bl = this.loadedCount == this.size;
        return bl;
    }

    @Override
    public Iterator<E> iterator() {
        return new LazyIterator(this, 0, false);
    }

    @Override
    public int lastIndexOf(Object object) {
        this.loadRemaining();
        return this.entities.lastIndexOf(object);
    }

    @Override
    public ListIterator<E> listIterator(int n) {
        return new LazyIterator(this, n, false);
    }

    @Override
    public CloseableListIterator<E> listIterator() {
        return new LazyIterator(this, 0, false);
    }

    public CloseableListIterator<E> listIteratorAutoClose() {
        return new LazyIterator(this, 0, true);
    }

    protected E loadEntity(int n) {
        if (!this.cursor.moveToPosition(n)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not move to cursor location ");
            stringBuilder.append(n);
            throw new DaoException(stringBuilder.toString());
        }
        Object object = this.daoAccess.loadCurrent(this.cursor, 0, true);
        if (object != null) {
            return (E)object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Loading of entity failed (null) at position ");
        ((StringBuilder)object).append(n);
        throw new DaoException(((StringBuilder)object).toString());
    }

    public void loadRemaining() {
        this.checkCached();
        int n = this.entities.size();
        int n2 = 0;
        while (n2 < n) {
            this.get(n2);
            ++n2;
        }
    }

    public E peek(int n) {
        List<E> list = this.entities;
        if (list == null) return null;
        return list.get(n);
    }

    @Override
    public E remove(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int n, E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public List<E> subList(int n, int n2) {
        this.checkCached();
        int n3 = n;
        while (n3 < n2) {
            this.get(n3);
            ++n3;
        }
        return this.entities.subList(n, n2);
    }

    @Override
    public Object[] toArray() {
        this.loadRemaining();
        return this.entities.toArray();
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        this.loadRemaining();
        return this.entities.toArray(TArray);
    }
}
