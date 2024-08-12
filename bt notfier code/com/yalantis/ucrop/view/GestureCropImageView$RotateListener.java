/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.yalantis.ucrop.util.RotationGestureDetector
 *  com.yalantis.ucrop.util.RotationGestureDetector$SimpleOnRotationGestureListener
 *  com.yalantis.ucrop.view.GestureCropImageView
 */
package com.yalantis.ucrop.view;

import com.yalantis.ucrop.util.RotationGestureDetector;
import com.yalantis.ucrop.view.GestureCropImageView;

/*
 * Exception performing whole class analysis ignored.
 */
private class GestureCropImageView.RotateListener
extends RotationGestureDetector.SimpleOnRotationGestureListener {
    final GestureCropImageView this$0;

    private GestureCropImageView.RotateListener(GestureCropImageView gestureCropImageView) {
        this.this$0 = gestureCropImageView;
    }

    public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
        this.this$0.postRotate(rotationGestureDetector.getAngle(), GestureCropImageView.access$300((GestureCropImageView)this.this$0), GestureCropImageView.access$400((GestureCropImageView)this.this$0));
        return true;
    }
}
