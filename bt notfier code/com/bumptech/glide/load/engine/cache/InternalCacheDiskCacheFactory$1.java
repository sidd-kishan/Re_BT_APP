/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
 */
package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

class InternalCacheDiskCacheFactory.1
implements DiskLruCacheFactory.CacheDirectoryGetter {
    final Context val$context;
    final String val$diskCacheName;

    InternalCacheDiskCacheFactory.1(Context context, String string) {
        this.val$context = context;
        this.val$diskCacheName = string;
    }

    public File getCacheDirectory() {
        File file = this.val$context.getCacheDir();
        if (file == null) {
            return null;
        }
        if (this.val$diskCacheName == null) return file;
        return new File(file, this.val$diskCacheName);
    }
}
