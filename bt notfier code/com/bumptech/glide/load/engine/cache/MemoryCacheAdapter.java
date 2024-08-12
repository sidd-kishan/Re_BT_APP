/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.cache.MemoryCache
 *  com.bumptech.glide.load.engine.cache.MemoryCache$ResourceRemovedListener
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

public class MemoryCacheAdapter
implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    public void clearMemory() {
    }

    public long getCurrentSize() {
        return 0L;
    }

    public long getMaxSize() {
        return 0L;
    }

    public Resource<?> put(Key key, Resource<?> resource) {
        if (resource == null) return null;
        this.listener.onResourceRemoved(resource);
        return null;
    }

    public Resource<?> remove(Key key) {
        return null;
    }

    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    public void setSizeMultiplier(float f) {
    }

    public void trimMemory(int n) {
    }
}
