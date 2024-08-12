/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Option$CacheKeyUpdater
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class VideoDecoder.2
implements Option.CacheKeyUpdater<Integer> {
    private final ByteBuffer buffer = ByteBuffer.allocate(4);

    VideoDecoder.2() {
    }

    public void update(byte[] object, Integer n, MessageDigest messageDigest) {
        if (n == null) {
            return;
        }
        messageDigest.update((byte[])object);
        object = this.buffer;
        synchronized (object) {
            this.buffer.position(0);
            messageDigest.update(this.buffer.putInt(n).array());
            return;
        }
    }
}
