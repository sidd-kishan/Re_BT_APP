/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 */
package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

public interface DataFetcher<T> {
    public void cancel();

    public void cleanup();

    public Class<T> getDataClass();

    public DataSource getDataSource();

    public void loadData(Priority var1, DataCallback<? super T> var2);
}
