/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  com.yalantis.ucrop.util.RotationGestureDetector
 *  com.yalantis.ucrop.util.RotationGestureDetector$OnRotationGestureListener
 *  com.yalantis.ucrop.view.CropImageView
 *  com.yalantis.ucrop.view.GestureCropImageView$GestureListener
 *  com.yalantis.ucrop.view.GestureCropImageView$RotateListener
 *  com.yalantis.ucrop.view.GestureCropImageView$ScaleListener
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.GestureCropImageView;

public class GestureCropImageView
extends CropImageView {
    private static final int DOUBLE_TAP_ZOOM_DURATION = 200;
    private int mDoubleTapScaleSteps = 5;
    private GestureDetector mGestureDetector;
    private boolean mIsRotateEnabled = true;
    private boolean mIsScaleEnabled = true;
    private float mMidPntX;
    private float mMidPntY;
    private RotationGestureDetector mRotateDetector;
    private ScaleGestureDetector mScaleDetector;

    public GestureCropImageView(Context context) {
        super(context);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    static /* synthetic */ float access$300(GestureCropImageView gestureCropImageView) {
        return gestureCropImageView.mMidPntX;
    }

    static /* synthetic */ float access$400(GestureCropImageView gestureCropImageView) {
        return gestureCropImageView.mMidPntY;
    }

    private void setupGestureListeners() {
        this.mGestureDetector = new GestureDetector(this.getContext(), (GestureDetector.OnGestureListener)new GestureListener(this, null), null, true);
        this.mScaleDetector = new ScaleGestureDetector(this.getContext(), (ScaleGestureDetector.OnScaleGestureListener)new ScaleListener(this, null));
        this.mRotateDetector = new RotationGestureDetector((RotationGestureDetector.OnRotationGestureListener)new RotateListener(this, null));
    }

    public int getDoubleTapScaleSteps() {
        return this.mDoubleTapScaleSteps;
    }

    protected float getDoubleTapTargetScale() {
        return this.getCurrentScale() * (float)Math.pow(this.getMaxScale() / this.getMinScale(), 1.0f / (float)this.mDoubleTapScaleSteps);
    }

    protected void init() {
        super.init();
        this.setupGestureListeners();
    }

    public boolean isRotateEnabled() {
        return this.mIsRotateEnabled;
    }

    public boolean isScaleEnabled() {
        return this.mIsScaleEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 0xFF) == 0) {
            this.cancelAllAnimations();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.mMidPntX = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.mMidPntY = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        if (this.mIsScaleEnabled) {
            this.mScaleDetector.onTouchEvent(motionEvent);
        }
        if (this.mIsRotateEnabled) {
            this.mRotateDetector.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() & 0xFF) != 1) return true;
        this.setImageToWrapCropBounds();
        return true;
    }

    public void setDoubleTapScaleSteps(int n) {
        this.mDoubleTapScaleSteps = n;
    }

    public void setRotateEnabled(boolean bl) {
        this.mIsRotateEnabled = bl;
    }

    public void setScaleEnabled(boolean bl) {
        this.mIsScaleEnabled = bl;
    }
}
