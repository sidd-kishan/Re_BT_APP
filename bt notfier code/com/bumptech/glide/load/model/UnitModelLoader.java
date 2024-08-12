/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.load.model.UnitModelLoader$UnitFetcher
 *  com.bumptech.glide.signature.ObjectKey
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.signature.ObjectKey;

public class UnitModelLoader<Model>
implements ModelLoader<Model, Model> {
    private static final UnitModelLoader<?> INSTANCE = new UnitModelLoader();

    @Deprecated
    public UnitModelLoader() {
    }

    public static <T> UnitModelLoader<T> getInstance() {
        return INSTANCE;
    }

    public ModelLoader.LoadData<Model> buildLoadData(Model Model, int n, int n2, Options options) {
        return new ModelLoader.LoadData((Key)new ObjectKey(Model), (DataFetcher)new UnitFetcher(Model));
    }

    public boolean handles(Model Model) {
        return true;
    }
}
