/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.data.DataRewinder
 */
package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;

private static final class DataRewinderRegistry.DefaultRewinder
implements DataRewinder<Object> {
    private final Object data;

    DataRewinderRegistry.DefaultRewinder(Object object) {
        this.data = object;
    }

    public void cleanup() {
    }

    public Object rewindAndGet() {
        return this.data;
    }
}
