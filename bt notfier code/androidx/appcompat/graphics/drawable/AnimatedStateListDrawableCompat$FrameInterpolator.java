/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.graphics.drawable.AnimationDrawable
 */
package androidx.appcompat.graphics.drawable;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;

private static class AnimatedStateListDrawableCompat.FrameInterpolator
implements TimeInterpolator {
    private int[] mFrameTimes;
    private int mFrames;
    private int mTotalDuration;

    AnimatedStateListDrawableCompat.FrameInterpolator(AnimationDrawable animationDrawable, boolean bl) {
        this.updateFrames(animationDrawable, bl);
    }

    public float getInterpolation(float f) {
        int n;
        int n2 = (int)(f * (float)this.mTotalDuration + 0.5f);
        int n3 = this.mFrames;
        int[] nArray = this.mFrameTimes;
        for (n = 0; n < n3 && n2 >= nArray[n]; n2 -= nArray[n], ++n) {
        }
        f = n < n3 ? (float)n2 / (float)this.mTotalDuration : 0.0f;
        return (float)n / (float)n3 + f;
    }

    int getTotalDuration() {
        return this.mTotalDuration;
    }

    int updateFrames(AnimationDrawable animationDrawable, boolean bl) {
        int n;
        this.mFrames = n = animationDrawable.getNumberOfFrames();
        int[] nArray = this.mFrameTimes;
        if (nArray == null || nArray.length < n) {
            this.mFrameTimes = new int[n];
        }
        nArray = this.mFrameTimes;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            if (n2 >= n) {
                this.mTotalDuration = n3;
                return n3;
            }
            int n4 = bl ? n - n2 - 1 : n2;
            nArray[n2] = n4 = animationDrawable.getDuration(n4);
            n3 += n4;
            ++n2;
        }
    }
}
