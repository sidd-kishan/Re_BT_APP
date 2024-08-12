/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader
 */
package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import java.io.InputStream;

public static class MediaStoreVideoThumbLoader.Factory
implements ModelLoaderFactory<Uri, InputStream> {
    private final Context context;

    public MediaStoreVideoThumbLoader.Factory(Context context) {
        this.context = context;
    }

    public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new MediaStoreVideoThumbLoader(this.context);
    }

    public void teardown() {
    }
}
