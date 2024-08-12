/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.google.android.material.tabs.TabLayout
 */
package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import com.google.android.material.tabs.TabLayout;

class TabLayout.1
implements ValueAnimator.AnimatorUpdateListener {
    final TabLayout this$0;

    TabLayout.1(TabLayout tabLayout) {
        this.this$0 = tabLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.scrollTo(((Integer)valueAnimator.getAnimatedValue()).intValue(), 0);
    }
}
