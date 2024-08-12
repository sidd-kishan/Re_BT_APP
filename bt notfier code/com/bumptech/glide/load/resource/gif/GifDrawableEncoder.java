/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.load.EncodeStrategy
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceEncoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.util.ByteBufferUtil
 */
package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class GifDrawableEncoder
implements ResourceEncoder<GifDrawable> {
    private static final String TAG = "GifEncoder";

    public boolean encode(Resource<GifDrawable> gifDrawable, File file, Options options) {
        boolean bl;
        gifDrawable = (GifDrawable)gifDrawable.get();
        try {
            ByteBufferUtil.toFile((ByteBuffer)gifDrawable.getBuffer(), (File)file);
            bl = true;
        }
        catch (IOException iOException) {
            if (Log.isLoggable((String)TAG, (int)5)) {
                Log.w((String)TAG, (String)"Failed to encode GIF drawable data", (Throwable)iOException);
            }
            bl = false;
        }
        return bl;
    }

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.SOURCE;
    }
}
