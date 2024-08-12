/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.AnimationUtils
 *  androidx.core.widget.AutoScrollHelper
 */
package androidx.core.widget;

import android.view.animation.AnimationUtils;
import androidx.core.widget.AutoScrollHelper;

/*
 * Exception performing whole class analysis ignored.
 */
private static class AutoScrollHelper.ClampedScroller {
    private long mDeltaTime = 0L;
    private int mDeltaX = 0;
    private int mDeltaY = 0;
    private int mEffectiveRampDown;
    private int mRampDownDuration;
    private int mRampUpDuration;
    private long mStartTime = Long.MIN_VALUE;
    private long mStopTime = -1L;
    private float mStopValue;
    private float mTargetVelocityX;
    private float mTargetVelocityY;

    AutoScrollHelper.ClampedScroller() {
    }

    private float getValueAt(long l) {
        if (l < this.mStartTime) {
            return 0.0f;
        }
        long l2 = this.mStopTime;
        if (l2 < 0L) return AutoScrollHelper.constrain((float)((float)(l - this.mStartTime) / (float)this.mRampUpDuration), (float)0.0f, (float)1.0f) * 0.5f;
        if (l < l2) {
            return AutoScrollHelper.constrain((float)((float)(l - this.mStartTime) / (float)this.mRampUpDuration), (float)0.0f, (float)1.0f) * 0.5f;
        }
        float f = this.mStopValue;
        return 1.0f - f + f * AutoScrollHelper.constrain((float)((float)(l - l2) / (float)this.mEffectiveRampDown), (float)0.0f, (float)1.0f);
    }

    private float interpolateValue(float f) {
        return -4.0f * f * f + f * 4.0f;
    }

    public void computeScrollDelta() {
        if (this.mDeltaTime == 0L) throw new RuntimeException("Cannot compute scroll delta before calling start()");
        long l = AnimationUtils.currentAnimationTimeMillis();
        float f = this.interpolateValue(this.getValueAt(l));
        long l2 = this.mDeltaTime;
        this.mDeltaTime = l;
        f = (float)(l - l2) * f;
        this.mDeltaX = (int)(this.mTargetVelocityX * f);
        this.mDeltaY = (int)(f * this.mTargetVelocityY);
    }

    public int getDeltaX() {
        return this.mDeltaX;
    }

    public int getDeltaY() {
        return this.mDeltaY;
    }

    public int getHorizontalDirection() {
        float f = this.mTargetVelocityX;
        return (int)(f / Math.abs(f));
    }

    public int getVerticalDirection() {
        float f = this.mTargetVelocityY;
        return (int)(f / Math.abs(f));
    }

    public boolean isFinished() {
        boolean bl = this.mStopTime > 0L && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + (long)this.mEffectiveRampDown;
        return bl;
    }

    public void requestStop() {
        long l = AnimationUtils.currentAnimationTimeMillis();
        this.mEffectiveRampDown = AutoScrollHelper.constrain((int)((int)(l - this.mStartTime)), (int)0, (int)this.mRampDownDuration);
        this.mStopValue = this.getValueAt(l);
        this.mStopTime = l;
    }

    public void setRampDownDuration(int n) {
        this.mRampDownDuration = n;
    }

    public void setRampUpDuration(int n) {
        this.mRampUpDuration = n;
    }

    public void setTargetVelocity(float f, float f2) {
        this.mTargetVelocityX = f;
        this.mTargetVelocityY = f2;
    }

    public void start() {
        long l;
        this.mStartTime = l = AnimationUtils.currentAnimationTimeMillis();
        this.mStopTime = -1L;
        this.mDeltaTime = l;
        this.mStopValue = 0.5f;
        this.mDeltaX = 0;
        this.mDeltaY = 0;
    }
}
