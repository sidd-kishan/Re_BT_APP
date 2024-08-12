/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.tabs.TabLayout$SlidingTabIndicator
 */
package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.tabs.TabLayout;

class TabLayout.SlidingTabIndicator.2
extends AnimatorListenerAdapter {
    final TabLayout.SlidingTabIndicator this$1;
    final int val$position;

    TabLayout.SlidingTabIndicator.2(TabLayout.SlidingTabIndicator slidingTabIndicator, int n) {
        this.this$1 = slidingTabIndicator;
        this.val$position = n;
    }

    public void onAnimationEnd(Animator animator) {
        this.this$1.selectedPosition = this.val$position;
        this.this$1.selectionOffset = 0.0f;
    }
}
