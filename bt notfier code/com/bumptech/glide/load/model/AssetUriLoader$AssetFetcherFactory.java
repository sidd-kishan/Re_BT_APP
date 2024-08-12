/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  com.bumptech.glide.load.data.DataFetcher
 */
package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import com.bumptech.glide.load.data.DataFetcher;

public static interface AssetUriLoader.AssetFetcherFactory<Data> {
    public DataFetcher<Data> buildFetcher(AssetManager var1, String var2);
}
