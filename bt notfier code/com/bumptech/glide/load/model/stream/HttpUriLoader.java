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
package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HttpUriLoader
implements ModelLoader<Uri, InputStream> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("http", "https")));
    private final ModelLoader<GlideUrl, InputStream> urlLoader;

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.urlLoader = modelLoader;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(Uri uri, int n, int n2, Options options) {
        return this.urlLoader.buildLoadData((Object)new GlideUrl(uri.toString()), n, n2, options);
    }

    public boolean handles(Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }
}
