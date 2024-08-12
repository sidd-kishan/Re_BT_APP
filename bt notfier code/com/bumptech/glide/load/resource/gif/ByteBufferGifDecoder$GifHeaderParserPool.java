/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.gifdecoder.GifHeaderParser
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.Queue;

static class ByteBufferGifDecoder.GifHeaderParserPool {
    private final Queue<GifHeaderParser> pool = Util.createQueue((int)0);

    ByteBufferGifDecoder.GifHeaderParserPool() {
    }

    GifHeaderParser obtain(ByteBuffer byteBuffer) {
        synchronized (this) {
            GifHeaderParser gifHeaderParser;
            GifHeaderParser gifHeaderParser2 = gifHeaderParser = this.pool.poll();
            if (gifHeaderParser == null) {
                gifHeaderParser2 = new GifHeaderParser();
            }
            byteBuffer = gifHeaderParser2.setData(byteBuffer);
            return byteBuffer;
        }
    }

    void release(GifHeaderParser gifHeaderParser) {
        synchronized (this) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
            return;
        }
    }
}
