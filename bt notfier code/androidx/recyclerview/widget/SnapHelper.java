/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.Scroller
 *  androidx.recyclerview.widget.LinearSmoothScroller
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$OnFlingListener
 *  androidx.recyclerview.widget.RecyclerView$OnScrollListener
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
 */
package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SnapHelper
extends RecyclerView.OnFlingListener {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.OnScrollListener mScrollListener = new /* Unavailable Anonymous Inner Class!! */;

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() != null) throw new IllegalStateException("An instance of OnFlingListener already set.");
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener((RecyclerView.OnFlingListener)this);
    }

    private boolean snapFromFling(RecyclerView.LayoutManager layoutManager, int n, int n2) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return false;
        }
        RecyclerView.SmoothScroller smoothScroller = this.createScroller(layoutManager);
        if (smoothScroller == null) {
            return false;
        }
        if ((n = this.findTargetSnapPosition(layoutManager, n, n2)) == -1) {
            return false;
        }
        smoothScroller.setTargetPosition(n);
        layoutManager.startSmoothScroll(smoothScroller);
        return true;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            this.destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView == null) return;
        this.setupCallbacks();
        this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), (Interpolator)new DecelerateInterpolator());
        this.snapToTargetExistingView();
    }

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager var1, View var2);

    public int[] calculateScrollDistance(int n, int n2) {
        this.mGravityScroller.fling(0, 0, n, n2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    protected RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        return this.createSnapScroller(layoutManager);
    }

    @Deprecated
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) return new /* Unavailable Anonymous Inner Class!! */;
        return null;
    }

    public abstract View findSnapView(RecyclerView.LayoutManager var1);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager var1, int var2, int var3);

    public boolean onFling(int n, int n2) {
        boolean bl;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        boolean bl2 = false;
        if (layoutManager == null) {
            return false;
        }
        if (this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int n3 = this.mRecyclerView.getMinFlingVelocity();
        if (Math.abs(n2) <= n3) {
            bl = bl2;
            if (Math.abs(n) <= n3) return bl;
        }
        bl = bl2;
        if (!this.snapFromFling(layoutManager, n, n2)) return bl;
        bl = true;
        return bl;
    }

    void snapToTargetExistingView() {
        Object object = this.mRecyclerView;
        if (object == null) {
            return;
        }
        if ((object = object.getLayoutManager()) == null) {
            return;
        }
        View view = this.findSnapView((RecyclerView.LayoutManager)object);
        if (view == null) {
            return;
        }
        if ((object = (Object)this.calculateDistanceToFinalSnap((RecyclerView.LayoutManager)object, view))[0] == false) {
            if (object[1] == false) return;
        }
        this.mRecyclerView.smoothScrollBy((int)object[0], (int)object[1]);
    }
}
