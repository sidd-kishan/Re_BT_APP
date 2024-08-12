/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool = Util.createQueue((int)20);

    BaseKeyPool() {
    }

    abstract T create();

    T get() {
        Poolable poolable;
        Object object = poolable = (Poolable)this.keyPool.poll();
        if (poolable != null) return (T)object;
        object = this.create();
        return (T)object;
    }

    public void offer(T t) {
        if (this.keyPool.size() >= 20) return;
        this.keyPool.offer(t);
    }
}
