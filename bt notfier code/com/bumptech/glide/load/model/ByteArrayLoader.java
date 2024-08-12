/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.model.ByteArrayLoader$Converter
 *  com.bumptech.glide.load.model.ByteArrayLoader$Fetcher
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.signature.ObjectKey
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

public class ByteArrayLoader<Data>
implements ModelLoader<byte[], Data> {
    private final Converter<Data> converter;

    public ByteArrayLoader(Converter<Data> converter) {
        this.converter = converter;
    }

    public ModelLoader.LoadData<Data> buildLoadData(byte[] byArray, int n, int n2, Options options) {
        return new ModelLoader.LoadData((Key)new ObjectKey((Object)byArray), (DataFetcher)new Fetcher(byArray, this.converter));
    }

    public boolean handles(byte[] byArray) {
        return true;
    }
}
