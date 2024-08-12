/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.data.DataRewinder
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream
 */
package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamRewinder
implements DataRewinder<InputStream> {
    private static final int MARK_LIMIT = 0x500000;
    private final RecyclableBufferedInputStream bufferedStream;

    InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.bufferedStream = inputStream;
        inputStream.mark(0x500000);
    }

    public void cleanup() {
        this.bufferedStream.release();
    }

    public InputStream rewindAndGet() throws IOException {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }
}
