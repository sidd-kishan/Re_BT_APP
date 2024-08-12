/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 *  androidx.camera.view.PreviewView
 */
package androidx.camera.view;

import android.view.ScaleGestureDetector;
import androidx.camera.view.PreviewView;

class PreviewView.PinchToZoomOnScaleGestureListener
extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    final PreviewView this$0;

    PreviewView.PinchToZoomOnScaleGestureListener(PreviewView previewView) {
        this.this$0 = previewView;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (this.this$0.mCameraController == null) return true;
        this.this$0.mCameraController.onPinchToZoom(scaleGestureDetector.getScaleFactor());
        return true;
    }
}
