/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.cache.MemoryCache
 *  com.bumptech.glide.load.engine.cache.MemoryCache$ResourceRemovedListener
 *  com.bumptech.glide.util.LruCache
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache
extends LruCache<Key, Resource<?>>
implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    public LruResourceCache(long l) {
        super(l);
    }

    protected int getSize(Resource<?> resource) {
        if (resource != null) return resource.getSize();
        return super.getSize(null);
    }

    protected void onItemEvicted(Key key, Resource<?> resource) {
        key = this.listener;
        if (key == null) return;
        if (resource == null) return;
        key.onResourceRemoved(resource);
    }

    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    public void trimMemory(int n) {
        if (n >= 40) {
            this.clearMemory();
        } else {
            if (n < 20) return;
            this.trimToSize(this.getMaxSize() / 2L);
        }
    }
}
