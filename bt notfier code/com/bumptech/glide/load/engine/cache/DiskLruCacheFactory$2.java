/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

class DiskLruCacheFactory.2
implements DiskLruCacheFactory.CacheDirectoryGetter {
    final String val$diskCacheFolder;
    final String val$diskCacheName;

    DiskLruCacheFactory.2(String string, String string2) {
        this.val$diskCacheFolder = string;
        this.val$diskCacheName = string2;
    }

    public File getCacheDirectory() {
        return new File(this.val$diskCacheFolder, this.val$diskCacheName);
    }
}
