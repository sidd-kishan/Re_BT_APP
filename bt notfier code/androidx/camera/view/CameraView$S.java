/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 */
package androidx.camera.view;

import android.view.ScaleGestureDetector;

static class CameraView.S
extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private ScaleGestureDetector.OnScaleGestureListener mListener;

    CameraView.S() {
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return this.mListener.onScale(scaleGestureDetector);
    }

    void setRealGestureDetector(ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        this.mListener = onScaleGestureListener;
    }
}
