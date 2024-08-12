/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.media.MediaMetadataRetriever
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaMetadataRetrieverInitializer
 */
package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;

private static final class VideoDecoder.AssetFileDescriptorInitializer
implements VideoDecoder.MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
    private VideoDecoder.AssetFileDescriptorInitializer() {
    }

    public void initialize(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }
}
