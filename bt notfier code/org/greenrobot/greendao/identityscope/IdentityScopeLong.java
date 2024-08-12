/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.identityscope.IdentityScope
 *  org.greenrobot.greendao.internal.LongHashMap
 */
package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.internal.LongHashMap;

public class IdentityScopeLong<T>
implements IdentityScope<Long, T> {
    private final ReentrantLock lock;
    private final LongHashMap<Reference<T>> map = new LongHashMap();

    public IdentityScopeLong() {
        this.lock = new ReentrantLock();
    }

    public void clear() {
        this.lock.lock();
        try {
            this.map.clear();
            return;
        }
        finally {
            this.lock.unlock();
        }
    }

    public boolean detach(Long l, T t) {
        boolean bl;
        this.lock.lock();
        try {
            if (this.get(l) == t && t != null) {
                this.remove(l);
                bl = true;
            } else {
                bl = false;
            }
        }
        finally {
            this.lock.unlock();
        }
        return bl;
    }

    public T get(Long l) {
        return this.get2(l);
    }

    public T get2(long l) {
        this.lock.lock();
        Reference reference = (Reference)this.map.get(l);
        if (reference == null) return null;
        return reference.get();
        finally {
            this.lock.unlock();
        }
    }

    public T get2NoLock(long l) {
        Reference reference = (Reference)this.map.get(l);
        if (reference == null) return null;
        return reference.get();
    }

    public T getNoLock(Long l) {
        return this.get2NoLock(l);
    }

    public void lock() {
        this.lock.lock();
    }

    public void put(Long l, T t) {
        this.put2(l, t);
    }

    public void put2(long l, T t) {
        this.lock.lock();
        try {
            LongHashMap<Reference<T>> longHashMap = this.map;
            WeakReference<T> weakReference = new WeakReference<T>(t);
            longHashMap.put(l, weakReference);
            return;
        }
        finally {
            this.lock.unlock();
        }
    }

    public void put2NoLock(long l, T t) {
        this.map.put(l, new WeakReference<T>(t));
    }

    public void putNoLock(Long l, T t) {
        this.put2NoLock(l, t);
    }

    public void remove(Iterable<Long> object) {
        this.lock.lock();
        try {
            Iterator<Long> iterator = object.iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    this.lock.unlock();
                    return;
                }
                object = iterator.next();
                this.map.remove(((Long)object).longValue());
            }
        }
        catch (Throwable throwable) {
            this.lock.unlock();
            throw throwable;
        }
    }

    public void remove(Long l) {
        this.lock.lock();
        try {
            this.map.remove(l.longValue());
            return;
        }
        finally {
            this.lock.unlock();
        }
    }

    public void reserveRoom(int n) {
        this.map.reserveRoom(n);
    }

    public void unlock() {
        this.lock.unlock();
    }
}
