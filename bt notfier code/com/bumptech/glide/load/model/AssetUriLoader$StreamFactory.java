/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.net.Uri
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.StreamAssetPathFetcher
 *  com.bumptech.glide.load.model.AssetUriLoader
 *  com.bumptech.glide.load.model.AssetUriLoader$AssetFetcherFactory
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 */
package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public static class AssetUriLoader.StreamFactory
implements ModelLoaderFactory<Uri, InputStream>,
AssetUriLoader.AssetFetcherFactory<InputStream> {
    private final AssetManager assetManager;

    public AssetUriLoader.StreamFactory(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new AssetUriLoader(this.assetManager, (AssetUriLoader.AssetFetcherFactory)this);
    }

    public DataFetcher<InputStream> buildFetcher(AssetManager assetManager, String string) {
        return new StreamAssetPathFetcher(assetManager, string);
    }

    public void teardown() {
    }
}
