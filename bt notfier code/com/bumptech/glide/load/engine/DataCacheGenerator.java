/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.load.engine.DataCacheKey
 *  com.bumptech.glide.load.engine.DataFetcherGenerator
 *  com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
 *  com.bumptech.glide.load.engine.DecodeHelper
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataCacheKey;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodeHelper;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class DataCacheGenerator
implements DataFetcherGenerator,
DataFetcher.DataCallback<Object> {
    private File cacheFile;
    private final List<Key> cacheKeys;
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int sourceIdIndex = -1;
    private Key sourceKey;

    DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.getCacheKeys(), decodeHelper, fetcherReadyCallback);
    }

    DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.cacheKeys = list;
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    private boolean hasNextModelLoader() {
        boolean bl = this.modelLoaderIndex < this.modelLoaders.size();
        return bl;
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData == null) return;
        loadData.fetcher.cancel();
    }

    public void onDataReady(Object object) {
        this.cb.onDataFetcherReady(this.sourceKey, object, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    public void onLoadFailed(Exception exception) {
        this.cb.onDataFetcherFailed(this.sourceKey, exception, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }

    public boolean startNext() {
        int n;
        boolean bl;
        Key key;
        while (true) {
            key = this.modelLoaders;
            bl = false;
            if (key != null && this.hasNextModelLoader()) break;
            this.sourceIdIndex = n = this.sourceIdIndex + 1;
            if (n >= this.cacheKeys.size()) {
                return false;
            }
            key = this.cacheKeys.get(this.sourceIdIndex);
            Object object = new DataCacheKey(key, this.helper.getSignature());
            object = this.helper.getDiskCache().get((Key)object);
            this.cacheFile = object;
            if (object == null) continue;
            this.sourceKey = key;
            this.modelLoaders = this.helper.getModelLoaders((File)object);
            this.modelLoaderIndex = 0;
        }
        this.loadData = null;
        while (!bl) {
            if (!this.hasNextModelLoader()) return bl;
            key = this.modelLoaders;
            n = this.modelLoaderIndex;
            this.modelLoaderIndex = n + 1;
            this.loadData = ((ModelLoader)key.get(n)).buildLoadData((Object)this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
            if (this.loadData == null || !this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) continue;
            this.loadData.fetcher.loadData(this.helper.getPriority(), (DataFetcher.DataCallback)this);
            bl = true;
        }
        return bl;
    }
}
