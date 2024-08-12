/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.load.model.UriLoader$LocalUriFetcherFactory
 *  com.bumptech.glide.signature.ObjectKey
 */
package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UriLoader<Data>
implements ModelLoader<Uri, Data> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("file", "android.resource", "content")));
    private final LocalUriFetcherFactory<Data> factory;

    public UriLoader(LocalUriFetcherFactory<Data> localUriFetcherFactory) {
        this.factory = localUriFetcherFactory;
    }

    public ModelLoader.LoadData<Data> buildLoadData(Uri uri, int n, int n2, Options options) {
        return new ModelLoader.LoadData((Key)new ObjectKey((Object)uri), this.factory.build(uri));
    }

    public boolean handles(Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }
}
