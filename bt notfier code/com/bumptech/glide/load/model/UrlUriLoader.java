/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.model.GlideUrl
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UrlUriLoader<Data>
implements ModelLoader<Uri, Data> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("http", "https")));
    private final ModelLoader<GlideUrl, Data> urlLoader;

    public UrlUriLoader(ModelLoader<GlideUrl, Data> modelLoader) {
        this.urlLoader = modelLoader;
    }

    public ModelLoader.LoadData<Data> buildLoadData(Uri uri, int n, int n2, Options options) {
        uri = new GlideUrl(uri.toString());
        return this.urlLoader.buildLoadData((Object)uri, n, n2, options);
    }

    public boolean handles(Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }
}
