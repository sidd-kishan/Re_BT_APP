/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

public static class ModelLoader.LoadData<Data> {
    public final List<Key> alternateKeys;
    public final DataFetcher<Data> fetcher;
    public final Key sourceKey;

    public ModelLoader.LoadData(Key key, DataFetcher<Data> dataFetcher) {
        this(key, Collections.emptyList(), dataFetcher);
    }

    public ModelLoader.LoadData(Key key, List<Key> list, DataFetcher<Data> dataFetcher) {
        this.sourceKey = (Key)Preconditions.checkNotNull((Object)key);
        this.alternateKeys = (List)Preconditions.checkNotNull(list);
        this.fetcher = (DataFetcher)Preconditions.checkNotNull(dataFetcher);
    }
}
