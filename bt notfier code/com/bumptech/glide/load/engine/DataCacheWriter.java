/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Encoder
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.engine.cache.DiskCache$Writer
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

class DataCacheWriter<DataType>
implements DiskCache.Writer {
    private final DataType data;
    private final Encoder<DataType> encoder;
    private final Options options;

    DataCacheWriter(Encoder<DataType> encoder, DataType DataType, Options options) {
        this.encoder = encoder;
        this.data = DataType;
        this.options = options;
    }

    public boolean write(File file) {
        return this.encoder.encode(this.data, file, this.options);
    }
}
