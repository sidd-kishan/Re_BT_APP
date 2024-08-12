/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy$Key
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool;
import com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy;

static class SizeStrategy.KeyPool
extends BaseKeyPool<SizeStrategy.Key> {
    SizeStrategy.KeyPool() {
    }

    protected SizeStrategy.Key create() {
        return new SizeStrategy.Key(this);
    }

    public SizeStrategy.Key get(int n) {
        SizeStrategy.Key key = (SizeStrategy.Key)super.get();
        key.init(n);
        return key;
    }
}
