/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  com.google.android.material.animation.AnimationUtils
 */
package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.animation.AnimationUtils;

public class MotionTiming {
    private long delay = 0L;
    private long duration = 300L;
    private TimeInterpolator interpolator = null;
    private int repeatCount = 0;
    private int repeatMode = 1;

    public MotionTiming(long l, long l2) {
        this.delay = l;
        this.duration = l2;
    }

    public MotionTiming(long l, long l2, TimeInterpolator timeInterpolator) {
        this.delay = l;
        this.duration = l2;
        this.interpolator = timeInterpolator;
    }

    static MotionTiming createFromAnimator(ValueAnimator valueAnimator) {
        MotionTiming motionTiming = new MotionTiming(valueAnimator.getStartDelay(), valueAnimator.getDuration(), MotionTiming.getInterpolatorCompat(valueAnimator));
        motionTiming.repeatCount = valueAnimator.getRepeatCount();
        motionTiming.repeatMode = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    private static TimeInterpolator getInterpolatorCompat(ValueAnimator valueAnimator) {
        TimeInterpolator timeInterpolator = valueAnimator.getInterpolator();
        if (timeInterpolator instanceof AccelerateDecelerateInterpolator) return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        if (timeInterpolator == null) {
            return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        }
        if (timeInterpolator instanceof AccelerateInterpolator) {
            return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        }
        valueAnimator = timeInterpolator;
        if (!(timeInterpolator instanceof DecelerateInterpolator)) return valueAnimator;
        valueAnimator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
        return valueAnimator;
    }

    public void apply(Animator animator) {
        animator.setStartDelay(this.getDelay());
        animator.setDuration(this.getDuration());
        animator.setInterpolator(this.getInterpolator());
        if (!(animator instanceof ValueAnimator)) return;
        animator = (ValueAnimator)animator;
        animator.setRepeatCount(this.getRepeatCount());
        animator.setRepeatMode(this.getRepeatMode());
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (MotionTiming)object;
        if (this.getDelay() != ((MotionTiming)object).getDelay()) {
            return false;
        }
        if (this.getDuration() != ((MotionTiming)object).getDuration()) {
            return false;
        }
        if (this.getRepeatCount() != ((MotionTiming)object).getRepeatCount()) {
            return false;
        }
        if (this.getRepeatMode() == ((MotionTiming)object).getRepeatMode()) return this.getInterpolator().getClass().equals(((MotionTiming)object).getInterpolator().getClass());
        return false;
    }

    public long getDelay() {
        return this.delay;
    }

    public long getDuration() {
        return this.duration;
    }

    public TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.interpolator;
        if (timeInterpolator != null) return timeInterpolator;
        timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        return timeInterpolator;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public int hashCode() {
        return ((((int)(this.getDelay() ^ this.getDelay() >>> 32) * 31 + (int)(this.getDuration() ^ this.getDuration() >>> 32)) * 31 + this.getInterpolator().getClass().hashCode()) * 31 + this.getRepeatCount()) * 31 + this.getRepeatMode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" delay: ");
        stringBuilder.append(this.getDelay());
        stringBuilder.append(" duration: ");
        stringBuilder.append(this.getDuration());
        stringBuilder.append(" interpolator: ");
        stringBuilder.append(this.getInterpolator().getClass());
        stringBuilder.append(" repeatCount: ");
        stringBuilder.append(this.getRepeatCount());
        stringBuilder.append(" repeatMode: ");
        stringBuilder.append(this.getRepeatMode());
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
