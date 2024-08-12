/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.google.android.material.bottomappbar.BottomAppBar
 */
package com.google.android.material.bottomappbar;

import android.animation.ValueAnimator;
import com.google.android.material.bottomappbar.BottomAppBar;

/*
 * Exception performing whole class analysis ignored.
 */
class BottomAppBar.6
implements ValueAnimator.AnimatorUpdateListener {
    final BottomAppBar this$0;

    BottomAppBar.6(BottomAppBar bottomAppBar) {
        this.this$0 = bottomAppBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        BottomAppBar.access$200((BottomAppBar)this.this$0).setInterpolation(((Float)valueAnimator.getAnimatedValue()).floatValue());
    }
}
