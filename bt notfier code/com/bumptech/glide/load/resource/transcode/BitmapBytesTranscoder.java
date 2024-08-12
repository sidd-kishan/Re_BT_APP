/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.bytes.BytesResource
 *  com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 */
package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class BitmapBytesTranscoder
implements ResourceTranscoder<Bitmap, byte[]> {
    private final Bitmap.CompressFormat compressFormat;
    private final int quality;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public BitmapBytesTranscoder(Bitmap.CompressFormat compressFormat, int n) {
        this.compressFormat = compressFormat;
        this.quality = n;
    }

    public Resource<byte[]> transcode(Resource<Bitmap> resource, Options object) {
        object = new ByteArrayOutputStream();
        ((Bitmap)resource.get()).compress(this.compressFormat, this.quality, (OutputStream)object);
        resource.recycle();
        return new BytesResource(((ByteArrayOutputStream)object).toByteArray());
    }
}
