/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy$Key
 *  com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool;

static class AttributeStrategy.KeyPool
extends BaseKeyPool<AttributeStrategy.Key> {
    AttributeStrategy.KeyPool() {
    }

    protected AttributeStrategy.Key create() {
        return new AttributeStrategy.Key(this);
    }

    AttributeStrategy.Key get(int n, int n2, Bitmap.Config config) {
        AttributeStrategy.Key key = (AttributeStrategy.Key)this.get();
        key.init(n, n2, config);
        return key;
    }
}
