/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaMetadataRetrieverInitializer
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder$ParcelFileDescriptorInitializer
 */
package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;

@Deprecated
public class VideoBitmapDecoder
extends VideoDecoder<ParcelFileDescriptor> {
    public VideoBitmapDecoder(Context context) {
        this(Glide.get((Context)context).getBitmapPool());
    }

    public VideoBitmapDecoder(BitmapPool bitmapPool) {
        super(bitmapPool, (VideoDecoder.MediaMetadataRetrieverInitializer)new VideoDecoder.ParcelFileDescriptorInitializer());
    }
}
