/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;

public interface ModelLoader<Model, Data> {
    public LoadData<Data> buildLoadData(Model var1, int var2, int var3, Options var4);

    public boolean handles(Model var1);
}
