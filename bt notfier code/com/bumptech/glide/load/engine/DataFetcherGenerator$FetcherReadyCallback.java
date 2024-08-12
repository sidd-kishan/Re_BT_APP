/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.data.DataFetcher
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

public static interface DataFetcherGenerator.FetcherReadyCallback {
    public void onDataFetcherFailed(Key var1, Exception var2, DataFetcher<?> var3, DataSource var4);

    public void onDataFetcherReady(Key var1, Object var2, DataFetcher<?> var3, DataSource var4, Key var5);

    public void reschedule();
}
