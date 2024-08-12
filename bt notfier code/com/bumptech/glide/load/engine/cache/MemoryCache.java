/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.cache.MemoryCache$ResourceRemovedListener
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

public interface MemoryCache {
    public void clearMemory();

    public long getCurrentSize();

    public long getMaxSize();

    public Resource<?> put(Key var1, Resource<?> var2);

    public Resource<?> remove(Key var1);

    public void setResourceRemovedListener(ResourceRemovedListener var1);

    public void setSizeMultiplier(float var1);

    public void trimMemory(int var1);
}
