/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.model.DataUrlLoader$DataDecoder
 *  com.bumptech.glide.load.model.DataUrlLoader$DataUriFetcher
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.signature.ObjectKey
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

public final class DataUrlLoader<Data>
implements ModelLoader<String, Data> {
    private static final String BASE64_TAG = ";base64";
    private static final String DATA_SCHEME_IMAGE = "data:image";
    private final DataDecoder<Data> dataDecoder;

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.dataDecoder = dataDecoder;
    }

    public ModelLoader.LoadData<Data> buildLoadData(String string, int n, int n2, Options options) {
        return new ModelLoader.LoadData((Key)new ObjectKey((Object)string), (DataFetcher)new DataUriFetcher(string, this.dataDecoder));
    }

    public boolean handles(String string) {
        return string.startsWith(DATA_SCHEME_IMAGE);
    }
}
