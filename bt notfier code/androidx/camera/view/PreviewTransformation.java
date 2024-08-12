/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.util.Size
 *  android.view.Display
 *  android.view.TextureView
 *  android.view.View
 *  androidx.camera.core.Logger
 *  androidx.camera.core.SurfaceRequest$TransformationInfo
 *  androidx.camera.view.PreviewTransformation$1
 *  androidx.camera.view.PreviewView$ScaleType
 *  androidx.camera.view.TransformUtils
 *  androidx.camera.view.internal.compat.quirk.DeviceQuirks
 *  androidx.camera.view.internal.compat.quirk.PreviewOneThirdWiderQuirk
 *  androidx.core.util.Preconditions
 */
package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewView;
import androidx.camera.view.TransformUtils;
import androidx.camera.view.internal.compat.quirk.DeviceQuirks;
import androidx.camera.view.internal.compat.quirk.PreviewOneThirdWiderQuirk;
import androidx.core.util.Preconditions;

final class PreviewTransformation {
    private static final PreviewView.ScaleType DEFAULT_SCALE_TYPE = PreviewView.ScaleType.FILL_CENTER;
    private static final String TAG = "PreviewTransform";
    private boolean mIsFrontCamera;
    private int mPreviewRotationDegrees;
    private Size mResolution;
    private PreviewView.ScaleType mScaleType = DEFAULT_SCALE_TYPE;
    private Rect mSurfaceCropRect;
    private int mTargetRotation;
    private Rect mViewportRect;

    PreviewTransformation() {
    }

    private static RectF flipHorizontally(RectF rectF, float f) {
        f += f;
        return new RectF(f - rectF.right, rectF.top, f - rectF.left, rectF.bottom);
    }

    private Rect getCorrectedCropRect(Rect rect) {
        PreviewOneThirdWiderQuirk previewOneThirdWiderQuirk = (PreviewOneThirdWiderQuirk)DeviceQuirks.get(PreviewOneThirdWiderQuirk.class);
        Rect rect2 = rect;
        if (previewOneThirdWiderQuirk == null) return rect2;
        RectF rectF = new RectF(rect);
        rect2 = new Matrix();
        rect2.setScale(previewOneThirdWiderQuirk.getCropRectScaleX(), 1.0f, (float)rect.centerX(), (float)rect.centerY());
        rect2.mapRect(rectF);
        rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    private Size getRotatedViewportSize() {
        if (!TransformUtils.is90or270((int)this.mPreviewRotationDegrees)) return new Size(this.mViewportRect.width(), this.mViewportRect.height());
        return new Size(this.mViewportRect.height(), this.mViewportRect.width());
    }

    private RectF getTransformedSurfaceRect(Size size, int n) {
        Preconditions.checkState((boolean)this.isTransformationInfoReady());
        size = this.getSurfaceToPreviewViewMatrix(size, n);
        RectF rectF = new RectF(0.0f, 0.0f, (float)this.mResolution.getWidth(), (float)this.mResolution.getHeight());
        size.mapRect(rectF);
        return rectF;
    }

    private boolean isTransformationInfoReady() {
        boolean bl = this.mSurfaceCropRect != null && this.mResolution != null;
        return bl;
    }

    private static void setMatrixRectToRect(Matrix matrix, RectF rectF, RectF rectF2, PreviewView.ScaleType scaleType) {
        Object object;
        switch (1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[scaleType.ordinal()]) {
            default: {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unexpected crop rect: ");
                ((StringBuilder)object).append(scaleType);
                Logger.e((String)TAG, (String)((StringBuilder)object).toString());
                object = Matrix.ScaleToFit.FILL;
                break;
            }
            case 5: 
            case 6: {
                object = Matrix.ScaleToFit.START;
                break;
            }
            case 3: 
            case 4: {
                object = Matrix.ScaleToFit.END;
                break;
            }
            case 1: 
            case 2: {
                object = Matrix.ScaleToFit.CENTER;
            }
        }
        boolean bl = scaleType == PreviewView.ScaleType.FIT_CENTER || scaleType == PreviewView.ScaleType.FIT_START || scaleType == PreviewView.ScaleType.FIT_END;
        if (bl) {
            matrix.setRectToRect(rectF, rectF2, (Matrix.ScaleToFit)object);
        } else {
            matrix.setRectToRect(rectF2, rectF, (Matrix.ScaleToFit)object);
            matrix.invert(matrix);
        }
    }

    Bitmap createTransformedBitmap(Bitmap bitmap, Size size, int n) {
        if (!this.isTransformationInfoReady()) {
            return bitmap;
        }
        Matrix matrix = this.getTextureViewCorrectionMatrix();
        RectF rectF = this.getTransformedSurfaceRect(size, n);
        size = Bitmap.createBitmap((int)size.getWidth(), (int)size.getHeight(), (Bitmap.Config)bitmap.getConfig());
        Canvas canvas = new Canvas((Bitmap)size);
        Matrix matrix2 = new Matrix();
        matrix2.postConcat(matrix);
        matrix2.postScale(rectF.width() / (float)this.mResolution.getWidth(), rectF.height() / (float)this.mResolution.getHeight());
        matrix2.postTranslate(rectF.left, rectF.top);
        canvas.drawBitmap(bitmap, matrix2, new Paint(7));
        return size;
    }

    Matrix getPreviewViewToNormalizedSurfaceMatrix(Size size, int n) {
        if (!this.isTransformationInfoReady()) {
            return null;
        }
        Matrix matrix = new Matrix();
        this.getSurfaceToPreviewViewMatrix(size, n).invert(matrix);
        size = new Matrix();
        size.setRectToRect(new RectF(0.0f, 0.0f, (float)this.mResolution.getWidth(), (float)this.mResolution.getHeight()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        matrix.postConcat((Matrix)size);
        return matrix;
    }

    RectF getPreviewViewViewportRectForMismatchedAspectRatios(Size size, int n) {
        RectF rectF = new RectF(0.0f, 0.0f, (float)size.getWidth(), (float)size.getHeight());
        Size size2 = this.getRotatedViewportSize();
        size2 = new RectF(0.0f, 0.0f, (float)size2.getWidth(), (float)size2.getHeight());
        Matrix matrix = new Matrix();
        PreviewTransformation.setMatrixRectToRect(matrix, (RectF)size2, rectF, this.mScaleType);
        matrix.mapRect((RectF)size2);
        if (n != 1) return size2;
        return PreviewTransformation.flipHorizontally((RectF)size2, (float)size.getWidth() / 2.0f);
    }

    PreviewView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    Rect getSurfaceCropRect() {
        return this.mSurfaceCropRect;
    }

    Matrix getSurfaceToPreviewViewMatrix(Size size, int n) {
        Preconditions.checkState((boolean)this.isTransformationInfoReady());
        size = this.isViewportAspectRatioMatchPreviewView(size) ? new RectF(0.0f, 0.0f, (float)size.getWidth(), (float)size.getHeight()) : this.getPreviewViewViewportRectForMismatchedAspectRatios(size, n);
        size = TransformUtils.getRectToRect((RectF)new RectF(this.mSurfaceCropRect), (RectF)size, (int)this.mPreviewRotationDegrees);
        if (!this.mIsFrontCamera) return size;
        if (TransformUtils.is90or270((int)this.mPreviewRotationDegrees)) {
            size.preScale(1.0f, -1.0f, (float)this.mSurfaceCropRect.centerX(), (float)this.mSurfaceCropRect.centerY());
        } else {
            size.preScale(-1.0f, 1.0f, (float)this.mSurfaceCropRect.centerX(), (float)this.mSurfaceCropRect.centerY());
        }
        return size;
    }

    Matrix getTextureViewCorrectionMatrix() {
        Preconditions.checkState((boolean)this.isTransformationInfoReady());
        RectF rectF = new RectF(0.0f, 0.0f, (float)this.mResolution.getWidth(), (float)this.mResolution.getHeight());
        return TransformUtils.getRectToRect((RectF)rectF, (RectF)rectF, (int)(-TransformUtils.surfaceRotationToRotationDegrees((int)this.mTargetRotation)));
    }

    boolean isViewportAspectRatioMatchPreviewView(Size size) {
        return TransformUtils.isAspectRatioMatchingWithRoundingError((Size)size, (boolean)true, (Size)this.getRotatedViewportSize(), (boolean)false);
    }

    void setScaleType(PreviewView.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    void setTransformationInfo(SurfaceRequest.TransformationInfo transformationInfo, Size size, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transformation info set: ");
        stringBuilder.append(transformationInfo);
        stringBuilder.append(" ");
        stringBuilder.append(size);
        stringBuilder.append(" ");
        stringBuilder.append(bl);
        Logger.d((String)TAG, (String)stringBuilder.toString());
        this.mSurfaceCropRect = this.getCorrectedCropRect(transformationInfo.getCropRect());
        this.mViewportRect = transformationInfo.getCropRect();
        this.mPreviewRotationDegrees = transformationInfo.getRotationDegrees();
        this.mTargetRotation = transformationInfo.getTargetRotation();
        this.mResolution = size;
        this.mIsFrontCamera = bl;
    }

    void transformView(Size size, int n, View object) {
        if (size.getHeight() != 0 && size.getWidth() != 0) {
            if (!this.isTransformationInfoReady()) {
                return;
            }
            if (object instanceof TextureView) {
                ((TextureView)object).setTransform(this.getTextureViewCorrectionMatrix());
            } else {
                Display display = object.getDisplay();
                if (display != null && display.getRotation() != this.mTargetRotation) {
                    Logger.e((String)TAG, (String)"Non-display rotation not supported with SurfaceView / PERFORMANCE mode.");
                }
            }
            size = this.getTransformedSurfaceRect(size, n);
            object.setPivotX(0.0f);
            object.setPivotY(0.0f);
            object.setScaleX(size.width() / (float)this.mResolution.getWidth());
            object.setScaleY(size.height() / (float)this.mResolution.getHeight());
            object.setTranslationX(size.left - (float)object.getLeft());
            object.setTranslationY(size.top - (float)object.getTop());
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Transform not applied due to PreviewView size: ");
        ((StringBuilder)object).append(size);
        Logger.w((String)TAG, (String)((StringBuilder)object).toString());
    }
}
