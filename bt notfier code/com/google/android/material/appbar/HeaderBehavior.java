/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.widget.OverScroller
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.core.math.MathUtils
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.appbar.HeaderBehavior$FlingRunnable
 *  com.google.android.material.appbar.ViewOffsetBehavior
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.HeaderBehavior;
import com.google.android.material.appbar.ViewOffsetBehavior;

abstract class HeaderBehavior<V extends View>
extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId = -1;
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop = -1;
    private VelocityTracker velocityTracker;

    public HeaderBehavior() {
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker != null) return;
        this.velocityTracker = VelocityTracker.obtain();
    }

    boolean canDragView(V v) {
        return false;
    }

    final boolean fling(CoordinatorLayout coordinatorLayout, V v, int n, int n2, float f) {
        Runnable runnable = this.flingRunnable;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.flingRunnable = null;
        }
        if (this.scroller == null) {
            this.scroller = new OverScroller(v.getContext());
        }
        this.scroller.fling(0, this.getTopAndBottomOffset(), 0, Math.round(f), 0, 0, n, n2);
        if (this.scroller.computeScrollOffset()) {
            coordinatorLayout = new FlingRunnable(this, coordinatorLayout, v);
            this.flingRunnable = coordinatorLayout;
            ViewCompat.postOnAnimation(v, (Runnable)coordinatorLayout);
            return true;
        }
        this.onFlingFinished(coordinatorLayout, v);
        return false;
    }

    int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    int getTopBottomOffsetForScrollingSibling() {
        return this.getTopAndBottomOffset();
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v) {
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        block8: {
            int n;
            block5: {
                block6: {
                    block7: {
                        if (this.touchSlop < 0) {
                            this.touchSlop = ViewConfiguration.get((Context)coordinatorLayout.getContext()).getScaledTouchSlop();
                        }
                        if (motionEvent.getAction() == 2 && this.isBeingDragged) {
                            return true;
                        }
                        n = motionEvent.getActionMasked();
                        if (n == 0) break block5;
                        if (n == 1) break block6;
                        if (n == 2) break block7;
                        if (n == 3) break block6;
                        break block8;
                    }
                    n = this.activePointerId;
                    if (n != -1 && (n = motionEvent.findPointerIndex(n)) != -1 && Math.abs((n = (int)motionEvent.getY(n)) - this.lastMotionY) > this.touchSlop) {
                        this.isBeingDragged = true;
                        this.lastMotionY = n;
                    }
                    break block8;
                }
                this.isBeingDragged = false;
                this.activePointerId = -1;
                coordinatorLayout = this.velocityTracker;
                if (coordinatorLayout != null) {
                    coordinatorLayout.recycle();
                    this.velocityTracker = null;
                }
                break block8;
            }
            this.isBeingDragged = false;
            int n2 = (int)motionEvent.getX();
            n = (int)motionEvent.getY();
            if (this.canDragView(v) && coordinatorLayout.isPointInChildBounds(v, n2, n)) {
                this.lastMotionY = n;
                this.activePointerId = motionEvent.getPointerId(0);
                this.ensureVelocityTracker();
            }
        }
        coordinatorLayout = this.velocityTracker;
        if (coordinatorLayout == null) return this.isBeingDragged;
        coordinatorLayout.addMovement(motionEvent);
        return this.isBeingDragged;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        block11: {
            int n;
            block7: {
                block10: {
                    block8: {
                        int n2;
                        block9: {
                            if (this.touchSlop < 0) {
                                this.touchSlop = ViewConfiguration.get((Context)coordinatorLayout.getContext()).getScaledTouchSlop();
                            }
                            if ((n = motionEvent.getActionMasked()) == 0) break block7;
                            if (n == 1) break block8;
                            if (n == 2) break block9;
                            if (n == 3) break block10;
                            break block11;
                        }
                        n = motionEvent.findPointerIndex(this.activePointerId);
                        if (n == -1) {
                            return false;
                        }
                        int n3 = (int)motionEvent.getY(n);
                        n = n2 = this.lastMotionY - n3;
                        if (!this.isBeingDragged) {
                            int n4 = Math.abs(n2);
                            int n5 = this.touchSlop;
                            n = n2;
                            if (n4 > n5) {
                                this.isBeingDragged = true;
                                n = n2 > 0 ? n2 - n5 : n2 + n5;
                            }
                        }
                        if (this.isBeingDragged) {
                            this.lastMotionY = n3;
                            this.scroll(coordinatorLayout, v, n, this.getMaxDragOffset(v), 0);
                        }
                        break block11;
                    }
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        this.velocityTracker.computeCurrentVelocity(1000);
                        float f = this.velocityTracker.getYVelocity(this.activePointerId);
                        this.fling(coordinatorLayout, v, -this.getScrollRangeForDragFling(v), 0, f);
                    }
                }
                this.isBeingDragged = false;
                this.activePointerId = -1;
                coordinatorLayout = this.velocityTracker;
                if (coordinatorLayout != null) {
                    coordinatorLayout.recycle();
                    this.velocityTracker = null;
                }
                break block11;
            }
            int n6 = (int)motionEvent.getX();
            if (!coordinatorLayout.isPointInChildBounds(v, n6, n = (int)motionEvent.getY())) return false;
            if (!this.canDragView(v)) return false;
            this.lastMotionY = n;
            this.activePointerId = motionEvent.getPointerId(0);
            this.ensureVelocityTracker();
        }
        coordinatorLayout = this.velocityTracker;
        if (coordinatorLayout == null) return true;
        coordinatorLayout.addMovement(motionEvent);
        return true;
    }

    final int scroll(CoordinatorLayout coordinatorLayout, V v, int n, int n2, int n3) {
        return this.setHeaderTopBottomOffset(coordinatorLayout, v, this.getTopBottomOffsetForScrollingSibling() - n, n2, n3);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int n) {
        return this.setHeaderTopBottomOffset(coordinatorLayout, v, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int n, int n2, int n3) {
        int n4 = this.getTopAndBottomOffset();
        if (n2 != 0 && n4 >= n2 && n4 <= n3 && n4 != (n = MathUtils.clamp((int)n, (int)n2, (int)n3))) {
            this.setTopAndBottomOffset(n);
            n = n4 - n;
        } else {
            n = 0;
        }
        return n;
    }
}
