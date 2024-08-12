/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.bitmap.Downsampler
 *  com.bumptech.glide.util.ByteBufferUtil
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder
implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final Downsampler downsampler;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.downsampler = downsampler;
    }

    public Resource<Bitmap> decode(ByteBuffer object, int n, int n2, Options options) throws IOException {
        object = ByteBufferUtil.toStream((ByteBuffer)object);
        return this.downsampler.decode((InputStream)object, n, n2, options);
    }

    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return this.downsampler.handles(byteBuffer);
    }
}
