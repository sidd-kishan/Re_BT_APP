/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class SimpleResource<T>
implements Resource<T> {
    protected final T data;

    public SimpleResource(T t) {
        this.data = Preconditions.checkNotNull(t);
    }

    public final T get() {
        return this.data;
    }

    public Class<T> getResourceClass() {
        return this.data.getClass();
    }

    public final int getSize() {
        return 1;
    }

    public void recycle() {
    }
}
