/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$Key
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool;
import com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy;

static class SizeConfigStrategy.KeyPool
extends BaseKeyPool<SizeConfigStrategy.Key> {
    SizeConfigStrategy.KeyPool() {
    }

    protected SizeConfigStrategy.Key create() {
        return new SizeConfigStrategy.Key(this);
    }

    public SizeConfigStrategy.Key get(int n, Bitmap.Config config) {
        SizeConfigStrategy.Key key = (SizeConfigStrategy.Key)this.get();
        key.init(n, config);
        return key;
    }
}
