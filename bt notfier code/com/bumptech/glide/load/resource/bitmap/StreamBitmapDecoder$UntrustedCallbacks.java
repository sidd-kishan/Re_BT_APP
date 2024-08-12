/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks
 *  com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream
 *  com.bumptech.glide.util.ExceptionCatchingInputStream
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import java.io.IOException;

static class StreamBitmapDecoder.UntrustedCallbacks
implements Downsampler.DecodeCallbacks {
    private final RecyclableBufferedInputStream bufferedStream;
    private final ExceptionCatchingInputStream exceptionStream;

    StreamBitmapDecoder.UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
        this.bufferedStream = recyclableBufferedInputStream;
        this.exceptionStream = exceptionCatchingInputStream;
    }

    public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
        IOException iOException = this.exceptionStream.getException();
        if (iOException == null) return;
        if (bitmap == null) throw iOException;
        bitmapPool.put(bitmap);
        throw iOException;
    }

    public void onObtainBounds() {
        this.bufferedStream.fixMarkLimit();
    }
}
