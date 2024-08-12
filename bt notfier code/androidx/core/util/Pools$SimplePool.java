/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 */
package androidx.core.util;

import androidx.core.util.Pools;

public static class Pools.SimplePool<T>
implements Pools.Pool<T> {
    private final Object[] mPool;
    private int mPoolSize;

    public Pools.SimplePool(int n) {
        if (n <= 0) throw new IllegalArgumentException("The max pool size must be > 0");
        this.mPool = new Object[n];
    }

    private boolean isInPool(T t) {
        int n = 0;
        while (n < this.mPoolSize) {
            if (this.mPool[n] == t) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public T acquire() {
        int n = this.mPoolSize;
        if (n <= 0) return null;
        int n2 = n - 1;
        Object[] objectArray = this.mPool;
        Object object = objectArray[n2];
        objectArray[n2] = null;
        this.mPoolSize = n - 1;
        return (T)object;
    }

    public boolean release(T t) {
        if (this.isInPool(t)) throw new IllegalStateException("Already in the pool!");
        int n = this.mPoolSize;
        Object[] objectArray = this.mPool;
        if (n >= objectArray.length) return false;
        objectArray[n] = t;
        this.mPoolSize = n + 1;
        return true;
    }
}
