/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.cache.DiskCache
 *  com.bumptech.glide.load.engine.cache.DiskCache$Factory
 *  com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
 *  com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import java.io.File;

public class DiskLruCacheFactory
implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long l) {
        this.diskCacheSize = l;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    public DiskLruCacheFactory(String string, long l) {
        this((CacheDirectoryGetter)new /* Unavailable Anonymous Inner Class!! */, l);
    }

    public DiskLruCacheFactory(String string, String string2, long l) {
        this((CacheDirectoryGetter)new /* Unavailable Anonymous Inner Class!! */, l);
    }

    public DiskCache build() {
        File file = this.cacheDirectoryGetter.getCacheDirectory();
        if (file == null) {
            return null;
        }
        if (file.mkdirs()) return DiskLruCacheWrapper.create((File)file, (long)this.diskCacheSize);
        if (!file.exists()) return null;
        if (file.isDirectory()) return DiskLruCacheWrapper.create((File)file, (long)this.diskCacheSize);
        return null;
    }
}
