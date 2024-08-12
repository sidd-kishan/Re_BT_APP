/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.StreamLocalUriFetcher
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.UriLoader
 *  com.bumptech.glide.load.model.UriLoader$LocalUriFetcherFactory
 */
package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.UriLoader;
import java.io.InputStream;

public static class UriLoader.StreamFactory
implements ModelLoaderFactory<Uri, InputStream>,
UriLoader.LocalUriFetcherFactory<InputStream> {
    private final ContentResolver contentResolver;

    public UriLoader.StreamFactory(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public DataFetcher<InputStream> build(Uri uri) {
        return new StreamLocalUriFetcher(this.contentResolver, uri);
    }

    public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new UriLoader((UriLoader.LocalUriFetcherFactory)this);
    }

    public void teardown() {
    }
}
