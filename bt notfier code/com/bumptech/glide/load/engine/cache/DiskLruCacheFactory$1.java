/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

class DiskLruCacheFactory.1
implements DiskLruCacheFactory.CacheDirectoryGetter {
    final String val$diskCacheFolder;

    DiskLruCacheFactory.1(String string) {
        this.val$diskCacheFolder = string;
    }

    public File getCacheDirectory() {
        return new File(this.val$diskCacheFolder);
    }
}
