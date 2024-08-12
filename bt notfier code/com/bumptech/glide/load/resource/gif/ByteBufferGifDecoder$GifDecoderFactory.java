/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.gifdecoder.GifDecoder
 *  com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider
 *  com.bumptech.glide.gifdecoder.GifHeader
 *  com.bumptech.glide.gifdecoder.StandardGifDecoder
 */
package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import java.nio.ByteBuffer;

static class ByteBufferGifDecoder.GifDecoderFactory {
    ByteBufferGifDecoder.GifDecoderFactory() {
    }

    GifDecoder build(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int n) {
        return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, n);
    }
}
