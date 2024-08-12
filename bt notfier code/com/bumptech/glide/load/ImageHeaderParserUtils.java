/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream
 */
package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils {
    private static final int MARK_POSITION = 0x500000;

    private ImageHeaderParserUtils() {
    }

    public static int getOrientation(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        InputStream inputStream2 = inputStream;
        if (!inputStream.markSupported()) {
            inputStream2 = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream2.mark(0x500000);
        int n = 0;
        int n2 = list.size();
        while (n < n2) {
            block6: {
                int n3;
                inputStream = list.get(n);
                try {
                    n3 = inputStream.getOrientation(inputStream2, arrayPool);
                    if (n3 == -1) break block6;
                }
                finally {
                    inputStream2.reset();
                }
                return n3;
            }
            ++n;
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        InputStream inputStream2 = inputStream;
        if (!inputStream.markSupported()) {
            inputStream2 = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream2.mark(0x500000);
        int n = 0;
        int n2 = list.size();
        while (n < n2) {
            block6: {
                inputStream = list.get(n);
                try {
                    arrayPool = inputStream.getType(inputStream2);
                    inputStream = ImageHeaderParser.ImageType.UNKNOWN;
                    if (arrayPool == inputStream) break block6;
                }
                finally {
                    inputStream2.reset();
                }
                return arrayPool;
            }
            ++n;
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int n = 0;
        int n2 = list.size();
        while (n < n2) {
            ImageHeaderParser.ImageType imageType = list.get(n).getType(byteBuffer);
            if (imageType != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageType;
            }
            ++n;
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
