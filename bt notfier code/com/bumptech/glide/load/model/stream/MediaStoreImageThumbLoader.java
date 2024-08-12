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
 *  com.bumptech.glide.load.data.mediastore.ThumbFetcher
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.signature.ObjectKey
 */
package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreImageThumbLoader
implements ModelLoader<Uri, InputStream> {
    private final Context context;

    public MediaStoreImageThumbLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(Uri uri, int n, int n2, Options options) {
        if (!MediaStoreUtil.isThumbnailSize((int)n, (int)n2)) return null;
        return new ModelLoader.LoadData((Key)new ObjectKey((Object)uri), (DataFetcher)ThumbFetcher.buildImageFetcher((Context)this.context, (Uri)uri));
    }

    public boolean handles(Uri uri) {
        return MediaStoreUtil.isMediaStoreImageUri((Uri)uri);
    }
}
