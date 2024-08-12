/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.exifinterface.media.ExifInterface
 *  com.yalantis.ucrop.util.ImageHeaderParser$RandomAccessReader
 *  com.yalantis.ucrop.util.ImageHeaderParser$Reader
 *  com.yalantis.ucrop.util.ImageHeaderParser$StreamReader
 */
package com.yalantis.ucrop.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT;
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    public static final int UNKNOWN_ORIENTATION = -1;
    private final Reader reader;

    static {
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(StandardCharsets.UTF_8);
        BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.reader = new StreamReader(inputStream);
    }

    private static int calcTagOffset(int n, int n2) {
        return n + 2 + n2 * 12;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public static void copyExif(ExifInterface exifInterface, int n, int n2, String string) {
        block4: {
            ExifInterface exifInterface2;
            try {
                exifInterface2 = new ExifInterface(string);
                for (int i = 0; i < 22; ++i) {
                    string = (new String[]{"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"})[i];
                    String string2 = exifInterface.getAttribute(string);
                    if (TextUtils.isEmpty((CharSequence)string2)) continue;
                    exifInterface2.setAttribute(string, string2);
                }
            }
            catch (IOException iOException) {
                Log.d((String)TAG, (String)iOException.getMessage());
                break block4;
            }
            {
                exifInterface2.setAttribute("ImageWidth", String.valueOf(n));
                exifInterface2.setAttribute("ImageLength", String.valueOf(n2));
                exifInterface2.setAttribute("Orientation", "0");
                exifInterface2.saveAttributes();
            }
        }
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

    private int moveToExifSegmentAndGetLength() throws IOException {
        short s;
        int n;
        long l;
        StringBuilder stringBuilder;
        long l2;
        do {
            if ((s = this.reader.getUInt8()) != 255) {
                if (!Log.isLoggable((String)TAG, (int)3)) return -1;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown segmentId=");
                stringBuilder.append(s);
                Log.d((String)TAG, (String)stringBuilder.toString());
                return -1;
            }
            s = this.reader.getUInt8();
            if (s == 218) {
                return -1;
            }
            if (s == 217) {
                if (!Log.isLoggable((String)TAG, (int)3)) return -1;
                Log.d((String)TAG, (String)"Found MARKER_EOI in exif segment");
                return -1;
            }
            n = this.reader.getUInt16() - 2;
            if (s == 225) return n;
        } while ((l2 = (stringBuilder = this.reader).skip(l = (long)n)) == l);
        if (!Log.isLoggable((String)TAG, (int)3)) return -1;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to skip enough data, type: ");
        stringBuilder.append(s);
        stringBuilder.append(", wanted to skip: ");
        stringBuilder.append(n);
        stringBuilder.append(", but actually skipped: ");
        stringBuilder.append(l2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        return -1;
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        Object object;
        int n = randomAccessReader.getInt16(6);
        if (n == 19789) {
            object = ByteOrder.BIG_ENDIAN;
        } else if (n == 18761) {
            object = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable((String)TAG, (int)3)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unknown endianness = ");
                ((StringBuilder)object).append(n);
                Log.d((String)TAG, (String)((StringBuilder)object).toString());
            }
            object = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order((ByteOrder)object);
        int n2 = randomAccessReader.getInt32(10) + 6;
        short s = randomAccessReader.getInt16(n2);
        n = 0;
        while (n < s) {
            int n3 = ImageHeaderParser.calcTagOffset(n2, n);
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

    private int parseExifSegment(byte[] object, int n) throws IOException {
        int n2 = this.reader.read((byte[])object, n);
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
        if (this.hasJpegExifPreamble((byte[])object, n)) {
            return ImageHeaderParser.parseExifSegment(new RandomAccessReader((byte[])object, n));
        }
        if (!Log.isLoggable((String)TAG, (int)3)) return -1;
        Log.d((String)TAG, (String)"Missing jpeg exif preamble");
        return -1;
    }

    public int getOrientation() throws IOException {
        int n = this.reader.getUInt16();
        if (!ImageHeaderParser.handles(n)) {
            if (!Log.isLoggable((String)TAG, (int)3)) return -1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Parser doesn't handle magic number: ");
            stringBuilder.append(n);
            Log.d((String)TAG, (String)stringBuilder.toString());
            return -1;
        }
        n = this.moveToExifSegmentAndGetLength();
        if (n != -1) return this.parseExifSegment(new byte[n], n);
        if (!Log.isLoggable((String)TAG, (int)3)) return -1;
        Log.d((String)TAG, (String)"Failed to parse exif segment length, or exif segment not found");
        return -1;
    }
}
