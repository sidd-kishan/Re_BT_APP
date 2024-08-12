/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.UriLoader
 *  com.bumptech.glide.load.model.UriLoader$LocalUriFetcherFactory
 */
package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.UriLoader;

public static class UriLoader.FileDescriptorFactory
implements ModelLoaderFactory<Uri, ParcelFileDescriptor>,
UriLoader.LocalUriFetcherFactory<ParcelFileDescriptor> {
    private final ContentResolver contentResolver;

    public UriLoader.FileDescriptorFactory(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public DataFetcher<ParcelFileDescriptor> build(Uri uri) {
        return new FileDescriptorLocalUriFetcher(this.contentResolver, uri);
    }

    public ModelLoader<Uri, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new UriLoader((UriLoader.LocalUriFetcherFactory)this);
    }

    public void teardown() {
    }
}
