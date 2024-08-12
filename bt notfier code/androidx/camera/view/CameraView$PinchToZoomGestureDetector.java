/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  androidx.camera.view.CameraView
 *  androidx.camera.view.CameraView$S
 */
package androidx.camera.view;

import android.content.Context;
import android.view.ScaleGestureDetector;
import androidx.camera.view.CameraView;

private class CameraView.PinchToZoomGestureDetector
extends ScaleGestureDetector
implements ScaleGestureDetector.OnScaleGestureListener {
    final CameraView this$0;

    CameraView.PinchToZoomGestureDetector(CameraView cameraView, Context context) {
        this(cameraView, context, new CameraView.S());
    }

    CameraView.PinchToZoomGestureDetector(CameraView cameraView, Context context, CameraView.S s) {
        this.this$0 = cameraView;
        super(context, (ScaleGestureDetector.OnScaleGestureListener)s);
        s.setRealGestureDetector((ScaleGestureDetector.OnScaleGestureListener)this);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float f = scaleGestureDetector.getScaleFactor();
        f = f > 1.0f ? (f - 1.0f) * 2.0f + 1.0f : 1.0f - (1.0f - f) * 2.0f;
        float f2 = this.this$0.getZoomRatio();
        scaleGestureDetector = this.this$0;
        f = scaleGestureDetector.rangeLimit(f2 * f, scaleGestureDetector.getMaxZoomRatio(), this.this$0.getMinZoomRatio());
        this.this$0.setZoomRatio(f);
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }
}
