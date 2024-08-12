/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.mediastore.MediaStoreUtil
 *  com.bumptech.glide.load.model.MediaStoreFileLoader$FilePathFetcher
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.signature.ObjectKey
 */
package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;

public final class MediaStoreFileLoader
implements ModelLoader<Uri, File> {
    private final Context context;

    public MediaStoreFileLoader(Context context) {
        this.context = context;
    }

    public ModelLoader.LoadData<File> buildLoadData(Uri uri, int n, int n2, Options options) {
        return new ModelLoader.LoadData((Key)new ObjectKey((Object)uri), (DataFetcher)new FilePathFetcher(this.context, uri));
    }

    public boolean handles(Uri uri) {
        return MediaStoreUtil.isMediaStoreUri((Uri)uri);
    }
}
