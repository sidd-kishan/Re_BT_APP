/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 *  com.bumptech.glide.util.pool.FactoryPools$Poolable
 *  com.bumptech.glide.util.pool.FactoryPools$Resetter
 */
package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.FactoryPools;

private static final class FactoryPools.FactoryPool<T>
implements Pools.Pool<T> {
    private final FactoryPools.Factory<T> factory;
    private final Pools.Pool<T> pool;
    private final FactoryPools.Resetter<T> resetter;

    FactoryPools.FactoryPool(Pools.Pool<T> pool, FactoryPools.Factory<T> factory, FactoryPools.Resetter<T> resetter) {
        this.pool = pool;
        this.factory = factory;
        this.resetter = resetter;
    }

    public T acquire() {
        Object object;
        Object object2 = object = this.pool.acquire();
        if (object == null) {
            object2 = object = this.factory.create();
            if (Log.isLoggable((String)"FactoryPools", (int)2)) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Created new ");
                ((StringBuilder)object2).append(object.getClass());
                Log.v((String)"FactoryPools", (String)((StringBuilder)object2).toString());
                object2 = object;
            }
        }
        if (!(object2 instanceof FactoryPools.Poolable)) return (T)object2;
        ((FactoryPools.Poolable)object2).getVerifier().setRecycled(false);
        return (T)object2;
    }

    public boolean release(T t) {
        if (t instanceof FactoryPools.Poolable) {
            ((FactoryPools.Poolable)t).getVerifier().setRecycled(true);
        }
        this.resetter.reset(t);
        return this.pool.release(t);
    }
}
