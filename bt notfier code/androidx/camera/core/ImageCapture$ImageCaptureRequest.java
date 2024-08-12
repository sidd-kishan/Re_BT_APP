/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.util.Rational
 *  android.util.Size
 *  androidx.camera.core.ImageCapture$OnImageCapturedCallback
 *  androidx.camera.core.ImageCaptureException
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImmutableImageInfo
 *  androidx.camera.core.Logger
 *  androidx.camera.core.SettableImageProxy
 *  androidx.camera.core._$$Lambda$ImageCapture$ImageCaptureRequest$1G7WSvt8TANxhZtOyewefm68pg4
 *  androidx.camera.core._$$Lambda$ImageCapture$ImageCaptureRequest$E13UUGhRx8PID5WbaCuwcGP87BA
 *  androidx.camera.core.impl.TagBundle
 *  androidx.camera.core.impl.utils.Exif
 *  androidx.camera.core.internal.compat.workaround.ExifRotationAvailability
 *  androidx.camera.core.internal.utils.ImageUtil
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core._$;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

static class ImageCapture.ImageCaptureRequest {
    private final ImageCapture.OnImageCapturedCallback mCallback;
    AtomicBoolean mDispatched;
    final int mJpegQuality;
    private final Executor mListenerExecutor;
    final int mRotationDegrees;
    private final Rational mTargetRatio;
    private final Rect mViewPortCropRect;

    ImageCapture.ImageCaptureRequest(int n, int n2, Rational rational, Rect rect, Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        boolean bl = false;
        this.mDispatched = new AtomicBoolean(false);
        this.mRotationDegrees = n;
        this.mJpegQuality = n2;
        if (rational != null) {
            Preconditions.checkArgument((boolean)(rational.isZero() ^ true), (Object)"Target ratio cannot be zero");
            if (rational.floatValue() > 0.0f) {
                bl = true;
            }
            Preconditions.checkArgument((boolean)bl, (Object)"Target ratio must be positive");
        }
        this.mTargetRatio = rational;
        this.mViewPortCropRect = rect;
        this.mListenerExecutor = executor;
        this.mCallback = onImageCapturedCallback;
    }

    static Rect getDispatchCropRect(Rect rect, int n, Size object, int n2) {
        Matrix matrix = new Matrix();
        matrix.setRotate((float)(n2 - n));
        object = ImageUtil.sizeToVertexes((Size)object);
        matrix.mapPoints((float[])object);
        float f = ImageUtil.min((float)object[0], (float)object[2], (float)object[4], (float)object[6]);
        float f2 = ImageUtil.min((float)object[1], (float)object[3], (float)object[5], (float)object[7]);
        matrix.postTranslate(-f, -f2);
        matrix.invert(matrix);
        object = new RectF();
        matrix.mapRect((RectF)object, new RectF(rect));
        object.sort();
        rect = new Rect();
        object.round(rect);
        return rect;
    }

    void dispatchImage(ImageProxy imageProxy) {
        int n;
        Object object;
        Object object2;
        ByteBuffer byteBuffer;
        if (!this.mDispatched.compareAndSet(false, true)) {
            imageProxy.close();
            return;
        }
        if (new ExifRotationAvailability().shouldUseExifOrientation(imageProxy)) {
            try {
                byteBuffer = imageProxy.getPlanes()[0].getBuffer();
                byteBuffer.rewind();
                object2 = new byte[byteBuffer.capacity()];
                byteBuffer.get((byte[])object2);
                object = new ByteArrayInputStream((byte[])object2);
                object2 = Exif.createFromInputStream((InputStream)object);
                byteBuffer.rewind();
                byteBuffer = new Size(object2.getWidth(), object2.getHeight());
                n = object2.getRotation();
            }
            catch (IOException iOException) {
                this.notifyCallbackError(1, "Unable to parse JPEG exif", iOException);
                imageProxy.close();
                return;
            }
        } else {
            byteBuffer = new Size(imageProxy.getWidth(), imageProxy.getHeight());
            n = this.mRotationDegrees;
        }
        object2 = new SettableImageProxy(imageProxy, (Size)byteBuffer, ImmutableImageInfo.create((TagBundle)imageProxy.getImageInfo().getTagBundle(), (long)imageProxy.getImageInfo().getTimestamp(), (int)n));
        object = this.mViewPortCropRect;
        if (object != null) {
            object2.setCropRect(ImageCapture.ImageCaptureRequest.getDispatchCropRect((Rect)object, this.mRotationDegrees, (Size)byteBuffer, n));
        } else {
            byteBuffer = this.mTargetRatio;
            if (byteBuffer != null) {
                if (n % 180 != 0) {
                    byteBuffer = new Rational(this.mTargetRatio.getDenominator(), this.mTargetRatio.getNumerator());
                }
                if (ImageUtil.isAspectRatioValid((Size)(object = new Size(object2.getWidth(), object2.getHeight())), (Rational)byteBuffer)) {
                    object2.setCropRect(ImageUtil.computeCropRectFromAspectRatio((Size)object, (Rational)byteBuffer));
                }
            }
        }
        try {
            object = this.mListenerExecutor;
            byteBuffer = new _$.Lambda.ImageCapture.ImageCaptureRequest.E13UUGhRx8PID5WbaCuwcGP87BA(this, (ImageProxy)object2);
            object.execute((Runnable)((Object)byteBuffer));
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            Logger.e((String)"ImageCapture", (String)"Unable to post to the supplied executor.");
            imageProxy.close();
        }
    }

    public /* synthetic */ void lambda$dispatchImage$0$ImageCapture$ImageCaptureRequest(ImageProxy imageProxy) {
        this.mCallback.onCaptureSuccess(imageProxy);
    }

    public /* synthetic */ void lambda$notifyCallbackError$1$ImageCapture$ImageCaptureRequest(int n, String string, Throwable throwable) {
        this.mCallback.onError(new ImageCaptureException(n, string, throwable));
    }

    void notifyCallbackError(int n, String string, Throwable throwable) {
        if (!this.mDispatched.compareAndSet(false, true)) {
            return;
        }
        try {
            Executor executor = this.mListenerExecutor;
            _$.Lambda.ImageCapture.ImageCaptureRequest.1G7WSvt8TANxhZtOyewefm68pg4 g7WSvt8TANxhZtOyewefm68pg4 = new _$.Lambda.ImageCapture.ImageCaptureRequest.1G7WSvt8TANxhZtOyewefm68pg4(this, n, string, throwable);
            executor.execute((Runnable)g7WSvt8TANxhZtOyewefm68pg4);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            Logger.e((String)"ImageCapture", (String)"Unable to post to the supplied executor.");
        }
    }
}
