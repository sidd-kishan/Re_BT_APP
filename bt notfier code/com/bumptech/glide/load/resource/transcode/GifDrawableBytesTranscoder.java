/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.bytes.BytesResource
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 *  com.bumptech.glide.util.ByteBufferUtil
 */
package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.ByteBufferUtil;
import java.nio.ByteBuffer;

public class GifDrawableBytesTranscoder
implements ResourceTranscoder<GifDrawable, byte[]> {
    public Resource<byte[]> transcode(Resource<GifDrawable> resource, Options options) {
        return new BytesResource(ByteBufferUtil.toBytes((ByteBuffer)((GifDrawable)resource.get()).getBuffer()));
    }
}
