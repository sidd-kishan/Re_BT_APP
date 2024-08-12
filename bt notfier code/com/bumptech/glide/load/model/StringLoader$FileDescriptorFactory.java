/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.StringLoader
 */
package com.bumptech.glide.load.model;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.StringLoader;

public static class StringLoader.FileDescriptorFactory
implements ModelLoaderFactory<String, ParcelFileDescriptor> {
    public ModelLoader<String, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new StringLoader(multiModelLoaderFactory.build(Uri.class, ParcelFileDescriptor.class));
    }

    public void teardown() {
    }
}
