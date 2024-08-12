/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  com.yalantis.ucrop.view.GestureCropImageView
 */
package com.yalantis.ucrop.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.yalantis.ucrop.view.GestureCropImageView;

private class GestureCropImageView.GestureListener
extends GestureDetector.SimpleOnGestureListener {
    final GestureCropImageView this$0;

    private GestureCropImageView.GestureListener(GestureCropImageView gestureCropImageView) {
        this.this$0 = gestureCropImageView;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        GestureCropImageView gestureCropImageView = this.this$0;
        gestureCropImageView.zoomImageToPosition(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
        return super.onDoubleTap(motionEvent);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.this$0.postTranslate(-f, -f2);
        return true;
    }
}
