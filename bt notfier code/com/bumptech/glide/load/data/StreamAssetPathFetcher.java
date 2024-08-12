/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  com.bumptech.glide.load.data.AssetPathFetcher
 */
package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import com.bumptech.glide.load.data.AssetPathFetcher;
import java.io.IOException;
import java.io.InputStream;

public class StreamAssetPathFetcher
extends AssetPathFetcher<InputStream> {
    public StreamAssetPathFetcher(AssetManager assetManager, String string) {
        super(assetManager, string);
    }

    protected void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    protected InputStream loadResource(AssetManager assetManager, String string) throws IOException {
        return assetManager.open(string);
    }
}
