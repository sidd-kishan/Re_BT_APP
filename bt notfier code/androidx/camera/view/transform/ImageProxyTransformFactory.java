/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.view.TransformUtils
 *  androidx.camera.view.transform.OutputTransform
 */
package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.camera.core.ImageProxy;
import androidx.camera.view.TransformUtils;
import androidx.camera.view.transform.OutputTransform;

public class ImageProxyTransformFactory {
    private final boolean mUseCropRect;
    private final boolean mUseRotationDegrees;

    ImageProxyTransformFactory(boolean bl, boolean bl2) {
        this.mUseCropRect = bl;
        this.mUseRotationDegrees = bl2;
    }

    private RectF getCropRect(ImageProxy imageProxy) {
        if (!this.mUseCropRect) return new RectF(0.0f, 0.0f, (float)imageProxy.getWidth(), (float)imageProxy.getHeight());
        return new RectF(imageProxy.getCropRect());
    }

    static RectF getRotatedCropRect(RectF rectF, int n) {
        if (!TransformUtils.is90or270((int)n)) return new RectF(0.0f, 0.0f, rectF.width(), rectF.height());
        return new RectF(0.0f, 0.0f, rectF.height(), rectF.width());
    }

    private int getRotationDegrees(ImageProxy imageProxy) {
        if (!this.mUseRotationDegrees) return 0;
        return imageProxy.getImageInfo().getRotationDegrees();
    }

    public OutputTransform getOutputTransform(ImageProxy imageProxy) {
        int n = this.getRotationDegrees(imageProxy);
        RectF rectF = this.getCropRect(imageProxy);
        rectF = TransformUtils.getRectToRect((RectF)rectF, (RectF)ImageProxyTransformFactory.getRotatedCropRect(rectF, n), (int)n);
        rectF.preConcat(TransformUtils.getNormalizedToBuffer((Rect)imageProxy.getCropRect()));
        return new OutputTransform((Matrix)rectF, TransformUtils.rectToSize((Rect)imageProxy.getCropRect()));
    }
}
