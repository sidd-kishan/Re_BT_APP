/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.customview.widget.ViewDragHelper
 *  androidx.customview.widget.ViewDragHelper$Callback
 *  androidx.drawerlayout.widget.DrawerLayout
 *  androidx.drawerlayout.widget.DrawerLayout$LayoutParams
 */
package androidx.drawerlayout.widget;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.widget.DrawerLayout;

private class DrawerLayout.ViewDragCallback
extends ViewDragHelper.Callback {
    private final int mAbsGravity;
    private ViewDragHelper mDragger;
    private final Runnable mPeekRunnable;
    final DrawerLayout this$0;

    DrawerLayout.ViewDragCallback(DrawerLayout drawerLayout, int n) {
        this.this$0 = drawerLayout;
        this.mPeekRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mAbsGravity = n;
    }

    private void closeOtherDrawer() {
        View view;
        int n = this.mAbsGravity;
        int n2 = 3;
        if (n == 3) {
            n2 = 5;
        }
        if ((view = this.this$0.findDrawerWithGravity(n2)) == null) return;
        this.this$0.closeDrawer(view);
    }

    public int clampViewPositionHorizontal(View view, int n, int n2) {
        if (this.this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(n, 0));
        }
        n2 = this.this$0.getWidth();
        return Math.max(n2 - view.getWidth(), Math.min(n, n2));
    }

    public int clampViewPositionVertical(View view, int n, int n2) {
        return view.getTop();
    }

    public int getViewHorizontalDragRange(View view) {
        int n = this.this$0.isDrawerView(view) ? view.getWidth() : 0;
        return n;
    }

    public void onEdgeDragStarted(int n, int n2) {
        View view = (n & 1) == 1 ? this.this$0.findDrawerWithGravity(3) : this.this$0.findDrawerWithGravity(5);
        if (view == null) return;
        if (this.this$0.getDrawerLockMode(view) != 0) return;
        this.mDragger.captureChildView(view, n2);
    }

    public boolean onEdgeLock(int n) {
        return false;
    }

    public void onEdgeTouched(int n, int n2) {
        this.this$0.postDelayed(this.mPeekRunnable, 160L);
    }

    public void onViewCaptured(View view, int n) {
        ((DrawerLayout.LayoutParams)view.getLayoutParams()).isPeeking = false;
        this.closeOtherDrawer();
    }

    public void onViewDragStateChanged(int n) {
        this.this$0.updateDrawerState(this.mAbsGravity, n, this.mDragger.getCapturedView());
    }

    public void onViewPositionChanged(View view, int n, int n2, int n3, int n4) {
        n2 = view.getWidth();
        float f = this.this$0.checkDrawerViewAbsoluteGravity(view, 3) ? (float)(n + n2) : (float)(this.this$0.getWidth() - n);
        this.this$0.setDrawerViewOffset(view, f /= (float)n2);
        n = f == 0.0f ? 4 : 0;
        view.setVisibility(n);
        this.this$0.invalidate();
    }

    public void onViewReleased(View view, float f, float f2) {
        int n;
        block4: {
            int n2;
            int n3;
            block5: {
                block3: {
                    f2 = this.this$0.getDrawerViewOffset(view);
                    n3 = view.getWidth();
                    if (!this.this$0.checkDrawerViewAbsoluteGravity(view, 3)) break block3;
                    n = !(f > 0.0f || f == 0.0f && f2 > 0.5f) ? -n3 : 0;
                    break block4;
                }
                n2 = this.this$0.getWidth();
                if (f < 0.0f) break block5;
                n = n2;
                if (f != 0.0f) break block4;
                n = n2;
                if (!(f2 > 0.5f)) break block4;
            }
            n = n2 - n3;
        }
        this.mDragger.settleCapturedViewAt(n, view.getTop());
        this.this$0.invalidate();
    }

    void peekDrawer() {
        View view;
        int n = this.mDragger.getEdgeSize();
        int n2 = this.mAbsGravity;
        int n3 = 0;
        if ((n2 = n2 == 3 ? 1 : 0) != 0) {
            view = this.this$0.findDrawerWithGravity(3);
            if (view != null) {
                n3 = -view.getWidth();
            }
            n3 += n;
        } else {
            view = this.this$0.findDrawerWithGravity(5);
            n3 = this.this$0.getWidth() - n;
        }
        if (view == null) return;
        if (n2 == 0 || view.getLeft() >= n3) {
            if (n2 != 0) return;
            if (view.getLeft() <= n3) return;
        }
        if (this.this$0.getDrawerLockMode(view) != 0) return;
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams)view.getLayoutParams();
        this.mDragger.smoothSlideViewTo(view, n3, view.getTop());
        layoutParams.isPeeking = true;
        this.this$0.invalidate();
        this.closeOtherDrawer();
        this.this$0.cancelChildViewTouch();
    }

    public void removeCallbacks() {
        this.this$0.removeCallbacks(this.mPeekRunnable);
    }

    public void setDragger(ViewDragHelper viewDragHelper) {
        this.mDragger = viewDragHelper;
    }

    public boolean tryCaptureView(View view, int n) {
        boolean bl = this.this$0.isDrawerView(view) && this.this$0.checkDrawerViewAbsoluteGravity(view, this.mAbsGravity) && this.this$0.getDrawerLockMode(view) == 0;
        return bl;
    }
}
