/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.animation.Interpolator
 *  android.widget.OverScroller
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.QMUIInterpolatorStaticHolder
 *  com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIContinuousNestedTopAreaBehavior.ViewFlinger
implements Runnable {
    private View mCurrentChild;
    private CoordinatorLayout mCurrentParent;
    private boolean mEatRunOnAnimationRequest;
    Interpolator mInterpolator;
    private int mLastFlingY;
    OverScroller mOverScroller;
    private boolean mReSchedulePostAnimationCallback;
    final QMUIContinuousNestedTopAreaBehavior this$0;

    QMUIContinuousNestedTopAreaBehavior.ViewFlinger(QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior, Context context) {
        this.this$0 = qMUIContinuousNestedTopAreaBehavior;
        this.mInterpolator = QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
        this.mEatRunOnAnimationRequest = false;
        this.mReSchedulePostAnimationCallback = false;
        this.mOverScroller = new OverScroller(context, QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
    }

    private void internalPostOnAnimation() {
        if (this.mCurrentChild == null) return;
        this.mCurrentParent.removeCallbacks((Runnable)this);
        ViewCompat.postOnAnimation((View)this.mCurrentChild, (Runnable)this);
    }

    private void onFlingOrScrollEnd() {
        if (QMUIContinuousNestedTopAreaBehavior.access$100((QMUIContinuousNestedTopAreaBehavior)this.this$0) != null && QMUIContinuousNestedTopAreaBehavior.access$000((QMUIContinuousNestedTopAreaBehavior)this.this$0)) {
            QMUIContinuousNestedTopAreaBehavior.access$100((QMUIContinuousNestedTopAreaBehavior)this.this$0).onTopBehaviorFlingOrScrollEnd();
        }
        QMUIContinuousNestedTopAreaBehavior.access$002((QMUIContinuousNestedTopAreaBehavior)this.this$0, (boolean)false);
    }

    private void onFlingOrScrollStart(CoordinatorLayout coordinatorLayout, View view) {
        QMUIContinuousNestedTopAreaBehavior.access$002((QMUIContinuousNestedTopAreaBehavior)this.this$0, (boolean)true);
        if (QMUIContinuousNestedTopAreaBehavior.access$100((QMUIContinuousNestedTopAreaBehavior)this.this$0) != null) {
            QMUIContinuousNestedTopAreaBehavior.access$100((QMUIContinuousNestedTopAreaBehavior)this.this$0).onTopBehaviorFlingOrScrollStart();
        }
        this.mCurrentParent = coordinatorLayout;
        this.mCurrentChild = view;
        this.mLastFlingY = 0;
        if (this.mInterpolator == QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR) return;
        this.mInterpolator = QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
        this.mOverScroller = new OverScroller(this.mCurrentParent.getContext(), QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
    }

    public void fling(CoordinatorLayout coordinatorLayout, View view, int n) {
        this.onFlingOrScrollStart(coordinatorLayout, view);
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
            View view;
            int n = overScroller.getCurrY();
            int n2 = this.mLastFlingY;
            this.mLastFlingY = n;
            overScroller = this.mCurrentParent;
            if (overScroller != null && (view = this.mCurrentChild) != null) {
                this.this$0.scroll((CoordinatorLayout)overScroller, view, n - n2);
                this.postOnAnimation();
            }
        }
        this.mEatRunOnAnimationRequest = false;
        if (this.mReSchedulePostAnimationCallback) {
            this.internalPostOnAnimation();
        } else {
            this.mCurrentChild = null;
            this.onFlingOrScrollEnd();
        }
    }

    public void startScroll(CoordinatorLayout coordinatorLayout, View view, int n, int n2) {
        this.onFlingOrScrollStart(coordinatorLayout, view);
        this.mOverScroller.startScroll(0, 0, 0, n, n2);
        this.postOnAnimation();
    }

    public void stop() {
        View view = this.mCurrentChild;
        if (view != null) {
            view.removeCallbacks((Runnable)this);
        }
        this.mOverScroller.abortAnimation();
        this.mCurrentChild = null;
        this.mCurrentParent = null;
        this.onFlingOrScrollEnd();
    }
}
