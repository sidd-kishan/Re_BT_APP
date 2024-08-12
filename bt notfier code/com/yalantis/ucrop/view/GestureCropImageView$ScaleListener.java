/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 *  com.yalantis.ucrop.view.GestureCropImageView
 */
package com.yalantis.ucrop.view;

import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.view.GestureCropImageView;

/*
 * Exception performing whole class analysis ignored.
 */
private class GestureCropImageView.ScaleListener
extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    final GestureCropImageView this$0;

    private GestureCropImageView.ScaleListener(GestureCropImageView gestureCropImageView) {
        this.this$0 = gestureCropImageView;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.this$0.postScale(scaleGestureDetector.getScaleFactor(), GestureCropImageView.access$300((GestureCropImageView)this.this$0), GestureCropImageView.access$400((GestureCropImageView)this.this$0));
        return true;
    }
}
