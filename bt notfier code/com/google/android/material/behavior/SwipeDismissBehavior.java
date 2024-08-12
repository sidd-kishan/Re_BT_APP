/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  androidx.customview.widget.ViewDragHelper
 *  androidx.customview.widget.ViewDragHelper$Callback
 *  com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener
 */
package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.behavior.SwipeDismissBehavior;

public class SwipeDismissBehavior<V extends View>
extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance = 0.5f;
    float alphaStartSwipeDistance = 0.0f;
    private final ViewDragHelper.Callback dragCallback = new /* Unavailable Anonymous Inner Class!! */;
    float dragDismissThreshold = 0.5f;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private float sensitivity = 0.0f;
    private boolean sensitivitySet;
    int swipeDirection = 2;
    ViewDragHelper viewDragHelper;

    static float clamp(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int clamp(int n, int n2, int n3) {
        return Math.min(Math.max(n, n2), n3);
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        if (this.viewDragHelper != null) return;
        viewGroup = this.sensitivitySet ? ViewDragHelper.create((ViewGroup)viewGroup, (float)this.sensitivity, (ViewDragHelper.Callback)this.dragCallback) : ViewDragHelper.create((ViewGroup)viewGroup, (ViewDragHelper.Callback)this.dragCallback);
        this.viewDragHelper = viewGroup;
    }

    static float fraction(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        int n = viewDragHelper != null ? viewDragHelper.getViewDragState() : 0;
        return n;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean bl = this.interceptingEvents;
        int n = motionEvent.getActionMasked();
        if (n != 0) {
            if (n == 1 || n == 3) {
                this.interceptingEvents = false;
            }
        } else {
            this.interceptingEvents = bl = coordinatorLayout.isPointInChildBounds(v, (int)motionEvent.getX(), (int)motionEvent.getY());
        }
        if (!bl) return false;
        this.ensureViewDragHelper((ViewGroup)coordinatorLayout);
        return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        coordinatorLayout = this.viewDragHelper;
        if (coordinatorLayout == null) return false;
        coordinatorLayout.processTouchEvent(motionEvent);
        return true;
    }

    public void setDragDismissDistance(float f) {
        this.dragDismissThreshold = SwipeDismissBehavior.clamp(0.0f, f, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f) {
        this.alphaEndSwipeDistance = SwipeDismissBehavior.clamp(0.0f, f, 1.0f);
    }

    public void setListener(OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public void setSensitivity(float f) {
        this.sensitivity = f;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f) {
        this.alphaStartSwipeDistance = SwipeDismissBehavior.clamp(0.0f, f, 1.0f);
    }

    public void setSwipeDirection(int n) {
        this.swipeDirection = n;
    }
}
