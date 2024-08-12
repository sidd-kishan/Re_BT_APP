/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ModelCache$ModelKey
 *  com.bumptech.glide.util.LruCache
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.util.LruCache;

/*
 * Exception performing whole class analysis ignored.
 */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    public ModelCache() {
        this(250L);
    }

    public ModelCache(long l) {
        this.cache = new /* Unavailable Anonymous Inner Class!! */;
    }

    public void clear() {
        this.cache.clearMemory();
    }

    public B get(A object, int n, int n2) {
        ModelKey modelKey = ModelKey.get(object, (int)n, (int)n2);
        object = this.cache.get((Object)modelKey);
        modelKey.release();
        return (B)object;
    }

    public void put(A object, int n, int n2, B b) {
        object = ModelKey.get(object, (int)n, (int)n2);
        this.cache.put(object, b);
    }
}
