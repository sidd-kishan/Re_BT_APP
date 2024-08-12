/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.BitmapRegionDecoder
 *  android.graphics.Rect
 *  android.graphics.YuvImage
 *  android.util.Rational
 *  android.util.Size
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImageProxy$PlaneProxy
 *  androidx.camera.core.Logger
 *  androidx.camera.core.internal.utils.ImageUtil$CodecFailedException
 *  androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType
 */
package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.internal.utils.ImageUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class ImageUtil {
    private static final String TAG = "ImageUtil";

    private ImageUtil() {
    }

    public static Rect computeCropRectFromAspectRatio(Size size, Rational rational) {
        if (!ImageUtil.isAspectRatioValid(rational)) {
            Logger.w((String)TAG, (String)"Invalid view ratio.");
            return null;
        }
        int n = size.getWidth();
        int n2 = size.getHeight();
        float f = n;
        float f2 = n2;
        float f3 = f / f2;
        int n3 = rational.getNumerator();
        int n4 = rational.getDenominator();
        float f4 = rational.floatValue();
        int n5 = 0;
        if (f4 > f3) {
            n3 = Math.round(f / (float)n3 * (float)n4);
            n4 = (n2 - n3) / 2;
            n2 = n3;
        } else {
            n4 = Math.round(f2 / (float)n4 * (float)n3);
            n5 = (n - n4) / 2;
            n = n4;
            n4 = 0;
        }
        return new Rect(n5, n4, n + n5, n2 + n4);
    }

    public static byte[] cropByteArray(byte[] object, Rect object2) throws CodecFailedException {
        if (object2 == null) {
            return object;
        }
        try {
            object = BitmapRegionDecoder.newInstance((byte[])object, (int)0, (int)((byte[])object).length, (boolean)false);
            BitmapFactory.Options options = new BitmapFactory.Options();
            object2 = object.decodeRegion((Rect)object2, options);
            object.recycle();
            if (object2 == null) throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        }
        catch (IOException iOException) {
            throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Decode byte array failed with illegal argument.");
            ((StringBuilder)object2).append(illegalArgumentException);
            throw new CodecFailedException(((StringBuilder)object2).toString(), CodecFailedException.FailureType.DECODE_FAILED);
        }
        object = new ByteArrayOutputStream();
        if (!object2.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)object)) throw new CodecFailedException("Encode bitmap failed.", CodecFailedException.FailureType.ENCODE_FAILED);
        object2.recycle();
        return ((ByteArrayOutputStream)object).toByteArray();
    }

    public static Rational getRotatedAspectRatio(int n, Rational rational) {
        if (n == 90) return ImageUtil.inverseRational(rational);
        if (n != 270) return new Rational(rational.getNumerator(), rational.getDenominator());
        return ImageUtil.inverseRational(rational);
    }

    public static byte[] imageToJpegByteArray(ImageProxy object) throws CodecFailedException {
        if (object.getFormat() == 256) {
            object = ImageUtil.jpegImageToJpegByteArray(object);
        } else if (object.getFormat() == 35) {
            object = ImageUtil.yuvImageToJpegByteArray(object);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unrecognized image format: ");
            stringBuilder.append(object.getFormat());
            Logger.w((String)TAG, (String)stringBuilder.toString());
            object = null;
        }
        return object;
    }

    private static Rational inverseRational(Rational rational) {
        if (rational != null) return new Rational(rational.getDenominator(), rational.getNumerator());
        return rational;
    }

    public static boolean isAspectRatioValid(Rational rational) {
        boolean bl = rational != null && rational.floatValue() > 0.0f && !rational.isNaN();
        return bl;
    }

    public static boolean isAspectRatioValid(Size size, Rational rational) {
        boolean bl = rational != null && rational.floatValue() > 0.0f && ImageUtil.isCropAspectRatioHasEffect(size, rational) && !rational.isNaN();
        return bl;
    }

    private static boolean isCropAspectRatioHasEffect(Size size, Rational rational) {
        int n = size.getWidth();
        int n2 = size.getHeight();
        int n3 = rational.getNumerator();
        int n4 = rational.getDenominator();
        float f = n;
        float f2 = n3;
        float f3 = n4;
        boolean bl = n2 != Math.round((f /= f2) * f3) || n != Math.round((float)n2 / f3 * f2);
        return bl;
    }

    private static byte[] jpegImageToJpegByteArray(ImageProxy imageProxy) throws CodecFailedException {
        Object object = imageProxy.getPlanes()[0].getBuffer();
        byte[] byArray = new byte[((Buffer)object).capacity()];
        ((Buffer)object).rewind();
        ((ByteBuffer)object).get(byArray);
        object = byArray;
        if (!ImageUtil.shouldCropImage(imageProxy)) return object;
        object = ImageUtil.cropByteArray(byArray, imageProxy.getCropRect());
        return object;
    }

    public static float min(float f, float f2, float f3, float f4) {
        return Math.min(Math.min(f, f2), Math.min(f3, f4));
    }

    private static byte[] nv21ToJpeg(byte[] object, int n, int n2, Rect rect) throws CodecFailedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        YuvImage yuvImage = new YuvImage(object, 17, n, n2, null);
        object = rect;
        if (rect == null) {
            object = new Rect(0, 0, n, n2);
        }
        if (!yuvImage.compressToJpeg((Rect)object, 100, (OutputStream)byteArrayOutputStream)) throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
        return byteArrayOutputStream.toByteArray();
    }

    private static boolean shouldCropImage(ImageProxy imageProxy) {
        Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
        return new Size(imageProxy.getCropRect().width(), imageProxy.getCropRect().height()).equals((Object)size) ^ true;
    }

    public static float[] sizeToVertexes(Size size) {
        return new float[]{0.0f, 0.0f, size.getWidth(), 0.0f, size.getWidth(), size.getHeight(), 0.0f, size.getHeight()};
    }

    private static byte[] yuvImageToJpegByteArray(ImageProxy object) throws CodecFailedException {
        byte[] byArray = ImageUtil.yuv_420_888toNv21(object);
        int n = object.getWidth();
        int n2 = object.getHeight();
        object = ImageUtil.shouldCropImage(object) ? object.getCropRect() : null;
        return ImageUtil.nv21ToJpeg(byArray, n, n2, (Rect)object);
    }

    public static byte[] yuv_420_888toNv21(ImageProxy object) {
        int n;
        Object object2 = object.getPlanes()[0];
        ImageProxy.PlaneProxy planeProxy = object.getPlanes()[1];
        ImageProxy.PlaneProxy planeProxy2 = object.getPlanes()[2];
        ByteBuffer byteBuffer = object2.getBuffer();
        ByteBuffer byteBuffer2 = planeProxy.getBuffer();
        ByteBuffer byteBuffer3 = planeProxy2.getBuffer();
        byteBuffer.rewind();
        byteBuffer2.rewind();
        byteBuffer3.rewind();
        int n2 = byteBuffer.remaining();
        byte[] byArray = new byte[object.getWidth() * object.getHeight() / 2 + n2];
        int n3 = 0;
        for (n = 0; n < object.getHeight(); n3 += object.getWidth(), ++n) {
            byteBuffer.get(byArray, n3, object.getWidth());
            byteBuffer.position(Math.min(n2, byteBuffer.position() - object.getWidth() + object2.getRowStride()));
        }
        int n4 = object.getHeight() / 2;
        int n5 = object.getWidth() / 2;
        int n6 = planeProxy2.getRowStride();
        int n7 = planeProxy.getRowStride();
        int n8 = planeProxy2.getPixelStride();
        int n9 = planeProxy.getPixelStride();
        object2 = new byte[n6];
        object = new byte[n7];
        n = 0;
        int n10 = n3;
        while (n < n4) {
            byteBuffer3.get((byte[])object2, 0, Math.min(n6, byteBuffer3.remaining()));
            byteBuffer2.get((byte[])object, 0, Math.min(n7, byteBuffer2.remaining()));
            n2 = 0;
            n3 = 0;
            for (int i = 0; i < n5; n2 += n8, n3 += n9, ++i) {
                int n11 = n10 + 1;
                byArray[n10] = (byte)object2[n2];
                n10 = n11 + 1;
                byArray[n11] = (byte)object[n3];
            }
            ++n;
        }
        return byArray;
    }
}
