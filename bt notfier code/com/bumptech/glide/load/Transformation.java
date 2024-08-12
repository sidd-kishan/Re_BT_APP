/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.Resource
 */
package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public interface Transformation<T>
extends Key {
    public boolean equals(Object var1);

    public int hashCode();

    public Resource<T> transform(Context var1, Resource<T> var2, int var3, int var4);
}
