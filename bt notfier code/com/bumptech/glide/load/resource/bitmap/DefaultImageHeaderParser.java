/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParser$ImageType
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$ByteBufferReader
 *  com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$RandomAccessReader
 *  com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
 *  com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$StreamReader
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser
implements ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT;
    static final int EXIF_MAGIC_NUMBER = 65496;
    static final int EXIF_SEGMENT_TYPE = 225;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int RIFF_HEADER = 1380533830;
    private static final int SEGMENT_SOS = 218;
    static final int SEGMENT_START_ID = 255;
    private static final String TAG = "DfltImageHeaderParser";
    private static final int VP8_HEADER = 1448097792;
    private static final int VP8_HEADER_MASK = -256;
    private static final int VP8_HEADER_TYPE_EXTENDED = 88;
    private static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    private static final int VP8_HEADER_TYPE_MASK = 255;
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;

    static {
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
        BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    private static int calcTagOffset(int n, int n2) {
        return n + 2 + n2 * 12;
    }

    private int getOrientation(Reader object, ArrayPool arrayPool) throws IOException {
        int n = object.getUInt16();
        if (!DefaultImageHeaderParser.handles(n)) {
            if (!Log.isLoggable((String)TAG, (int)3)) return -1;
            object = new StringBuilder();
            ((StringBuilder)object).append("Parser doesn't handle magic number: ");
            ((StringBuilder)object).append(n);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            return -1;
        }
        n = this.moveToExifSegmentAndGetLength((Reader)object);
        if (n == -1) {
            if (!Log.isLoggable((String)TAG, (int)3)) return -1;
            Log.d((String)TAG, (String)"Failed to parse exif segment length, or exif segment not found");
            return -1;
        }
        byte[] byArray = (byte[])arrayPool.get(n, byte[].class);
        try {
            n = this.parseExifSegment((Reader)object, byArray, n);
            return n;
        }
        finally {
            arrayPool.put((Object)byArray);
        }
    }

    private ImageHeaderParser.ImageType getType(Reader reader) throws IOException {
        int n = reader.getUInt16();
        if (n == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        if ((n = n << 16 & 0xFFFF0000 | reader.getUInt16() & 0xFFFF) == -1991225785) {
            reader.skip(21L);
            reader = reader.getByte() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
            return reader;
        }
        if (n >> 8 == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        }
        if (n != 1380533830) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        reader.skip(4L);
        if ((reader.getUInt16() << 16 & 0xFFFF0000 | reader.getUInt16() & 0xFFFF) != 1464156752) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        n = reader.getUInt16() << 16 & 0xFFFF0000 | reader.getUInt16() & 0xFFFF;
        if ((n & 0xFFFFFF00) != 1448097792) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if ((n &= 0xFF) == 88) {
            reader.skip(4L);
            reader = (reader.getByte() & 0x10) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            return reader;
        }
        if (n != 76) return ImageHeaderParser.ImageType.WEBP;
        reader.skip(4L);
        reader = (reader.getByte() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        return reader;
    }

    private static boolean handles(int n) {
        boolean bl = (n & 0xFFD8) == 65496 || n == 19789 || n == 18761;
        return bl;
    }

    private boolean hasJpegExifPreamble(byte[] byArray, int n) {
        byte[] byArray2;
        boolean bl = false;
        boolean bl2 = byArray != null && n > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (!bl2) return bl2;
        n = 0;
        while (n < (byArray2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES).length) {
            if (byArray[n] != byArray2[n]) {
                bl2 = bl;
                return bl2;
            }
            ++n;
        }
        return bl2;
    }

    private int moveToExifSegmentAndGetLength(Reader object) throws IOException {
        short s;
        int n;
        long l;
        long l2;
        do {
            if ((s = object.getUInt8()) != 255) {
                if (!Log.isLoggable((String)TAG, (int)3)) return -1;
                object = new StringBuilder();
                ((StringBuilder)object).append("Unknown segmentId=");
                ((StringBuilder)object).append(s);
                Log.d((String)TAG, (String)((StringBuilder)object).toString());
                return -1;
            }
            s = object.getUInt8();
            if (s == 218) {
                return -1;
            }
            if (s == 217) {
                if (!Log.isLoggable((String)TAG, (int)3)) return -1;
                Log.d((String)TAG, (String)"Found MARKER_EOI in exif segment");
                return -1;
            }
            n = object.getUInt16() - 2;
            if (s == 225) return n;
        } while ((l2 = object.skip(l = (long)n)) == l);
        if (!Log.isLoggable((String)TAG, (int)3)) return -1;
        object = new StringBuilder();
        ((StringBuilder)object).append("Unable to skip enough data, type: ");
        ((StringBuilder)object).append(s);
        ((StringBuilder)object).append(", wanted to skip: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(", but actually skipped: ");
        ((StringBuilder)object).append(l2);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        return -1;
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        Object object;
        int n = randomAccessReader.getInt16(6);
        if (n != 18761) {
            if (n != 19789) {
                if (Log.isLoggable((String)TAG, (int)3)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unknown endianness = ");
                    ((StringBuilder)object).append(n);
                    Log.d((String)TAG, (String)((StringBuilder)object).toString());
                }
                object = ByteOrder.BIG_ENDIAN;
            } else {
                object = ByteOrder.BIG_ENDIAN;
            }
        } else {
            object = ByteOrder.LITTLE_ENDIAN;
        }
        randomAccessReader.order((ByteOrder)object);
        int n2 = randomAccessReader.getInt32(10) + 6;
        short s = randomAccessReader.getInt16(n2);
        n = 0;
        while (n < s) {
            int n3 = DefaultImageHeaderParser.calcTagOffset(n2, n);
            short s2 = randomAccessReader.getInt16(n3);
            if (s2 == 274) {
                short s3 = randomAccessReader.getInt16(n3 + 2);
                if (s3 >= 1 && s3 <= 12) {
                    int n4 = randomAccessReader.getInt32(n3 + 4);
                    if (n4 < 0) {
                        if (Log.isLoggable((String)TAG, (int)3)) {
                            Log.d((String)TAG, (String)"Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable((String)TAG, (int)3)) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Got tagIndex=");
                            ((StringBuilder)object).append(n);
                            ((StringBuilder)object).append(" tagType=");
                            ((StringBuilder)object).append(s2);
                            ((StringBuilder)object).append(" formatCode=");
                            ((StringBuilder)object).append(s3);
                            ((StringBuilder)object).append(" componentCount=");
                            ((StringBuilder)object).append(n4);
                            Log.d((String)TAG, (String)((StringBuilder)object).toString());
                        }
                        if ((n4 += BYTES_PER_FORMAT[s3]) > 4) {
                            if (Log.isLoggable((String)TAG, (int)3)) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("Got byte count > 4, not orientation, continuing, formatCode=");
                                ((StringBuilder)object).append(s3);
                                Log.d((String)TAG, (String)((StringBuilder)object).toString());
                            }
                        } else if ((n3 += 8) >= 0 && n3 <= randomAccessReader.length()) {
                            if (n4 >= 0) {
                                if (n4 + n3 <= randomAccessReader.length()) return randomAccessReader.getInt16(n3);
                            }
                            if (Log.isLoggable((String)TAG, (int)3)) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("Illegal number of bytes for TI tag data tagType=");
                                ((StringBuilder)object).append(s2);
                                Log.d((String)TAG, (String)((StringBuilder)object).toString());
                            }
                        } else if (Log.isLoggable((String)TAG, (int)3)) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Illegal tagValueOffset=");
                            ((StringBuilder)object).append(n3);
                            ((StringBuilder)object).append(" tagType=");
                            ((StringBuilder)object).append(s2);
                            Log.d((String)TAG, (String)((StringBuilder)object).toString());
                        }
                    }
                } else if (Log.isLoggable((String)TAG, (int)3)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Got invalid format code = ");
                    ((StringBuilder)object).append(s3);
                    Log.d((String)TAG, (String)((StringBuilder)object).toString());
                }
            }
            ++n;
        }
        return -1;
    }

    private int parseExifSegment(Reader object, byte[] byArray, int n) throws IOException {
        int n2 = object.read(byArray, n);
        if (n2 != n) {
            if (!Log.isLoggable((String)TAG, (int)3)) return -1;
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to read exif segment data, length: ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(", actually read: ");
            ((StringBuilder)object).append(n2);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            return -1;
        }
        if (this.hasJpegExifPreamble(byArray, n)) {
            return DefaultImageHeaderParser.parseExifSegment(new RandomAccessReader(byArray, n));
        }
        if (!Log.isLoggable((String)TAG, (int)3)) return -1;
        Log.d((String)TAG, (String)"Missing jpeg exif preamble");
        return -1;
    }

    public int getOrientation(InputStream inputStream, ArrayPool arrayPool) throws IOException {
        return this.getOrientation((Reader)new StreamReader((InputStream)Preconditions.checkNotNull((Object)inputStream)), (ArrayPool)Preconditions.checkNotNull((Object)arrayPool));
    }

    public int getOrientation(ByteBuffer byteBuffer, ArrayPool arrayPool) throws IOException {
        return this.getOrientation((Reader)new ByteBufferReader((ByteBuffer)Preconditions.checkNotNull((Object)byteBuffer)), (ArrayPool)Preconditions.checkNotNull((Object)arrayPool));
    }

    public ImageHeaderParser.ImageType getType(InputStream inputStream) throws IOException {
        return this.getType((Reader)new StreamReader((InputStream)Preconditions.checkNotNull((Object)inputStream)));
    }

    public ImageHeaderParser.ImageType getType(ByteBuffer byteBuffer) throws IOException {
        return this.getType((Reader)new ByteBufferReader((ByteBuffer)Preconditions.checkNotNull((Object)byteBuffer)));
    }
}
