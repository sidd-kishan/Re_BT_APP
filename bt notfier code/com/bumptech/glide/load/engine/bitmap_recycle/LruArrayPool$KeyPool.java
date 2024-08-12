/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$Key
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;

private static final class LruArrayPool.KeyPool
extends BaseKeyPool<LruArrayPool.Key> {
    LruArrayPool.KeyPool() {
    }

    protected LruArrayPool.Key create() {
        return new LruArrayPool.Key(this);
    }

    LruArrayPool.Key get(int n, Class<?> clazz) {
        LruArrayPool.Key key = (LruArrayPool.Key)this.get();
        key.init(n, clazz);
        return key;
    }
}
