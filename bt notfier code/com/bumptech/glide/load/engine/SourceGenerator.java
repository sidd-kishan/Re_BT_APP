/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.Encoder
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.load.engine.DataCacheGenerator
 *  com.bumptech.glide.load.engine.DataCacheKey
 *  com.bumptech.glide.load.engine.DataCacheWriter
 *  com.bumptech.glide.load.engine.DataFetcherGenerator
 *  com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
 *  com.bumptech.glide.load.engine.DecodeHelper
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.engine.cache.DiskCache$Writer
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.util.LogTime
 */
package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataCacheGenerator;
import com.bumptech.glide.load.engine.DataCacheKey;
import com.bumptech.glide.load.engine.DataCacheWriter;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodeHelper;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;

class SourceGenerator
implements DataFetcherGenerator,
DataFetcher.DataCallback<Object>,
DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int loadDataListIndex;
    private DataCacheKey originalKey;
    private DataCacheGenerator sourceCacheGenerator;

    SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    private void cacheData(Object object) {
        long l = LogTime.getLogTime();
        try {
            Encoder encoder = this.helper.getSourceEncoder(object);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(encoder, object, this.helper.getOptions());
            Object object2 = new DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());
            this.originalKey = object2;
            this.helper.getDiskCache().put((Key)this.originalKey, (DiskCache.Writer)dataCacheWriter);
            if (Log.isLoggable((String)TAG, (int)2)) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Finished encoding source to cache, key: ");
                ((StringBuilder)object2).append(this.originalKey);
                ((StringBuilder)object2).append(", data: ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(", encoder: ");
                ((StringBuilder)object2).append(encoder);
                ((StringBuilder)object2).append(", duration: ");
                ((StringBuilder)object2).append(LogTime.getElapsedMillis((long)l));
                Log.v((String)TAG, (String)((StringBuilder)object2).toString());
            }
            this.sourceCacheGenerator = new DataCacheGenerator(Collections.singletonList(this.loadData.sourceKey), this.helper, (DataFetcherGenerator.FetcherReadyCallback)this);
            return;
        }
        finally {
            this.loadData.fetcher.cleanup();
        }
    }

    private boolean hasNextModelLoader() {
        boolean bl = this.loadDataListIndex < this.helper.getLoadData().size();
        return bl;
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData == null) return;
        loadData.fetcher.cancel();
    }

    public void onDataFetcherFailed(Key key, Exception exception, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.cb.onDataFetcherFailed(key, exception, dataFetcher, this.loadData.fetcher.getDataSource());
    }

    public void onDataFetcherReady(Key key, Object object, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.cb.onDataFetcherReady(key, object, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    public void onDataReady(Object object) {
        DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
        if (object != null && diskCacheStrategy.isDataCacheable(this.loadData.fetcher.getDataSource())) {
            this.dataToCache = object;
            this.cb.reschedule();
        } else {
            this.cb.onDataFetcherReady(this.loadData.sourceKey, object, this.loadData.fetcher, this.loadData.fetcher.getDataSource(), (Key)this.originalKey);
        }
    }

    public void onLoadFailed(Exception exception) {
        this.cb.onDataFetcherFailed((Key)this.originalKey, exception, this.loadData.fetcher, this.loadData.fetcher.getDataSource());
    }

    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    public boolean startNext() {
        Object object = this.dataToCache;
        if (object != null) {
            this.dataToCache = null;
            this.cacheData(object);
        }
        if ((object = this.sourceCacheGenerator) != null && object.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean bl = false;
        while (!bl) {
            if (!this.hasNextModelLoader()) return bl;
            object = this.helper.getLoadData();
            int n = this.loadDataListIndex;
            this.loadDataListIndex = n + 1;
            this.loadData = (ModelLoader.LoadData)object.get(n);
            if (this.loadData == null || !this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) && !this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) continue;
            this.loadData.fetcher.loadData(this.helper.getPriority(), (DataFetcher.DataCallback)this);
            bl = true;
        }
        return bl;
    }
}
