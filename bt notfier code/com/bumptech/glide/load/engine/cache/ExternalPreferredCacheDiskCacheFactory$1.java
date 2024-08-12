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

class ExternalPreferredCacheDiskCacheFactory.1
implements DiskLruCacheFactory.CacheDirectoryGetter {
    final Context val$context;
    final String val$diskCacheName;

    ExternalPreferredCacheDiskCacheFactory.1(Context context, String string) {
        this.val$context = context;
        this.val$diskCacheName = string;
    }

    private File getInternalCacheDirectory() {
        File file = this.val$context.getCacheDir();
        if (file == null) {
            return null;
        }
        if (this.val$diskCacheName == null) return file;
        return new File(file, this.val$diskCacheName);
    }

    public File getCacheDirectory() {
        File file = this.getInternalCacheDirectory();
        if (file != null && file.exists()) {
            return file;
        }
        File file2 = this.val$context.getExternalCacheDir();
        if (file2 == null) return file;
        if (!file2.canWrite()) {
            return file;
        }
        if (this.val$diskCacheName == null) return file2;
        return new File(file2, this.val$diskCacheName);
    }
}
