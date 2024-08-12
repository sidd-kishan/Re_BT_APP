/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.GlideBuilder
 *  com.bumptech.glide.load.engine.cache.DiskCache
 *  com.bumptech.glide.load.engine.cache.DiskCache$Factory
 */
package com.bumptech.glide;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskCache;

class GlideBuilder.1
implements DiskCache.Factory {
    final GlideBuilder this$0;
    final DiskCache val$diskCache;

    GlideBuilder.1(GlideBuilder glideBuilder, DiskCache diskCache) {
        this.this$0 = glideBuilder;
        this.val$diskCache = diskCache;
    }

    public DiskCache build() {
        return this.val$diskCache;
    }
}
