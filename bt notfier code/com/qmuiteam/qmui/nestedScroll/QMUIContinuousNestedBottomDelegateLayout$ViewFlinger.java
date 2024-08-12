/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.animation.Interpolator
 *  android.widget.OverScroller
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.QMUIInterpolatorStaticHolder
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout
 */
package com.qmuiteam.qmui.nestedScroll;

import android.view.View;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIContinuousNestedBottomDelegateLayout.ViewFlinger
implements Runnable {
    private boolean mEatRunOnAnimationRequest;
    Interpolator mInterpolator;
    private int mLastFlingY;
    OverScroller mOverScroller;
    private boolean mReSchedulePostAnimationCallback;
    final QMUIContinuousNestedBottomDelegateLayout this$0;

    QMUIContinuousNestedBottomDelegateLayout.ViewFlinger(QMUIContinuousNestedBottomDelegateLayout qMUIContinuousNestedBottomDelegateLayout) {
        this.this$0 = qMUIContinuousNestedBottomDelegateLayout;
        this.mInterpolator = QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
        this.mEatRunOnAnimationRequest = false;
        this.mReSchedulePostAnimationCallback = false;
        this.mOverScroller = new OverScroller(qMUIContinuousNestedBottomDelegateLayout.getContext(), QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
    }

    private void internalPostOnAnimation() {
        this.this$0.removeCallbacks((Runnable)this);
        ViewCompat.postOnAnimation((View)this.this$0, (Runnable)this);
    }

    public void fling(int n) {
        this.this$0.startNestedScroll(2, 1);
        this.mLastFlingY = 0;
        if (this.mInterpolator != QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR) {
            this.mInterpolator = QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
        }
        this.mOverScroller.fling(0, 0, 0, n, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.postOnAnimation();
    }

    void postOnAnimation() {
        if (this.mEatRunOnAnimationRequest) {
            this.mReSchedulePostAnimationCallback = true;
        } else {
            this.internalPostOnAnimation();
        }
    }

    @Override
    public void run() {
        this.mReSchedulePostAnimationCallback = false;
        this.mEatRunOnAnimationRequest = true;
        OverScroller overScroller = this.mOverScroller;
        if (overScroller.computeScrollOffset()) {
            int n = overScroller.getCurrY();
            int n2 = this.mLastFlingY;
            this.mLastFlingY = n;
            if (!QMUIContinuousNestedBottomDelegateLayout.access$100((QMUIContinuousNestedBottomDelegateLayout)this.this$0).hasNestedScrollingParent(1)) {
                this.this$0.startNestedScroll(2, 1);
            }
            this.this$0.consumeScroll(n - n2);
            this.postOnAnimation();
        }
        this.mEatRunOnAnimationRequest = false;
        if (this.mReSchedulePostAnimationCallback) {
            this.internalPostOnAnimation();
        } else {
            this.this$0.stopNestedScroll(1);
        }
    }

    public void stop() {
        this.this$0.removeCallbacks((Runnable)this);
        this.mOverScroller.abortAnimation();
    }
}
