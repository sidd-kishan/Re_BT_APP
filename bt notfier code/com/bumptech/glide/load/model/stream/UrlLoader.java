/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.model.GlideUrl
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.net.URL;

public class UrlLoader
implements ModelLoader<URL, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> glideUrlLoader;

    public UrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.glideUrlLoader = modelLoader;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(URL uRL, int n, int n2, Options options) {
        return this.glideUrlLoader.buildLoadData((Object)new GlideUrl(uRL), n, n2, options);
    }

    public boolean handles(URL uRL) {
        return true;
    }
}
