/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.SystemClock
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewConfiguration
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.Interpolator
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.AutoScrollHelper$ClampedScroller
 *  androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable
 */
package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper;

public abstract class AutoScrollHelper
implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private final Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges;
    private float[] mMaximumVelocity;
    private float[] mMinimumVelocity;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private float[] mRelativeEdges;
    private float[] mRelativeVelocity;
    private Runnable mRunnable;
    final ClampedScroller mScroller = new ClampedScroller();
    final View mTarget;

    public AutoScrollHelper(View view) {
        this.mEdgeInterpolator = new AccelerateInterpolator();
        this.mRelativeEdges = new float[]{0.0f, 0.0f};
        this.mMaximumEdges = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mRelativeVelocity = new float[]{0.0f, 0.0f};
        this.mMinimumVelocity = new float[]{0.0f, 0.0f};
        this.mMaximumVelocity = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mTarget = view;
        view = Resources.getSystem().getDisplayMetrics();
        int n = (int)(view.density * 1575.0f + 0.5f);
        int n2 = (int)(view.density * 315.0f + 0.5f);
        float f = n;
        this.setMaximumVelocity(f, f);
        f = n2;
        this.setMinimumVelocity(f, f);
        this.setEdgeType(1);
        this.setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        this.setRelativeEdges(0.2f, 0.2f);
        this.setRelativeVelocity(1.0f, 1.0f);
        this.setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        this.setRampUpDuration(500);
        this.setRampDownDuration(500);
    }

    private float computeTargetVelocity(int n, float f, float f2, float f3) {
        float f4 = this.getEdgeValue(this.mRelativeEdges[n], f2, this.mMaximumEdges[n], f);
        if (f4 == 0.0f) {
            return 0.0f;
        }
        float f5 = this.mRelativeVelocity[n];
        f2 = this.mMinimumVelocity[n];
        f = this.mMaximumVelocity[n];
        f3 = f5 * f3;
        if (!(f4 > 0.0f)) return -AutoScrollHelper.constrain(-f4 * f3, f2, f);
        return AutoScrollHelper.constrain(f4 * f3, f2, f);
    }

    static float constrain(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (!(f < f2)) return f;
        return f2;
    }

    static int constrain(int n, int n2, int n3) {
        if (n > n3) {
            return n3;
        }
        if (n >= n2) return n;
        return n2;
    }

    private float constrainEdgeValue(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int n = this.mEdgeType;
        if (n != 0 && n != 1) {
            if (n != 2) {
                return 0.0f;
            }
            if (!(f < 0.0f)) return 0.0f;
            return f / -f2;
        }
        if (!(f < f2)) return 0.0f;
        if (f >= 0.0f) {
            return 1.0f - f / f2;
        }
        if (!this.mAnimating) return 0.0f;
        if (this.mEdgeType != 1) return 0.0f;
        return 1.0f;
    }

    private float getEdgeValue(float f, float f2, float f3, float f4) {
        f = AutoScrollHelper.constrain(f * f2, 0.0f, f3);
        f3 = this.constrainEdgeValue(f4, f);
        if ((f = this.constrainEdgeValue(f2 - f4, f) - f3) < 0.0f) {
            f = -this.mEdgeInterpolator.getInterpolation(-f);
        } else {
            if (!(f > 0.0f)) return 0.0f;
            f = this.mEdgeInterpolator.getInterpolation(f);
        }
        return AutoScrollHelper.constrain(f, -1.0f, 1.0f);
    }

    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        } else {
            this.mScroller.requestStop();
        }
    }

    private void startAnimating() {
        int n;
        if (this.mRunnable == null) {
            this.mRunnable = new ScrollAnimationRunnable(this);
        }
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (!this.mAlreadyDelayed && (n = this.mActivationDelay) > 0) {
            ViewCompat.postOnAnimationDelayed((View)this.mTarget, (Runnable)this.mRunnable, (long)n);
        } else {
            this.mRunnable.run();
        }
        this.mAlreadyDelayed = true;
    }

    public abstract boolean canTargetScrollHorizontally(int var1);

    public abstract boolean canTargetScrollVertically(int var1);

    void cancelTargetTouch() {
        long l = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain((long)l, (long)l, (int)3, (float)0.0f, (float)0.0f, (int)0);
        this.mTarget.onTouchEvent(motionEvent);
        motionEvent.recycle();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean bl;
        boolean bl2;
        block7: {
            block6: {
                block4: {
                    block5: {
                        bl2 = this.mEnabled;
                        bl = false;
                        if (!bl2) {
                            return false;
                        }
                        int n = motionEvent.getActionMasked();
                        if (n == 0) break block4;
                        if (n == 1) break block5;
                        if (n == 2) break block6;
                        if (n != 3) break block7;
                    }
                    this.requestStop();
                    break block7;
                }
                this.mNeedsCancel = true;
                this.mAlreadyDelayed = false;
            }
            float f = this.computeTargetVelocity(0, motionEvent.getX(), view.getWidth(), this.mTarget.getWidth());
            float f2 = this.computeTargetVelocity(1, motionEvent.getY(), view.getHeight(), this.mTarget.getHeight());
            this.mScroller.setTargetVelocity(f, f2);
            if (!this.mAnimating && this.shouldAnimate()) {
                this.startAnimating();
            }
        }
        bl2 = bl;
        if (!this.mExclusive) return bl2;
        bl2 = bl;
        if (!this.mAnimating) return bl2;
        bl2 = true;
        return bl2;
    }

    public abstract void scrollTargetBy(int var1, int var2);

    public AutoScrollHelper setActivationDelay(int n) {
        this.mActivationDelay = n;
        return this;
    }

    public AutoScrollHelper setEdgeType(int n) {
        this.mEdgeType = n;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean bl) {
        if (this.mEnabled && !bl) {
            this.requestStop();
        }
        this.mEnabled = bl;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean bl) {
        this.mExclusive = bl;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f, float f2) {
        float[] fArray = this.mMaximumEdges;
        fArray[0] = f;
        fArray[1] = f2;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float f, float f2) {
        float[] fArray = this.mMaximumVelocity;
        fArray[0] = f / 1000.0f;
        fArray[1] = f2 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f, float f2) {
        float[] fArray = this.mMinimumVelocity;
        fArray[0] = f / 1000.0f;
        fArray[1] = f2 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int n) {
        this.mScroller.setRampDownDuration(n);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int n) {
        this.mScroller.setRampUpDuration(n);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f, float f2) {
        float[] fArray = this.mRelativeEdges;
        fArray[0] = f;
        fArray[1] = f2;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f, float f2) {
        float[] fArray = this.mRelativeVelocity;
        fArray[0] = f / 1000.0f;
        fArray[1] = f2 / 1000.0f;
        return this;
    }

    boolean shouldAnimate() {
        ClampedScroller clampedScroller = this.mScroller;
        int n = clampedScroller.getVerticalDirection();
        int n2 = clampedScroller.getHorizontalDirection();
        boolean bl = n != 0 && this.canTargetScrollVertically(n) || n2 != 0 && this.canTargetScrollHorizontally(n2);
        return bl;
    }
}
