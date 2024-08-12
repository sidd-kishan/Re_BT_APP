/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ModelCache
 *  com.bumptech.glide.load.model.ModelCache$ModelKey
 *  com.bumptech.glide.util.LruCache
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.util.LruCache;

class ModelCache.1
extends LruCache<ModelCache.ModelKey<A>, B> {
    final ModelCache this$0;

    ModelCache.1(ModelCache modelCache, long l) {
        this.this$0 = modelCache;
        super(l);
    }

    protected void onItemEvicted(ModelCache.ModelKey<A> modelKey, B b) {
        modelKey.release();
    }
}
