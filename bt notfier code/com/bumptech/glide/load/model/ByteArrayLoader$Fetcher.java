/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.load.model.ByteArrayLoader$Converter
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ByteArrayLoader;

private static class ByteArrayLoader.Fetcher<Data>
implements DataFetcher<Data> {
    private final ByteArrayLoader.Converter<Data> converter;
    private final byte[] model;

    ByteArrayLoader.Fetcher(byte[] byArray, ByteArrayLoader.Converter<Data> converter) {
        this.model = byArray;
        this.converter = converter;
    }

    public void cancel() {
    }

    public void cleanup() {
    }

    public Class<Data> getDataClass() {
        return this.converter.getDataClass();
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
        dataCallback.onDataReady(this.converter.convert(this.model));
    }
}
