/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.tabs.TabLayout$SlidingTabIndicator
 */
package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.tabs.TabLayout;

class TabLayout.SlidingTabIndicator.1
implements ValueAnimator.AnimatorUpdateListener {
    final TabLayout.SlidingTabIndicator this$1;
    final int val$finalTargetLeft;
    final int val$finalTargetRight;
    final int val$startLeft;
    final int val$startRight;

    TabLayout.SlidingTabIndicator.1(TabLayout.SlidingTabIndicator slidingTabIndicator, int n, int n2, int n3, int n4) {
        this.this$1 = slidingTabIndicator;
        this.val$startLeft = n;
        this.val$finalTargetLeft = n2;
        this.val$startRight = n3;
        this.val$finalTargetRight = n4;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f = valueAnimator.getAnimatedFraction();
        this.this$1.setIndicatorPosition(AnimationUtils.lerp((int)this.val$startLeft, (int)this.val$finalTargetLeft, (float)f), AnimationUtils.lerp((int)this.val$startRight, (int)this.val$finalTargetRight, (float)f));
    }
}
