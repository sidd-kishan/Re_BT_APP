/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Log
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
 *  androidx.recyclerview.widget.RecyclerView$State
 */
package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public static abstract class RecyclerView.SmoothScroller {
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final Action mRecyclingAction = new Action(0, 0);
    private boolean mRunning;
    private boolean mStarted;
    private int mTargetPosition = -1;
    private View mTargetView;

    public PointF computeScrollVectorForPosition(int n) {
        Object object = this.getLayoutManager();
        if (object instanceof ScrollVectorProvider) {
            return ((ScrollVectorProvider)object).computeScrollVectorForPosition(n);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
        ((StringBuilder)object).append(ScrollVectorProvider.class.getCanonicalName());
        Log.w((String)"RecyclerView", (String)((StringBuilder)object).toString());
        return null;
    }

    public View findViewByPosition(int n) {
        return this.mRecyclerView.mLayout.findViewByPosition(n);
    }

    public int getChildCount() {
        return this.mRecyclerView.mLayout.getChildCount();
    }

    public int getChildPosition(View view) {
        return this.mRecyclerView.getChildLayoutPosition(view);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public int getTargetPosition() {
        return this.mTargetPosition;
    }

    @Deprecated
    public void instantScrollToPosition(int n) {
        this.mRecyclerView.scrollToPosition(n);
    }

    public boolean isPendingInitialRun() {
        return this.mPendingInitialRun;
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    protected void normalize(PointF pointF) {
        float f = (float)Math.sqrt(pointF.x * pointF.x + pointF.y * pointF.y);
        pointF.x /= f;
        pointF.y /= f;
    }

    void onAnimation(int n, int n2) {
        View view;
        RecyclerView recyclerView = this.mRecyclerView;
        if (this.mTargetPosition == -1 || recyclerView == null) {
            this.stop();
        }
        if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (view = this.computeScrollVectorForPosition(this.mTargetPosition)) != null && (view.x != 0.0f || view.y != 0.0f)) {
            recyclerView.scrollStep((int)Math.signum(view.x), (int)Math.signum(view.y), null);
        }
        this.mPendingInitialRun = false;
        view = this.mTargetView;
        if (view != null) {
            if (this.getChildPosition(view) == this.mTargetPosition) {
                this.onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                this.mRecyclingAction.runIfNecessary(recyclerView);
                this.stop();
            } else {
                Log.e((String)"RecyclerView", (String)"Passed over target position while smooth scrolling.");
                this.mTargetView = null;
            }
        }
        if (!this.mRunning) return;
        this.onSeekTargetStep(n, n2, recyclerView.mState, this.mRecyclingAction);
        boolean bl = this.mRecyclingAction.hasJumpTarget();
        this.mRecyclingAction.runIfNecessary(recyclerView);
        if (!bl) return;
        if (!this.mRunning) return;
        this.mPendingInitialRun = true;
        recyclerView.mViewFlinger.postOnAnimation();
    }

    protected void onChildAttachedToWindow(View view) {
        if (this.getChildPosition(view) != this.getTargetPosition()) return;
        this.mTargetView = view;
    }

    protected abstract void onSeekTargetStep(int var1, int var2, RecyclerView.State var3, Action var4);

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void onTargetFound(View var1, RecyclerView.State var2, Action var3);

    public void setTargetPosition(int n) {
        this.mTargetPosition = n;
    }

    void start(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager) {
        recyclerView.mViewFlinger.stop();
        if (this.mStarted) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("An instance of ");
            stringBuilder.append(this.getClass().getSimpleName());
            stringBuilder.append(" was started more than once. Each instance of");
            stringBuilder.append(this.getClass().getSimpleName());
            stringBuilder.append(" is intended to only be used once. You should create a new instance for each use.");
            Log.w((String)"RecyclerView", (String)stringBuilder.toString());
        }
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = layoutManager;
        if (this.mTargetPosition == -1) throw new IllegalArgumentException("Invalid target position");
        recyclerView.mState.mTargetPosition = this.mTargetPosition;
        this.mRunning = true;
        this.mPendingInitialRun = true;
        this.mTargetView = this.findViewByPosition(this.getTargetPosition());
        this.onStart();
        this.mRecyclerView.mViewFlinger.postOnAnimation();
        this.mStarted = true;
    }

    protected final void stop() {
        if (!this.mRunning) {
            return;
        }
        this.mRunning = false;
        this.onStop();
        this.mRecyclerView.mState.mTargetPosition = -1;
        this.mTargetView = null;
        this.mTargetPosition = -1;
        this.mPendingInitialRun = false;
        this.mLayoutManager.onSmoothScrollerStopped(this);
        this.mLayoutManager = null;
        this.mRecyclerView = null;
    }
}
