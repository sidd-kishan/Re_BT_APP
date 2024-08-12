/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.graphics.drawable.AnimationDrawable
 *  android.os.Build$VERSION
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$FrameInterpolator
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
 */
package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;

private static class AnimatedStateListDrawableCompat.AnimationDrawableTransition
extends AnimatedStateListDrawableCompat.Transition {
    private final ObjectAnimator mAnim;
    private final boolean mHasReversibleFlag;

    AnimatedStateListDrawableCompat.AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean bl, boolean bl2) {
        super(null);
        int n = animationDrawable.getNumberOfFrames();
        int n2 = bl ? n - 1 : 0;
        if (bl) {
            n = 0;
        }
        AnimatedStateListDrawableCompat.FrameInterpolator frameInterpolator = new AnimatedStateListDrawableCompat.FrameInterpolator(animationDrawable, bl);
        animationDrawable = ObjectAnimator.ofInt((Object)animationDrawable, (String)"currentIndex", (int[])new int[]{n2, --n});
        if (Build.VERSION.SDK_INT >= 18) {
            animationDrawable.setAutoCancel(true);
        }
        animationDrawable.setDuration((long)frameInterpolator.getTotalDuration());
        animationDrawable.setInterpolator((TimeInterpolator)frameInterpolator);
        this.mHasReversibleFlag = bl2;
        this.mAnim = animationDrawable;
    }

    public boolean canReverse() {
        return this.mHasReversibleFlag;
    }

    public void reverse() {
        this.mAnim.reverse();
    }

    public void start() {
        this.mAnim.start();
    }

    public void stop() {
        this.mAnim.cancel();
    }
}
