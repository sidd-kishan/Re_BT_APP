/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.data.DataRewinder
 *  com.bumptech.glide.load.data.DataRewinder$Factory
 *  com.bumptech.glide.load.data.DataRewinderRegistry$DefaultRewinder
 */
package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;

class DataRewinderRegistry.1
implements DataRewinder.Factory<Object> {
    DataRewinderRegistry.1() {
    }

    public DataRewinder<Object> build(Object object) {
        return new DataRewinderRegistry.DefaultRewinder(object);
    }

    public Class<Object> getDataClass() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
