/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.bumptech.glide.load.model.MediaStoreFileLoader
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 */
package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.File;

public static final class MediaStoreFileLoader.Factory
implements ModelLoaderFactory<Uri, File> {
    private final Context context;

    public MediaStoreFileLoader.Factory(Context context) {
        this.context = context;
    }

    public ModelLoader<Uri, File> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new MediaStoreFileLoader(this.context);
    }

    public void teardown() {
    }
}
