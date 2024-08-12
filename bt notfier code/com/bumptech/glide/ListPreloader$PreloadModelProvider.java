/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.RequestBuilder
 */
package com.bumptech.glide;

import com.bumptech.glide.RequestBuilder;
import java.util.List;

public static interface ListPreloader.PreloadModelProvider<U> {
    public List<U> getPreloadItems(int var1);

    public RequestBuilder<?> getPreloadRequestBuilder(U var1);
}
