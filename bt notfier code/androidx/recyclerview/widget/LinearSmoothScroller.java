/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action
 *  androidx.recyclerview.widget.RecyclerView$State
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class LinearSmoothScroller
extends RecyclerView.SmoothScroller {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    protected final DecelerateInterpolator mDecelerateInterpolator;
    private final DisplayMetrics mDisplayMetrics;
    private boolean mHasCalculatedMillisPerPixel = false;
    protected int mInterimTargetDx = 0;
    protected int mInterimTargetDy = 0;
    protected final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
    private float mMillisPerPixel;
    protected PointF mTargetVector;

    public LinearSmoothScroller(Context context) {
        this.mDecelerateInterpolator = new DecelerateInterpolator();
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    private int clampApplyScroll(int n, int n2) {
        if (n * (n2 = n - n2) > 0) return n2;
        return 0;
    }

    private float getSpeedPerPixel() {
        if (this.mHasCalculatedMillisPerPixel) return this.mMillisPerPixel;
        this.mMillisPerPixel = this.calculateSpeedPerPixel(this.mDisplayMetrics);
        this.mHasCalculatedMillisPerPixel = true;
        return this.mMillisPerPixel;
    }

    public int calculateDtToFit(int n, int n2, int n3, int n4, int n5) {
        if (n5 == -1) return n3 - n;
        if (n5 != 0) {
            if (n5 != 1) throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            return n4 - n2;
        }
        if ((n = n3 - n) > 0) {
            return n;
        }
        n = n4 - n2;
        if (n >= 0) return 0;
        return n;
    }

    public int calculateDxToMakeVisible(View view, int n) {
        RecyclerView.LayoutManager layoutManager = this.getLayoutManager();
        if (layoutManager == null) return 0;
        if (!layoutManager.canScrollHorizontally()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.calculateDtToFit(layoutManager.getDecoratedLeft(view) - layoutParams.leftMargin, layoutManager.getDecoratedRight(view) + layoutParams.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), n);
    }

    public int calculateDyToMakeVisible(View view, int n) {
        RecyclerView.LayoutManager layoutManager = this.getLayoutManager();
        if (layoutManager == null) return 0;
        if (!layoutManager.canScrollVertically()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.calculateDtToFit(layoutManager.getDecoratedTop(view) - layoutParams.topMargin, layoutManager.getDecoratedBottom(view) + layoutParams.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), n);
    }

    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 25.0f / (float)displayMetrics.densityDpi;
    }

    protected int calculateTimeForDeceleration(int n) {
        double d = this.calculateTimeForScrolling(n);
        Double.isNaN(d);
        return (int)Math.ceil(d / 0.3356);
    }

    protected int calculateTimeForScrolling(int n) {
        return (int)Math.ceil((float)Math.abs(n) * this.getSpeedPerPixel());
    }

    protected int getHorizontalSnapPreference() {
        PointF pointF = this.mTargetVector;
        int n = pointF != null && pointF.x != 0.0f ? (this.mTargetVector.x > 0.0f ? 1 : -1) : 0;
        return n;
    }

    protected int getVerticalSnapPreference() {
        PointF pointF = this.mTargetVector;
        int n = pointF != null && pointF.y != 0.0f ? (this.mTargetVector.y > 0.0f ? 1 : -1) : 0;
        return n;
    }

    protected void onSeekTargetStep(int n, int n2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (this.getChildCount() == 0) {
            this.stop();
            return;
        }
        this.mInterimTargetDx = this.clampApplyScroll(this.mInterimTargetDx, n);
        this.mInterimTargetDy = n = this.clampApplyScroll(this.mInterimTargetDy, n2);
        if (this.mInterimTargetDx != 0) return;
        if (n != 0) return;
        this.updateActionForInterimTarget(action);
    }

    protected void onStart() {
    }

    protected void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int n;
        int n2 = this.calculateDxToMakeVisible(view, this.getHorizontalSnapPreference());
        int n3 = this.calculateTimeForDeceleration((int)Math.sqrt(n2 * n2 + (n = this.calculateDyToMakeVisible(view, this.getVerticalSnapPreference())) * n));
        if (n3 <= 0) return;
        action.update(-n2, -n, n3, (Interpolator)this.mDecelerateInterpolator);
    }

    protected void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action action) {
        PointF pointF = this.computeScrollVectorForPosition(this.getTargetPosition());
        if (pointF != null && (pointF.x != 0.0f || pointF.y != 0.0f)) {
            this.normalize(pointF);
            this.mTargetVector = pointF;
            this.mInterimTargetDx = (int)(pointF.x * 10000.0f);
            this.mInterimTargetDy = (int)(pointF.y * 10000.0f);
            int n = this.calculateTimeForScrolling(10000);
            action.update((int)((float)this.mInterimTargetDx * 1.2f), (int)((float)this.mInterimTargetDy * 1.2f), (int)((float)n * 1.2f), (Interpolator)this.mLinearInterpolator);
            return;
        }
        action.jumpTo(this.getTargetPosition());
        this.stop();
    }
}
