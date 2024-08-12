/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.animation.Interpolator
 *  android.widget.OverScroller
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.widget.RecyclerView
 */
package androidx.recyclerview.widget;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/*
 * Exception performing whole class analysis ignored.
 */
class RecyclerView.ViewFlinger
implements Runnable {
    private boolean mEatRunOnAnimationRequest;
    Interpolator mInterpolator;
    private int mLastFlingX;
    private int mLastFlingY;
    OverScroller mOverScroller;
    private boolean mReSchedulePostAnimationCallback;
    final RecyclerView this$0;

    RecyclerView.ViewFlinger(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
        this.mInterpolator = RecyclerView.sQuinticInterpolator;
        this.mEatRunOnAnimationRequest = false;
        this.mReSchedulePostAnimationCallback = false;
        this.mOverScroller = new OverScroller(recyclerView.getContext(), RecyclerView.sQuinticInterpolator);
    }

    private int computeScrollDuration(int n, int n2) {
        int n3;
        int n4 = Math.abs(n);
        n = n4 > (n3 = Math.abs(n2)) ? 1 : 0;
        RecyclerView recyclerView = this.this$0;
        n2 = n != 0 ? recyclerView.getWidth() : recyclerView.getHeight();
        n = n != 0 ? n4 : n3;
        return Math.min((int)(((float)n / (float)n2 + 1.0f) * 300.0f), 2000);
    }

    private void internalPostOnAnimation() {
        this.this$0.removeCallbacks((Runnable)this);
        ViewCompat.postOnAnimation((View)this.this$0, (Runnable)this);
    }

    public void fling(int n, int n2) {
        this.this$0.setScrollState(2);
        this.mLastFlingY = 0;
        this.mLastFlingX = 0;
        if (this.mInterpolator != RecyclerView.sQuinticInterpolator) {
            this.mInterpolator = RecyclerView.sQuinticInterpolator;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), RecyclerView.sQuinticInterpolator);
        }
        this.mOverScroller.fling(0, 0, n, n2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
        if (this.this$0.mLayout == null) {
            this.stop();
            return;
        }
        this.mReSchedulePostAnimationCallback = false;
        this.mEatRunOnAnimationRequest = true;
        this.this$0.consumePendingUpdateOperations();
        OverScroller overScroller = this.mOverScroller;
        if (overScroller.computeScrollOffset()) {
            int n;
            int n2;
            int n3 = overScroller.getCurrX();
            int n4 = overScroller.getCurrY();
            int n5 = n3 - this.mLastFlingX;
            int n6 = n4 - this.mLastFlingY;
            this.mLastFlingX = n3;
            this.mLastFlingY = n4;
            this.this$0.mReusableIntPair[0] = 0;
            this.this$0.mReusableIntPair[1] = 0;
            RecyclerView recyclerView = this.this$0;
            n4 = n5;
            n3 = n6;
            if (recyclerView.dispatchNestedPreScroll(n5, n6, recyclerView.mReusableIntPair, null, 1)) {
                n4 = n5 - this.this$0.mReusableIntPair[0];
                n3 = n6 - this.this$0.mReusableIntPair[1];
            }
            if (this.this$0.getOverScrollMode() != 2) {
                this.this$0.considerReleasingGlowsOnScroll(n4, n3);
            }
            if (this.this$0.mAdapter != null) {
                this.this$0.mReusableIntPair[0] = 0;
                this.this$0.mReusableIntPair[1] = 0;
                recyclerView = this.this$0;
                recyclerView.scrollStep(n4, n3, recyclerView.mReusableIntPair);
                n2 = this.this$0.mReusableIntPair[0];
                n = this.this$0.mReusableIntPair[1];
                int n7 = n4 - n2;
                int n8 = n3 - n;
                recyclerView = this.this$0.mLayout.mSmoothScroller;
                n4 = n2;
                n5 = n7;
                n3 = n;
                n6 = n8;
                if (recyclerView != null) {
                    n4 = n2;
                    n5 = n7;
                    n3 = n;
                    n6 = n8;
                    if (!recyclerView.isPendingInitialRun()) {
                        n4 = n2;
                        n5 = n7;
                        n3 = n;
                        n6 = n8;
                        if (recyclerView.isRunning()) {
                            n3 = this.this$0.mState.getItemCount();
                            if (n3 == 0) {
                                recyclerView.stop();
                                n4 = n2;
                                n5 = n7;
                                n3 = n;
                                n6 = n8;
                            } else if (recyclerView.getTargetPosition() >= n3) {
                                recyclerView.setTargetPosition(n3 - 1);
                                recyclerView.onAnimation(n2, n);
                                n4 = n2;
                                n5 = n7;
                                n3 = n;
                                n6 = n8;
                            } else {
                                recyclerView.onAnimation(n2, n);
                                n4 = n2;
                                n5 = n7;
                                n3 = n;
                                n6 = n8;
                            }
                        }
                    }
                }
            } else {
                n2 = 0;
                n5 = 0;
                n6 = n3;
                n3 = n5;
                n5 = n4;
                n4 = n2;
            }
            if (!this.this$0.mItemDecorations.isEmpty()) {
                this.this$0.invalidate();
            }
            this.this$0.mReusableIntPair[0] = 0;
            this.this$0.mReusableIntPair[1] = 0;
            recyclerView = this.this$0;
            recyclerView.dispatchNestedScroll(n4, n3, n5, n6, null, 1, recyclerView.mReusableIntPair);
            n = n5 - this.this$0.mReusableIntPair[0];
            n2 = n6 - this.this$0.mReusableIntPair[1];
            if (n4 != 0 || n3 != 0) {
                this.this$0.dispatchOnScrolled(n4, n3);
            }
            if (!RecyclerView.access$200((RecyclerView)this.this$0)) {
                this.this$0.invalidate();
            }
            n6 = overScroller.getCurrX() == overScroller.getFinalX() ? 1 : 0;
            n5 = overScroller.getCurrY() == overScroller.getFinalY() ? 1 : 0;
            n6 = !overScroller.isFinished() && (n6 == 0 && n == 0 || n5 == 0 && n2 == 0) ? 0 : 1;
            recyclerView = this.this$0.mLayout.mSmoothScroller;
            n5 = recyclerView != null && recyclerView.isPendingInitialRun() ? 1 : 0;
            if (n5 == 0 && n6 != 0) {
                if (this.this$0.getOverScrollMode() != 2) {
                    n4 = (int)overScroller.getCurrVelocity();
                    n3 = n < 0 ? -n4 : (n > 0 ? n4 : 0);
                    if (n2 < 0) {
                        n4 = -n4;
                    } else if (n2 <= 0) {
                        n4 = 0;
                    }
                    this.this$0.absorbGlows(n3, n4);
                }
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    this.this$0.mPrefetchRegistry.clearPrefetchPositions();
                }
            } else {
                this.postOnAnimation();
                if (this.this$0.mGapWorker != null) {
                    this.this$0.mGapWorker.postFromTraversal(this.this$0, n4, n3);
                }
            }
        }
        if ((overScroller = this.this$0.mLayout.mSmoothScroller) != null && overScroller.isPendingInitialRun()) {
            overScroller.onAnimation(0, 0);
        }
        this.mEatRunOnAnimationRequest = false;
        if (this.mReSchedulePostAnimationCallback) {
            this.internalPostOnAnimation();
        } else {
            this.this$0.setScrollState(0);
            this.this$0.stopNestedScroll(1);
        }
    }

    public void smoothScrollBy(int n, int n2, int n3, Interpolator interpolator) {
        int n4 = n3;
        if (n3 == Integer.MIN_VALUE) {
            n4 = this.computeScrollDuration(n, n2);
        }
        Interpolator interpolator2 = interpolator;
        if (interpolator == null) {
            interpolator2 = RecyclerView.sQuinticInterpolator;
        }
        if (this.mInterpolator != interpolator2) {
            this.mInterpolator = interpolator2;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), interpolator2);
        }
        this.mLastFlingY = 0;
        this.mLastFlingX = 0;
        this.this$0.setScrollState(2);
        this.mOverScroller.startScroll(0, 0, n, n2, n4);
        if (Build.VERSION.SDK_INT < 23) {
            this.mOverScroller.computeScrollOffset();
        }
        this.postOnAnimation();
    }

    public void stop() {
        this.this$0.removeCallbacks((Runnable)this);
        this.mOverScroller.abortAnimation();
    }
}
