/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaMetadataRetriever
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaMetadataRetrieverInitializer
 */
package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;

static final class VideoDecoder.ParcelFileDescriptorInitializer
implements VideoDecoder.MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
    VideoDecoder.ParcelFileDescriptorInitializer() {
    }

    public void initialize(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
        mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
    }
}
