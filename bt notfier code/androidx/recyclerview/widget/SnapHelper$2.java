/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.animation.Interpolator
 *  androidx.recyclerview.widget.LinearSmoothScroller
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action
 *  androidx.recyclerview.widget.RecyclerView$State
 *  androidx.recyclerview.widget.SnapHelper
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

class SnapHelper.2
extends LinearSmoothScroller {
    final SnapHelper this$0;

    SnapHelper.2(SnapHelper snapHelper, Context context) {
        this.this$0 = snapHelper;
        super(context);
    }

    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / (float)displayMetrics.densityDpi;
    }

    protected void onTargetFound(View object, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (this.this$0.mRecyclerView == null) {
            return;
        }
        state = this.this$0;
        object = state.calculateDistanceToFinalSnap(state.mRecyclerView.getLayoutManager(), object);
        View view = object[0];
        View view2 = object[1];
        int n = this.calculateTimeForDeceleration(Math.max(Math.abs((int)view), Math.abs((int)view2)));
        if (n <= 0) return;
        action.update((int)view, (int)view2, n, (Interpolator)this.mDecelerateInterpolator);
    }
}
