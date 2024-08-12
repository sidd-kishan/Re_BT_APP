/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.load.Encoder
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.util.ByteBufferUtil
 */
package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferEncoder
implements Encoder<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    public boolean encode(ByteBuffer byteBuffer, File file, Options options) {
        boolean bl;
        try {
            ByteBufferUtil.toFile((ByteBuffer)byteBuffer, (File)file);
            bl = true;
        }
        catch (IOException iOException) {
            if (Log.isLoggable((String)TAG, (int)3)) {
                Log.d((String)TAG, (String)"Failed to write data", (Throwable)iOException);
            }
            bl = false;
        }
        return bl;
    }
}
