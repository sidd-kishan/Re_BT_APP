/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.PointF
 *  android.util.Size
 *  androidx.camera.core.MeteringPointFactory
 *  androidx.camera.core.impl.utils.Threads
 *  androidx.camera.view.PreviewTransformation
 */
package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.PreviewTransformation;

class PreviewViewMeteringPointFactory
extends MeteringPointFactory {
    static final PointF INVALID_POINT = new PointF(2.0f, 2.0f);
    private Matrix mMatrix;
    private final PreviewTransformation mPreviewTransformation;

    PreviewViewMeteringPointFactory(PreviewTransformation previewTransformation) {
        this.mPreviewTransformation = previewTransformation;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected PointF convertPoint(float f, float f2) {
        Object object = new float[]{f, f2};
        synchronized (this) {
            if (this.mMatrix == null) {
                return INVALID_POINT;
            }
            this.mMatrix.mapPoints(object);
            return new PointF(object[0], object[1]);
        }
    }

    void recalculate(Size size, int n) {
        Threads.checkMainThread();
        synchronized (this) {
            if (size.getWidth() != 0 && size.getHeight() != 0) {
                this.mMatrix = this.mPreviewTransformation.getPreviewViewToNormalizedSurfaceMatrix(size, n);
                return;
            }
            this.mMatrix = null;
            return;
        }
    }
}
