/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Option
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.HttpUrlFetcher
 *  com.bumptech.glide.load.model.GlideUrl
 *  com.bumptech.glide.load.model.ModelCache
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class HttpGlideUrlLoader
implements ModelLoader<GlideUrl, InputStream> {
    public static final Option<Integer> TIMEOUT = Option.memory((String)"com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", (Object)2500);
    private final ModelCache<GlideUrl, GlideUrl> modelCache;

    public HttpGlideUrlLoader() {
        this(null);
    }

    public HttpGlideUrlLoader(ModelCache<GlideUrl, GlideUrl> modelCache) {
        this.modelCache = modelCache;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(GlideUrl glideUrl, int n, int n2, Options options) {
        ModelCache<GlideUrl, GlideUrl> modelCache = this.modelCache;
        GlideUrl glideUrl2 = glideUrl;
        if (modelCache == null) return new ModelLoader.LoadData((Key)glideUrl2, (DataFetcher)new HttpUrlFetcher(glideUrl2, ((Integer)options.get(TIMEOUT)).intValue()));
        glideUrl2 = (GlideUrl)modelCache.get((Object)glideUrl, 0, 0);
        if (glideUrl2 != null) return new ModelLoader.LoadData((Key)glideUrl2, (DataFetcher)new HttpUrlFetcher(glideUrl2, ((Integer)options.get(TIMEOUT)).intValue()));
        this.modelCache.put((Object)glideUrl, 0, 0, (Object)glideUrl);
        glideUrl2 = glideUrl;
        return new ModelLoader.LoadData((Key)glideUrl2, (DataFetcher)new HttpUrlFetcher(glideUrl2, ((Integer)options.get(TIMEOUT)).intValue()));
    }

    public boolean handles(GlideUrl glideUrl) {
        return true;
    }
}
