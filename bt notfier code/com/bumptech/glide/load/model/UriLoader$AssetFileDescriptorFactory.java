/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
 *  com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.UriLoader
 *  com.bumptech.glide.load.model.UriLoader$LocalUriFetcherFactory
 */
package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.UriLoader;

public static final class UriLoader.AssetFileDescriptorFactory
implements ModelLoaderFactory<Uri, AssetFileDescriptor>,
UriLoader.LocalUriFetcherFactory<AssetFileDescriptor> {
    private final ContentResolver contentResolver;

    public UriLoader.AssetFileDescriptorFactory(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public DataFetcher<AssetFileDescriptor> build(Uri uri) {
        return new AssetFileDescriptorLocalUriFetcher(this.contentResolver, uri);
    }

    public ModelLoader<Uri, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new UriLoader((UriLoader.LocalUriFetcherFactory)this);
    }

    public void teardown() {
    }
}
