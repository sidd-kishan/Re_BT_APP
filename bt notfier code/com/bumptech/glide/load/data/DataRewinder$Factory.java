/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.data.DataRewinder
 */
package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;

public static interface DataRewinder.Factory<T> {
    public DataRewinder<T> build(T var1);

    public Class<T> getDataClass();
}
