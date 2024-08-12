/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.data;

public static interface DataFetcher.DataCallback<T> {
    public void onDataReady(T var1);

    public void onLoadFailed(Exception var1);
}
