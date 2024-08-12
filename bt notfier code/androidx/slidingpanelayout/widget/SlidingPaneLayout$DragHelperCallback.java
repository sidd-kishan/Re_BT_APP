/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.customview.widget.ViewDragHelper$Callback
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams
 */
package androidx.slidingpanelayout.widget;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

private class SlidingPaneLayout.DragHelperCallback
extends ViewDragHelper.Callback {
    final SlidingPaneLayout this$0;

    SlidingPaneLayout.DragHelperCallback(SlidingPaneLayout slidingPaneLayout) {
        this.this$0 = slidingPaneLayout;
    }

    public int clampViewPositionHorizontal(View view, int n, int n2) {
        view = (SlidingPaneLayout.LayoutParams)this.this$0.mSlideableView.getLayoutParams();
        if (this.this$0.isLayoutRtlSupport()) {
            n2 = this.this$0.getWidth() - (this.this$0.getPaddingRight() + view.rightMargin + this.this$0.mSlideableView.getWidth());
            int n3 = this.this$0.mSlideRange;
            n = Math.max(Math.min(n, n2), n2 - n3);
        } else {
            n2 = this.this$0.getPaddingLeft() + view.leftMargin;
            int n4 = this.this$0.mSlideRange;
            n = Math.min(Math.max(n, n2), n4 + n2);
        }
        return n;
    }

    public int clampViewPositionVertical(View view, int n, int n2) {
        return view.getTop();
    }

    public int getViewHorizontalDragRange(View view) {
        return this.this$0.mSlideRange;
    }

    public void onEdgeDragStarted(int n, int n2) {
        this.this$0.mDragHelper.captureChildView(this.this$0.mSlideableView, n2);
    }

    public void onViewCaptured(View view, int n) {
        this.this$0.setAllChildrenVisible();
    }

    public void onViewDragStateChanged(int n) {
        if (this.this$0.mDragHelper.getViewDragState() != 0) return;
        if (this.this$0.mSlideOffset == 0.0f) {
            SlidingPaneLayout slidingPaneLayout = this.this$0;
            slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
            slidingPaneLayout = this.this$0;
            slidingPaneLayout.dispatchOnPanelClosed(slidingPaneLayout.mSlideableView);
            this.this$0.mPreservedOpenState = false;
        } else {
            SlidingPaneLayout slidingPaneLayout = this.this$0;
            slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
            this.this$0.mPreservedOpenState = true;
        }
    }

    public void onViewPositionChanged(View view, int n, int n2, int n3, int n4) {
        this.this$0.onPanelDragged(n);
        this.this$0.invalidate();
    }

    public void onViewReleased(View view, float f, float f2) {
        int n;
        block7: {
            int n2;
            block8: {
                SlidingPaneLayout.LayoutParams layoutParams;
                block4: {
                    int n3;
                    block6: {
                        block5: {
                            layoutParams = (SlidingPaneLayout.LayoutParams)view.getLayoutParams();
                            if (!this.this$0.isLayoutRtlSupport()) break block4;
                            n3 = this.this$0.getPaddingRight() + layoutParams.rightMargin;
                            if (f < 0.0f) break block5;
                            n = n3;
                            if (f != 0.0f) break block6;
                            n = n3;
                            if (!(this.this$0.mSlideOffset > 0.5f)) break block6;
                        }
                        n = n3 + this.this$0.mSlideRange;
                    }
                    n3 = this.this$0.mSlideableView.getWidth();
                    n = this.this$0.getWidth() - n - n3;
                    break block7;
                }
                n = this.this$0.getPaddingLeft();
                n2 = layoutParams.leftMargin + n;
                if (f > 0.0f) break block8;
                n = n2;
                if (f != 0.0f) break block7;
                n = n2;
                if (!(this.this$0.mSlideOffset > 0.5f)) break block7;
            }
            n = n2 + this.this$0.mSlideRange;
        }
        this.this$0.mDragHelper.settleCapturedViewAt(n, view.getTop());
        this.this$0.invalidate();
    }

    public boolean tryCaptureView(View view, int n) {
        if (!this.this$0.mIsUnableToDrag) return ((SlidingPaneLayout.LayoutParams)view.getLayoutParams()).slideable;
        return false;
    }
}
