/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher
 *  com.bumptech.glide.load.model.AssetUriLoader
 *  com.bumptech.glide.load.model.AssetUriLoader$AssetFetcherFactory
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 */
package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

public static class AssetUriLoader.FileDescriptorFactory
implements ModelLoaderFactory<Uri, ParcelFileDescriptor>,
AssetUriLoader.AssetFetcherFactory<ParcelFileDescriptor> {
    private final AssetManager assetManager;

    public AssetUriLoader.FileDescriptorFactory(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public ModelLoader<Uri, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new AssetUriLoader(this.assetManager, (AssetUriLoader.AssetFetcherFactory)this);
    }

    public DataFetcher<ParcelFileDescriptor> buildFetcher(AssetManager assetManager, String string) {
        return new FileDescriptorAssetPathFetcher(assetManager, string);
    }

    public void teardown() {
    }
}
