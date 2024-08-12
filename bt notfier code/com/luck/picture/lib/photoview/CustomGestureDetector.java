/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.VelocityTracker
 *  android.view.ViewConfiguration
 *  com.luck.picture.lib.photoview.OnGestureListener
 *  com.luck.picture.lib.photoview.Util
 */
package com.luck.picture.lib.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.luck.picture.lib.photoview.OnGestureListener;
import com.luck.picture.lib.photoview.Util;

class CustomGestureDetector {
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId = -1;
    private int mActivePointerIndex = 0;
    private final ScaleGestureDetector mDetector;
    private boolean mIsDragging;
    private float mLastTouchX;
    private float mLastTouchY;
    private OnGestureListener mListener;
    private final float mMinimumVelocity;
    private final float mTouchSlop;
    private VelocityTracker mVelocityTracker;

    CustomGestureDetector(Context context, OnGestureListener onGestureListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mListener = onGestureListener;
        this.mDetector = new ScaleGestureDetector(context, (ScaleGestureDetector.OnScaleGestureListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ OnGestureListener access$000(CustomGestureDetector customGestureDetector) {
        return customGestureDetector.mListener;
    }

    private float getActiveX(MotionEvent motionEvent) {
        try {
            float f = motionEvent.getX(this.mActivePointerIndex);
            return f;
        }
        catch (Exception exception) {
            return motionEvent.getX();
        }
    }

    private float getActiveY(MotionEvent motionEvent) {
        try {
            float f = motionEvent.getY(this.mActivePointerIndex);
            return f;
        }
        catch (Exception exception) {
            return motionEvent.getY();
        }
    }

    private boolean processTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getAction() & 0xFF;
        int n2 = 0;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n == 6 && motionEvent.getPointerId(n = Util.getPointerIndex((int)motionEvent.getAction())) == this.mActivePointerId) {
                            n = n == 0 ? 1 : 0;
                            this.mActivePointerId = motionEvent.getPointerId(n);
                            this.mLastTouchX = motionEvent.getX(n);
                            this.mLastTouchY = motionEvent.getY(n);
                        }
                    } else {
                        this.mActivePointerId = -1;
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.mVelocityTracker = null;
                        }
                    }
                } else {
                    float f = this.getActiveX(motionEvent);
                    float f2 = this.getActiveY(motionEvent);
                    float f3 = f - this.mLastTouchX;
                    float f4 = f2 - this.mLastTouchY;
                    if (!this.mIsDragging) {
                        boolean bl = Math.sqrt(f3 * f3 + f4 * f4) >= (double)this.mTouchSlop;
                        this.mIsDragging = bl;
                    }
                    if (this.mIsDragging) {
                        this.mListener.onDrag(f3, f4);
                        this.mLastTouchX = f;
                        this.mLastTouchY = f2;
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        if (velocityTracker != null) {
                            velocityTracker.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker;
                this.mActivePointerId = -1;
                if (this.mIsDragging && this.mVelocityTracker != null) {
                    this.mLastTouchX = this.getActiveX(motionEvent);
                    this.mLastTouchY = this.getActiveY(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float f = this.mVelocityTracker.getXVelocity();
                    float f5 = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(f), Math.abs(f5)) >= this.mMinimumVelocity) {
                        this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -f, -f5);
                    }
                }
                if ((velocityTracker = this.mVelocityTracker) != null) {
                    velocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
            }
        } else {
            VelocityTracker velocityTracker;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mVelocityTracker = velocityTracker = VelocityTracker.obtain();
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.mLastTouchX = this.getActiveX(motionEvent);
            this.mLastTouchY = this.getActiveY(motionEvent);
            this.mIsDragging = false;
        }
        int n3 = this.mActivePointerId;
        n = n2;
        if (n3 != -1) {
            n = n3;
        }
        this.mActivePointerIndex = motionEvent.findPointerIndex(n);
        return true;
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public boolean isScaling() {
        return this.mDetector.isInProgress();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.mDetector.onTouchEvent(motionEvent);
            boolean bl = this.processTouchEvent(motionEvent);
            return bl;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return true;
        }
    }
}
