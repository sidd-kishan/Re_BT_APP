/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.LazyHeaders$Builder
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Map;

public interface Headers {
    public static final Headers DEFAULT;
    @Deprecated
    public static final Headers NONE;

    static {
        NONE = new /* Unavailable Anonymous Inner Class!! */;
        DEFAULT = new LazyHeaders.Builder().build();
    }

    public Map<String, String> getHeaders();
}
