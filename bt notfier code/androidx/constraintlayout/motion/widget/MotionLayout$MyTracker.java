/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
 */
package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.constraintlayout.motion.widget.MotionLayout;

private static class MotionLayout.MyTracker
implements MotionLayout.MotionTracker {
    private static MotionLayout.MyTracker me = new MotionLayout.MyTracker();
    VelocityTracker tracker;

    private MotionLayout.MyTracker() {
    }

    public static MotionLayout.MyTracker obtain() {
        MotionLayout.MyTracker.me.tracker = VelocityTracker.obtain();
        return me;
    }

    public void addMovement(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker == null) return;
        velocityTracker.addMovement(motionEvent);
    }

    public void clear() {
        this.tracker.clear();
    }

    public void computeCurrentVelocity(int n) {
        this.tracker.computeCurrentVelocity(n);
    }

    public void computeCurrentVelocity(int n, float f) {
        this.tracker.computeCurrentVelocity(n, f);
    }

    public float getXVelocity() {
        return this.tracker.getXVelocity();
    }

    public float getXVelocity(int n) {
        return this.tracker.getXVelocity(n);
    }

    public float getYVelocity() {
        return this.tracker.getYVelocity();
    }

    public float getYVelocity(int n) {
        return this.getYVelocity(n);
    }

    public void recycle() {
        this.tracker.recycle();
        this.tracker = null;
    }
}
