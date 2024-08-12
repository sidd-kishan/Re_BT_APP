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

class VideoDecoder.1
implements Option.CacheKeyUpdater<Long> {
    private final ByteBuffer buffer = ByteBuffer.allocate(8);

    VideoDecoder.1() {
    }

    public void update(byte[] object, Long l, MessageDigest messageDigest) {
        messageDigest.update((byte[])object);
        object = this.buffer;
        synchronized (object) {
            this.buffer.position(0);
            messageDigest.update(this.buffer.putLong(l).array());
            return;
        }
    }
}
