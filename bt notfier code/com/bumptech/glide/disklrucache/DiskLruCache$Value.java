/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.disklrucache.DiskLruCache
 *  com.bumptech.glide.disklrucache.DiskLruCache$Editor
 */
package com.bumptech.glide.disklrucache;

import com.bumptech.glide.disklrucache.DiskLruCache;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * Exception performing whole class analysis ignored.
 */
public final class DiskLruCache.Value {
    private final File[] files;
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;
    final DiskLruCache this$0;

    private DiskLruCache.Value(DiskLruCache diskLruCache, String string, long l, File[] fileArray, long[] lArray) {
        this.this$0 = diskLruCache;
        this.key = string;
        this.sequenceNumber = l;
        this.files = fileArray;
        this.lengths = lArray;
    }

    public DiskLruCache.Editor edit() throws IOException {
        return DiskLruCache.access$1700((DiskLruCache)this.this$0, (String)this.key, (long)this.sequenceNumber);
    }

    public File getFile(int n) {
        return this.files[n];
    }

    public long getLength(int n) {
        return this.lengths[n];
    }

    public String getString(int n) throws IOException {
        return DiskLruCache.access$1800((InputStream)new FileInputStream(this.files[n]));
    }
}
