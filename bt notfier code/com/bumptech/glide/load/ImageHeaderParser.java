/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 */
package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {
    public static final int UNKNOWN_ORIENTATION = -1;

    public int getOrientation(InputStream var1, ArrayPool var2) throws IOException;

    public int getOrientation(ByteBuffer var1, ArrayPool var2) throws IOException;

    public ImageType getType(InputStream var1) throws IOException;

    public ImageType getType(ByteBuffer var1) throws IOException;
}
