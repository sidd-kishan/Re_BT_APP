/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.bumptech.glide.load.data.DataFetcher
 */
package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;

public static interface UriLoader.LocalUriFetcherFactory<Data> {
    public DataFetcher<Data> build(Uri var1);
}
