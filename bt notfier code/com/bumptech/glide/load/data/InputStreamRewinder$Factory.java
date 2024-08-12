/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.data.DataRewinder
 *  com.bumptech.glide.load.data.DataRewinder$Factory
 *  com.bumptech.glide.load.data.InputStreamRewinder
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 */
package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

public static final class InputStreamRewinder.Factory
implements DataRewinder.Factory<InputStream> {
    private final ArrayPool byteArrayPool;

    public InputStreamRewinder.Factory(ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    public DataRewinder<InputStream> build(InputStream inputStream) {
        return new InputStreamRewinder(inputStream, this.byteArrayPool);
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
