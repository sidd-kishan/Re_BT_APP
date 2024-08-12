/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.load.model.DataUrlLoader$DataDecoder
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.DataUrlLoader;
import java.io.IOException;

private static final class DataUrlLoader.DataUriFetcher<Data>
implements DataFetcher<Data> {
    private Data data;
    private final String dataUri;
    private final DataUrlLoader.DataDecoder<Data> reader;

    DataUrlLoader.DataUriFetcher(String string, DataUrlLoader.DataDecoder<Data> dataDecoder) {
        this.dataUri = string;
        this.reader = dataDecoder;
    }

    public void cancel() {
    }

    /*
     * Enabled force condition propagation
     */
    public void cleanup() {
        try {
            this.reader.close(this.data);
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public Class<Data> getDataClass() {
        return this.reader.getDataClass();
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority object, DataFetcher.DataCallback<? super Data> dataCallback) {
        try {
            object = this.reader.decode(this.dataUri);
            this.data = object;
            dataCallback.onDataReady(object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            dataCallback.onLoadFailed((Exception)illegalArgumentException);
        }
    }
}
