/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.cache.DiskCache$Writer
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

public interface DiskCache {
    public void clear();

    public void delete(Key var1);

    public File get(Key var1);

    public void put(Key var1, Writer var2);
}
