/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.resource.bitmap.Downsampler
 *  com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks
 *  com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream
 *  com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder$UntrustedCallbacks
 *  com.bumptech.glide.util.ExceptionCatchingInputStream
 *  com.bumptech.glide.util.MarkEnforcingInputStream
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder
implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool byteArrayPool;
    private final Downsampler downsampler;

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.downsampler = downsampler;
        this.byteArrayPool = arrayPool;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int n, int n2, Options options) throws IOException {
        boolean bl;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            inputStream = (RecyclableBufferedInputStream)inputStream;
            bl = false;
        } else {
            inputStream = new RecyclableBufferedInputStream(inputStream, this.byteArrayPool);
            bl = true;
        }
        ExceptionCatchingInputStream exceptionCatchingInputStream = ExceptionCatchingInputStream.obtain((InputStream)inputStream);
        MarkEnforcingInputStream markEnforcingInputStream = new MarkEnforcingInputStream((InputStream)exceptionCatchingInputStream);
        UntrustedCallbacks untrustedCallbacks = new UntrustedCallbacks((RecyclableBufferedInputStream)inputStream, exceptionCatchingInputStream);
        try {
            options = this.downsampler.decode((InputStream)markEnforcingInputStream, n, n2, options, (Downsampler.DecodeCallbacks)untrustedCallbacks);
            return options;
        }
        finally {
            exceptionCatchingInputStream.release();
            if (bl) {
                inputStream.release();
            }
        }
    }

    public boolean handles(InputStream inputStream, Options options) {
        return this.downsampler.handles(inputStream);
    }
}
