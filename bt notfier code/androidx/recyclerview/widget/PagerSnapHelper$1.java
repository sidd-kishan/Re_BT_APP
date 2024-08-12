/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.animation.Interpolator
 *  androidx.recyclerview.widget.LinearSmoothScroller
 *  androidx.recyclerview.widget.PagerSnapHelper
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action
 *  androidx.recyclerview.widget.RecyclerView$State
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

class PagerSnapHelper.1
extends LinearSmoothScroller {
    final PagerSnapHelper this$0;

    PagerSnapHelper.1(PagerSnapHelper pagerSnapHelper, Context context) {
        this.this$0 = pagerSnapHelper;
        super(context);
    }

    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / (float)displayMetrics.densityDpi;
    }

    protected int calculateTimeForScrolling(int n) {
        return Math.min(100, super.calculateTimeForScrolling(n));
    }

    protected void onTargetFound(View object, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        state = this.this$0;
        object = state.calculateDistanceToFinalSnap(state.mRecyclerView.getLayoutManager(), object);
        View view = object[0];
        View view2 = object[1];
        int n = this.calculateTimeForDeceleration(Math.max(Math.abs((int)view), Math.abs((int)view2)));
        if (n <= 0) return;
        action.update((int)view, (int)view2, n, (Interpolator)this.mDecelerateInterpolator);
    }
}
