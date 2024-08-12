/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

private static class UnitModelLoader.UnitFetcher<Model>
implements DataFetcher<Model> {
    private final Model resource;

    UnitModelLoader.UnitFetcher(Model Model) {
        this.resource = Model;
    }

    public void cancel() {
    }

    public void cleanup() {
    }

    public Class<Model> getDataClass() {
        return this.resource.getClass();
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super Model> dataCallback) {
        dataCallback.onDataReady(this.resource);
    }
}
