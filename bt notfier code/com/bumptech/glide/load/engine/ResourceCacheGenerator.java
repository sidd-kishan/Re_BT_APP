/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.load.engine.DataFetcherGenerator
 *  com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
 *  com.bumptech.glide.load.engine.DecodeHelper
 *  com.bumptech.glide.load.engine.ResourceCacheKey
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodeHelper;
import com.bumptech.glide.load.engine.ResourceCacheKey;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class ResourceCacheGenerator
implements DataFetcherGenerator,
DataFetcher.DataCallback<Object> {
    private File cacheFile;
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int resourceClassIndex = -1;
    private int sourceIdIndex;
    private Key sourceKey;

    ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
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
        this.cb.onDataFetcherReady(this.sourceKey, object, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, (Key)this.currentKey);
    }

    public void onLoadFailed(Exception exception) {
        this.cb.onDataFetcherFailed((Key)this.currentKey, exception, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }

    public boolean startNext() {
        Key key;
        int n;
        List list = this.helper.getCacheKeys();
        boolean bl = list.isEmpty();
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        List list2 = this.helper.getRegisteredResourceClasses();
        while (this.modelLoaders == null || !this.hasNextModelLoader()) {
            this.resourceClassIndex = n = this.resourceClassIndex + 1;
            if (n >= list2.size()) {
                this.sourceIdIndex = n = this.sourceIdIndex + 1;
                if (n >= list.size()) {
                    return false;
                }
                this.resourceClassIndex = 0;
            }
            key = (Key)list.get(this.sourceIdIndex);
            Class clazz = (Class)list2.get(this.resourceClassIndex);
            Object object = this.helper.getTransformation(clazz);
            this.currentKey = new ResourceCacheKey(this.helper.getArrayPool(), key, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), object, clazz, this.helper.getOptions());
            object = this.helper.getDiskCache().get((Key)this.currentKey);
            this.cacheFile = object;
            if (object == null) continue;
            this.sourceKey = key;
            this.modelLoaders = this.helper.getModelLoaders((File)object);
            this.modelLoaderIndex = 0;
        }
        this.loadData = null;
        while (!bl2) {
            if (!this.hasNextModelLoader()) return bl2;
            key = this.modelLoaders;
            n = this.modelLoaderIndex;
            this.modelLoaderIndex = n + 1;
            this.loadData = ((ModelLoader)key.get(n)).buildLoadData((Object)this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
            if (this.loadData == null || !this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) continue;
            this.loadData.fetcher.loadData(this.helper.getPriority(), (DataFetcher.DataCallback)this);
            bl2 = true;
        }
        return bl2;
    }
}
