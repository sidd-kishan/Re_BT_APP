/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.load.model.MultiModelLoader$MultiFetcher
 */
package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.MultiModelLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class MultiModelLoader<Model, Data>
implements ModelLoader<Model, Data> {
    private final Pools.Pool<List<Throwable>> exceptionListPool;
    private final List<ModelLoader<Model, Data>> modelLoaders;

    MultiModelLoader(List<ModelLoader<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
        this.modelLoaders = list;
        this.exceptionListPool = pool;
    }

    public ModelLoader.LoadData<Data> buildLoadData(Model object, int n, int n2, Options options) {
        int n3 = this.modelLoaders.size();
        ArrayList<DataFetcher> arrayList = new ArrayList<DataFetcher>(n3);
        Object var9_7 = null;
        int n4 = 0;
        Key key = null;
        while (true) {
            if (n4 >= n3) {
                object = var9_7;
                if (arrayList.isEmpty()) return object;
                object = new ModelLoader.LoadData(key, (DataFetcher)new MultiFetcher(arrayList, this.exceptionListPool));
                return object;
            }
            ModelLoader.LoadData loadData = this.modelLoaders.get(n4);
            Key key2 = key;
            if (loadData.handles(object)) {
                loadData = loadData.buildLoadData(object, n, n2, options);
                key2 = key;
                if (loadData != null) {
                    key2 = loadData.sourceKey;
                    arrayList.add(loadData.fetcher);
                }
            }
            ++n4;
            key = key2;
        }
    }

    public boolean handles(Model Model) {
        Iterator<ModelLoader<Model, Data>> iterator = this.modelLoaders.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!iterator.next().handles(Model));
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiModelLoader{modelLoaders=");
        stringBuilder.append(Arrays.toString(this.modelLoaders.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
