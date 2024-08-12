/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.net.Uri
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.model.AssetUriLoader$AssetFetcherFactory
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.signature.ObjectKey
 */
package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

public class AssetUriLoader<Data>
implements ModelLoader<Uri, Data> {
    private static final String ASSET_PATH_SEGMENT = "android_asset";
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH = 22;
    private final AssetManager assetManager;
    private final AssetFetcherFactory<Data> factory;

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory<Data> assetFetcherFactory) {
        this.assetManager = assetManager;
        this.factory = assetFetcherFactory;
    }

    public ModelLoader.LoadData<Data> buildLoadData(Uri uri, int n, int n2, Options object) {
        object = uri.toString().substring(ASSET_PREFIX_LENGTH);
        return new ModelLoader.LoadData((Key)new ObjectKey((Object)uri), this.factory.buildFetcher(this.assetManager, (String)object));
    }

    public boolean handles(Uri uri) {
        boolean bl;
        boolean bl2 = "file".equals(uri.getScheme());
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        bl3 = bl;
        if (uri.getPathSegments().isEmpty()) return bl3;
        bl3 = bl;
        if (!ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0))) return bl3;
        bl3 = true;
        return bl3;
    }
}
