/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.identityscope.IdentityScope
 */
package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.identityscope.IdentityScope;

public class IdentityScopeObject<K, T>
implements IdentityScope<K, T> {
    private final ReentrantLock lock;
    private final HashMap<K, Reference<T>> map = new HashMap();

    public IdentityScopeObject() {
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

    public boolean detach(K k, T t) {
        boolean bl;
        this.lock.lock();
        try {
            if (this.get(k) == t && t != null) {
                this.remove(k);
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

    public T get(K object) {
        this.lock.lock();
        object = this.map.get(object);
        if (object == null) return null;
        return ((Reference)object).get();
        finally {
            this.lock.unlock();
        }
    }

    public T getNoLock(K object) {
        if ((object = this.map.get(object)) == null) return null;
        return ((Reference)object).get();
    }

    public void lock() {
        this.lock.lock();
    }

    public void put(K k, T t) {
        this.lock.lock();
        try {
            HashMap<K, Reference<T>> hashMap = this.map;
            WeakReference<T> weakReference = new WeakReference<T>(t);
            hashMap.put(k, weakReference);
            return;
        }
        finally {
            this.lock.unlock();
        }
    }

    public void putNoLock(K k, T t) {
        this.map.put(k, new WeakReference<T>(t));
    }

    public void remove(Iterable<K> object) {
        this.lock.lock();
        try {
            object = object.iterator();
            while (true) {
                if (!object.hasNext()) {
                    this.lock.unlock();
                    return;
                }
                Object e = object.next();
                this.map.remove(e);
            }
        }
        catch (Throwable throwable) {
            this.lock.unlock();
            throw throwable;
        }
    }

    public void remove(K k) {
        this.lock.lock();
        try {
            this.map.remove(k);
            return;
        }
        finally {
            this.lock.unlock();
        }
    }

    public void reserveRoom(int n) {
    }

    public void unlock() {
        this.lock.unlock();
    }
}
