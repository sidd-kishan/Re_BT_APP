/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$SimplePool
 */
package androidx.core.util;

import androidx.core.util.Pools;

public static class Pools.SynchronizedPool<T>
extends Pools.SimplePool<T> {
    private final Object mLock = new Object();

    public Pools.SynchronizedPool(int n) {
        super(n);
    }

    public T acquire() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = super.acquire();
            return (T)object2;
        }
    }

    public boolean release(T t) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = super.release(t);
            return bl;
        }
    }
}
