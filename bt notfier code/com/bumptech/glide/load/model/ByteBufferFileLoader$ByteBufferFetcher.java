/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.util.ByteBufferUtil
 */
package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

private static final class ByteBufferFileLoader.ByteBufferFetcher
implements DataFetcher<ByteBuffer> {
    private final File file;

    ByteBufferFileLoader.ByteBufferFetcher(File file) {
        this.file = file;
    }

    public void cancel() {
    }

    public void cleanup() {
    }

    public Class<ByteBuffer> getDataClass() {
        return ByteBuffer.class;
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority object, DataFetcher.DataCallback<? super ByteBuffer> dataCallback) {
        try {
            object = ByteBufferUtil.fromFile((File)this.file);
        }
        catch (IOException iOException) {
            if (Log.isLoggable((String)"ByteBufferFileLoader", (int)3)) {
                Log.d((String)"ByteBufferFileLoader", (String)"Failed to obtain ByteBuffer for file", (Throwable)iOException);
            }
            dataCallback.onLoadFailed((Exception)iOException);
            return;
        }
        dataCallback.onDataReady(object);
    }
}
