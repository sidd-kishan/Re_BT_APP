/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  com.yalantis.ucrop.util.RotationGestureDetector$OnRotationGestureListener
 */
package com.yalantis.ucrop.util;

import android.view.MotionEvent;
import com.yalantis.ucrop.util.RotationGestureDetector;

public class RotationGestureDetector {
    private static final int INVALID_POINTER_INDEX = -1;
    private float fX;
    private float fY;
    private float mAngle;
    private boolean mIsFirstTouch;
    private OnRotationGestureListener mListener;
    private int mPointerIndex1;
    private int mPointerIndex2;
    private float sX;
    private float sY;

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.mListener = onRotationGestureListener;
        this.mPointerIndex1 = -1;
        this.mPointerIndex2 = -1;
    }

    private float calculateAngleBetweenLines(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return this.calculateAngleDelta((float)Math.toDegrees((float)Math.atan2(f2 - f4, f - f3)), (float)Math.toDegrees((float)Math.atan2(f6 - f8, f5 - f7)));
    }

    private float calculateAngleDelta(float f, float f2) {
        this.mAngle = f = f2 % 360.0f - f % 360.0f;
        if (f < -180.0f) {
            this.mAngle = f + 360.0f;
        } else {
            if (!(f > 180.0f)) return this.mAngle;
            this.mAngle = f - 360.0f;
        }
        return this.mAngle;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 5) {
                        if (n != 6) return true;
                        this.mPointerIndex2 = -1;
                    } else {
                        this.fX = motionEvent.getX();
                        this.fY = motionEvent.getY();
                        this.mPointerIndex2 = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                        this.mAngle = 0.0f;
                        this.mIsFirstTouch = true;
                    }
                } else {
                    if (this.mPointerIndex1 == -1) return true;
                    if (this.mPointerIndex2 == -1) return true;
                    if (motionEvent.getPointerCount() <= this.mPointerIndex2) return true;
                    float f = motionEvent.getX(this.mPointerIndex1);
                    float f2 = motionEvent.getY(this.mPointerIndex1);
                    float f3 = motionEvent.getX(this.mPointerIndex2);
                    float f4 = motionEvent.getY(this.mPointerIndex2);
                    if (this.mIsFirstTouch) {
                        this.mAngle = 0.0f;
                        this.mIsFirstTouch = false;
                    } else {
                        this.calculateAngleBetweenLines(this.fX, this.fY, this.sX, this.sY, f3, f4, f, f2);
                    }
                    motionEvent = this.mListener;
                    if (motionEvent != null) {
                        motionEvent.onRotation(this);
                    }
                    this.fX = f3;
                    this.fY = f4;
                    this.sX = f;
                    this.sY = f2;
                }
            } else {
                this.mPointerIndex1 = -1;
            }
        } else {
            this.sX = motionEvent.getX();
            this.sY = motionEvent.getY();
            this.mPointerIndex1 = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.mAngle = 0.0f;
            this.mIsFirstTouch = true;
        }
        return true;
    }
}
