/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.graphics.Bitmap
 *  android.media.MediaMetadataRetriever
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.Option
 *  com.bumptech.glide.load.Option$CacheKeyUpdater
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.BitmapResource
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder$AssetFileDescriptorInitializer
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaMetadataRetrieverFactory
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaMetadataRetrieverInitializer
 *  com.bumptech.glide.load.resource.bitmap.VideoDecoder$ParcelFileDescriptorInitializer
 */
package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import java.io.IOException;

public class VideoDecoder<T>
implements ResourceDecoder<T, Bitmap> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY;
    public static final long DEFAULT_FRAME = -1L;
    static final int DEFAULT_FRAME_OPTION = 2;
    public static final Option<Integer> FRAME_OPTION;
    public static final Option<Long> TARGET_FRAME;
    private final BitmapPool bitmapPool;
    private final MediaMetadataRetrieverFactory factory;
    private final MediaMetadataRetrieverInitializer<T> initializer;

    static {
        TARGET_FRAME = Option.disk((String)"com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", (Object)-1L, (Option.CacheKeyUpdater)new /* Unavailable Anonymous Inner Class!! */);
        FRAME_OPTION = Option.disk((String)"com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", (Object)2, (Option.CacheKeyUpdater)new /* Unavailable Anonymous Inner Class!! */);
        DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    }

    VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer) {
        this(bitmapPool, mediaMetadataRetrieverInitializer, DEFAULT_FACTORY);
    }

    VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.bitmapPool = bitmapPool;
        this.initializer = mediaMetadataRetrieverInitializer;
        this.factory = mediaMetadataRetrieverFactory;
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool) {
        return new VideoDecoder<AssetFileDescriptor>(bitmapPool, (MediaMetadataRetrieverInitializer<AssetFileDescriptor>)new AssetFileDescriptorInitializer(null));
    }

    private static Bitmap decodeFrame(MediaMetadataRetriever mediaMetadataRetriever, long l, int n, int n2, int n3) {
        if (Build.VERSION.SDK_INT < 27) return mediaMetadataRetriever.getFrameAtTime(l, n);
        if (n2 == Integer.MIN_VALUE) return mediaMetadataRetriever.getFrameAtTime(l, n);
        if (n3 == Integer.MIN_VALUE) return mediaMetadataRetriever.getFrameAtTime(l, n);
        return mediaMetadataRetriever.getScaledFrameAtTime(l, n, n2, n3);
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool) {
        return new VideoDecoder<ParcelFileDescriptor>(bitmapPool, (MediaMetadataRetrieverInitializer<ParcelFileDescriptor>)new ParcelFileDescriptorInitializer());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public Resource<Bitmap> decode(T object, int n, int n2, Options object2) throws IOException {
        Throwable throwable2222222;
        Integer n3;
        block6: {
            long l = (Long)object2.get(TARGET_FRAME);
            if (l < 0L && l != -1L) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
                ((StringBuilder)object).append(l);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            n3 = (Integer)object2.get(FRAME_OPTION);
            object2 = n3;
            if (n3 == null) {
                object2 = 2;
            }
            n3 = this.factory.build();
            this.initializer.initialize((MediaMetadataRetriever)n3, object);
            object = VideoDecoder.decodeFrame((MediaMetadataRetriever)n3, l, (Integer)object2, n, n2);
            {
                catch (Throwable throwable2222222) {
                    break block6;
                }
                catch (RuntimeException runtimeException) {}
                {
                    object = new IOException(runtimeException);
                    throw object;
                }
            }
            n3.release();
            return BitmapResource.obtain((Bitmap)object, (BitmapPool)this.bitmapPool);
        }
        n3.release();
        throw throwable2222222;
    }

    public boolean handles(T t, Options options) {
        return true;
    }
}
