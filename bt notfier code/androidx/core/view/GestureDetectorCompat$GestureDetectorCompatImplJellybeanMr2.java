/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
 */
package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;

static class GestureDetectorCompat.GestureDetectorCompatImplJellybeanMr2
implements GestureDetectorCompat.GestureDetectorCompatImpl {
    private final GestureDetector mDetector;

    GestureDetectorCompat.GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.mDetector = new GestureDetector(context, onGestureListener, handler);
    }

    public boolean isLongpressEnabled() {
        return this.mDetector.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDetector.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean bl) {
        this.mDetector.setIsLongpressEnabled(bl);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
    }
}
