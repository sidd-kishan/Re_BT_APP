/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.Pools$Pool
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.Pools;

static class Pools.SimplePool<T>
implements Pools.Pool<T> {
    private final Object[] mPool;
    private int mPoolSize;

    Pools.SimplePool(int n) {
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
        int n = this.mPoolSize;
        Object[] objectArray = this.mPool;
        if (n >= objectArray.length) return false;
        objectArray[n] = t;
        this.mPoolSize = n + 1;
        return true;
    }

    public void releaseAll(T[] TArray, int n) {
        int n2 = n;
        if (n > TArray.length) {
            n2 = TArray.length;
        }
        n = 0;
        while (n < n2) {
            T t = TArray[n];
            int n3 = this.mPoolSize;
            Object[] objectArray = this.mPool;
            if (n3 < objectArray.length) {
                objectArray[n3] = t;
                this.mPoolSize = n3 + 1;
            }
            ++n;
        }
    }
}
