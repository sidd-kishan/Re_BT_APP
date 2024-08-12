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
class BottomAppBar.2
implements ValueAnimator.AnimatorUpdateListener {
    final BottomAppBar this$0;

    BottomAppBar.2(BottomAppBar bottomAppBar) {
        this.this$0 = bottomAppBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        BottomAppBar.access$100((BottomAppBar)this.this$0).setHorizontalOffset(((Float)valueAnimator.getAnimatedValue()).floatValue());
        BottomAppBar.access$200((BottomAppBar)this.this$0).invalidateSelf();
    }
}
