/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.animation.Interpolator
 *  androidx.recyclerview.widget.RecyclerView
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

public static class RecyclerView.SmoothScroller.Action {
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    private boolean mChanged = false;
    private int mConsecutiveUpdates = 0;
    private int mDuration;
    private int mDx;
    private int mDy;
    private Interpolator mInterpolator;
    private int mJumpToPosition = -1;

    public RecyclerView.SmoothScroller.Action(int n, int n2) {
        this(n, n2, Integer.MIN_VALUE, null);
    }

    public RecyclerView.SmoothScroller.Action(int n, int n2, int n3) {
        this(n, n2, n3, null);
    }

    public RecyclerView.SmoothScroller.Action(int n, int n2, int n3, Interpolator interpolator) {
        this.mDx = n;
        this.mDy = n2;
        this.mDuration = n3;
        this.mInterpolator = interpolator;
    }

    private void validate() {
        if (this.mInterpolator != null) {
            if (this.mDuration < 1) throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.mDuration < 1) throw new IllegalStateException("Scroll duration must be a positive number");
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getDx() {
        return this.mDx;
    }

    public int getDy() {
        return this.mDy;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    boolean hasJumpTarget() {
        boolean bl = this.mJumpToPosition >= 0;
        return bl;
    }

    public void jumpTo(int n) {
        this.mJumpToPosition = n;
    }

    void runIfNecessary(RecyclerView recyclerView) {
        int n = this.mJumpToPosition;
        if (n >= 0) {
            this.mJumpToPosition = -1;
            recyclerView.jumpToPositionForSmoothScroller(n);
            this.mChanged = false;
            return;
        }
        if (this.mChanged) {
            this.validate();
            recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
            this.mConsecutiveUpdates = n = this.mConsecutiveUpdates + 1;
            if (n > 10) {
                Log.e((String)"RecyclerView", (String)"Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.mChanged = false;
        } else {
            this.mConsecutiveUpdates = 0;
        }
    }

    public void setDuration(int n) {
        this.mChanged = true;
        this.mDuration = n;
    }

    public void setDx(int n) {
        this.mChanged = true;
        this.mDx = n;
    }

    public void setDy(int n) {
        this.mChanged = true;
        this.mDy = n;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mChanged = true;
        this.mInterpolator = interpolator;
    }

    public void update(int n, int n2, int n3, Interpolator interpolator) {
        this.mDx = n;
        this.mDy = n2;
        this.mDuration = n3;
        this.mInterpolator = interpolator;
        this.mChanged = true;
    }
}
