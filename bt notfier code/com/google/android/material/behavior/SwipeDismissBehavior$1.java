/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.customview.widget.ViewDragHelper$Callback
 *  com.google.android.material.behavior.SwipeDismissBehavior
 *  com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable
 */
package com.google.android.material.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.behavior.SwipeDismissBehavior;

/*
 * Exception performing whole class analysis ignored.
 */
class SwipeDismissBehavior.1
extends ViewDragHelper.Callback {
    private static final int INVALID_POINTER_ID = -1;
    private int activePointerId;
    private int originalCapturedViewLeft;
    final SwipeDismissBehavior this$0;

    SwipeDismissBehavior.1(SwipeDismissBehavior swipeDismissBehavior) {
        this.this$0 = swipeDismissBehavior;
        this.activePointerId = -1;
    }

    private boolean shouldDismiss(View view, float f) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (f == 0.0f) {
            int n = view.getLeft();
            int n2 = this.originalCapturedViewLeft;
            int n3 = Math.round((float)view.getWidth() * this.this$0.dragDismissThreshold);
            bl3 = bl2;
            if (Math.abs(n - n2) < n3) return bl3;
            bl3 = true;
            return bl3;
        }
        boolean bl4 = ViewCompat.getLayoutDirection((View)view) == 1;
        if (this.this$0.swipeDirection == 2) {
            return true;
        }
        if (this.this$0.swipeDirection == 0) {
            if (bl4) {
                if (!(f < 0.0f)) return bl3;
            } else if (!(f > 0.0f)) return bl3;
            bl3 = true;
            return bl3;
        }
        bl3 = bl;
        if (this.this$0.swipeDirection != 1) return bl3;
        if (bl4) {
            bl3 = bl;
            if (!(f > 0.0f)) return bl3;
        } else {
            bl3 = bl;
            if (!(f < 0.0f)) return bl3;
        }
        bl3 = true;
        return bl3;
    }

    /*
     * Enabled force condition propagation
     */
    public int clampViewPositionHorizontal(View view, int n, int n2) {
        int n3;
        n2 = ViewCompat.getLayoutDirection((View)view) == 1 ? 1 : 0;
        if (this.this$0.swipeDirection == 0) {
            if (n2 != 0) {
                n3 = this.originalCapturedViewLeft - view.getWidth();
                n2 = this.originalCapturedViewLeft;
                return SwipeDismissBehavior.clamp((int)n3, (int)n, (int)n2);
            }
            n3 = this.originalCapturedViewLeft;
            n2 = view.getWidth();
            return SwipeDismissBehavior.clamp((int)n3, (int)n, (int)(n2 += n3));
        } else {
            if (this.this$0.swipeDirection != 1) {
                n3 = this.originalCapturedViewLeft - view.getWidth();
                n2 = this.originalCapturedViewLeft;
                n2 = view.getWidth() + n2;
                return SwipeDismissBehavior.clamp((int)n3, (int)n, (int)n2);
            }
            if (n2 == 0) {
                n3 = this.originalCapturedViewLeft - view.getWidth();
                n2 = this.originalCapturedViewLeft;
                return SwipeDismissBehavior.clamp((int)n3, (int)n, (int)n2);
            }
            n3 = this.originalCapturedViewLeft;
            n2 = view.getWidth();
        }
        return SwipeDismissBehavior.clamp((int)n3, (int)n, (int)(n2 += n3));
    }

    public int clampViewPositionVertical(View view, int n, int n2) {
        return view.getTop();
    }

    public int getViewHorizontalDragRange(View view) {
        return view.getWidth();
    }

    public void onViewCaptured(View view, int n) {
        this.activePointerId = n;
        this.originalCapturedViewLeft = view.getLeft();
        if ((view = view.getParent()) == null) return;
        view.requestDisallowInterceptTouchEvent(true);
    }

    public void onViewDragStateChanged(int n) {
        if (this.this$0.listener == null) return;
        this.this$0.listener.onDragStateChanged(n);
    }

    public void onViewPositionChanged(View view, int n, int n2, int n3, int n4) {
        float f = (float)this.originalCapturedViewLeft + (float)view.getWidth() * this.this$0.alphaStartSwipeDistance;
        float f2 = (float)this.originalCapturedViewLeft + (float)view.getWidth() * this.this$0.alphaEndSwipeDistance;
        float f3 = n;
        if (f3 <= f) {
            view.setAlpha(1.0f);
        } else if (f3 >= f2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(SwipeDismissBehavior.clamp((float)0.0f, (float)(1.0f - SwipeDismissBehavior.fraction((float)f, (float)f2, (float)f3)), (float)1.0f));
        }
    }

    public void onViewReleased(View view, float f, float f2) {
        boolean bl;
        int n;
        this.activePointerId = -1;
        int n2 = view.getWidth();
        if (this.shouldDismiss(view, f)) {
            int n3;
            n = view.getLeft();
            n = n < (n3 = this.originalCapturedViewLeft) ? n3 - n2 : n3 + n2;
            bl = true;
        } else {
            n = this.originalCapturedViewLeft;
            bl = false;
        }
        if (this.this$0.viewDragHelper.settleCapturedViewAt(n, view.getTop())) {
            ViewCompat.postOnAnimation((View)view, (Runnable)new SwipeDismissBehavior.SettleRunnable(this.this$0, view, bl));
        } else {
            if (!bl) return;
            if (this.this$0.listener == null) return;
            this.this$0.listener.onDismiss(view);
        }
    }

    public boolean tryCaptureView(View view, int n) {
        boolean bl = this.activePointerId == -1 && this.this$0.canSwipeDismissView(view);
        return bl;
    }
}
